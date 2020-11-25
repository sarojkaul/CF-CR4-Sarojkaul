public class StockLimitReachedException extends Exception{
    public StockLimitReachedException(){
        super("Stock is already full");
    }

}