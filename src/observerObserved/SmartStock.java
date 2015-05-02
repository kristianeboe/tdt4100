package observerObserved;

/**
 * Created by Kristian on 02/05/15.
 */
public class SmartStock extends Stock {


    public SmartStock(String ticker, double price) {
        super(ticker, price);
    }


    @Override
    public void setPrice(double price) {
        super.setPrice(price);
        if (price <= 0){
            throw new IllegalArgumentException("price must be positive");
        }
        for (StockListener listener:super.stockListeners){
        }
    }
}
