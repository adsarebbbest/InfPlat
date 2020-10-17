package platformer;
//doesn't work on replit
import java.awt.Dimension;
import java.awt.Toolkit;

public class platformer {
    
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setSize(700, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        frame.setResizable(false);
        frame.setTitle("Java Platformer");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        
    }
}
