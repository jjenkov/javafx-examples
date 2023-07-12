# JavaFX Examples
This repository contains a growing collection of JavaFX examples. So far this GitHub repository contains 76 examples.
I have plans to add lots more examples in the future, so make sure you star this repository for future reference ;-)


The lists of examples is found here: 

- [JavaFX Basic Examples](#javafx-basic-examples)
- [JavaFX Advanced Examples](#javafx-advanced-examples)

## JavaFX Tutorial
The examples come from my JavaFX tutorial series: [JavaFX Tutorial](http://tutorials.jenkov.com).

## Java + JavaFX Version Used
In general the examples in this repository will attempt to use the latest version of Java and JavaFX. 
For now the examples are tested with Java 14 and JavaFX 14 (yes, 15 + 15 are latest - will update soon!).

## Running the Examples
There are 3 options to run the examples.

- Using your IDE (IntelliJ IDEA / Eclipse / Netbeans)
- Using Maven - passing main class to run on the command line
- Using gradle - passing main class to run on the command line
- Using Maven - configuring the main class inside the pom.xml

Some of these are covered in more detail below.

### Run the Examples in IntelliJ Idea(needs pre-downloaded javafx modules)
To run the examples from within IntelliJ IDEA you must first create a new project in IntelliJ, and set the root
directory to the directory into which you have cloned this Git repository. 

Second, you must download JavaFX and unzip the distribution to some directory.

Third, you must add all the JAR files found in the "lib" directory to your project's classpath.

Fourth, you must create a run configuration for the example class you want to run. Add the following
JVM args to that run configuration:

--module-path C:\data\downloads\javafx\javafx-sdk-14\lib --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

Make sure that the --module-path points to the directory you unzipped your downloaded JavaFX distribution to (meaning the "lib" dir within that JavaFX distribution dir - as shown above).

### Run in IDE - alternative
Instead of creating run configuration for each example class you can create a run configuration for the ExampleRunner class(based on maven or gradle nature. Both are supported using wrappers so you don't need to have any of them on you system and you can choose to use the one you prefer), and then from inside the
ExampleRunner class, call the example class you want to run - by changing the main() method inside the ExampleRunner class. For instance,
add the following line to the ExampleRunner class main() method and then run ExampleRunner main

	ButtonExample.main(args);


### Run via Maven - Passing Main Class as Argument to Maven
You can use maven and pass the example class you want to add. for example to run WebViewExample you can run

./mvnw compile exec:java -Dexec.args="com.jenkov.javafx.webview.WebViewExample"

### Run via Gradle - Passing Main Class as Argument to Gradle
You can use gradle and pass the example class you want to add. for example to run WebViewExample you can run

./gradlew run --args="com.jenkov.javafx.webview.WebViewExample"

### Run via Maven
You can use Maven and edit the pom.xml file and change "mainClass" of openjfx plugin configuration and select the example you want then run

./mvnw clean javafx:run


## Suggestions
If you have any suggestions for missing examples, create a GitHub issue in this repo, and / or ping me on 
Twitter (@jjenkov) or LinkedIn (Jakob Jenkov).

<a name="javafx-basic-examples"></a>
# JavaFX Basic Examples

 - [Accordion Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/accordion/AccordionExample.java)
 - [Animation Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/animation/AnimationExample.java)
 - Button Examples
   - [Button Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonExample.java)
   - [Button Font Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonFontExample.java)
   - [Disabled Button Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/DisabledButtonExample.java)
   - [Normal, Default and Cancel Mode Button Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonDefaultAndCancelModesExample.java)
   - [Button FXML Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonFXMLExample.java)
   - [Button Transformation Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/button/ButtonTransformationExample.java)
 - [Canvas Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/canvas/CanvasExample.java)
 - [ChoiceBox Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/choicebox/ChoiceBoxExample.java)
 - [Color Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/color/ColorExample.java)
 - [ColorPicker Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/colorpicker/ColorPickerExample.java)
 - [ComboBox Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/combobox/ComboBoxExample.java)
 - [Concurrency Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/concurrency/ConcurrencyExample.java)
 - [ContextMenu Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/contextmenu/ContextMenuExample.java)
 - [DirectoryChooser Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/directorychooser/DirectoryChooserExample.java)
 - [FileChooser Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/filechooser/FileChooserExample.java)
 - [Font Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/font/FontExample.java)
 - [FXML Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/fxml/FXMLExample.java)
 - [HTMLEditor Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/htmleditor/HtmlEditorExample.java)
   Hyperlink Examples
   - [Hyperlink Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/hyperlink/HyperlinkExample.java)
   - [Hyperlink Font Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/hyperlink/HyperlinkFontExample.java)
   - [Hyperlink Change Text Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/hyperlink/HyperlinkChangeTextExample.java)
 - [ImageView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/imageview/ImageViewExample.java)
 - Label Examples
   - [Label Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/label/LabelExample.java)
   - [Label Font Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/label/LabelFontExample.java)
   - [Label Change Text Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/label/LabelChangeTextExample.java)
 - [Media Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/media/MediaExample.java)
 - MenuButton Examples
   - [MenuButton Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/menubutton/MenuButtonExample.java)
   - [MenuButton Font Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/menubutton/MenuButtonFontExample.java)
   - [MenuButton Icon Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/menubutton/MenuButtonIconExample.java)
 - [Pagination Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/pagination/PaginationExample.java)
 - [ProgressBar Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/progressbar/ProgressBarExample.java)
 - [Properties Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/properties/PropertyExample.java)
 - [Scene Cursor Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/scene/SceneCursorExample.java)
 - [ScrollPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/scrollpane/ScrollPaneExample.java)
 - [Separator Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/separator/SeparatorExample.java)
 - [Slider Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/slider/SliderExample.java)
 - [SplitMenuButton Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/splitmenubutton/SplitMenuButtonExample.java)
 - [SplitPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/splitpane/SplitPaneExample.java)
 - Stage Examples
   - [Stage Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageExample.java)
   - [Stage Decoration Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageDecorationExample.java)
   - [Multiple Stages Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/MultipleStagesExample.java)
   - [Multiple Stages Modal Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/MultipleStagesModalExample.java)
   - [Full Screen Stage Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/FullScreenStageExample.java)
   - [Auto Shutdown Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/AutoShutDownExample.java)
   - [Keyboard Events Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/stage/StageKeyboardEventsExample.java)
 - [TabPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tabpane/TabPaneExample.java)
 - TableView Examples
   - [TableView Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewExample.java)
   - [TableView Editable Column Cells Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewEditableExample.java)
   - [TableView Nested Columns Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewNestedColumnsExample.java)
   - [TableView Selection Model Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewSelectionModelExample.java)
   - [TableView Custom Rendering Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewCustomRenderingExample.java)
   - [TableView Map as Data Items Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/tableview/TableViewMapDataItemsExample.java)
 - [Text Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/text/TextExample.java)
 - [TextArea Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/textarea/TextAreaExample.java)
 - [TextField Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/textfield/TextFieldExample.java)
 - [TitledPane Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/titledpane/TitledPaneExample.java)
 - ToggleButton Examples
   - [ToggleButton Example](https://github.com/jjenkov/javafx-example/blob/main/src/main/java/com/jenkov/javafx/togglebutton/ToggleButtonExample.java)
   - [ToggleButton Font Example](https://github.com/jjenkov/javafx-example/blob/main/src/main/java/com/jenkov/javafx/togglebutton/ToggleButtonFontExample.java)
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
 - 2D Examples
   - [2D Basics Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/gfx2d/Gfx2DExample.java)
 - 3D Examples
   - [3D Basics Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/gfx3d/Gfx3DExample.java)
 - Transformations Examples
   - [Transformations Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/transformations/TransformationsExample.java)
   - [Translate Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/transformations/TranslateTransformationsExample.java)
   - [Rotate Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/transformations/RotateTransformationsExample.java)
   - [Scale Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/transformations/ScaleTransformationsExample.java)
 - Drag and Drop Examples
   - [Drag and Drop Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/draganddrop/DragAndDropExample.java)
 - Selenium Example
   - { [Selenium Example]((https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/selenium/Selenium.java)


<a name="javafx-advanced-examples"></a>
# JavaFX Advanced Examples
- [Auto-responsive Layout Example](https://github.com/jjenkov/javafx-examples/blob/main/src/main/java/com/jenkov/javafx/layout/AutoResponsiveLayoutExample.java)


