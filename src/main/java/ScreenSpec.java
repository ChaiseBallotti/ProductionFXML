public interface ScreenSpec {

  // Methods that every screen will have
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
