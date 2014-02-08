
package snake;

import java.awt.BorderLayout;
import java.awt.Color;
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
    JMenu AboutMenu;
    JMenu GameMenu;
    JMenuItem AboutItem;
    JMenuItem ExitItem;
    JMenuItem PlayerNameItem;
    JMenuItem NewGameItem;
    JMenuItem SaveGameItem;
    JMenuItem LoadGameItem;
    Board b;
    
    Player p = new Player();

    public Framey() {
        super("Snake");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        //setLayout(layout);
        menubar = new JMenuBar();
        AboutMenu = new JMenu("Help");
        GameMenu = new JMenu("Game");
        AboutItem = new JMenuItem("About");
        ExitItem = new JMenuItem("Exit");
        PlayerNameItem = new JMenuItem("New Player");
        NewGameItem = new JMenuItem("New Game");
        LoadGameItem = new JMenuItem("Load Game");
        SaveGameItem = new JMenuItem("Save Game");
        
        ExitItem.addActionListener(this);
        AboutItem.addActionListener(this);
        PlayerNameItem.addActionListener(this);
        NewGameItem.addActionListener(this);
        
        menubar.add(GameMenu);
        menubar.add(AboutMenu);
        
        AboutMenu.add(AboutItem);
        
        GameMenu.add(NewGameItem);
        GameMenu.add(PlayerNameItem);
        GameMenu.add(LoadGameItem);
        GameMenu.add(SaveGameItem);
        GameMenu.add(ExitItem);
        
        setResizable(false);
        setJMenuBar(menubar);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(p.getName(), 150, 150);
        
        //draw board
        int startingPointX = 100;
        int startingPointY = 100;
        for (int i = 0; i < b.getWidth(); i++) {
            g.setColor(Color.red);
            g.drawRect(startingPointX+ (i*b.gridWidthInPixels()), startingPointY + (i*b.gridHeightInPixels()), b.gridWidthInPixels(), b.gridHeightInPixels());
        }
    }
    
    public void newPlayer() {
        p.setName(JOptionPane.showInputDialog("Please Enter Your Name"));
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PlayerNameItem){
            newPlayer();
        }else if (e.getSource() == ExitItem){
            System.exit(0);
        } else if (e.getSource() == AboutItem) {
            JOptionPane.showMessageDialog(null, "SnakeGame\nCopyright 2014\n\nClayton Andersen & Tim Cotter");
        } else if (e.getSource() == NewGameItem) {
            int boardSize = Integer.parseInt(JOptionPane.showInputDialog("How big would you like the board?\nExample:8 makes an 8x8 board"));
            b = new Board(boardSize, boardSize);
            repaint();
        } else if (e.getSource() == LoadGameItem) {
            
        } else if (e.getSource() == SaveGameItem) {
            
        }
    }
}


