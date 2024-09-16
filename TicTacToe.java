import java.util.Scanner;
public class TicTacToe{

    public static String player = "X";
    public static void printBoard(String[] board){
        System.out.println(board[0] +" | "+ board[1] +" | "+ board[2]);
        System.out.println(board[3] +" | "+ board[4] +" | "+ board[5]);
        System.out.println(board[6] +" | "+ board[7] +" | "+ board[8]);
    }


    public static void play(String[] board,String player){
        if(!gameDraw(board)){
            System.out.println();
            System.out.println("Player "+player+" Turn");
            System.out.print("Enter Place Where You Want To Insert: ");
            Scanner sc=new Scanner(System.in);
            int place=sc.nextInt();

            if(board[place-1] == " "){
                board[place-1] = player;
            }        
            else{
                System.out.println("Invalid Move. Try Again !!");
                play(board,player);
            }
            System.out.println();
            printBoard(board);
            if(!gameWin(board)){
                if(player == "X"){
                    player="O";
                }
                else{
                    player="X";
                }
                play(board,player);
            }
            else{
                System.out.println("Player "+player+ " Win");
                return;
            }
            
        }
        else{
            System.out.println("Game Draw.");
            return;
        }


    }

    public static Boolean gameWin(String board[]){
        if(((board[0]==board[1]) && (board[0]==board[2]) && (board[0] !=" ")) || ((board[3]==board[4]) && (board[3]==board[5]) && (board[3] !=" ")) || ((board[6]==board[7]) && (board[6]==board[8]) && (board[6] !=" "))){
            return true;
        }
        else if(((board[0]==board[3]) && (board[0]==board[6]) && (board[0] !=" ")) || ((board[1]==board[4]) && (board[1]==board[7]) && (board[1] !=" ")) || ((board[2]==board[5]) && (board[2]==board[8]) && (board[2] !=" "))){
            return true;
        }
        else if(((board[2]==board[4]) && (board[2]==board[6]) && (board[2] !=" ")) || ((board[0]==board[4]) && (board[0]==board[8]) && (board[0] !=" ")) ){
            return true;
        }
        else{
            return false;
        }
    }

    public static Boolean gameDraw(String board[]){
        for(int i=0;i<=8;i++){
            if(board[i] == " "){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println();
        String[] board = {"A","A","A","A","A","A","A","A","A"};
        printBoard(board);
        
        int playAgain=1;
        while(playAgain == 1){
            for(int i=0;i<=8;i++){
                board[i]=" ";
            }
            play(board,player);
            System.out.println();
            System.out.println("Do You Want To Play Again ? ");
            System.out.print("If Yes then enter 1 else 0: ");
            Scanner sc=new Scanner(System.in);
            playAgain=sc.nextInt();
        }

        
    }
}