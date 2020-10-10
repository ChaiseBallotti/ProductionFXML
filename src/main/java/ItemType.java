public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  private final String CODE;

  ItemType(String CODE) {
    this.CODE = CODE;
  }

  public String getCode() {
    return CODE;
  }
}
