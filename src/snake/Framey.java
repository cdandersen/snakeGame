
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
    JMenu DifficultyMenu;
    JMenuItem AboutItem;
    JMenuItem ExitItem;
    JMenuItem PlayerNameItem;
    JMenuItem NewGameItem;
    JMenuItem SaveGameItem;
    JMenuItem LoadGameItem;
    JMenuItem BeginnerItem;
    JMenuItem IntermediateItem;
    JMenuItem ExpertItem;
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
        DifficultyMenu = new JMenu("Difficulty");
        AboutItem = new JMenuItem("About");
        ExitItem = new JMenuItem("Exit");
        PlayerNameItem = new JMenuItem("New Player");
        NewGameItem = new JMenuItem("New Game");
        LoadGameItem = new JMenuItem("Load Game");
        SaveGameItem = new JMenuItem("Save Game");
        BeginnerItem = new JMenuItem("Beginner");
        IntermediateItem = new JMenuItem("Intermediate");
        ExpertItem = new JMenuItem("Expert");
        
        
        ExitItem.addActionListener(this);
        AboutItem.addActionListener(this);
        PlayerNameItem.addActionListener(this);
        NewGameItem.addActionListener(this);
        BeginnerItem.addActionListener(this);
        IntermediateItem.addActionListener(this);
        ExpertItem.addActionListener(this);
        
        
        menubar.add(GameMenu);
        menubar.add(DifficultyMenu);
        menubar.add(AboutMenu);
        
        AboutMenu.add(AboutItem);
        
        GameMenu.add(NewGameItem);
        GameMenu.add(PlayerNameItem);
        GameMenu.add(LoadGameItem);
        GameMenu.add(SaveGameItem);
        GameMenu.add(ExitItem);
        DifficultyMenu.add(BeginnerItem);
        DifficultyMenu.add(IntermediateItem);
        DifficultyMenu.add(ExpertItem);
        
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
        b.setPixelModifier(10);
        int startModifier = 60;
        for (int w = 0; w < b.getWidth(); w++) {
            //g.drawRect(w*b.getPixelModifier(), h*b.getPixelModifier(), b.getWidth(), b.getHeight());
            for (int h = 0; h < b.getHeight(); h++) {
            g.setColor(Color.red);
            g.drawRect((w*b.getPixelModifier())+startModifier, (h*b.getPixelModifier())+startModifier, b.getPixelModifier(), b.getPixelModifier());
            }
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
            boardSize();
        } else if (e.getSource() == LoadGameItem) {
            
        } else if (e.getSource() == SaveGameItem) {
            
        } else if (e.getSource() == BeginnerItem){
            JOptionPane.showMessageDialog(null, "You have chosen beginner mode.");
        } else if (e.getSource() == IntermediateItem){
            JOptionPane.showMessageDialog(null, "You have chosen intermediate mode.");
        }else if (e.getSource() == ExpertItem){
            JOptionPane.showMessageDialog(null, "You have chosen expert mode.");
        }else{
        }
    }
    
    public void boardSize() {
        int boardSize = Integer.parseInt(JOptionPane.showInputDialog("How big would you like the board?\nExample:8 makes an 8x8 board"));
            if (boardSize > 70) {
                JOptionPane.showMessageDialog(null, "Board canot be that big, try again");
                boardSize();
            } else if (boardSize < 10) {
                JOptionPane.showMessageDialog(null, "Board canot be that small, try again");
                boardSize();
            } else {
                b = new Board(boardSize, boardSize);
                repaint();
            }
    }
            
 }


