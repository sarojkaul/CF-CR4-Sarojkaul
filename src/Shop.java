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

    }}


    //Add UserHistroy
    public void UserHistory(User user){
        User.add(user);
    System.out.println("Purchase gets added to the purchase history of user ") ;

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

    public  String getShopName() {
        return shopName;
    }



    //Method for removing products from shop
        public void removeProducts(Product product) {
        products.remove(product);

    }
//Method to increase stock
    public void increaseStock(int productID,int Numberofproducts) throws StockLimitReachedException  {
        int oldStock;
        for (Product item : products)
        {
          if(item.getProductID()==productID){
              oldStock = item.getStock();
              if (oldStock > 15){
                  item.setStock((oldStock)+Numberofproducts);
                  System.out.println("Stock is changed ");
                  System.out.println("Product " +item.getProductID() +"  "+item.getProductName() +" " +" stock " +item.getStock());
              }
              else {
                  System.err.println("this product cannot be added");
                 throw new StockLimitReachedException();
              }
     
  }
        }

    }

    //Check Limitation of Stock
    public void CheckStock(Product product) {
        int old_Stock;
        for(Product item: products) {
            old_Stock = item.getStock();
            if (old_Stock <= 5) {
                System.out.println("\"Attention! shop has less than 5 items in Stock");

            }
        }

    }

    public void addItemstoStock(int productID,int Numberofproducts) {
        try{
            this.increaseStock(productID,Numberofproducts);
        }catch (StockLimitReachedException e){
            System.out.println(e.getMessage());
        }
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
        System.out.println("2) Display all products of category Jacket.");
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
                        case 1: {
                            System.out.println("Display All the Products");
                            for (int i = 0; i < products.size(); i++)
                                System.out.println(products.get(i));
                        }
                            break;

                            case 2:
                                System.out.println("Products Which are belonged to category Jacket");
                                for (int i = 0; i < products.size(); i++) {
                                    if (products.get(i).getProductcategory() == ProductCategory.JACKET)
                                        System.out.println( products.get(i));

                                }

                                 break;

                        case 3:
                            System.out.println("Display all products where stock <5");
                            for(int i=0;i<products.size();i++) {
                                if (products.get(i).getStock() < 5)
                                    System.out.println(products.get(i));
                            }
                          break;

                        case 4:
                            System.out.println("Display all products out of stock.");
                            for (int i = 0; i < products.size(); i++) {
                                if (products.get(i).getStock() == 0)
                                    System.err.println("\n" + products.get(i));
                                }
                            break;

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

        Shop shop = new Shop("Louis Vuition", "Karlsplatz");
        Product product1 = new Product("Puma T-shirt", "100% cotton,Farbe White", 20, ProductCategory.TSHIRT,6);
        Product product2 = new Product("addidas T-shirt", "100% cotton,Farbe Black", 35, ProductCategory.TSHIRT,5);
        Product product3 = new Product("Only T-shirt", "100% cotton,Farbe Grey", 25, ProductCategory.TSHIRT,0);
        Product product4 = new Product("Puma Jacket", "Farbe White", 65, ProductCategory.JACKET,0);
        Product product5 = new Product("Only Jacket", "Farbe Black", 75, ProductCategory.JACKET,3);

        shop.addShopProduct(product1);
        shop.addShopProduct(product2);
        shop.addShopProduct(product3);
        shop.addShopProduct(product4);
        shop.addShopProduct(product5);

        shop.PrintHeader();
        shop.PrintMenu();
        shop.UserInput();

 }



    //get userPurchased Report in the file




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


