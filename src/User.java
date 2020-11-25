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
    static int Counter = 1;
    private ArrayList<Product> userPurchaseditems;
    ArrayList<Shop> shop;

    public  User(String firstname,String lastname,String eMail,String address,int zip,int phone){
        this.UserID = Counter++;
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
    public  void purchaseFromShop(Product product, Shop shop) {
        for(int i = 0; i< shop.getProducts().size();i++)
        if(shop.getProducts().get(i).getProductName().equals(product.getProductName())&& shop.getProducts().get(i).getProductPrice() == product.getProductPrice()){
          int oldStock = shop.getProducts().get(i).getStock();
              if(oldStock==0){
              System.err.println("Sorry! Product is not available");
          }
          else  {

              System.out.println("USer" +getFirstname() +" has purchased product " +product.getProductName() +" from " +shop.getShopName());
              oldStock=oldStock-1;
              shop.getProducts().get(i).setStock(oldStock);
              //shop.UserHistory(this);
              userPurchaseditems.add(product);
              System.out.println("Product's Stock After the Purchase");
              System.out.println("Stock gets reduced by the amount " +oldStock);

              System.out.println("Purchased History of the User After Purchase \n" +userPurchaseditems);
          }
        }

    }
    public void getReport(User userPurchaseditems) throws IOException {
        try {
            File File = new File("User.txt");
            if (File.createNewFile()) {
                System.out.println("File has been created");
            }
            else {
                System.out.println("File is already exists");
            }
            FileWriter fileWriter = new FileWriter(File);
            fileWriter.write("Sorry donot know the way to formating the file its shows all data in one line \n But its shows purschased history after the Display user detail" +System.lineSeparator());
            fileWriter.write(String.valueOf("Purchase History of Users \n " +userPurchaseditems.firstname + " has Purchased Foloowing items \n " +userPurchaseditems));
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    public ArrayList<Shop> getShop() {
        return shop;
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
