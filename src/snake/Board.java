
package snake;

import java.awt.Dimension;
import java.util.ArrayList;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */


public class Board {
    
    int width = 0;
    int height = 0;
    int pixelModifier = 10;
    
    int boardArray [][] = new int[width][height];
    ArrayList list = new ArrayList(10);
    
    
    public Board() {
        width = 10;
        height = 10;
    }
    
    public Board(int w, int h) {
        width = w;
        height = h;
    }
    public void setSize(int w, int h) {
        width = w;
        height = h;
    }  
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    
    public void setBox(int x, int y, int value) {
        boardArray[x][y] = value;
    }
    
    public int getPixelModifier() {    
        return pixelModifier;
    }
      
    public int setPixelModifier(int m){
        if (m > 0)
        {
            pixelModifier = m;
            return pixelModifier;
        } 
        else 
        {
            System.out.println("Need positive number");
            return 0;
        }
    }
    
    public int gridWidthInPixels() {
        return width * pixelModifier;
    }
    
    public int gridHeightInPixels() {
        return height * pixelModifier;
    }
    
    public Dimension getFullBoardDimensions() {
        Dimension d = new Dimension();
        d.setSize(gridWidthInPixels(), gridHeightInPixels());
        return d;
    }
}
     
