package goal.design.patterns.observer;

public class StockObserver implements Observer {
	
	private double ibmPrice;
	private double applPrice;
	private double googPrice;
	private Subject stockGrabber;
	
	private String name;
	
	public StockObserver(Subject stockGrabber, String name) {
		this.stockGrabber = stockGrabber;
		this.name = name;
		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double applPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.applPrice = applPrice;
		this.googPrice = googPrice;
		System.out.println("Observer: " + name);
		System.out.println("IBM: " + ibmPrice + ", APPL: " + applPrice + ", GOOG: " + googPrice);
	}

}
