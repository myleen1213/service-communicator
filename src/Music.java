public class Music extends ServiceCommunicator{
    private String music;

    public Music(String music) {
        super("http://itunes.apple.com/search?term=" + music);
        this.music = music;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public static void main(String[] args) {
        Music song1 = new Music("alicia_keys&limit=1");
        song1.connect();
        String response = song1.get();
        System.out.println("Song");
        System.out.println(response);



    }


}
