
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

  @FXML
  private Button addProductButton;
  private Button recordProductionButton;

  @FXML
  public void testOut(ActionEvent event){
    System.out.println("Button pushed");
  }
}
