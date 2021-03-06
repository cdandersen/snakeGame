
package snake;

import java.io.Serializable;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */

public class Snake implements Serializable {
    
    private int Atx;
    private int Aty;
    private int length;
    private int speed;
    private int direction;
    
    //1 is Up, 2 is Left, 3 is Down, 4 is Right
    private int directions [] = {1, 2, 3, 4}; 
    
    public Snake() {
        Atx = 0;
        Aty = 0;
        length = 3;
        speed = 1;
    }
    
    public Snake(int l, int s) {
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
    
    public void setDirection(int d) {
        direction = d;
    }
    
    public void setDirectionString(String s) {
        if (s.equalsIgnoreCase("Up")) {
            direction = 1;
        } else if (s.equalsIgnoreCase("Left")) {
            direction = 2;
        } else if (s.equalsIgnoreCase("Down")) {
            direction = 3;
        } else if (s.equalsIgnoreCase("Right")) {
            direction = 4;
        }
    }
    
    public int getDirection() {
        return direction;
    }
    
    
    
    public int[] getLocation() {
        int[] tmp = new int[2];
        tmp[0] = Atx;
        tmp[1] = Aty;
        return tmp;
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

    
}
