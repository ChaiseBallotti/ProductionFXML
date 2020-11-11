import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;

  ProductionRecord(int ProductId) {
    this.productId = productId;
    this.productionNumber = 0;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  ProductionRecord(Product newProduct) {
    serialNumber = String.format("%s%s%05d", newProduct.getManufacturer().substring(0, 3),
        newProduct.type.getCode());
    productionNumber = 0;
    productId = 0;
    dateProduced = new Date();
  }

  ProductionRecord(Product newProduct, int numOfItems) {
    this.serialNumber = String.format("%s%s%05d",
        newProduct.getManufacturer().substring(0, 3), newProduct.type.getCode(), numOfItems);
    this.productionNumber = 0;
    this.productId = 0;
    this.dateProduced = new Date();
  }

  ProductionRecord(int ProductionRecord, int productId, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public void setProductID(int productId) {
    this.productId = productId;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public int getProductID() {
    return productId;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public Date getProdDate() {
    return dateProduced;
  }

  @Override
  public String toString() {
    return String.format("Prod. Num: %d Product ID: %d Serial Num: %s Date: %s",
        productionNumber, productId, serialNumber, dateProduced.toString());
  }


}
