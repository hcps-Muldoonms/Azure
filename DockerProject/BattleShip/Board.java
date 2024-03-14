public class Board{
   private int[][] board;
   private String[] topRow = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   public Board(int row, int col){
      board = new int[row][col];
   }
   public int[][] getBoard(){
      return board;
   }
   public int getStatus(int row, int col){
      return board[row][col];
   }
   public void setBoard(int row, int col, int num){
      board[row][col] = num;
   }
   public void output(){
      System.out.print("    ");
      for(int c = 0; c<board.length;c++){
         System.out.print(c+" ");
      }
      System.out.println();
      System.out.print("    ");
      for(int q = 0; q<board.length;q++){
         System.out.print("-"+" ");
      }
      System.out.println();
      for(int i = 0; i<board.length;i++){
         for(int x = 0; x<board[0].length+1;x++){
            if(x == 0){
               System.out.print(topRow[i]+" | ");
            }
            else{
               System.out.print(board[i][x-1]+" ");
            }
         }
         System.out.println();
      }
   }
}