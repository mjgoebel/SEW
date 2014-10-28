package goebel;

import java.util.ArrayList;

/**
 * Benachrichtigungssystem fuer Observers
 * @author Melanie Goebel
 * @version 2014-10-27
 */
public class Wecker implements Runnable,Observable{
	ArrayList<Observer> observers = new ArrayList<Observer>();

	@Override
	public void run() {
		try {
			benachrichtige();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.err.println("Fehler beim Wecksystem");
		}
	}
	
	@Override
	public void anmelden(Observer o) {
		observers.add(o);
	}

	@Override
	public void abmelden(Observer o) {
		observers.remove(o);
	}

	@Override
	public void benachrichtige() {
		for(Observer o: observers){
			o.synchoniziereZustand();
		}
		
	}
	
}