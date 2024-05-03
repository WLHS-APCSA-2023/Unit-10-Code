public class Textbook extends Book{

    private int edition;
    private String title;
    private double price;

    public Textbook(String bookTitle, double bookPrice, int edition){
        super(title, price);
        this.edition = edition;
    }

    public int getEdition(){
        return edition;
    }

    public boolean canSubstituteFor(Textbook other){
        return other.getTitle() == this.getTitle() && edition >= other.getEdition();
    }

    public String getBookInfo(){
        return super.getBookInfo() + "-" + edition;
    }
    
}
