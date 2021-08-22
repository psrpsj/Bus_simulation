//written by park1564, imxxx074

public class Statistic{

	public double avgNumBoarded() {
		int numSum = 0;
		for (int i = 0; i < numBoardedList.size(); i++) {
			numSum += (int) numBoardedList.get(i);
		}
		return (double)numSum/numBoardedList.size();
	}

	public double avgWaitingTime() {
		double timeSum = 0;
		for (int i = 0; i < waitTimeList.size(); i++) {
			timeSum += (double) waitTimeList.get(i);
		}
		return timeSum/waitTimeList.size();
	}

	public double avgTravelTime(){
		double timeSum = 0;
		for(int i = 0; i < travelTimeList.size(); i++){
			timeSum += (double)travelTimeList.get(i);
		}
		return (double) timeSum / travelTimeList.size();
	}


	public double maxWaitingTime() {
		waitTimeList.sort(false);
		return (double) waitTimeList.get(0);
	}

	//initialize
	public static ArrayList waitTimeList = new ArrayList();
	public static ArrayList numBoardedList = new ArrayList();
	public static ArrayList travelTimeList = new ArrayList();

}//Statistic class
