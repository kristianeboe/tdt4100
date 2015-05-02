package observerObserved;

/**
 * Created by Kristian on 02/05/15.
 */
public interface StockListener {
    public void stockPriceChanged(Stock stock, double oldPrice, double newPrice);
}
