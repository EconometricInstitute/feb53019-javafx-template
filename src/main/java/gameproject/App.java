package gameproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;

public class App extends Application {

    // This method builds and starts the JavaFX Scene. You can adjust the default window size (currently 640x480)
    @Override
    public void start(Stage stage) {
        // Create a text label
        Label textLabel = new Label(getGreeting());

        // Load the image from the project's resources and create a JavaFX node that shows it
        Image logo = loadImage("/gameproject/images/ese_logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(118);
        logoView.setPreserveRatio(true);

        // Create a vertical layout that shows the text and logo, centered
        VBox layout = new VBox(20, textLabel, logoView);
        layout.setAlignment(Pos.CENTER);

        // Create the scene and show it
        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static String getGreeting() {
        return "Hello, JavaFX!";
    }

    private Image loadImage(String resourcePath){
        InputStream stream = getClass().getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new IllegalStateException("Resource not found: "+resourcePath);
        }
        return new Image(stream);
    }

    // This is the main methods that starts JavaFX
    static void main(String[] args) {
        launch(args);
    }

}