import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Sets the scene for the GUI.
 * @author Chaise Ballotti
 */

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 800, 600);
    primaryStage.setTitle("Vinson Dynamics");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
