public class Zipcode extends ServiceCommunicator{
    private String zipcode;

    public Zipcode(String zipcode) {
        super("http://api.zippopotam.us/us/" + zipcode);
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public static void main(String[] args) {
      //create a new zipccode and populate it
      Zipcode zip = new Zipcode("33033");
      //connect the zipcode
      zip.connect();
      //make response = zipcode entered
      String response = zip.get();
      System.out.println("Zip results: " );
      //print response
      System.out.println(response);



     // Zipcode zip2 = new Zipcode("10001");
      //Zipcode zip3 = new Zipcode("32304");
      //Zipcode zip4 = new Zipcode("33065");




    }


}
