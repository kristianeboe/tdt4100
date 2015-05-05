package observerObserved;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristian on 02/05/15.
 */
public class Stock {
    protected String ticker;
    protected double price;
    protected List<StockListener> stockListeners;


    public Stock(String ticker, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price must be positive");
        }
        this.ticker = ticker;
        this.price = price;
        stockListeners = new ArrayList<>();
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price must be positive");
        }
        firePriceChanged(price);
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void addStockListener(StockListener listener) {
        if (!stockListeners.contains(listener)) {
            stockListeners.add(listener);
        }

    }

    public void removeStockListener(StockListener listener) {
        if (stockListeners.contains(listener)) {
            stockListeners.remove(listener);
        }
    }

    protected void firePriceChanged(double newPrice){
        for (StockListener listener : stockListeners) {
            listener.stockPriceChanged(this, this.price, newPrice);
        }
    }
}
