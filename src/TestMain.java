import java.util.HashMap;
import java.util.Scanner;

public class TestMain
{
    public static void main(String[] args) {
        Product product1 = new Product("Puma T-shirt", "100% cotton,Farbe White", 20, ProductCategory.TSHIRT,6);
        Product product2 = new Product("addidas T-shirt", "100% cotton,Farbe Black", 35, ProductCategory.TSHIRT,5);
        Product product3 = new Product("Only T-shirt", "100% cotton,Farbe Grey", 25, ProductCategory.TSHIRT,0);
        Product product4 = new Product("Puma Jacket", "Farbe White", 65, ProductCategory.JACKET,4);
        Product product5 = new Product("Only Jacket", "Farbe Black", 75, ProductCategory.JACKET,3);
        Product product6 = new Product("addidas Jacket", "Farbe Grey", 100, ProductCategory.JACKET,10);
        Product product7 = new Product("Puma Trouser", "100% cotton,Farbe Black", 50, ProductCategory.TROUSER,4);

        HashMap<Integer, Product> products = new HashMap<>();
        products.put(product1.getProductID(), product1);
        products.put(product2.getProductID(), product2);
        products.put(product3.getProductID(), product3);
        products.put(product4.getProductID(), product4);
        products.put(product5.getProductID(), product5);
        products.put(product6.getProductID(), product6);
        products.put(product7.getProductID(), product7);

        //creating Shop
        Shop shop1 = new Shop("Louis Vuition", "Karlsplatz");
        Shop shop2 = new Shop("Harley-Davidson", "Landstraße");
        Shop shop3 = new Shop("Shein", "Schwedenplatz");


        // add products to the shop
        shop1.addShopProduct(product1);
        shop1.addShopProduct(product2);
        shop1.addShopProduct(product3);
        shop1.addShopProduct(product4);
        shop2.addShopProduct(product5);
        shop2.addShopProduct(product6);
        shop3.addShopProduct(product7);

         // Users

        User user1 = new User("saroj", "kaul", "saroj@gmail.com", "vienna", 1200, 690234555);
        User user2 = new User("Maria", "Müller", "Maria@gmail.com", "vienna", 1210, 640234555);
        User user3 = new User("Stephen", "John", "stephen@gmail.com", "vienna", 1220, 590234555);
        User user4 = new User("Joe", "Müller", "joe@gmail.com", "vienna", 1230, 790234555);

        HashMap<Integer, User> users = new HashMap<>();
        users.put(User.getUserID(), user1);
        users.put(User.getUserID(), user2);
        users.put(User.getUserID(), user3);
        users.put(User.getUserID(), user4);

        user2.purchaseFromShop(product1,shop1);

        //Work on Tomorrow why cannot add more products

        user3.purchaseFromShop(product3,shop1);//User Try to Purchase Product from Out of stock


        try {
            user2.getReport(shop1);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        


    }
}
