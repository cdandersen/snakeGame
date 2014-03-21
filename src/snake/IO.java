
package snake;

import javax.swing.JOptionPane;

public class IO {

    String input;
    int inputInt;
    
    public String getInput(String message) {
        input = JOptionPane.showInputDialog(message);
        return input;
    }
    
    public int getInputInteger(String message) {
        inputInt = Integer.parseInt(JOptionPane.showInputDialog(message));
        return inputInt;
    }
    
    public void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
