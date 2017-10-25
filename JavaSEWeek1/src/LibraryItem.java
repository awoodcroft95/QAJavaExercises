public abstract class LibraryItem {

    //Attributes go here
    private String itemName;
    private String itemID;
    private double price;
    private boolean outStatus;
    private String returnDate;

    public LibraryItem(String itemName, String itemID, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.price = price;
        this.outStatus = false;
    }


    //Methods go here
//Getters and Setters
    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOutStatus() {
        return outStatus;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOutStatus(boolean outStatus) {
        this.outStatus = outStatus;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}

class Map extends LibraryItem {

    private String location;
    private String date;

    public Map(String itemName, String itemID, double price, String location, String date) {
        super(itemName, itemID, price);
        this.location = location;
        this.date = date;
    }

}
