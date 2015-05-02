package observerObserved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kristian on 02/05/15.
 */
public class StockIndex implements StockListener{
    private String name;
    private double index;
    private List<Stock> stocks;


    public StockIndex(String name, Stock... stocks) {
        this.name = name;
        this.stocks = new ArrayList<>(Arrays.asList(stocks));
        this.index = getIndex();
    }

    public void addStock(Stock stock){
        if (!stocks.contains(stock)){
            stocks.add(stock);
            index = getIndex();
        }
    }

    public void removeStock(Stock stock){
        if (stocks.contains(stock)){
            stocks.remove(stock);
            index = getIndex();
        }


    }

    public double getIndex(){
        if (!this.stocks.isEmpty()){
            for (Stock stock:this.stocks){
                index += stock.getPrice();
            }
            return index;
        }
        return 0;
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
        index += newPrice-oldPrice;
        System.out.println("Stock name: "+stock.getTicker()+"\n"+ "Old price: "+oldPrice+"\n"+"New price: "+newPrice);
    }

}
