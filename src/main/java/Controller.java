import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {
  @FXML
  Tab productLine;
  @FXML
  Tab produce;
  @FXML
  Tab productionLog;
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    FXMLLoader loader = new FXMLLoader();
    try {
      AnchorPane anchor1 = loader.load(getClass().getResource("ProductLine.fxml"));
      productLine.setContent(anchor1);
    } catch (IOException iex) {
      System.out.println("unable to load ProductLine");
    }

    loader = new FXMLLoader();
    try {
      AnchorPane anchor2 = loader.load(getClass().getResource("Produce.fxml"));
      produce.setContent(anchor2);
    } catch (IOException iex) {
      System.out.println("unable to load Produce");
    }

    loader = new FXMLLoader();
    try
    {
      AnchorPane anchor3 = loader.load(getClass().getResource("ProductionLog.fxml"));
      productionLog.setContent(anchor3);
    }
    catch(IOException iex)
    {
      System.out.println("unable to load ProductionLog");
    }
  }
}