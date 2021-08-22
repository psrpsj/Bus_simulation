//written by park1564, imxxx074
//Code were inspired by RiderEvent on Lab 11 in CSCI1933 done by park1564, imxxx074

import java.util.Random;

public class RiderEvent implements Event{

	public RiderEvent(int stop){
		this.stop = stop;
	}

	public int getstop(){
		return stop;
	}

	public void run() {

		Rider newRider = new Rider(this.stop, BusSim.agenda.getCurrentTime());
		for (int i = 0; i < 30; i++) {
			if (this.stop == i) {
				BusSim.lines[i].add(newRider);
			}
		}

		//Find if the stop is downtown or not
		boolean downtown = false;
		for (int i = 0; i < 6; i++) {
			if (this.stop == downtownStop[i]) {
				downtown = true;
			}
		}

		//According to stop is in downtown or not add into agenda accordingly
		if (downtown) {
			Random rand = new Random();
			int random_index = rand.nextInt(20);
			double time = (120 + (arrivalPercents[random_index] * 120))/2;
			RiderEvent newEvent = new RiderEvent(this.stop);
			BusSim.agenda.add(newEvent, time);
		}
		else {
			Random rand = new Random();
			int random_index = rand.nextInt(20);
			double time = 120 + (arrivalPercents[random_index] * 120);
			RiderEvent newEvent = new RiderEvent(this.stop);
			BusSim.agenda.add(newEvent, time);
		}
	}

	//initialization
	private int stop;
	double[] arrivalPercents = {0.75, 0.75, 0.5, 0.5, 0.5, 0.2, 0.2, 0.2, 0.2,
		0, 0, -0.2, -0.2, -0.2, -0.2, -0.5, -0.5, -0.5, -0.75, -0.75};
	int[] downtownStop = {0, 1, 29, 14, 15, 16};
} //RideEvent class
