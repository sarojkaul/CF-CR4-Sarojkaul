import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {

    private static int UserID;
    private String firstname;
    private String lastname;
    private String eMail;
    private String address;
    private int zip;
    private int phone;
    int Counter = 0;
    private ArrayList<Product> userPurchaseditems;

    public  User(String firstname,String lastname,String eMail,String address,int zip,int phone){
        Counter++;
        this.UserID = Counter;
        this.firstname = firstname;
        this.lastname=lastname;
        this.eMail = eMail;
        this.address=address;
        this.zip=zip;
        this.phone=phone;
        this.userPurchaseditems = new ArrayList<>();
    }

    public void setUserPurchaseditems(ArrayList<Product> userPurchaseditems) {
        this.userPurchaseditems = userPurchaseditems;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public static int getUserID() {
        return UserID;
    }
    public int getZip() {
        return zip;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public ArrayList<Product> getUserPurchaseditems() {
        return userPurchaseditems;
    }

    public void UserPurchase(Product product){
        this.userPurchaseditems.add(product);

    }


    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", address='" + address + '\'' +
                ", zip=" + zip +
                ", phone=" + phone +
                ", Counter=" + Counter +
                ", userPurchaseditems=" + userPurchaseditems +
                '}';
    }
}
