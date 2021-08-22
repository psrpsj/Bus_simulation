//written by park1564, imxxx074

public class BusEvent implements Event{

  public BusEvent(int stop, Bus bus) {
    this.curStop = stop;
    this.bus = bus;
  }

  public void run() {

    //Case when bus is not express bus
    if (!bus.isExpress()) {
      Rider[] toGetOff = bus.removeRidersAtStop(this.curStop);

      for(int i = 0; i < toGetOff.length; i++){
        Statistic.travelTimeList.add(BusSim.agenda.getCurrentTime() - toGetOff[i].busOnTime);
      }

      //When no paggensgers are leaving
      if (toGetOff.length != 0) {
        BusSim.agenda.add(new BusEvent(this.curStop, bus), toGetOff.length * 2);
      }

      //Passengers are leaving and boarding into bus
      else {
        int numBoarded = 0;
        while (!bus.isFull() && BusSim.lines[this.curStop].length() > 0) {
          Rider passenger = BusSim.lines[this.curStop].remove();
          bus.addRiders(passenger);
          numBoarded++;

          //Add time to take bus into Statistic
          passenger.busOnTime = BusSim.agenda.getCurrentTime();
          Statistic.waitTimeList.add(BusSim.agenda.getCurrentTime()-passenger.getBoardingTime());
        }

        if (numBoarded > 0) {
          BusSim.agenda.add(new BusEvent(this.curStop,this.bus), numBoarded * 3);
        }

        else if (BusSim.lines[curStop].length() == 0 || this.bus.isFull()) {
          this.curStop++;
          if (this.curStop == 30) {
            this.curStop = 0;
          }
          if (toGetOff.length * 2 + numBoarded * 3 < 15) {
            BusSim.agenda.add(new BusEvent(this.curStop,this.bus), 240 + 15 - (toGetOff.length * 2 + numBoarded * 3));
          }
          else {
            BusSim.agenda.add(new BusEvent(this.curStop,this.bus), 240);
          }
          Statistic.numBoardedList.add(bus.getPeople());
        }
      }
    }

    //When Bus is expressbus
    else {
      Rider[] toGetOff = bus.removeRidersAtStop(this.curStop);

      for(int i = 0; i < toGetOff.length; i++){
        Statistic.travelTimeList.add(BusSim.agenda.getCurrentTime() - toGetOff[i].busOnTime);
      }

      if (toGetOff.length != 0) {
        BusSim.agenda.add(new BusEvent(this.curStop, bus), toGetOff.length * 2);
      }
      else {
        int numBoarded = 0;
        Q<Rider> temp = new Q();
        while (!bus.isFull() && BusSim.lines[this.curStop].length() > 0) {
          Rider passenger = BusSim.lines[this.curStop].remove();
          for (int i = 0; i < express.length; i++) {
            if (passenger.getDestinationStation() == express[i]) {
              bus.addRiders(passenger);
              numBoarded++;
              Statistic.waitTimeList.add(BusSim.agenda.getCurrentTime()-passenger.getBoardingTime());
            }
          }
          temp.add(passenger);
        }
        BusSim.lines[this.curStop] = temp;
        if (numBoarded > 0) {
          BusSim.agenda.add(new BusEvent(this.curStop,this.bus), numBoarded * 3);
        }
        else if (BusSim.lines[curStop].length() == 0 || this.bus.isFull()) {
          int express_index = 0;
          for (int i = 0; i < express.length; i++) {
            if (this.curStop == express[i])
            express_index = i;
          }
          if (express[express_index] == 29) {
            express_index = 0;
            this.curStop = 0;
          }
          else {
            this.curStop = express[express_index+1];
          }

          int express_distance = express[express_index+1] - express[express_index];
          if (toGetOff.length * 2 + numBoarded * 3 < 15) {
            BusSim.agenda.add(new BusEvent(this.curStop,this.bus), 240 * express_distance + 15 - (toGetOff.length * 2 + numBoarded * 3));
          }
          else {
            BusSim.agenda.add(new BusEvent(this.curStop,this.bus), 240 * express_distance);
          }
          Statistic.numBoardedList.add(bus.getPeople());
        }
      }
    }
  }

  //initialize
  private int curStop;
  private Bus bus;
  int[] express = {0,1,4,8,12,14,15,16,20,24,28,29};

}//BusEvent class
