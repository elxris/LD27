package elxris.util;

import java.awt.Color;

public class ColorHandler {
    Color color;
    int darkness, alpha;
    public ColorHandler(Color color, int darkness){
        this.color = color;
        this.darkness = darkness;
        this.alpha = color.getAlpha();
    }
    public ColorHandler(Color color){
        this(color, 0);
    }
    public static Color getColor(Color color, int darkness, int alpha){
        int r = checkColor(color.getRed()-darkness);
        int gr = checkColor(color.getGreen()-darkness);
        int b = checkColor(color.getBlue()-darkness);
        Color newColor = new Color(r, gr, b);
        return newColor;
    }
    public Color getColor(int addDarkness){
        return getColor(color, this.darkness+darkness, this.alpha);
    }
    public Color getColor(){
        return getColor(0);
    }
    public void setDarkness(int value){
        this.darkness = value;
    }
    public int getDarkness(){
        return this.darkness;
    }
    public void addDarkness(int add){
        setDarkness(getDarkness()+add);
    }
    public void setAlpha(int value){
        this.alpha = checkColor(value);
    }
    public int getAlpha(){
        return this.alpha;
    }
    public void addAlpha(int value){
        setAlpha(getAlpha()+value);
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
