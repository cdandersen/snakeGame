
package snake;


public class Player {
    
    String name;
    int highScore;

    public Player() {
        
    }
    
    public Player(String n) {
        name = n;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
}
