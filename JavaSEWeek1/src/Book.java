public class Book extends LibraryItem {

    //Attributes go here
    private String bookName;
    private String authorName;

    public Book(String itemName, String itemID, double price, String bookName, String authorName) {
        super(itemName, itemID, price);
        this.bookName = bookName;
        this.authorName = authorName;
    }

//Methods go here


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

class Journal extends Book implements AcademicTexts {

    //Attributes go here
    private String topic;

    public Journal(String itemName, String itemID, double price, String bookName, String authorName, String topic) {
        super(itemName, itemID, price, bookName, authorName);
        this.topic = topic;
    }

    @Override
    public void extendReturnDate() {

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

class Magazine extends Book {

    //Attributes go here
    private int issueNumber;

    public Magazine(String itemName, String itemID, double price, String bookName, String authorName, int issueNumber) {
        super(itemName, itemID, price, bookName, authorName);
        this.issueNumber = issueNumber;
    }

    //Methods go here


    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}
