public class AudioPlayer extends Product implements MultimediaControl {

  // fields
  public String supportedAudioFormats;
  public String supportedPlaylistFormats;


  AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  AudioPlayer(String name, String manufacturer, ItemType type) {
    super(0, name, manufacturer, type);
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }
}
