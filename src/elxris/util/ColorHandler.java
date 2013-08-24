package elxris.util;

import java.awt.Color;

public class ColorHandler {
    Color color;
    int darkness;
    public ColorHandler(Color color, int darkness){
        this.color = color;
        this.darkness = darkness;
    }
    public ColorHandler(Color color){
        this(color, 0);
    }
    public static Color getColor(Color color, int darkness){
        int r = checkColor(color.getRed()-darkness);
        int gr = checkColor(color.getGreen()-darkness);
        int b = checkColor(color.getBlue()-darkness);
        Color newColor = new Color(r, gr, b);
        return newColor;
    }
    public Color getColor(int addDarkness){
        return getColor(color, this.darkness+darkness);
    }
    public Color getColor(){
        return getColor(0);
    }
    public void addDarkness(int add){
        this.darkness += add;
    }
    public static int checkColor(int color){
        if(color > 0){
            if(color >= 256){
                return 255;
            }
            return color;
        }else{
            return 0;
        }
    }
}
