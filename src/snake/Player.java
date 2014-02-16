
package snake;

import javax.swing.JOptionPane;


public class Player {
    
    String name;
    int highScore;
    int currentScore;
    String [] list = {"300", "700"};

    public Player() {
        name = "";
        String s = null;
        for (String list1 : list) {
            s += list1;
        }
        JOptionPane.showMessageDialog(null, s);
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
    
    public int getScore(int numOfApples, int lengthOfTime) {
        int tmpscore = currentScore;
        tmpscore += 50*numOfApples;
        tmpscore += 2*lengthOfTime;
        return tmpscore;
    }
    
    public String printScore() {
        return "The Current Score is: " + currentScore;
    }
}
