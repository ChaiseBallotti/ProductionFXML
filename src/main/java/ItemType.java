public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  private final String CODE;

  ItemType(String itemCode) {
    this.CODE = itemCode;
  }

  public String getCode() {
    return CODE;
  }

}
