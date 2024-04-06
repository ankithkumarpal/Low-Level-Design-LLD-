import java.util.*;

interface IDice {
    int roll();
}

class Cordinate {

    int x ; 
    int y ; 

    Cordinate (int x , int y) {
        this.x = x;
        this.y = y;
    }
}

class Cell  {
    
    int id; 
    Cordinate cordinate ; 
    Snake snake  = null; 
    Ladder ladder = null ; 

    Cell(int id , Cordinate cordinate){
        this.id = id;
        this.cordinate = cordinate;
    }

    Cell(int id , Cordinate cordinate ,Snake snake , Ladder ladder) {
        this.id = id;
        this.cordinate = cordinate;
        this.snake = snake;
        this.ladder = ladder;
    }
}

class Snake {
    int id ; 
    Cordinate start ; 
    Cordinate end ; 

    Snake(int id , Cordinate start , Cordinate end) {
        this.id = id;
        this.start = start;
        this.end = end ;
    }

    Cordinate climbDown(){
        return this.end;
    }
}

class Ladder {
    int id ; 
    Cordinate start ; 
    Cordinate end ; 

    Ladder(int id , Cordinate start , Cordinate end) {
        this.id = id;
        this.start = start;
        this.end = end ;
    }


    Cordinate climbTo() {
        return this.start;
    }
}


class player {
    int id ; 
    Cordinate currentPosition ; 
    boolean turn ; 

    player(int id , Cordinate currPosition) {
        this.id = id;
        this.currentPosition = currPosition;
    }

    Cordinate currentCordinate(){
        return this.currentPosition;
    }
}


class Dice implements IDice {

    public int roll(){
        Random random = new Random();
        int randomNumber = random.nextInt(1  , 7);
        return randomNumber;
    }
}



class Board {

    int size ; 
    List<Snake> snake ; 
    List<Ladder> ladder ; 

    Cell [][] board ;

    public Board (int size , List<Snake> snake , List<Ladder> ladder) {
        this.size = size;
        this.snake = snake;
        this.ladder = ladder;

        int row = size % 10 == 0 ? size/10 : size/10 + 1;
        this.board = new Cell[row][10];
    }

    
    Snake snakePresent(List<Snake> snake , int row , int col){

        for(int i = 0;i< snake.size(); i++) {
            Snake snk = snake.get(i);
            if(snk.start.x == row && snk.start.y == col) return snk;
        }

        return null;

    }

    Ladder ladderPresent(List<Ladder> ladder , int row , int col){
        for(int i = 0;i<ladder.size(); i++) {
            Ladder ldr = ladder.get(i);
            if(ldr.start.x == row && ldr.start.y == col) return ldr;
        }
        return null;
    }

    Cell [][] construct() {
        
        int k = 0;
            for(int i = 0;i< board.length;i++) {
                for(int j = 0;j<board[0].length;j++) {

                    Cordinate cordinate = new Cordinate(i, j);
                    Cell cell = new Cell(k++ , cordinate);
                    
                    Snake snk = snakePresent(snake , i , j);
                    Ladder ldr = ladderPresent(ladder , i , j);
                    if(snake != null) {
                        cell.snake = snk;
                    }

                    if(ladder != null) {
                        cell.ladder = ldr;
                    }

                    board[i][j] = cell;
                }
            }
        
        return board;
    }
    
}

public class snake_ladder {
    
     public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter board size");
        int size = scn.nextInt();
        System.out.println("Enter no of players");
        int noOfplayers = scn.nextInt();

        System.out.println("Enter no of snakes");
        int noOfSnakes = scn.nextInt();

        System.out.println("Enter no of ladder");
        int noOfLadders = scn.nextInt();

        System.out.println("Enter no of dice");
        int noOfDice = scn.nextInt();


        Queue<player> players = new ArrayDeque<>();
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        List<Dice> dices = new ArrayList<>();


        for(int i = 0;i<noOfDice;i++){
            dices.add(new Dice());
        }


        for(int i = 0;i<noOfplayers;i++){
            Cordinate cordinate = new Cordinate(0, 0);
            players.offer(new player(i , cordinate));
        }

        for(int i = 0;i<noOfSnakes;i++) {

            System.out.println("Enter the x cordinate of snake start");
            int startX = scn.nextInt();
            System.out.println("Enter the y cordinate of snake start");
            int startY = scn.nextInt();

            System.out.println("Enter the x cordinate of snake end");
            int endX = scn.nextInt();
            System.out.println("Enter the y cordinate of snake start");
            int endY = scn.nextInt();

            Cordinate start = new Cordinate(startX, startY);
            Cordinate end = new Cordinate(endX, endY);


            Snake snake  = new Snake(i,start, end);
            snakes.add(snake);

        }

        for(int i = 0;i<noOfLadders;i++) {
            System.out.println("Enter the x cordinate of ladder start");
            int startX = scn.nextInt();
            System.out.println("Enter the y cordinate of ladder start");
            int startY = scn.nextInt();

            System.out.println("Enter the x cordinate of ladder end");
            int endX = scn.nextInt();
            System.out.println("Enter the y cordinate of ladder end");
            int endY = scn.nextInt();

            Cordinate start = new Cordinate(startX, startY);
            Cordinate end = new Cordinate(endX, endY);

            Ladder ladder  = new Ladder(i,start, end);
            ladders.add(ladder);
        }
        Cell [][] board = new Board(size, snakes, ladders).construct();

        
        player winner = play(size , board , players , dices);
        System.out.println("The winner");
        System.out.println(winner.id);
     }


     static player play(int size , Cell[][] board ,  Queue<player> playerTurn , List<Dice> dices){
        
        while(true) {
            System.out.println("New Turn : ");
            player player = playerTurn.remove();
            int diceSum = 0;
            for(int i = 0;i<dices.size();i++){
                int  val = dices.get(i).roll();
                diceSum = diceSum + val;
            }

            int x = player.currentPosition.x + (player.currentPosition.y + diceSum)/10;
            int y = (player.currentPosition.y + diceSum) % 10;

            System.out.println("value " + x + " " + player.currentPosition.x + " " + player.currentPosition.y + " " + diceSum);
            
            if(x < 10){
                 Cordinate cordinate = new Cordinate(x , y);
                 player.currentPosition = cordinate;
                 if(board[x][y].snake != null) {
                   player.currentPosition = board[x][y].snake.end;
                 } else if(board[x][y].ladder != null) {
                    player.currentPosition = board[x][y].ladder.end;
                 }
            }
           
            System.out.println(player.id + " " + player.currentPosition.x + " " + player.currentPosition.y);

            if(x ==  board.length -1 && y == board[0].length - 1) return player;

            System.out.println(playerTurn.size());

            playerTurn.add(player);
        }

    }
}
