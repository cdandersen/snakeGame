
package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/* Snake Game
 * CIT 260 - WInter 2014
 * Clayton Andersen - Tim Cotter
 */

public class Main implements ActionListener{

    static Board gameBoard = new Board(64, 64);
    static Snake mySnake = new Snake(3, 1);
    static Player myPlayer = new Player();
    /*
    JFrame frame = new JFrame();
    BorderLayout layout = new BorderLayout();
    
    JMenuBar menubar = new JMenuBar();
    JMenu menu1 = new JMenu("Help");
    JMenuItem AboutItem = new JMenuItem("About");
    JMenuItem ExitItem = new JMenuItem("Exit");
    JMenuItem PlayerName = new JMenuItem("New Player");
    JLabel PlayerNameLabel = new JLabel();*/

    public static void main(String[] args) {
        Menu frame = new Menu() {};
    }
    /*
    public Main() {
        frame.setUndecorated(true);
        Board b = new Board(500, 500);
        frame.setSize(b.getWidth(), b.getHeight());
        frame.setLocation(400, 400);
        frame.setLayout(layout);
        menubar.add(menu1);
        menu1.add(AboutItem);
        menu1.add(PlayerName);
        
        menu1.add(ExitItem);
        ExitItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        AboutItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This game is made by:\nClaytonAndersen\n&\nTim Cotter");
            }
        });
        PlayerName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerNameLabel.setText(newPlayer());
            }
        });
        frame.add(PlayerNameLabel, BorderLayout.SOUTH);
        
        frame.setJMenuBar(menubar);
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        startGame();
    }*/
    
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String newPlayer() {
        Player p = new Player();
        p.setName(JOptionPane.showInputDialog("Please Enter Your Name\nCannot Contain Numbers"));
        if (p.getName().matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "InValid Name");
        } else {       
        return p.getName();
        }
        return "";
    }

}
