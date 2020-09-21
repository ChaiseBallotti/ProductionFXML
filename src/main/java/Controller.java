import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/*
 * This file is used for all the code within the GUI.
 * It is also responsible for making queries and updates to the database.
 * @author Chaise Ballotti
 */

public class Controller {

  @FXML
  private TextField addProductName;

  @FXML
  private TextField addManufacturer;

  @FXML
  private ChoiceBox<String> itemType;

  @FXML
  private ComboBox<String> addQuantity;

  @FXML
  private Button addProductButton;

  @FXML
  private Button RecordProductButton;

  @FXML
  void addProduct(ActionEvent event) {
    connectToDB();
  }

  @FXML
  void recordProduction(ActionEvent event) {
    System.out.println("product recorded");
  }

  // Information that is needed to set the scene before the user interacts with the GUI.
  public void initialize(){
    itemType.getItems().add("AUDIO");

    for(int i = 1; i <= 10; i++){
      addQuantity.getItems().add(Integer.toString(i));
    }
    addQuantity.setEditable(true);
    addQuantity.getSelectionModel().selectFirst();
  }

  // Connecting to database. Query and updates need to be moved in next iteration.
  public void connectToDB(){
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String insertSql = "insert into PRODUCT (PRODUCT_NAME, DEVICE_TYPE, MANUFACTURER) "
          + "values (?, ?, ?)";

      PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
      preparedStatement.setString(1, addProductName.getText());
      preparedStatement.setString(2, itemType.getValue());
      preparedStatement.setString(3, addManufacturer.getText());
      preparedStatement.executeUpdate();

      String sql = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
        System.out.println(rs.getString(4));
      }

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
