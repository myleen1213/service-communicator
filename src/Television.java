public class Television extends ServiceCommunicator{
    private String tvshow;

    public Television(String tvshow) {
        super("http://api.tvmaze.com/singlesearch/shows?q=" + tvshow);
        this.tvshow = tvshow;
    }

    public String getTvshow() {
        return tvshow;
    }

    public void setTvshow(String tvshow) {
        this.tvshow = tvshow;
    }


    public static void main(String[] args) {
        Television show1 = new Television("Ozark");
        show1.connect();
        String response = show1.get();
        System.out.println("Tv Show: " );
        //print response
        System.out.println(response);
    }
}
