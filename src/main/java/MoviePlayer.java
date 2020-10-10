public class MoviePlayer extends Product implements MultimediaControl {

  private Screen screen;
  private String monitorType;

  MoviePlayer(String productName, String productManufacturer, Screen productScreen,
      MonitorType productMonitor) {
    super(productName, productManufacturer, ItemType.VISUAL);
    this.screen = productScreen;
    this.monitorType = productMonitor.getPANEL();
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public String toString() {
    return String.format("%s%n%s%nMonitor Type: %s",
        super.toString(), screen.toString(), monitorType);
  }
}
