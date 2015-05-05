package observerObserved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kristian on 02/05/15.
 */
public class SmartStock extends Stock {
    private Map<StockListener, ArrayList<Double>> stockListeners;


    public SmartStock(String ticker, double price) {
        super(ticker, price);
        stockListeners = new HashMap<>();
    }


    @Override
    protected void firePriceChanged(double newPrice) {
        for (StockListener listener : stockListeners.keySet()) {
            if (newPrice < stockListeners.get(listener).get(0) || newPrice > stockListeners.get(listener).get(1)) {
                listener.stockPriceChanged(this, this.price, newPrice);
                super.firePriceChanged(newPrice);
            }
        }
    }

    public void addStockListener(StockListener listener, double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Illegal interval range");
        }

        ArrayList<Double> interval = new ArrayList<Double>();
        interval.add(min);
        interval.add(max);
        stockListeners.put(listener, interval);
    }

}
