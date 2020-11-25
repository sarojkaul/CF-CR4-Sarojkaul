public class StockLowException extends Exception{
    public StockLowException(){
        super("Attention! shop has less than 5 items in Stock  ");
    }

}