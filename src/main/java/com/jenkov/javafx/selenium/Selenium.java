import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium extends Application {
    private WebDriver driver;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create GUI elements
        Button visitButton = new Button("Open youtube");
        visitButton.setOnAction(e -> openYouTube());

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> closeBrowser());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(visitButton, closeButton);

        // Set up the scene and stage
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("YouTube Visitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openYouTube() {
        // Here Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver();

        // Open YouTube or any url 
        driver.get("https://www.youtube.com");
    }

    private void closeBrowser() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public void stop() {
        // stop it 
        if (driver != null) {
            driver.quit();
        }
    }
}

