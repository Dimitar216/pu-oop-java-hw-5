package gameboard;

import pixels.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard extends JFrame implements MouseListener {

    private final String title = randomStringGen();

    public GameBoard(){
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
                int random = ThreadLocalRandom.current().nextInt(1,4);
                pixelColorSelector(g,random,row,col);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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
    private void pixelColorSelector(Graphics g,int randomNumber,int row,int col){
        if(randomNumber == 1){
            Pixel pixel = new Pixel(row,col,Color.BLUE);
            pixel.render(g);
        } else if(randomNumber == 2){
            Pixel pixel = new Pixel(row,col,Color.GREEN);
            pixel.render(g);
        } else if(randomNumber == 3){
            Pixel pixel = new Pixel(row,col,Color.RED);
            pixel.render(g);
        }
    }
}
