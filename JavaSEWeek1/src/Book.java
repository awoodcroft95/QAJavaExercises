public class Book extends LibraryItem {

    //Attributes go here
    private String bookName;
    private String authorName;

    public Book(){

    }

    //Methods go here



}

class Journal extends Book implements AcademicTexts {

    //Attributes go here
    private String topic;

    public Journal() {

    }

    @Override
    public void extendReturnDate() {

    }
}

class Magazine extends Book {

    //Attributes go here
    private int issueNumber;

    public  Magazine() {

    }

    //Methods go here

}
