//written by park1564 imxxx074

import java.util.Random;

public class Rider{

  public Rider(int boardingStop, double boardingTime){
    this.boardingStation = boardingStop;
    this.boardingTime = boardingTime;

    //Eastbound destination Selection
    if (this.boardingStation < 15) {
      Random rand = new Random();
      destinationStation = eastboundStation[rand.nextInt(18)];
      while(destinationStation <= this.boardingStation){
        destinationStation = eastboundStation[rand.nextInt(18)];
      }
    }

    //Westbound destination Selection
    else {
      Random rand = new Random();
      destinationStation = westboundStation[rand.nextInt(18)];
      while(destinationStation <= this.boardingStation && destinationStation != 0){
        destinationStation = westboundStation[rand.nextInt(18)];
      }
    }
  }

  public int getBoardingStation(){
    return boardingStation;
  }

  public int getDestinationStation(){
    return destinationStation;
  }

  public double getBoardingTime(){
    return this.boardingTime;
  }

  //initialize
  public int[] eastboundStation = {1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,14,15,15};
  public int[] westboundStation = {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,29,0,0};
  private int boardingStation;
  public double boardingTime;
  private int destinationStation;
  public double busOnTime;
}// Rider class
