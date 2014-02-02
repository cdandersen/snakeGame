
package snake;

import java.awt.Dimension;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */


public class Board {
    
    int width = 0;
    int height = 0;
    int pixelModifier = 10;
    int m = 12;
    
    int boardArray [][] = new int[width][height];
    
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
    
    
    public void setBox(int x, int y, int value) {
        boardArray[x][y] = value;
    }
    
    /**
     *
     * @param m
     * @return
     */
    public int getPixelModifier(int m) {
        if (m > 0){
        pixelModifier = m;
        return pixelModifier;
    }
        else {
        System.out.println("Need positive number");
        return 0;
        }
        
    }
    
    public double gridWidthInPixels() {
        return width * pixelModifier;
    }
    
    public double gridHeightInPixels() {
        return height * pixelModifier;
    }
    
    public Dimension getFullBoardDimensions() {
        Dimension d = new Dimension();
        d.setSize(gridWidthInPixels(), gridHeightInPixels());
        return d;
    }
}
     
