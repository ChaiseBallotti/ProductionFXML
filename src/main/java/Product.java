public abstract class Product implements Item {

  int id;
  ItemType type;
  String manufacturer;
  String name;

  Product(int id, ItemType type, String manufacturer, String name) {
    this.id = id;
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
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

  public int getId() {
    return id;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
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
