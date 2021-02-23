package gameboard;

import pixels.Pixel;
import ui.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard extends JFrame implements MouseListener {

    private final String title = randomStringGen();
    private final Pixel[][] pixelCollection = new Pixel[64][64];
    private Pixel selectedPixel;

    public GameBoard(){
        pixelSetUp();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle(title);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                Pixel pixel = getBoardPixel(row,col);
                pixel.render(g);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardCoordinates(e.getY());
        int col = this.getBoardCoordinates(e.getX());
        if(row<=64 && col<=64){

                this.selectedPixel = this.getBoardPixel(row, col);
                if(this.selectedPixel.getHiddenColorID() == 1){
                    this.pixelCollection[row][col].setColor(Color.BLUE);
                } else if(this.selectedPixel.getHiddenColorID() == 2 ){
                    this.pixelCollection[row][col].setColor(Color.GREEN);
                } else if(this.selectedPixel.getHiddenColorID() == 3 ){
                    this.pixelCollection[row][col].setColor(Color.RED);
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
    private String randomStringGen() {

        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
    private void pixelColorSelector(int randomNumber,int row,int col){
        Pixel pixel = new Pixel(row,col,Color.BLACK);

        if(randomNumber == 1){
            pixel.setHiddenColorID(1);
        } else if(randomNumber == 2){
            pixel.setHiddenColorID(2);
        } else if(randomNumber == 3){
            pixel.setHiddenColorID(3);
        }

        this.pixelCollection[row][col] = pixel;
    }

    private int getBoardCoordinates(int coordinates){
        return  coordinates/10;
    }

    private Pixel getBoardPixel(int row, int col){
        return this.pixelCollection[row][col];
    }
    private void pixelSetUp(){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                int random = ThreadLocalRandom.current().nextInt(1,4);
                pixelColorSelector(random,row,col);
            }
        }
    }
}
