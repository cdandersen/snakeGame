
package citbyui.cit230.snakeGame.menu;

import javax.swing.JMenuItem;

public class AboutMenu {
    
    JMenuItem AboutItem = new JMenuItem();

    public AboutMenu(String name) {
        AboutItem = new JMenuItem(name);
    }
    
    public void setItem(String s) {
        AboutItem = new JMenuItem(s);
    }
    

    
}
