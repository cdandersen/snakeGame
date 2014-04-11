
package citbyui.cit230.snakeGame.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import snake.Board;
import snake.Player;

public class Menu extends JFrame implements ActionListener, KeyListener, Serializable{
    
    BorderLayout layout = new BorderLayout();

    Timer t;
    Image buff;
    Graphics graph;
    
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
    boolean isFruity;
    public Board b = new Board();
    
    int startingPointX = 50;
    int startingPointY = 80;
    
    Player p = new Player();
    String [] list = {"Number Of Wins", "Tim  22", "Clayton  19", "Bryce  15", "Amanda  14", "Linda  11", "Bob  5"};
    int [] scores = {400, 700, 930, 420, 230, 490, 1020};
    
    boolean snakeLives = true;
    
    Point currentHead = new Point(16, 16);
    Point currentFruit = new Point(3, 7);
    
    ArrayList<Point> tail = new ArrayList<>();
    
    int tailLength = 0;
    int fruitsEaten = 0;


    public Menu() {
        super("Snake");
        setSize(800, 800);
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
        AboutMenu.addActionListener(this);
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
        
        //addKeyListener(this);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        
        setResizable(false);
        setJMenuBar(menubar);
        setFocusable(true);
        setAutoRequestFocus(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        setVisible(true);
        
        buff = this.createImage(this.getWidth(), this.getHeight());
        graph = buff.getGraphics();
        
        repaint();
        
    }
    
    @Override
    public void paint(Graphics g) {
        if (snakeLives) {
        
        if (graph != null){
            super.paint(graph);
            
            //graph.drawString("Hello", 150, 150);

            //draw board


            for (int w = 0; w < b.getWidth(); w++) {
                for (int h = 0; h < b.getWidth(); h++) {
                       int value = b.getValue(w, h);
                       switch(value){
                           case 0: drawEmpty(graph, w, h); break;
                           case 3: drawHead(graph, w, h); break;
                           case 1: drawTail(graph, w, h); break;
                           case 2: drawFruit(graph, w, h); break;                        
                       }
                 }
            }
        }
        } else {
            Font f = new Font("Helvetica", Font.PLAIN, 22);
            graph.setFont(f);
            graph.setColor(Color.CYAN);
            graph.drawString("Game Over: You Got " + (fruitsEaten * 100) + " points", ((b.getWidth()*b.getPixelModifier())/2)-90, (b.getHeight()*b.getPixelModifier())/2);
        }
        g.drawImage(buff, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public void drawHead(Graphics graph, int w, int h) {
        graph.setColor(Color.ORANGE);
        graph.fillRect(startingPointX + (w*b.getPixelModifier()), startingPointY + (h*b.getPixelModifier()), b.getPixelModifier(), b.getPixelModifier());
    }
    
    public void drawTail(Graphics graph, int w, int h) {
        graph.setColor(Color.GREEN);
        graph.fillRect(startingPointX + (w*b.getPixelModifier()), startingPointY + (h*b.getPixelModifier()), b.getPixelModifier(), b.getPixelModifier());
    }
    
    public void drawFruit(Graphics graph, int w, int h) {
        graph.setColor(Color.RED);
        graph.fillRect(startingPointX + (w*b.getPixelModifier()), startingPointY + (h*b.getPixelModifier()), b.getPixelModifier(), b.getPixelModifier());
    }
    
    public void drawEmpty(Graphics graph, int w, int h) {
        graph.setColor(Color.BLACK);
        graph.fillRect(startingPointX + (w*b.getPixelModifier()), startingPointY + (h*b.getPixelModifier()), b.getPixelModifier(), b.getPixelModifier());
    }
    
    public void init() {
        b = new Board();
        tail.clear();
        currentHead = new Point(16, 16);
        currentFruit = new Point(3, 7);
        snakeLives = true;
        fruitsEaten = 0;
        
        b.setBox(16, 16, 3);
        b.setBox(3, 7, 2);
        b.setBox(16, 17, 1);
        b.setBox(16, 18, 1);
        b.setBox(16, 19, 1);
        
        tail.add(new Point(16, 17));
        tail.add(new Point(16, 18));
        tail.add(new Point(16, 19));
    }
    
    public void start() {
        init();
        repaint();
        t = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (snakeLives){
                collisionDetect();
                update();
                //repaint();
                }else{
                    t.stop();
                }
                
                repaint();
                //collisionDetect();
            }
        });
        t.start();
    }

    
    public boolean isOnBoard() {
        //checks to make sure the snake is still on the screen
        Point tmp = new Point();
        tmp = findHead();
        if (tmp.x == 0) {
            snakeLives = false;
            return false;
        } else if (tmp.y == 0) {
            snakeLives = false;
            return false;
        }
        return true;
    }
    
