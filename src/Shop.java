import com.sun.deploy.net.MessageHeader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Shop {

    private String shopName;
    private String address;
    ArrayList<Product> products;
    ArrayList<User> User;


    public Shop(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
        this.products = new ArrayList<>();
        this.User = new ArrayList<>();

    }
    public Shop(){

    }

    //Method that add the products to the Shop
    public void addShopProduct(Product product) {

        products.add(product);
        for(int i=0;i<products.size();i++){
            if (products.get(i).getStock()>=15){
                System.err.println("A product can only have max.stock 15 items");

            }
            else {
                int newStock = products.get(i).getStock()+1;
                products.get(i).setStock(newStock);

            }

    }}

    //Add UserHistroy
    public void UserHistory(User user){
        User.add(user);
    System.out.println("Purchase gets added to the purchase history of user") ;

}
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setUser(ArrayList<User> user) {
        User = user;
    }

    public String getAddress() {
        return address;
    }


    public ArrayList<User> getUser() {
        return User;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }



    //Method for removing products from shop
    public static void purchase(Product product, Shop shop, User user) {
        user.UserPurchase(product);
        System.out.println("User " + user.getFirstname() + " buy product " + product.getProductName() + " from Shop " + shop.getShopName());
        shop.removeProducts(product);
        System.out.println("Stock gets reduced by the amount " + user.Counter);
        System.out.println("Purchase gets added to the purchase history of user "+user.getFirstname());
        System.out.println("Stock after Purchasing Items " + product.getStock());
        System.out.println("Purchase History before and after the purchase " +user);

    }

    public void removeProducts(Product product) {

        products.remove(product);

    }

    public void PrintHeader() {
        System.out.println("+-------------------------+");
        System.out.println("|       Welcome           |");
        System.out.println("|       to the            |");
        System.out.println("|       Shop              |");
        System.out.println("+-------------------------+");
    }

    public void PrintMenu() {
        System.out.println("Make a selection");
        System.out.println("1) Display all products");
        System.out.println("2) Display all products of category x.");
        System.out.println("3) Display all products where stock <5.");
        System.out.println("4) Display all products out of stock.");
        System.out.println("0) Exit.");
    }

    public void UserInput() {
        int n = 0;
        try {
            do {
                Scanner userinput = new Scanner(System.in);
                System.out.println("Enter Your Choice");
                int x = userinput.nextInt();
                if (x >= 0 && x <= 4) {
                    switch (x) {
                        case 1:

                            System.out.println("Product " +products);//do not know why it say null in the console
                            break;
                            case 2:
                                System.out.println(products.contains("JACKET"));
                                break;

                        case 3: {
                            System.out.println("selection 3");
                            break;
                        }
                        case 4: {
                            System.out.println("selection 4");
                            break;
                        }

                        case 0: {
                            System.out.println("Exit");
                            n = -1;
                        }
                    }
                } else {
                    System.out.println("Enter Valid number");
                }
            } while (n == 0);
            System.out.println("End");
        } catch (NumberFormatException e) {
            System.out.println("Enter numeric value");
        }

    }

// MAin for Running Menu
    public static void main(String[] args) {

 Shop shop = new Shop();
 shop.PrintHeader();
 shop.PrintMenu();
 shop.UserInput();
 }



    //get userPurchased Report in the file

    public User getReport(User user) throws IOException {
        try {
            File File = new File("User.txt");
            if (File.createNewFile()) {
                System.out.println("File has been created");
            }
            else {
                System.out.println("File is already exists");
            }
            FileWriter fileWriter = new FileWriter(File);
            fileWriter.write(String.valueOf(user));
            System.lineSeparator();
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return user;
    }






    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                ", User=" + User +
                '}';
    }

    }
