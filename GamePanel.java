package platformer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    ArrayList<Wall> walls = new ArrayList<>();
    int cameraX;
    int offset;
    Timer gameTimer;
    public GamePanel() {
        player = new Player(400, 300, this);
        reset();
        makeWalls(50);
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(walls.get(walls.size() - 1).x < 800) {
                    offset += 700;
                    System.out.println(walls.size());
                    makeWalls(offset);
                    
                }
                player.set();
                for(Wall wall: walls) wall.set(cameraX);
                repaint();
            }
        }, 0, 17);
    }
    
    public void reset() {
        player.x = 200;
        player.y = 150;
        cameraX = 150;
        player.xspeed = 0;
        player.yspeed = 0;
        walls.clear();
        int offset = 150;
        makeWalls(offset);
    }
    
    public void makeWalls(int offset) {
        int s = 50;
        Random rand = new Random();
        int index = rand.nextInt(8);
        if(index == 0) {
            for(int i = 0; i < 14; i++) walls.add(new Wall(Color.PINK, offset + i*50, 600, s, s));
        } else if(index == 1) {
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.WHITE, offset + 450, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 500, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 550, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 600, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 650, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 700, 600, s, s));
            walls.add(new Wall(Color.WHITE, offset + 750, 600, s, s));   
        } else if(index == 2) {
            for(int i = 0; i < 14; i++) walls.add(new Wall(Color.RED, offset + i*50, 600, s, s));
            for(int i = 0; i < 12; i++) walls.add(new Wall(Color.RED, offset + 50 + i*50, 600, s, s));
            for(int i = 0; i < 10; i++) walls.add(new Wall(Color.RED, offset + 100 + i*50, 600, s, s));
            for(int i = 0; i < 8; i++) walls.add(new Wall(Color.RED, offset + 150 + i*50, 600, s, s));
            for(int i = 0; i < 6; i++) walls.add(new Wall(Color.RED, offset + 200 + i*50, 600, s, s));
            
        } else if(index == 3) {
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.GREEN, offset + i*50, 600, s, s));
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.GREEN, offset + 450 + i*50, 600, s, s));
            walls.add(new Wall(Color.GREEN, offset + 150, 550, s, s));
            walls.add(new Wall(Color.GREEN, offset + 200, 550, s, s));
            walls.add(new Wall(Color.GREEN, offset + 200, 500, s, s));
            walls.add(new Wall(Color.GREEN, offset + 200, 450, s, s));
            walls.add(new Wall(Color.GREEN, offset + 500, 550, s, s));
            walls.add(new Wall(Color.GREEN, offset + 450, 550, s, s));
            walls.add(new Wall(Color.GREEN, offset + 450, 500, s, s));
            walls.add(new Wall(Color.GREEN, offset + 450, 450, s, s));
        } else if(index == 4) {
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.BLUE, offset + i*50, 600, s, s));
            for(int i = 0; i < 4; i++) walls.add(new Wall(Color.BLUE, offset + 50 + i*50, 600, s, s));
            for(int i = 0; i < 3; i++) walls.add(new Wall(Color.BLUE, offset + 100 + i*50, 600, s, s));
            for(int i = 0; i < 2; i++) walls.add(new Wall(Color.BLUE, offset + 150 + i*50, 600, s, s));
            for(int i = 4; i < 3; i++) walls.add(new Wall(Color.BLUE, offset + 500 + i*50, 600, s, s));     
        } else if(index == 5) {
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.YELLOW, offset + i*50, 600, s, s));
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.YELLOW, offset + 100 + i*50, 550, s, s));
            for(int i = 0; i < 5; i++) walls.add(new Wall(Color.YELLOW, offset + 150 + i*50, 500, s, s));
            for(int j = 0; j < 4; j++) {
                for(int i = 0; i < 4; i++) walls.add(new Wall(Color.YELLOW, offset + 350 + i*50, 400 + 50*j, s, s));
            }
            for(int i = 0; i < 7; i++) walls.add(new Wall(Color.YELLOW, offset + 350 + i*50, 600, s, s));
            for(int i = 0; i < 2; i++) walls.add(new Wall(Color.YELLOW, offset + 550, 500 + i*50, s, s));
        } else if(index == 6) {
            for(int i = 0; i < 14; i++) walls.add(new Wall(Color.CYAN, offset + 1*50, 600, s, s));
            for(int i = 0; i < 7; i++) walls.add(new Wall(Color.CYAN, offset + 200 + i*50, 450, s, s));
        } else if(index == 7) {
            walls.add(new Wall(Color.MAGENTA, offset, 600, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 50, 600, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 150, 500, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 200, 500, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 300, 400, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 350, 400, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 450, 500, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 500, 500, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 600, 600, s, s));
            walls.add(new Wall(Color.MAGENTA, offset + 650, 600, s, s));
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for(Wall wall: walls) wall.draw(gtd);
    }

    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = true;
        if(e.getKeyChar() == 'w') player.keyUp = true;
        if(e.getKeyChar() == 'd') player.keyRight = true;
        if(e.getKeyChar() == 's') player.keyDown = true;
        if(e.getKeyChar() == 'r') reset();
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = false;
        if(e.getKeyChar() == 'w') player.keyUp = false;
        if(e.getKeyChar() == 'd') player.keyRight = false;
        if(e.getKeyChar() == 's') player.keyDown = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
