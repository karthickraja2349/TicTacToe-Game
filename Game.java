import java.util.Arrays;
import java.util.Scanner;
public class Game{
    private Scanner input = new Scanner(System.in);
    private String gameBoard[];
    private String player;
    private String winner;
    private static Game game = null;
    
    private Game(){
    
    }
    
    public static Game getGameInstance(){
           if(game == null){
               game = new Game();
           }
           return game;
     }           
    
    public String getPlayer(){
         return player;
    }
    
    public String getWinner(){
          return winner;
    }
    
    public String[] getGameBoard(){
          return gameBoard;
    }
    
    public void setPlayer(String player){
          this.player = player;
    }
     
    public void setWinner(String winner){
          this.winner = winner;
     }                            
     
     public void setGameBoard(int range){
         this.gameBoard = new String[range];
         for(int i=0;i<range;i++){
            gameBoard[i]=String.valueOf(i+1);
         }   
     }
    
     
     public void showBoard(){ 
          System.out.println("$$$$$$$$");
          System.out.println("|"+ gameBoard[0]+"|"+gameBoard[1]+"|"+gameBoard[2]+"|");
          System.out.println("|"+ gameBoard[3]+"|"+gameBoard[4]+"|"+gameBoard[5]+"|");
          System.out.println("|"+ gameBoard[6]+"|"+gameBoard[7]+"|"+gameBoard[8]+"|");
          System.out.println("$$$$$$$$");
    }
    
    private String checkPattern(int point1 , int point2 , int point3){
        return gameBoard[point1] + gameBoard[point2] + gameBoard[point3];
    }
    
    public void victory(){
         for(int i=0;i<8;i++){
              String check = null;
              switch(i){
                  case 0:
                       check = checkPattern(0,1,2);
                       break;
                  case 1:
                       check = checkPattern(3,4,5);
                       break;
                  case 2:
                       check = checkPattern(6,7,8);
                       break;
                  case 3:
                       check = checkPattern(0,3,6);
                       break;
                  case 4:
                       check = checkPattern(1,4,7);
                       break;
                   case 5:
                        check = checkPattern(2,5,8);
                        break;
                    case 6: 
                        check = checkPattern(0,4,8);
                        break;
                    case 7:
                        check = checkPattern(2,4,6);
                        break;
              }
              if(check.equalsIgnoreCase("XXX")){
                   setWinner("x");
                   return;
              }     
              else if(check.equalsIgnoreCase("OOO")){
                   setWinner("o");
                   return;
              }
          }    
          for(int i=0;i<gameBoard.length;i++){
                  if(Arrays.asList(gameBoard).contains(String.valueOf(i+1))){
                        break;
                   }     
                   else if(i==8){
                        setWinner("Tie");
                        return;
                   }    
          } 
          System.out.println("Its" + " " + getPlayer()+ " " + "Chance:" );
          setWinner(null);               
    }
    
    public void LetsGo(){
          while(getWinner()==null){
               int userInput = input.nextInt();
               if(userInput > 0 && userInput <=9){
                    if(getGameBoard()[userInput-1].equals(String.valueOf(userInput))){
                           getGameBoard()[userInput-1]=getPlayer();
                           showBoard();
                           if(getPlayer().equals("x"))
                               setPlayer("o");
                           else 
                                setPlayer("x");
                           victory();
                    }
                    else{
                          System.out.println("Enter next Slot:");
                    }
               }
           }
           if(getWinner().equals("Tie")){     
                   System.out.println("Game Tie No winner Found ");
           }  
           else{
                 System.out.println("congradulations:"+getWinner() + "-"+"wins the game");      
           }                                
   }    
                                                                 
 }        
