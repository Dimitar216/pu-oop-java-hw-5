package gameboard;


import custom.list.CustomArrayList;

public class Main {
    private static int totalPhonesChecked;
    private static final CustomArrayList<String> goodCollection = new CustomArrayList<>();
    private static final CustomArrayList<String>  badCollection = new CustomArrayList<>();

    public static void main(String[] args) {
        onExit(-1,"");
    }

    /**
     * Method which adds the phone's titles in the good or bad array.
     * @param deadPixels the number of the dead pixels.
     * @param title the phone's serial number.
     */
    public static void onExit(int deadPixels,String title) {
        if(deadPixels>2048){
            badCollection.add(title);
        } else if(deadPixels >= 0) {
            goodCollection.add(title);
        }
        if(totalPhonesChecked<5){
            totalPhonesChecked++;
            GameBoard gameBoard = new GameBoard();
        } else{
            System.out.println("Good batch of phones");
            System.out.println("--------------------");
            goodCollection.display();
            System.out.println();
            System.out.println("Bad batch of phones");
            System.out.println("--------------------");
            badCollection.display();
        }
    }
}