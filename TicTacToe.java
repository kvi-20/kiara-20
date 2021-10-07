import java.util.InputMismatchException;
import java.io.*;

public class TicTacToe {

   static String board[]=new String[9];
    static String turn=" ";
    static int time=0;
           public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             turn ="X";
            String winner=checkWinner();
        for(int i=0;i<9;i++)
            board[i]=String.valueOf(i+1);

        System.out.println("Welcome to Tic Tac Toe!!!");
        System.out.println("Let's begin the GAME.....");
        pBoard();
       // int input=Integer.parseInt(br.readLine());
        System.out.println("Enter a slot Number for X : ");
        //System.out.println(winner);
        int input=0;
        while(winner=="n"){
            
            try{
                //System.out.println("yes1");
                input=Integer.parseInt(br.readLine());
                if(input<=0 && input>9){
                    System.out.print("Input Not-Valid...RE-ENTER slot number : ");
                continue;
                }
            }
            catch(InputMismatchException e){
                System.out.print("Input Not-Valid...RE-ENTER slot number : ");
                continue;
            }

           if(board[input-1].equalsIgnoreCase(String.valueOf(input))){
           // System.out.println("yes1");
                board[input-1]=turn;
                if(turn=="X")
                    turn="O";
                else 
                    turn="X";
            
            pBoard();

            winner=checkWinner();
            //System.out.println(winner);
            //System.out.println("yes1");
            } else {
                 System.out.println("Slot already taken..RE-ENTER again...");
                   }
           

           /* if(winner.equalsIgnoreCase("draw"))
                System.out.println(
                "It's a draw! Thanks for playing.");*/
             if(winner!="n"){
                System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
            } 
            
           }
   }
       // }   
        
       // br.close();
   // }
    public static void pBoard(){
                 System.out.println("|---|---|---|");
              System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
                 System.out.println("|---|---|---|");
              System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
                 System.out.println("|---|---|---|");
              System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
                 System.out.println("|---|---|---|");
    }

    public static String checkWinner(){
        for(int a=0;a<8;a++){
            String line=null;
            //System.out.println("yes0");
            switch(a){
                case 0:
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }
            if(line.equals("XXX"))
                return "X";
            else if(line.equals("OOO"))
                return "O";
        }
        
        
        //System.out.println("yes1");
        if(time<9){
         System.out.println(turn + "'s turn; enter a slot number to place "+ turn + " in:");
         time++;
        }
        else{
            return "draw";
        }
         return "n";
    }
}

