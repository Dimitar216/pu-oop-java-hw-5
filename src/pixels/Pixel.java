package pixels;

import java.awt.*;
import java.awt.geom.Line2D;

public class Pixel {
    private int row;
    private int col;
    private final int widthOfTile = 10;
    private final int heightOfTile = 10;
    private final Color color;

    public Pixel(int row, int col,Color color){
        this.row          = row;
        this.col          = col;
        this.color = color;
    }

    public void render(Graphics g) {
        int tileX = (this.col * this.widthOfTile);
        int tileY = (this.row * this.heightOfTile);

        g.setColor(this.color);
        g.fillRect(tileX, tileY, this.widthOfTile, this.heightOfTile);
    }
}
