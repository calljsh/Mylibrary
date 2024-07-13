package Book;

public class BOOK
{


    private String name;
    private String author;
    private int price  ;
    private String type; //图书类型
    private boolean borrowed;
    public BOOK(String name, String author, int price, String type)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
       // this.borrowed = borrowed;
    }
    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((borrowed==true?"已经被借出":"没有被借出"))+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
