package com.jenkov.javafx.layout;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.List;


/**
 * An example of how to implement your own layout of controls contained inside a Pane. The JavaFX Pane class does not
 * do any layout of its children. The Pane shows the children where the children wants to be layed out themselves.
 * Thus, by changing layout position of the children of a Pane you can change it's layout.
 */
public class AutoResponsiveLayout {

    public static class WidgetLayoutInfo {

        public double x = 0.0D;
        public double y = 0.0D;

        public double minWidth  = 0.0D;
        public double width     = 0.0D;

        public double minHeight = 0.0D;
        public double height    = 0.0D;

        public int   rowNo = 0;

    }

    public static class PaneLayoutInfo {

        public List<WidgetLayoutInfo> widgetLayoutInfos = new ArrayList<>();

        public int    noOfRows    = 0;
        public double maxRowWidth = 0.0D;

        public double totalChildWidth = 0.0D; //width of all children if placed on a single row
        public double avgRowWidth = 0.0D;  // total child width divided by number of rows.

        public double visibleHeight = 0.0D; // The height visible within the parent ScrollPane

        /*
        public List<List<WidgetLayoutInfo>> rows = new ArrayList<>();

        public void initRows() {
            int missingRows = noOfRows - rows.size();
            for(int i=0; i<missingRows; i++) {
                rows.add(new ArrayList<WidgetLayoutInfo>());
            }
        }
        public void resetRows() {
            for(int i=0; i<rows.size(); i++) {
                List<WidgetLayoutInfo> rowList = rows.get(i);
                rowList.clear();
            }
        }
        public void assignWidgetsToRows() {
            resetRows();
            for(int i=0; i<widgetLayoutInfos.size(); i++) {
                WidgetLayoutInfo widgetLayoutInfo = widgetLayoutInfos.get(i);
                List<WidgetLayoutInfo> rowList = rows.get(widgetLayoutInfo.rowNo);
                rowList.add(widgetLayoutInfo);
            }
        }
       */

        public int determineRowCountFromWidgetLayoutInfos() {
            this.noOfRows = getLastWidgetLayoutInfo(this.widgetLayoutInfos).rowNo + 1; // row numbers are 0-based (first row has index 0)
            return this.noOfRows;
        }

        private WidgetLayoutInfo getLastWidgetLayoutInfo(List<WidgetLayoutInfo> widgetLayoutInfos) {
            return widgetLayoutInfos.get(widgetLayoutInfos.size()-1);
        }

        public void calculateTotalChildMinWidth(){
            this.totalChildWidth = 0.0D;
            for(int i=0; i<this.widgetLayoutInfos.size(); i++) {
                WidgetLayoutInfo widgetLayoutInfo = this.widgetLayoutInfos.get(i);
                double childWidth = widgetLayoutInfo.minWidth;
                this.totalChildWidth += childWidth;
            }
        }

        public void calculateAverageRowWidthBasedOnMinWidths() {
            this.avgRowWidth = this.totalChildWidth / this.noOfRows;
        }

        private double calcMinimumUsedRowHeights() {
            int rowEndIndex = 0;
            double minimumUsedRowHeights = 0.0D;
            for(int rowNo = 0; rowNo < this.noOfRows; rowNo++){
                double highestWidgetsOnRow = 0.0D;
                while(rowEndIndex < this.widgetLayoutInfos.size() && rowNo == this.widgetLayoutInfos.get(rowEndIndex).rowNo) {
                    WidgetLayoutInfo widgetLayoutInfo = this.widgetLayoutInfos.get(rowEndIndex);
                    highestWidgetsOnRow = Math.max(highestWidgetsOnRow, widgetLayoutInfo.minHeight);
                    rowEndIndex++;
                }
                minimumUsedRowHeights += highestWidgetsOnRow;
            }
            return minimumUsedRowHeights;
        }



    }

