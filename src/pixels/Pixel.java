package pixels;

import java.awt.*;

public class Pixel {
    private final int row;
    private final int col;
    private final Color color;

    public Pixel(int row, int col,Color color){
        this.row          = row;
        this.col          = col;
        this.color = color;
    }

    public void render(Graphics g) {
        int widthOfTile = 10;
        int tileX = (this.col * widthOfTile);
        int heightOfTile = 10;
        int tileY = (this.row * heightOfTile);

        g.setColor(this.color);
        g.fillRect(tileX, tileY, widthOfTile, heightOfTile);
    }
}
