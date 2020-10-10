public enum MonitorType {
  LCD("LCD"),
  LED("LED");

  private final String PANEL;

  MonitorType(String panelType) {
    this.PANEL = panelType;
  }

  public String getPANEL() {
    return PANEL;
  }
}
