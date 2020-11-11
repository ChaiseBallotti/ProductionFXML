import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/*
 * This file is used for all the code within the GUI.
 * It is also responsible for making queries and updates to the database.
 * @author Chaise Ballotti
 */

public class Controller {

  ObservableList<Product> productLine = populateProductLine();
  ObservableList<Product> produceList = FXCollections.observableArrayList();

  @FXML
  private TextField addProductName;

  @FXML
  private TextField addManufacturer;

  @FXML
  private TextArea ProductionLogText;

  @FXML
  private ChoiceBox<String> itemTypeBox;

  @FXML
  private TableView<Product> ExistingProductsTv;

  @FXML
  private TableColumn<?, ?> ProductIdCol;

  @FXML
  private TableColumn<?, ?> ProductNameCol;

  @FXML
  private TableColumn<?, ?> ManufacturerCol;

  @FXML
  private TableColumn<?, ?> ItemTypeCol;

  @FXML
  private ListView<Product> ProduceListView;

  @FXML
  private ComboBox<Integer> addQuantity;

  @FXML
  private Button addProductButton;

  @FXML
  private Button RecordProductButton;

  @FXML
  void addProduct(ActionEvent event) {
    //addToDB();
    switch (itemTypeBox.getValue()) {
      case "AUDIO":
        AudioPlayer newAudioPlayer = new AudioPlayer(addProductName.getText(),
            addManufacturer.getText(), ItemType.AUDIO);
        productLine.addAll(newAudioPlayer);
        produceList.addAll(newAudioPlayer);
        break;
      case "VISUAL":
        MoviePlayer newMoviePlayer = new MoviePlayer(addProductName.getText(),
            addManufacturer.getText(),
            ItemType.VISUAL);
        productLine.addAll(newMoviePlayer);
        produceList.addAll(newMoviePlayer);
        break;
      case "AUDIO_MOBILE":
        AudioPlayer newAudioMobilePlayer = new AudioPlayer(addProductName.getText(),
            addManufacturer.getText(), ItemType.AUDIO_MOBILE);
        productLine.addAll(newAudioMobilePlayer);
        produceList.addAll(newAudioMobilePlayer);
        break;
      case "VISUAL_MOBILE":
        MoviePlayer newMovieMobilePlayer = new MoviePlayer(addProductName.getText(),
            addManufacturer.getText(),
            ItemType.VISUAL_MOBILE);
        productLine.addAll(newMovieMobilePlayer);
        produceList.addAll(newMovieMobilePlayer);
      default:
    }
  }

  @FXML
  void recordProduction(ActionEvent event) {
    recordProduction(ProduceListView.getSelectionModel().getSelectedItem());
  }

  // Information that is needed to set the scene before the user interacts with the GUI.
  public void initialize() {
    for (int i = 1; i <= 10; i++) {
      addQuantity.getItems().add(i);
    }
    addQuantity.setEditable(true);
    addQuantity.getSelectionModel().selectFirst();

    for (ItemType item : ItemType.values()) {
      itemTypeBox.getItems().add(item.name());
    }
    itemTypeBox.getSelectionModel().selectFirst();

    ProductIdCol.setCellValueFactory(new PropertyValueFactory("id"));
    ProductNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    ManufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    ItemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));
    ExistingProductsTv.setItems(productLine);

    ProduceListView.setItems(produceList);

  }

  public ObservableList<Product> populateProductLine() {
    return FXCollections.observableArrayList(

    );
  }

  public void recordProduction(Product productToTextArea) {

    for (int i = 1; i <= Integer.parseInt(String.valueOf(addQuantity.getValue())); i++) {
      ProductionRecord pr = new ProductionRecord(productToTextArea, i);
      System.out.println(pr.toString() + "\n");
      ProductionLogText.appendText(pr.toString() + "\n");
    }
  }

  //implement for DB connection in sprint 3
  public ObservableList<Product> populateProductList() {
    return FXCollections.observableArrayList(

    );
  }


  // Connecting to database. Query and updates need to be moved in next iteration.
  public void addToDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn;
    Statement stmt;
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
      preparedStatement.setString(2, itemTypeBox.getValue());
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
