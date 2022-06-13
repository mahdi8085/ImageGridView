import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ImageGridView.fxml")));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}