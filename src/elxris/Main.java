package elxris;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        Frame frame = new Frame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setLocation(1600-700-1, 900-450-1);
        frame.run();
    }
}
