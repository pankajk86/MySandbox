package goal.design.patterns.observer;

public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        Observer observer = new StockObserver(stockGrabber, "Observer1");

        stockGrabber.setIBMPrice(200.45);
        stockGrabber.setAPPLPrice(400.45);
        stockGrabber.setGOOGPrice(800.45);

        stockGrabber.unregister(observer);
        System.out.println(stockGrabber.getObserversCount());
    }

}
