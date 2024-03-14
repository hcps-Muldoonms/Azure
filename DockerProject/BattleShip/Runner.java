import java.util.*;
public class Runner{
   public static void main(String[]args){
      String [] points = {"A0","A1","A2","A3","A4","A5","A6","A7","A8","A9","B0","B1","B2","B3","B4","B5","B6","B7","B8","B9","C0","C1","C2","C3","C4","C5","C6","C7","C8","C9","D0","D1","D2","D3","D4","D5","D6","D7","D8","D9","E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","F0","F1","F2","F3","F4","F5","F6","F7","F8","F9","G0","G1","G2","G3","G4","G5","G6","G7","G8","G9","H0","H1","H2","H3","H4","H5","H6","H7","H8","H9","I0","I1","I2","I3","I4","I5","I6","I7","I8","I9","J0","J1","J2","J3","J4","J5","J6","J7","J8","J9"};
      BattleShipBoard b = new BattleShipBoard(10);
      b.enableHiddenBoard();
      ArrayList<ship> fleet= new ArrayList<ship>();
      fleet.add(new ship(2,"Patrol Boat"));
      fleet.add(new ship(3,"Submarine"));
      fleet.add(new ship(3,"Destroyer"));
      fleet.add(new ship(4,"BattleShip"));
      fleet.add(new ship(5,"AirCraft Carrier"));
      b.placeShips(fleet);
      //b.output();
      int tL=0;
      for(int gTL = 0; gTL<fleet.size();gTL++){
         tL+=fleet.get(gTL).getLength();
      }
      ArrayList<String> pointsCalled= new ArrayList<String>();
      int ammo;
      boolean rapidFire = false;
      int shotsFired=0;
      int hits = 0;
      ammo = b.getNumShots();
      String lastShot = "";
      //For test ammo = 10;
      //Scanner rFM = new Scanner(System.in);
      System.out.println("Do you want the computer to play for you? Y for yes | N for No");
      System.out.println("Y");
      
      if(true){
         System.out.println("Would You like infinite ammo?");
         
       
         if(true){
            ammo = 1000000000;
            System.out.println("Infinite Ammo Mode Activated");
         }
         while(ammo>0){
            int nous =(int)(Math.random()*100);
            boolean it = b.fireShot(points[nous], fleet, pointsCalled);
            if(it){
               hits++;
            }
            if(hits == tL){
               System.out.println("You Have Sunk All The Ships");
               ammo = -1;
            }
            shotsFired++;
            ammo--;
            pointsCalled.add(points[nous]);
         }
      }
      //Not Rapid fire
     /* else{
         while(ammo>0){
            b.getHiddenBoard();
            Scanner TakeAShot = new Scanner(System.in);
            System.out.println("Take a Shot | Use letter then number | Ex: A0 | Shots Left: "+ammo+" |Total Hits: "+hits+"|Last Shot: "+lastShot);
            String shot = TakeAShot.nextLine();
            if(shot.toUpperCase().equals("UUDDLRLRBA")){
               ammo += 1000000;
            }
            if(shot.toUpperCase().equals("I GIVE UP")){
               ammo = -1;
               System.out.println("You Tried");
            }
            boolean it = b.fireShot(shot, fleet, pointsCalled);
            if(it){
               hits++;
            }
            if(hits == tL){
               System.out.println("You Have Sunk All The Ships");
               ammo = -1;
            }
            lastShot = shot;
         //System.out.println("Hit Enter to continue");
         //String result = TakeAShot.nextLine();
            pointsCalled.add(shot.toUpperCase());
            shotsFired++;
            ammo--;
            if(ammo == 0){
               System.out.println("You Have Run out of Ammo");
            }
         }
      }*/
      System.out.println();
      b.getHiddenBoard();
      System.out.println("You took "+shotsFired+" shots");
      b.output();
   }
}