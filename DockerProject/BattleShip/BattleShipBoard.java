import java.util.*;
import java.lang.*;
//Beans
public class BattleShipBoard extends Board{
   private int ships = 1;
   private ArrayList<String>points = new ArrayList<String>();
   private String[][] hiddenBoard;
   private String[] topRow = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   private int numShots;
   public BattleShipBoard(int i){
      super(i,i);
      hiddenBoard = new String[i][i];
      numShots = (i*i)/2;
   }
     public int getNumShots(){
      return numShots;
   }
   public void enableHiddenBoard(){
      for(int i = 0; i<hiddenBoard.length;i++){
         for(int x = 0; x<hiddenBoard.length;x++){
            hiddenBoard[i][x] = "*";
         }
      }
   }
   public void getHiddenBoard(){
      System.out.print("    ");
      for(int c = 0; c<hiddenBoard.length;c++){
         System.out.print(c+" ");
      }
      System.out.println();
      System.out.print("    ");
      for(int q = 0; q<hiddenBoard.length;q++){
         System.out.print("-"+" ");
      }
      System.out.println();
      for(int i = 0; i<hiddenBoard.length;i++){
         for(int x = 0; x<hiddenBoard[0].length+1;x++){
            if(x == 0){
               System.out.print(topRow[i]+" | ");
            }
            else{
               System.out.print(hiddenBoard[i][x-1]+" ");
            }
         }
         System.out.println();
      }
   }
   public void placeShips(ArrayList<ship> e){
      for(int i = 0; i<e.size();i++){
         int direction = (int)(Math.random()*100);
         boolean direct;
         if(direction<50){
            direct = true;//vertical
         }
         else{
            direct = false;//horizontal
         }
         if(direct){//Vertical Route
            int row = (int)(Math.random()*hiddenBoard.length);
            int col = (int)(Math.random()*(hiddenBoard[0].length-e.get(i).getLength()));
            boolean open = true;
            for(int theCol=0;theCol<e.get(i).getLength();theCol++){
               if(getStatus(row,col+theCol)>0){
                  open = false;
               }
            }
            if(open){
               e.get(i).setIdentifyer(ships);
               ships++;
               for(int place = 0; place<e.get(i).getLength();place++){
                  setBoard(row,col+place,e.get(i).getIdentifyer());
               }
            }
            else{//Tries again by -1 then +1
               i--;
            }
         }
         else{//Horizontal Route
            int row = (int)(Math.random()*(hiddenBoard.length-e.get(i).getLength()));
            int col = (int)(Math.random()*hiddenBoard[0].length);
            boolean open = true;
            for(int theRow=0;theRow<e.get(i).getLength();theRow++){
               if(getStatus(row+theRow,col)>0){
                  open = false;
               }
            }
            if(open){
               e.get(i).setIdentifyer(ships);
               ships++;
               for(int place = 0; place<e.get(i).getLength();place++){
                  setBoard(row+place,col,e.get(i).getIdentifyer());
               }
            }
            else{//Tries again by -1 then +1
               i--;
            }
         }  
      }
   }
   public boolean fireShot(String e, ArrayList<ship> a,ArrayList<String> alredyFiredOn){
      boolean didHit = false;
      e = e.toUpperCase();
      boolean runThis = true;
      if(e.substring(0,1).equals("1")){
         runThis = false;
      }
      if(e.substring(0,1).equals("2")){
         runThis = false;
      }
      if(e.substring(0,1).equals("3")){
         runThis = false;
      }
      if(e.substring(0,1).equals("4")){
         runThis = false;
      }
      if(e.substring(0,1).equals("5")){
         runThis = false;
      }
      if(e.substring(0,1).equals("6")){
         runThis = false;
      }
      if(e.substring(0,1).equals("7")){
         runThis = false;
      }
      if(e.substring(0,1).equals("8")){
         runThis = false;
      }
      if(e.substring(0,1).equals("9")){
         runThis = false;
      }
      if(e.substring(0,1).equals("0")){
         runThis = false;
      }
      if(e.length()!=2){
         runThis = false;
      }
      if(e.indexOf(" ")>-1){
         runThis = false;
      }
      for(int ex=0;ex<alredyFiredOn.size();ex++){
         if(alredyFiredOn.get(ex).equals(e)){
            runThis=false;
         }
      }
      if(!runThis){
      System.out.println("Wasted Shot, You fired on the same spot");
      }
      if(runThis){
         int normalizeRows=-1;
         int normalizeCols=-1;
         if(e.indexOf("A")>-1){
            normalizeRows = 0;
         }
         if(e.indexOf("B")>-1){
            normalizeRows = 1;
         }
         if(e.indexOf("C")>-1){
            normalizeRows = 2;
         }
         if(e.indexOf("D")>-1){
            normalizeRows = 3;
         }
         if(e.indexOf("E")>-1){
            normalizeRows = 4;
         }
         if(e.indexOf("F")>-1){
            normalizeRows = 5;
         }
         if(e.indexOf("G")>-1){
            normalizeRows = 6;
         }
         if(e.indexOf("H")>-1){
            normalizeRows = 7;
         }
         if(e.indexOf("I")>-1){
            normalizeRows = 8;
         }
         if(e.indexOf("J")>-1){
            normalizeRows = 9;
         }
         if(e.indexOf("0")>-1){
            normalizeCols = 0;
         }
         if(e.indexOf("1")>-1){
            normalizeCols = 1;
         }
         if(e.indexOf("2")>-1){
            normalizeCols = 2;
         }
         if(e.indexOf("3")>-1){
            normalizeCols = 3;
         }
         if(e.indexOf("4")>-1){
            normalizeCols = 4;
         }
         if(e.indexOf("5")>-1){
            normalizeCols = 5;
         }
         if(e.indexOf("6")>-1){
            normalizeCols = 6;
         }
         if(e.indexOf("7")>-1){
            normalizeCols = 7;
         }
         if(e.indexOf("8")>-1){
            normalizeCols = 8;
         }
         if(e.indexOf("9")>-1){
            normalizeCols = 9;
         }
         if(normalizeCols<0||normalizeRows<0){
         
         }
         else{
            if(getStatus(normalizeRows,normalizeCols)>0){
               hiddenBoard[normalizeRows][normalizeCols]="X";
               System.out.println("HIT!");
               for(int det = 0; det<a.size();det++){
                  if(getStatus(normalizeRows,normalizeCols)==a.get(det).getIdentifyer()){
                     a.get(det).addHit();
                     a.get(det).Destroyed();
                     didHit = true;
                  }
               }
            }
            else{
               hiddenBoard[normalizeRows][normalizeCols]="O";
               System.out.println("Miss");
            }
         }
      }
      return didHit;
   }
}