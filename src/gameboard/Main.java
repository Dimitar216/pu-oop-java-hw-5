package gameboard;


public class Main {
    private static int totalPhonesChecked;

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
    }

    public static void onExit() {
        if(totalPhonesChecked<4){
            totalPhonesChecked++;
            GameBoard gameBoard = new GameBoard();
        }
    }
}
