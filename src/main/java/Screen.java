public class Screen implements ScreenSpec {

  // fields that have attributes of a screen
  String resolution;
  int refreshRate;
  int responseTime;

  // Constructor for assignment wants the resolution "widthxheight"
  Screen(String resWidthXHeight, int refreshRate, int gtgResponseTime) {
    this.resolution = resWidthXHeight;
    this.refreshRate = refreshRate;
    this.responseTime = gtgResponseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  public String toString() {
    return String.format("Screen:%nResolution: %s%nRefresh rate: %s%nResponse time: %s",
        resolution, refreshRate, responseTime);
  }
}
