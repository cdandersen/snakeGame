
package snake;

public abstract class SnakeHead extends Snake {
    
    int atX;
    int atY;
    int direction;
    
    public SnakeHead() {
        super();
    }
    
    @Override
    public void setLoc(int x, int y) {
        atX = x;
        atY = y;
    }
    
    @Override
    public void setDirection(int x) {
        direction = x;
    }
    
    
}
