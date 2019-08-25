package multithread;

import java.util.concurrent.Semaphore;

// not complete
public class DesignH2O {

	public static void main(String[] args) throws InterruptedException {
		Semaphore sh = new Semaphore(2, true);
		Semaphore so = new Semaphore(0, true);
		
		Thread th = new Thread(new Hydrogen(sh, so), "H");
		Thread to = new Thread(new Oxygen(sh, so), "O");
		
		th.start(); to.start();
	}
}

class Hydrogen implements Runnable {
	private Semaphore sh, so;
	
	public Hydrogen(Semaphore sh, Semaphore so) {
		this.sh = sh; this.so = so;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				sh.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("H");
			
			so.release();
		}
	}
}

class Oxygen implements Runnable {
	private Semaphore sh, so;
	
	public Oxygen(Semaphore sh, Semaphore so) {
		this.sh = sh; this.so = so;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				so.acquire(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print("O");
			sh.release(2);
		}
	}
}
