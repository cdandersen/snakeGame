
package snake;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */


public class Board implements Serializable {
    
    int width = 32;
    int height = 32;
    int pixelModifier = 20;
    int direction = 0;
    //0 is up, 1 is down, 3 is left, 4 is right
    
    // 0 is nothing, 1 is Head, 2 is Tail, 3 is apple
    int boardArray [][];
    ArrayList list = new ArrayList(10); 
    
    public Board() {
        boardArray = new int[width][height];
    }
    
    public void setBox(int x, int y, int value) {
        boardArray[x][y] = value;
    }
    
    public int getValue(int x, int y){
        return boardArray[x][y];
    }
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getPixelModifier(){
        return pixelModifier;
    }
    
    public int getDirection() {
        return direction;
    }
    
    public void setDirection(int x) {
        direction = x;
    }
    
    public int boardWidthInPixels() {
        return width * pixelModifier;
    }
    
    public int boardHeightInPixels() {
        return height * pixelModifier;
    }
    
    public int[] getValidDirections(int d) {
        int[] tmp = new int[2];
        if (d < 5 && d > 0) {
            if (d%2 == 0) {
               tmp[0] = 1;
               tmp[1] = 3;
            } else {
               tmp[0] = 2;
               tmp[1] = 4;
            }
            return tmp;
        } else {
        return tmp;
        }
    }
    
    public int getWrongDirection() {
        switch (direction) {
            case 0: return 1;
            case 1: return 0;
            case 2: return 3;
            case 3: return 2;
        }
        return 0;
    }
    
    public Dimension getFullBoardDimensions() {
        Dimension d = new Dimension();
        d.setSize(boardWidthInPixels(), boardHeightInPixels());
        return d;
    }
}
     
