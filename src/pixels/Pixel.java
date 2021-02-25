package pixels;

import java.awt.*;
import java.awt.geom.Line2D;

public class Pixel {
    private final int row;
    private final int col;
    private Color color;
    private int hiddenColorID;

    /**
     * Pixel constructor
     * @param row row of pixel
     * @param col col of pixel
     * @param color color of pixel
     */
    public Pixel(int row, int col,Color color){
        this.row          = row;
        this.col          = col;
        this.color        = color;
    }

    /**
     * Pixel render method
     * @param g graphics component
     */
    public void render(Graphics g) {
        Graphics2D lineDrawer = (Graphics2D) g;

        int widthOfTile = 10;
        int tileX = (this.col * widthOfTile);
        int heightOfTile = 10;
        int tileY = (this.row * heightOfTile);

        g.setColor(this.color);
        g.fillRect(tileX, tileY, widthOfTile, heightOfTile);

        outlineRenderer(g, lineDrawer, tileX, tileY);
    }

    public int getHiddenColorID() {
        return hiddenColorID;
    }

    public void setHiddenColorID(int hiddenColorID) {
        this.hiddenColorID = hiddenColorID;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * renders outlines for the pixel
     * @param g graphics component
     * @param lineDrawer graphics 2d drawer
     * @param tileX x coordinate for pixel
     * @param tileY y coordinate for pixel
     */
    private void outlineRenderer(Graphics g, Graphics2D lineDrawer, int tileX, int tileY) {
        g.setColor(Color.BLACK);
        Line2D line0 = new Line2D.Float(tileX, tileY, tileX, tileY +9);
        Line2D line1 = new Line2D.Float(tileX +9, tileY, tileX +9, tileY +9);
        Line2D line2 = new Line2D.Float(tileX, tileY, tileX +9, tileY);
        Line2D line3 = new Line2D.Float(tileX, tileY +9, tileX +9, tileY +9);
        //left
        lineDrawer.draw(line0);
        //right
        lineDrawer.draw(line1);
        //top
        lineDrawer.draw(line2);
        //bottom
        lineDrawer.draw(line3);
    }
}
