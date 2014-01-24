
package snake;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */


public class Board {
    
    int width = 0;
    int height = 0;
    
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
    
    
    

}
