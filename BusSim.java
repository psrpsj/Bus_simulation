//written by park1564, imxxx074
//Code were inspired by FerrySim from Lab 11 of CSCI1933

public class BusSim {

    // Make genda static in order to access from other class
    public static PQ agenda = new PQ();

    // Array of queues to store Passengers for each stop
    public static Q<Rider>[] lines = new Q[30];
    static int[] express = {0,1,4,8,12,14,15,16,20,24,28,29};

    public static void main(String[] args) {

    	for (int i = 0; i < lines.length; i++) {
    		lines[i] = new Q();
    		agenda.add((Event) new RiderEvent(i), 0);
    	}

    	// normal bus
    	int busNum = 10;
        for (int i = 0; i < busNum; i++) {
        	agenda.add(new BusEvent((int) 30/busNum*i, new Bus(false)), 0);
        }

    	// express bus
    	int busNum2 = 4;
        for (int i = 0; i < busNum2; i++) {
        	agenda.add(new BusEvent((int) express[(int) (12/busNum2*i)], new Bus(true)), 0);
        }

        int setTime = 10000;
        while(agenda.getCurrentTime() <= setTime) {
            agenda.remove().run();
        }

        // Adding waiting times of those who could not get into the bus until set time.
        for (int i = 0; i < lines.length; i++) {
        	while (!(lines[i].length() == 0)) {
        		Statistic.waitTimeList.add(setTime - lines[i].remove().getBoardingTime());
        	}
        }

        Statistic myStat = new Statistic();
        System.out.println("Avg Number of People waiting in line: " + myStat.avgWaitingTime()/60);
        System.out.println("Max Number of People waiting in line: " + myStat.maxWaitingTime()/60);
        System.out.println("Avg Number of People in Bus: " + myStat.avgNumBoarded());
        System.out.println("Avg Number of people traveling : " + myStat.avgTravelTime() / 60);

    }
} //BusSim class
