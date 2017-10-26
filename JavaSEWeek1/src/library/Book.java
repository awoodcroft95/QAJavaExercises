package library;

public class Book extends LibraryItem {

    //Attributes go here
    private String authorName;

    public Book(String bookName, int itemID, double price, String authorName) {
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

    @Override
    public String toString() {
        return super.toString() + "-" + this.getAuthorName();
    }
}

class Journal extends Book implements AcademicTexts {

    //Attributes go here
    private String topic;

    public Journal(String bookName, int itemID, double price, String authorName, String topic) {
        super(bookName, itemID, price, authorName);
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

    @Override
    public String returnBookDetails() {
        return super.returnBookDetails() + " Topic:" + this.getTopic();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + this.getTopic();
    }
}

class Magazine extends Book {

    //Attributes go here
    private int issueNumber;

    public Magazine(String bookName, int itemID, double price, String authorName, int issueNumber) {
        super(bookName, itemID, price, authorName);
        this.issueNumber = issueNumber;
    }

    //Methods go here
    @Override
    public String returnBookDetails() {
        return super.returnBookDetails() + " IssueNo:" + this.getIssueNumber();
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + this.getIssueNumber();
    }
}
