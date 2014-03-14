
package snake;

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
