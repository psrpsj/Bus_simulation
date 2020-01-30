//written by park1564, imxxx074

import java.util.ArrayList;

public class Bus {

	public Bus(boolean expr) {
		this.express = expr;
		this.riders = new ArrayList();
		this.numPeople = 0;
	}

	//Add Rider into bus
  public boolean addRiders(Rider p) {
    if (numPeople < 50) {
    	riders.add(p);
    	numPeople++;
    	return true;
    }
    return false;
  }

	//Passenger is leaving the bus
  public Rider[] removeRidersAtStop(int stop){
    int riderCount = 0;
    for (int i = 0; i < riders.size(); i++){
    	if (((Rider) riders.get(i)).getDestinationStation() == stop) {
    		riderCount++;
    	}
    }
    int count = 0;
    int s = riders.size();
    ArrayList leaving = new ArrayList();
    ArrayList staying = new ArrayList();
    for (int i = 0; i < s; i++) {
    	Rider p = (Rider) riders.remove(0);
    	if(p.getDestinationStation() == stop) {
    		leaving.add(p);
    	}
			else {
    		staying.add(p);
    	}
    }
    riders = staying;
    count = riders.size();

    //copy over leaving into an array
    Rider[] temp = new Rider[leaving.size()];
    for (int i = 0; i < leaving.size(); i++) {
    	temp[i] = (Rider) leaving.get(i);
    	numPeople--;
    }
    return temp;
  }

  public boolean isFull() {
    return numPeople == 50;
  }

  public int getPeople() {
    return numPeople;
  }

  public boolean isExpress() {
    return express;
  }

	//initialize
	private boolean express;
	private ArrayList riders;
	private int numPeople;
}// Bus class
