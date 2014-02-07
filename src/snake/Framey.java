
package snake;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Framey extends JFrame implements ActionListener{
    
    BorderLayout layout = new BorderLayout();
    JMenuBar menubar;
    JMenu menu1;
    JMenuItem AboutItem;
    JMenuItem ExitItem;
    JMenuItem PlayerName;

    public Framey() {
        setUndecorated(true);
        Board b = new Board(500, 500);
        setSize(b.getWidth(), b.getHeight());
        setLocation(400, 400);
        setLayout(layout);
        menubar = new JMenuBar();
        menu1 = new JMenu("Help");
        AboutItem = new JMenuItem("About");
        ExitItem = new JMenuItem("Exit");
        PlayerName = new JMenuItem("New Player");
        ExitItem.addActionListener(this);
        AboutItem.addActionListener(this);
        PlayerName.addActionListener(this);
        
        menubar.add(menu1, BorderLayout.CENTER);
        menu1.add(AboutItem);
        menu1.add(PlayerName);
        
        menu1.add(ExitItem, BorderLayout.CENTER);
        setJMenuBar(menubar);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
        
    }
    
    public void newPlayer() {
        Player p = new Player();
        p.setName(JOptionPane.showInputDialog("Please Enter Your Name"));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PlayerName){
            
        }else if (e.getSource() == ExitItem){
            
        }
                }
}


