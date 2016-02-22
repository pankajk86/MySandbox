package goal.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {
	
	private List<Observer> observerList;
	private double ibmPrice;
	private double applPrice;
	private double googPrice;
	
	public StockGrabber() { 
		this.observerList = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o) {
		observerList.add(o);
	}

	@Override
	public void unregister(Observer o) {
		System.out.println("Observer " + (observerList.indexOf(o) + 1) + " removed.");
		observerList.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o: observerList) {
			o.update(ibmPrice, applPrice, googPrice);
		}
	}
	
	public int getObserversCount() {
		return observerList.size();
	}
	
	
	public void setIBMPrice(double price) {
		this.ibmPrice = price;
		notifyObservers();
	}
	
	public void setAPPLPrice(double price) {
		this.applPrice = price;
		notifyObservers();
	}
	
	public void setGOOGPrice(double price) {
		this.googPrice = price;
		notifyObservers();
	}

}
