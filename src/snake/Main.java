
package snake;

import javax.swing.JOptionPane;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */

public class Main {

    static Board gameBoard = new Board(64, 64);
    static Snake mySnake = new Snake(3, 1);
    static Player myPlayer = new Player();

    public static void main(String[] args) {
        startGame();
    }
    
    public static void startGame() {
        //String n = JOptionPane.showInputDialog(null, "Welcome to Snake\nPlease Enter Your Name");
        //myPlayer.setName(n);
        //int choice = JOptionPane.showConfirmDialog(null, "Your name has been set to: " + myPlayer.getName() + "\nis this correct?");
        //if they choose no it shows the help dialog, yes registers as 0
        //if (choice == 1) {
        //    displayHelp();
        //}
        Board b = new Board();
        Snake s = new Snake();
        s.setDirection(4);
        int[] tmp = new int[2];
        tmp = s.getValidDirections(s.getDirection());
        String print = "";
        for (int i = 0; i < 2; i++) {
            print += tmp[i] + " ";
        }
        System.out.println(print);
    }
    
    public static void displayHelp() {
        JOptionPane.showMessageDialog(null, "Get Help Here");
    }

}
