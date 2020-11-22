import java.util.ArrayList;

public class Product {

    private int productID;
    private String  productName;
    private String ProductDescription;
    private double productPrice;
    private ProductCategory productcategory;
    private int Stock;
    int counter = 0;


    public Product(String productName, String productDescription, double productPrice, ProductCategory prouctcategory) {
        counter++;
        this.productID = counter;
        this.productPrice = productPrice;
        this.productName = productName;
        this.ProductDescription = productDescription;
        this.productcategory = prouctcategory;
        this.Stock = 5;
    }

    public  String getProductName() {
        return productName;
    }


    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductcategory(ProductCategory productcategory) {
        this.productcategory = productcategory;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public int getStock() {
        return Stock;
    }

    //public static String getProductName() {
       // return productName;
    //}

    public String getProductDescription() {
        return ProductDescription;
    }

    public int getProductID() {
        return productID;
    }

    public ProductCategory getProductcategory() {
        return productcategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productcategory=" + productcategory +
                ", Stock=" + Stock +
                ", counter=" + counter +
                '}';
    }
}

