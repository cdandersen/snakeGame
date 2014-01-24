
package snake;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */

public class SnakeHead {
    
    int Atx;
    int Aty;
    int length;
    int speed;
    String direction;
    
    String directions [] = {"up", "left", "down", "right"}; 
    
    public SnakeHead() {
        
    }
    
    public SnakeHead(int l, int s) {
        length = l;
        speed = s;
    }
    
    public void eating() {
        length++;
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    public void setLoc(int x, int y) {
        Atx = x;
        Aty = y;
    }
    
    public void setDirection(String s) {
        direction = s;
    }
    
    public String[] getValidDirections() {
        
    }
    
}
