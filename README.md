# Bus Simulation
  - Created by Sangryu Park (psrpsj@gmail.com) and Donghee Im  
  - Program language used : Java  

## 1. How to run the simulation
  - By just compiling BusSim.java (javac BusSim.java), the class file will be created.  
  - After compiling run with java (java BusSim)  

## 2. Project organization  
  - 7 helper classes(including interface) : Able to help build interface for Bus simulation  
  - 3 basic class in the simulation (Bus, Stop, Rider)  
  - 2 Situation class  
    - BusEvent : When Bus arrive at stop, able to make passenger to leave and board  
    - RiderEvent : Rider will be created with the statistical random given,  
      and store in the Stop array (demonstrate Rider wait in line for bus)  
  - 1 Main class (BusSim) : will run the program to demonstrate the simulation  

## 3. Data structure had been used  
  - ArrayList (from Project 3 of CSCI1933 / created by Sangryu Park and Donghee Im)  
    - ArrayList are easy to index in order to add, remove and search  

  - Priority Queue (Lecture example from CSCI1933(CarWash Simulation))  

## 4. Any Bugs or issue : Not detected  
