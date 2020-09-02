import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 800, 500);
    //scene.getStylesheets().add(getClass().getResource("java\\Steel.css").toExternalForm());
    primaryStage.setTitle("Vinson Dynamics");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
