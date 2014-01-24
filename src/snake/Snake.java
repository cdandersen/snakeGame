
package snake;

import javax.swing.JOptionPane;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */

public class Snake {

    static Board gameBoard = new Board(64, 64);
    static SnakeHead mySnake = new SnakeHead(3, 1);
    static Player myPlayer = new Player();

    public static void main(String[] args) {
        
        startGame();
    }
    
    public static void startGame() {
        String n = JOptionPane.showInputDialog(null, "Welcome to Snake\nPlease Enter Your Name");
        myPlayer.setName(n);
        int choice = JOptionPane.showConfirmDialog(null, "Your name has been set to: " + myPlayer.getName() + "\nis this correct?");
        //if they choose no it shows the help dialog, yes registers as 0
        if (choice == 1) {
            getHelp();
        }
    }
    
    public static void displayHelp() {
        JOptionPane.showMessageDialog(null, "Get Help Here");
    }

}
