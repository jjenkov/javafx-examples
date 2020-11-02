# JavaFX Examples
This repository contains a growing collection of JavaFX examples. I am converting existing examples from my
own hard drive, but I need to clean each example up before I am able to share it. I have somewhere between 50 and 
100 examples I plan to share after clean up.

## JavaFX Tutorial
The examples come from my JavaFX tutorial series: [JavaFX Tutorial](http://tutorials.jenkov.com).

## Java + JavaFX Version Used
In general the examples in this repository will attempt to use the latest version of Java and JavaFX. 
For now the examples are tested with Java 14 and JavaFX 14 (yes, 15 + 15 are latest - will update soon!).

## Running the Examples
To run the examples you need to have the correct Java SDK installed, and the correct JavaFX release downloaded
and unzipped. Then add the JavaFX modules to your classpath in your IDE. When running an example you need to
add the following to the JVM args:

    --module-path C:\data\downloads\javafx\javafx-sdk-14\lib --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

Obviously you only need to add the JavaFX modules you are actually using. The above line just adds all JavaFX modules to the module path 
so it should work with all JavaFX examples.


Remember to replace the C:\data\downloads\javafx\javafx-sdk-14\lib  part with the actual file system path
to the JavaFX version you have downloaded and unzipped. Remember to use the correct path style for your OS.


## Suggestions
If you have any suggestions for missing examples, create a GitHub issue in this repo, and / or ping me on 
Twitter (@jjenkov) or LinkedIn (Jakob Jenkov).


# JavaFX Example List

 - Stage Examples
   - [Stage Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageExample.java)
   - [Stage Decoration Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageDecorationExample.java)
   - [Multiple Stages Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/MultipleStagesExample.java)
   - [Multiple Stages Modal Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/MultipleStagesModalExample.java)
   - [Full Screen Stage Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/FullScreenStageExample.java)
   - [Auto Shutdown Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/AutoShutDownExample.java)
   - [Keyboard Events Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageKeyboardEventsExample.java)
 - [Scene Cursor Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/scene/SceneCursorExample.java)
 - Button Examples
   - [Button Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonExample.java)
   - [Disabled Button Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/DisabledButtonExample.java)
 - [Accordion Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/accordion/AccordionExample.java)
 - [Animation Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/animation/AnimationExample.java)
 - [Color Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/color/ColorExample.java)
 - [ColorPicker Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/colorpicker/ColorPickerExample.java)
 - [Concurrency Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/concurrency/ConcurrencyExample.java)
 - [ContextMenu Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/contextmenu/ContextMenuExample.java)
 - [DirectoryChooser Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/directorychooser/DirectoryChooserExample.java)
 - [FileChooser Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/filechooser/FileChooserExample.java)
 - [FXML Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/fxml/FXMLExample.java)
 - [HTMLEditor Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/htmleditor/HtmlEditorExample.java)
 - [Hyperlink Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/hyperlink/HyperlinkExample.java)
 - [Label Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/label/LabelExample.java)
 - [Pagination Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/pagination/PaginationExample.java)
 - [ProgressBar Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/progressbar/ProgressBarExample.java)
 - [ScrollPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/scrollpane/ScrollPaneExample.java)
 - [Separator Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/separator/SeparatorExample.java)
 - [Slider Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/slider/SliderExample.java)
 - [SplitMenuButton Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/splitmenubutton/SplitMenuButtonExample.java)
 - [SplitPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/splitpane/SplitPaneExample.java)
 - [TabPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tabpane/TabPaneExample.java)
 - TableView Examples
   - [TableView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewExample.java)
   - [TableView Nested Colulmns Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewNestedColumnsExample.java)
   - [TableView Selection Model Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewSelectionModelExample.java)
   - [TableView Custom Rendering Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewCustomRenderingExample.java)
   - [TableView Map as Data Items Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewMapDataItemsExample.java)
 - [Text Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/text/TextExample.java)
 - [TitledPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/titledpane/TitledPaneExample.java)
 - [ToolBar Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/toolbar/ToolBarExample.java)
 - [ToolTip Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tooltip/ToolTipExample.java)
 - [TreeTableView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/treetableview/TreeTableViewExample.java)
 - [TreeView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/treeview/TreeViewExample.java)
 - [VBox Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/vbox/VBoxExample.java)
 - WebView Examples
   - [WebView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/webview/WebViewExample.java)
   - [WebView JavaScript Integration Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/webview/WebViewJavaScriptIntegrationExample.java)
   - [WebView Mouse Wheel Zoom Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/webview/WebViewMouseWheelZoomExample.java) 
     (Mouse wheel zoom code provided by Friedhold Matz (@FriedholdMatz on Twitter)) 