public class StockLimitReachedException extends Exception{
    public StockLimitReachedException(){
        super("Sorry!Stock has reached its maximum limit ");
    }

}