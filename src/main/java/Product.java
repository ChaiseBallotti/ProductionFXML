public abstract class Product implements Item {

  int id;
  ItemType type;
  String manufacturer;
  String name;

  Product(int id, String productName, String manufacturer, ItemType type) {
    this.id = id;
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = productName;
  }

  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  Product(String name, String manufacturer) {
    this.name = name;
    this.manufacturer = manufacturer;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int productId) {
    id = productId;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setType(ItemType productType) {
    type = productType;
  }

  public ItemType getType() {
    return type;
  }

  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  public String toString() {
    return String.format("Name: %s%nManufacturer: %s%nType: %s", name, manufacturer, type);
  }
}

/*
class Widget extends Product implements Item {

  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  @Override
  public String toString() {
    return String
        .format("Name: %s\nManufacturer: %s\nType: %s", name, manufacturer, type.getCode());
  }
}
*/