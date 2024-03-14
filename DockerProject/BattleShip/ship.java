public class ship{
   private String[] points;
   private int length;
   private String Type;
   private boolean Destroyed;
   private int timesHit;
   private int identifyer;
   private String[] topRow = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   private int declared=0;
   public ship(int i, String name){
      length = i;
      Type = name;
      points = new String[i];
   }
   
   
   public void setPoints(int row, int col){
      points[declared] = topRow[row]+col;
      declared++;
   }
   public String[] getPoints(){
      return points;
   }
   public void setIdentifyer(int i){
      identifyer = i;
   }
   public int getIdentifyer(){
      return identifyer;
   }
   public int getLength(){
      return length;
   }
   public void addHit(){
      timesHit++;
   }
   public void Destroyed(){
      if(length == timesHit){
         timesHit++;
         System.out.println("You Sunk my " + Type);
      }
   }
}