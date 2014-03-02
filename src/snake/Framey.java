
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
    JMenu StatsMenu;
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
    JMenuItem WinsItem;
    JMenuItem ScoresItem;
    Board b;
    
    Player p = new Player();
    String [] list = {"Number Of Wins", "Tim  22", "Clayton  19", "Bryce  15", "Amanda  14", "Linda  11", "Bob  5"};
    int [] scores = {400, 700, 930, 420, 230, 490, 1020};


    public Framey() {
        super("Snake");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        //setLayout(layout);
        menubar = new JMenuBar();
        AboutMenu = new JMenu("Help");
        StatsMenu = new JMenu("Stats");
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
        WinsItem = new JMenuItem("Wins");
        ScoresItem = new JMenuItem("Scores");
        
        
        ExitItem.addActionListener(this);
        AboutItem.addActionListener(this);
        PlayerNameItem.addActionListener(this);
        NewGameItem.addActionListener(this);
        BeginnerItem.addActionListener(this);
        IntermediateItem.addActionListener(this);
        ExpertItem.addActionListener(this);
        WinsItem.addActionListener(this);
        ScoresItem.addActionListener(this);
        
        
        menubar.add(GameMenu);
        menubar.add(DifficultyMenu);
        menubar.add(StatsMenu);
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
        StatsMenu.add(WinsItem);
        StatsMenu.add(ScoresItem);
        
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
        }else if (e.getSource() == WinsItem){
            isWins();
        }else if (e.getSource() == ScoresItem){
            sort(scores);
            String tmp = "";
            for (int i = 0; i < scores.length; i++) {
                tmp += scores[i];
                tmp += "\n";
            }
            JOptionPane.showMessageDialog(null, "The Scores are:\n" + tmp);
        } else {
            
        }
    }
        
    public String isWins(){
        String s = "";
        int [] wins = {22, 19, 15, 14, 11, 5};
        int sum = 0;
        for (String list1 : list) {
            s += list1 + "\n";
        }
        for (int i = 0; i < wins.length; i++){
            
            sum += wins[i];
        
        }
        String output = s + "\n" + "Total Wins   =" + sum;
        JOptionPane.showMessageDialog(null, output);
        return output;
    }
    
    public void boardSize() {
        int boardSize = Integer.parseInt(JOptionPane.showInputDialog("How big would you like the board?\nExample:12 makes a 12x12 board"));
            if (boardSize > 70) {
                JOptionPane.showMessageDialog(null, "Board canot be that big, Board size must be between 10 and 70");
                boardSize();
            } else if (boardSize < 10) {
                JOptionPane.showMessageDialog(null, "Board canot be that small, Board size must be between 10 and 70");
                boardSize();
            } else {
                b = new Board(boardSize, boardSize);
                repaint();
            }
    }
    
    public void sort(int [] list) {
        //runs insertion sort on a list of ints
        for (int i = 1; i < list.length; i++) {
            int tmp = list[i];
            int j;
            for (j = i - 1; j >=0 && tmp < list[j]; j--) {
                list[j+1] = list[j];
            }
        list[j+1] = tmp;
            }
    }
            
 }