    public void collisionDetect() {
        //detects a collision with the apple
        Point h = findHead();
        Point f = currentFruit;
        System.out.println("Fruit Spot: " + f.x + ":" + f.y);
        isFruity = (h.getLocation().equals(f.getLocation()));
    }
    
    /*public Point findFruit() {
        //seaches the board for a square containing a fruit
        for(int i = 0; i<b.getWidth(); i++){
            for(int j = 0; j<b.getHeight(); j++){
                if (b.getValue(i, j) == 2){
                    System.out.println("Found Fruit! " + i + ":" + j);
                    currentFruit = new Point(i, j);
                    return new Point(i, j);
                }
            }
        }
        return null;
    }*/
    

    public Point findHead(){
        //searches the board for a square containing a Head
        //findFruit();
        for(int i = 0; i<b.getWidth(); i++){
            for(int j = 0; j<b.getHeight(); j++){
                if (b.getValue(i, j) == 3){
                    System.out.println(i + ":" + j);
                    currentHead = new Point(i, j);
                    return new Point(i, j);
            }
        }
       }
        return null;
        
    }
    
    public void update(){
        Point head = findHead();
        
        tail.add(head);
        if (!isFruity){
            System.out.println("Not Fruity " + tail.get(0).x + ":" + tail.get(0).y);
            b.setBox(tail.get(0).x, tail.get(0).y, 0);
            tail.remove(0);
            System.out.println("Tail Length: " + tail.size());
        }
        else{
            fruitsEaten++;
            Random r = new Random();
            Point p = new Point(r.nextInt(31)+1, r.nextInt(31)+1);
            b.setBox(p.x, p.y, 2);
            currentFruit = p;
        }
        
        
        b.setBox((int)head.getX(), (int)head.getY(), 1);
        
        //Moves snake based on current direction
        if (b.getDirection() == 0/*UP*/) { 
            if (head.y <= 0 ) {
                snakeLives = false;
            }else if(b.getValue((int)head.getX(), (int)head.getY()-1) != 1){
                b.setBox((int)head.getX(), (int)head.getY()-1, 3);
            }
            
            //currentHead = new Point(head.getLocation());
        } else if (b.getDirection() == 1/*DOWN*/) {
            if (head.y >= 31) {
                snakeLives = false;
            } else if (b.getValue((int)head.getX(), (int)head.getY()+1) != 1) {
            b.setBox((int)head.getX(), (int)head.getY()+1, 3);
            }
            //currentHead = new Point(head.getLocation());
        } else if (b.getDirection() == 2/*LEFT*/) {
            if (head.x <= 0) {
                snakeLives = false;
            } else if (b.getValue((int)head.getX()-1, (int)head.getY()) != 1) {
            b.setBox((int)head.getX()-1, (int)head.getY(), 3);
            }
            //currentHead = new Point(head.getLocation());
        } else if (b.getDirection() == 3/*RIGHT*/) {
            if (head.x >= 31) {
                snakeLives = false;
            } else if (b.getValue((int)head.getX()+1, (int)head.getY()) != 1)  {
            b.setBox((int)head.getX()+1, (int)head.getY(), 3);
            }
            //currentHead = new Point(head.getLocation());
        }
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PlayerNameItem){
            
        }else if (e.getSource() == ExitItem){
            System.exit(0);
        } else if (e.getSource() == AboutItem) {
            JOptionPane.showMessageDialog(null, "SnakeGame\nCopyright 2014\n\nClayton Andersen & Tim Cotter");
        } else if (e.getSource() == NewGameItem) {
            start();
        } else if (e.getSource() == LoadGameItem) {
            
        } else if (e.getSource() == SaveGameItem) {
            
        } else if (e.getSource() == BeginnerItem){
            JOptionPane.showMessageDialog(null, "You have chosen beginner mode.");
        } else if (e.getSource() == IntermediateItem){
            JOptionPane.showMessageDialog(null, "You have chosen intermediate mode.");
        }else if (e.getSource() == ExpertItem){
            JOptionPane.showMessageDialog(null, "You have chosen expert mode.");
        }else if (e.getSource() == WinsItem){
            
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
    
    private void sort(int [] list) {
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
    
    public boolean correctDirection(int x) {
        if (b.getWrongDirection() == x) {
            return false;
        } else {
            return true;
        }
    }
        

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP) 
            {
                if (correctDirection(0)) {
                    b.setDirection(0);
                }
        } 
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                if (correctDirection(1)) {
                    b.setDirection(1);
                }
        } 
            else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if (correctDirection(2)) {
                    b.setDirection(2);
                }
        } 
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if (correctDirection(3)) {
                    b.setDirection(3);
                }
            }
            
            
        }
        return false;
        
    }
    }
    
      
 }



    


