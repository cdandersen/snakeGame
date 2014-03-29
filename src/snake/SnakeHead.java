
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
        try {
            atX = x;
            atY = y;
        } catch (Exception e) {
            System.out.println("Cannot set to that location, location out of bounds: " + e.getMessage().toString());
        }
    }
    
    @Override
    public void setDirection(int x) {
        direction = x;
    }
    
    
}
