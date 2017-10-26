package library;

public class Book extends LibraryItem {

    //Attributes go here
    private String authorName;

    public Book(int itemID, double price, String bookName, String authorName) {
        super(bookName, itemID, price);
        this.authorName = authorName;
    }

//Methods go here

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String returnBookDetails(){
        return this.getItemName() + " " + this.getAuthorName() + " ID:" + this.getItemID() + " £" + this.getPrice();
    }
}

class Journal extends Book implements AcademicTexts {

    //Attributes go here
    private String topic;

    public Journal(int itemID, double price, String bookName, String authorName, String topic) {
        super(itemID, price, bookName, authorName);
        this.topic = topic;
    }

    @Override
    public void extendReturnDate() {
        String tempReturnDateString;
        int tempReturnDateInt;
        tempReturnDateString = this.getReturnDate();
        tempReturnDateInt = Integer.parseInt(tempReturnDateString) + 5;
        this.setReturnDate("" + tempReturnDateInt);
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

    public Magazine(int itemID, double price, String bookName, String authorName, int issueNumber) {
        super(itemID, price, bookName, authorName);
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