    // Feature flags. All features should be enabled for a fully automatic responsive layout

    protected boolean balanceRows       = true;
    protected boolean pullUpChildren    = true;
    protected boolean extendChildWidth  = true;
    protected boolean extendChildHeight = true;

    PaneLayoutInfo          paneLayoutInfo = new PaneLayoutInfo();



    private Pane targetPane = null;
    private ScrollPane targetParentPane = null;

    public AutoResponsiveLayout(Pane pane, ScrollPane parent) {
        this.targetPane = pane;
        this.targetParentPane = parent;

        this.targetPane.widthProperty().addListener((ObservableValue<? extends Number> property, Number oldValue, Number newValue) -> {
            this.paneLayoutInfo.maxRowWidth = newValue.doubleValue();
            layoutPane();
        });

        parent.viewportBoundsProperty().addListener((ObservableValue<? extends Bounds> property, Bounds oldValue, Bounds newValue) -> {
            this.paneLayoutInfo.visibleHeight = newValue.getHeight();
            layoutPane();
        });

    }



    public void clear() {
        //this.paneLayoutInfo.resetRows();
        this.paneLayoutInfo.widgetLayoutInfos.clear();
        this.targetPane.getChildren().clear();
    }

    public void addWidget(Region child) {
        WidgetLayoutInfo widgetLayoutInfo = new WidgetLayoutInfo();
        widgetLayoutInfo.x        = 0.0D;
        widgetLayoutInfo.y        = 0.0D;
        widgetLayoutInfo.rowNo    = 0;
        widgetLayoutInfo.minWidth = child.getMinWidth();
        widgetLayoutInfo.width    = child.getMinWidth(); //start with min width as width
        widgetLayoutInfo.minHeight= child.getMinHeight();
        widgetLayoutInfo.height   = child.getMinWidth();

        addWidget(child, widgetLayoutInfo);
    }

    public void addWidget(Region child, WidgetLayoutInfo layoutInfo) {
        this.targetPane.getChildren().add(child);
        this.paneLayoutInfo.widgetLayoutInfos.add(layoutInfo);

    }

    protected void layoutPane() {
        //System.out.println("============== BEGIN LAYOUT ===============");
        ObservableList<Node> children = this.targetPane.getChildren();
        if(children.size() == 0) {
            return;
        }

        transferMinWidthsAndHeightsToWidths();

        // Phase 1: Divide children into rows based on their minimum widths
        assignChildrenToRowsNumbersAccordingToMinWidths();

        this.paneLayoutInfo.determineRowCountFromWidgetLayoutInfos();
        //this.paneLayoutInfo.initRows();
        //this.paneLayoutInfo.resetRows();
        //this.paneLayoutInfo.assignWidgetsToRows();

        adjustPaneToParentScrollPaneOrMinUsedRowsHeight();

        // Phase 2.1: Now that number of rows is decided, calculate the average width of rows
        paneLayoutInfo.calculateTotalChildMinWidth();
        paneLayoutInfo.calculateAverageRowWidthBasedOnMinWidths();

        // Phase 2.2: Assign children to rows based on average row width instead of max row width - for a more even distribution of children.
        if(this.balanceRows) {
            assignChildrenToRowsUsingAverageRowWidth();
        }

        // Phase 2.3 Pull up "dangling" widgets towards the top of the pane, so the grid looks more similar.
        if(this.pullUpChildren) {
            pullUpWidgets(children, this.paneLayoutInfo.widgetLayoutInfos);
        }

        // Phase 3: Expand widths of children to match row width
        if(this.extendChildWidth) {
            expandWidgetWidthsToFitRow(this.paneLayoutInfo.maxRowWidth, children);
        }

        // Phase 4: Expand heights of children to match highest child per row
        if(this.extendChildHeight) {
            expandRowHeights();
        }

        // Phase 5: Position children according to index and row
        positionAndSizeChildren(children, this.paneLayoutInfo.widgetLayoutInfos);

    }

