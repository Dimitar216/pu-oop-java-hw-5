package gameboard;

import pixels.Pixel;
import ui.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard extends JFrame implements MouseListener {

    private final Pixel[][] pixelCollection = new Pixel[64][64];
    private Pixel selectedPixel;
    private int deadPixelsCount;
    String title = randomStringGen("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",10);

    /**
     * Game board constructor
     */
    public GameBoard(){
        pixelSetUp();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                Main.onExit(deadPixelsCount,title);
            }
        });
        this.setSize(800, 800);
        this.setTitle(title);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    /**
     * paint method
     * @param g graphics component
     */
    @Override
    public void paint(Graphics g){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                Pixel pixel = getBoardPixel(row,col);
                pixel.render(g);
            }
        }
    }

    /**
     * Method which reveals a pixel when clicked if it is damaged or not.
     * @param e action event listener
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardCoordinates(e.getY());
        int col = this.getBoardCoordinates(e.getX());
        if(row<=64 && col<=64){
                this.selectedPixel = this.getBoardPixel(row, col);
                if (this.selectedPixel.getHiddenColorID() == 2) {
                    if(e.getClickCount()== 3) {
                        this.pixelCollection[row][col].setColor(Color.BLACK);
                        deadPixelsCount++;
                    }
                } else if (this.selectedPixel.getHiddenColorID() == 3) {
                    this.pixelCollection[row][col].setColor(Color.BLACK);
                    deadPixelsCount++;
                }
                this.repaint();

        } else {
            Modal.render(this,"Warning!","Out of bounds");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Method which generates random strings.
     * @param candidateChars which symbols to include
     * @param length the length of the randomly generated string
     * @return
     */
    public static String randomStringGen(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }

    /**
     * Method which sets the color of the pixel.
     * @param randomNumber random number
     * @param row row of pixel
     * @param col col of pixel.
     */
    private void pixelColorSelector(int randomNumber,int row,int col){
        if(randomNumber == 1){
            Pixel pixel = new Pixel(row,col,Color.BLUE);
            pixel.setHiddenColorID(1);
            this.pixelCollection[row][col] = pixel;
        } else if(randomNumber == 2){
            Pixel pixel = new Pixel(row,col,Color.GREEN);
            pixel.setHiddenColorID(2);
            this.pixelCollection[row][col] = pixel;
        } else if(randomNumber == 3){
            Pixel pixel = new Pixel(row,col,Color.RED);
            pixel.setHiddenColorID(3);
            this.pixelCollection[row][col] = pixel;
        }
    }

    /**
     * Method which gets the row/col of a pixel.
     * @param coordinates coordinates of the pixel.
     * @return row/col
     */
    private int getBoardCoordinates(int coordinates){
        return  coordinates/10;
    }

    /**
     * Gets board object of the pixel.
     * @param row row of the pixel.
     * @param col col of the pixel.
     * @return the pixel.
     */
    private Pixel getBoardPixel(int row, int col){
        return this.pixelCollection[row][col];
    }

    /**
     * Method that sets up pixel's color randomly.
     */
    private void pixelSetUp(){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                int random = ThreadLocalRandom.current().nextInt(1,4);
                pixelColorSelector(random,row,col);
            }
        }
    }

}