    private int determineRowCountFromWidgetLayoutInfos() {
        return getLastWidgetLayoutInfo(this.paneLayoutInfo.widgetLayoutInfos).rowNo + 1; // row numbers are 0-based (first row has index 0)
    }

    private void adjustPaneToParentScrollPaneOrMinUsedRowsHeight() {
        double minimumUsedRowHeights = this.paneLayoutInfo.calcMinimumUsedRowHeights();
        double newHeight = Math.max(this.paneLayoutInfo.visibleHeight, minimumUsedRowHeights);
        this.targetPane.setMinHeight(newHeight);
        this.targetPane.setPrefHeight(newHeight);
        this.targetPane.setMaxHeight(newHeight);
    }


    private void transferMinWidthsAndHeightsToWidths() {
        for(int i=0; i<this.paneLayoutInfo.widgetLayoutInfos.size(); i++){
            WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);
            widgetLayoutInfo.width  = widgetLayoutInfo.minWidth;
            widgetLayoutInfo.height = widgetLayoutInfo.minHeight;
        }
    }

    private void pullUpWidgets(ObservableList<Node> children, List<WidgetLayoutInfo> widgetLayoutInfos) {
        int    childrenPulledUpThisIteration = 0;
        do{
            childrenPulledUpThisIteration = 0;
            //System.out.println("===== Pull up round =====");
            double prevRowWidth = Double.MAX_VALUE;
            double thisRowWidth = 0.0D;
            int    thisRowNo    = 0;

            //Node firstChildOnRow = children.get(0);
            WidgetLayoutInfo firstChildOnRowWidgetLayoutInfo = widgetLayoutInfos.get(0);
            for(int i = 0; i < children.size(); i++) {
                WidgetLayoutInfo widgetLayoutInfo = widgetLayoutInfos.get(i);
                if(thisRowNo == widgetLayoutInfo.rowNo) {
                    thisRowWidth += widgetLayoutInfo.minWidth;
                } else {
                    double rowDiff = thisRowWidth - prevRowWidth;
                    //if(rowDiff >= firstChildOnRow.getLayoutBounds().getWidth()) {
                    if(rowDiff >= firstChildOnRowWidgetLayoutInfo.minWidth) {
                        //System.out.println("Move child " + i + " up to previous row");
                        firstChildOnRowWidgetLayoutInfo.rowNo--; //move first widget of this row up to previous row
                        childrenPulledUpThisIteration++;
                    } else {
                        //System.out.println("Row diff for row " + thisRowNo);
                    }

                    //firstChildOnRow = child;
                    firstChildOnRowWidgetLayoutInfo = widgetLayoutInfo;
                    prevRowWidth = thisRowWidth;
                    //thisRowWidth = child.getLayoutBounds().getWidth();
                    thisRowWidth = widgetLayoutInfo.minWidth;
                    thisRowNo++;
                }
            }
        } while (childrenPulledUpThisIteration > 0);
    }


    private void expandWidgetWidthsToFitRow(double newWidth, ObservableList<Node> children) {
        double usedRowWidth = 0.0D;

        int rowStartIndex = 0;
        int rowEndIndex   = 0;
        for(int rowNo = 0; rowNo < paneLayoutInfo.noOfRows; rowNo++){


            while(rowEndIndex < this.paneLayoutInfo.widgetLayoutInfos.size() && rowNo == this.paneLayoutInfo.widgetLayoutInfos.get(rowEndIndex).rowNo){
                rowEndIndex++;
            }
            for(int i=rowStartIndex; i<rowEndIndex; i++) {
                //Node node = children.get(i);
                //usedRowWidth += node.getLayoutBounds().getWidth();
                WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);
                usedRowWidth += widgetLayoutInfo.minWidth;
            }

            //System.out.println("   Max Row Width : " + newWidth + "(" + paneLayoutInfo.maxRowWidth + ")");
            //System.out.println("   Used Row width: " + usedRowWidth);

            double unusedRowWidth = paneLayoutInfo.maxRowWidth - usedRowWidth;
            //System.out.println("   Unused row width: " + unusedRowWidth);

            for(int i=rowStartIndex; i<rowEndIndex; i++) {
                Node node = children.get(i);

                WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);
                double childWidth      = widgetLayoutInfo.minWidth;
                double childToRowRatio = childWidth / usedRowWidth;
                double childWidthExtension = unusedRowWidth * childToRowRatio;
                double childWidthExtended = childWidth + childWidthExtension;

                //System.out.println("      Child Width Extension: " + childWidthExtension);
                //System.out.println("      Child Width Extended : " + childWidthExtended);

                widgetLayoutInfo.width = childWidthExtended;
                //((Region) node).setMinWidth(childWidthExtended);
                //((Region) node).setPrefWidth(childWidthExtended);
            }

            usedRowWidth = 0.0D;
            rowStartIndex = rowEndIndex;
        }
    }


    private void expandRowHeights() {
        double minimumUsedRowHeights = this.paneLayoutInfo.calcMinimumUsedRowHeights();

        double unusedHeight = 0.0D;
        //if(this.paneLayoutInfo.visibleHeight > this.targetPane.getHeight()) {
        if(this.paneLayoutInfo.visibleHeight > minimumUsedRowHeights) {
            //unusedHeight = Math.max(0, this.targetPane.getHeight() - minimumUsedRowHeights);
            unusedHeight = Math.max(0, this.paneLayoutInfo.visibleHeight - minimumUsedRowHeights);
        }

        //if minimumUsedRowHeights is larger than available height - do NOT use a negative unusedHeight - but use 0.

        //System.out.println("Pane height        : " + this.targetPane.getHeight());
        //System.out.println("Visible height     : " + this.paneLayoutInfo.visibleHeight);
        //System.out.println("Minimum rows height: " + minimumUsedRowHeights);
        //System.out.println("Unused height      : " + unusedHeight);

        int rowStartIndex = 0;
        int rowEndIndex   = 0;
        for(int rowNo = 0; rowNo < paneLayoutInfo.noOfRows; rowNo++){
            rowStartIndex = rowEndIndex;
            double highestWidgetsOnRow = 0.0D;
            while(rowEndIndex < this.paneLayoutInfo.widgetLayoutInfos.size() && rowNo == this.paneLayoutInfo.widgetLayoutInfos.get(rowEndIndex).rowNo) {
                WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(rowEndIndex);
                highestWidgetsOnRow = Math.max(highestWidgetsOnRow, widgetLayoutInfo.height);
                rowEndIndex++;
            }
            double rowRatio       = highestWidgetsOnRow / minimumUsedRowHeights;
            double rowExtension   = rowRatio * unusedHeight;
            double expandedHeight = highestWidgetsOnRow + rowExtension;
            //System.out.println("Row Height     : " + highestWidgetsOnRow);
            //System.out.println("Unused height  : " + unusedHeight);
            //System.out.println("Expanded height: " + expandedHeight);

            rowEndIndex = rowStartIndex;
            while(rowEndIndex < this.paneLayoutInfo.widgetLayoutInfos.size() && rowNo == this.paneLayoutInfo.widgetLayoutInfos.get(rowEndIndex).rowNo) {
                WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(rowEndIndex);
                widgetLayoutInfo.height = expandedHeight;
                rowEndIndex++;
            }

        }
    }

    private void printWidgetRows(ObservableList<Node> children) {
        System.out.println("=== Widget Row Nos ===");
        for(int i = 0; i< children.size(); i++) {
            WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);
            System.out.println("Widget " + i + " has row " + widgetLayoutInfo.rowNo);
        }
    }

    private WidgetLayoutInfo getLastWidgetLayoutInfo(List<WidgetLayoutInfo> widgetLayoutInfos) {
        return widgetLayoutInfos.get(widgetLayoutInfos.size()-1);
    }

    private void assignChildrenToRowsNumbersAccordingToMinWidths() {
        ObservableList<Node> children = targetPane.getChildren();
        double maxRowWidth = paneLayoutInfo.maxRowWidth;

        double widgetsOnRowWidth = 0.0D;
        int rowNo = 0;
        for(int i = 0; i < children.size(); i++) {
            WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);

            double childWidth =  widgetLayoutInfo.minWidth;
            widgetsOnRowWidth += childWidth;
            if(widgetsOnRowWidth > maxRowWidth && i>0) {
                rowNo++;
                widgetsOnRowWidth = childWidth;
            }
            widgetLayoutInfo.rowNo = rowNo;
        }
    }

    private void assignChildrenToRowsUsingAverageRowWidth() {
        //System.out.println("Avg. row width: " + avgRowWidth);
        double avgRowWidth = paneLayoutInfo.avgRowWidth;
        double maxRowWidth = paneLayoutInfo.maxRowWidth;
        double totalWidgetsWidthUsed = 0.0D;
        double widgetWidthOnRowUsed  = 0.0D;
        int rowNo = 0;
        for(int i = 0; i < this.paneLayoutInfo.widgetLayoutInfos.size(); i++) {
            WidgetLayoutInfo widgetLayoutInfo = this.paneLayoutInfo.widgetLayoutInfos.get(i);
            double childWidth = widgetLayoutInfo.minWidth;

            widgetWidthOnRowUsed  += childWidth;
            totalWidgetsWidthUsed += childWidth;

            double avgRowWidthSum = avgRowWidth * ((double) (rowNo + 1) );

            if(widgetWidthOnRowUsed > maxRowWidth){
                // widget cannot fit within this row - push to next row.
                widgetWidthOnRowUsed = childWidth;
                rowNo++;
                widgetLayoutInfo.rowNo = rowNo;
            }
            if(totalWidgetsWidthUsed >= avgRowWidthSum) {
                // widget can fit within this row - but after this widget break to next row
                widgetLayoutInfo.rowNo = rowNo;
                rowNo++;
                widgetWidthOnRowUsed = 0.0D;
            } else {
                widgetLayoutInfo.rowNo = rowNo;
            }
        }
    }


    private void positionAndSizeChildren(ObservableList<Node> children, List<WidgetLayoutInfo> widgetLayoutInfos) {
        int rowNo = 0;
        double x = 0.0D;
        double y = 0.0D;
        for(int i = 0; i< children.size(); i++) {
            Region           child            = (Region) children.get(i);
            WidgetLayoutInfo widgetLayoutInfo = widgetLayoutInfos.get(i);

            if(rowNo != widgetLayoutInfo.rowNo) {

                double highestWidgetOnRow = 0.0D;
                System.out.print("Calculating height for row: " + rowNo);
                for(int j=i-1; j>=0; j--) {
                    WidgetLayoutInfo widgetOnRow = widgetLayoutInfos.get(j);
                    if(widgetOnRow.rowNo != rowNo) { //reached previous row - skip loop now.
                        break;
                    }
                    //highestWidgetOnRow = Math.max(highestWidgetOnRow, widgetOnRow.minHeight);
                    highestWidgetOnRow = Math.max(highestWidgetOnRow, widgetOnRow.height);
                }
                System.out.println(" => " + highestWidgetOnRow);


                rowNo = widgetLayoutInfo.rowNo;
                x = 0.0D;

                y += highestWidgetOnRow;
            }

            child.setLayoutX(x);
            child.setLayoutY(y);
            child.setPrefWidth(widgetLayoutInfo.width);
            child.setPrefHeight(widgetLayoutInfo.height);

            x += widgetLayoutInfo.width;
        }
    }


}
