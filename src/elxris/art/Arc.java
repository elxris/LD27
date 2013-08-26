package elxris.art;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

import elxris.util.ColorHandler;

public class Arc implements Art{
    private int secments = 8;
    private int size = 10;
    private static int deadAngle = 1;
    private ColorHandler color;
    private int x, y, offX, offY;
    private static int halted;
    private static boolean selected;
    private double angle;
    public Arc(ColorHandler color, int secments, int x, int y, int offsetX, int offsetY, double angle){
        this.color = color;
        this.secments = secments;
        this.x = x;
        this.y = y;
        this.offX = offsetX;
        this.offY = offsetY;
        this.angle = angle;
    }
    public Arc(ColorHandler color, int secments, int x, int y){
        this(color, secments, x, y, 0, 0, 0);
    }
    public Arc(ColorHandler color, int secments){
        this(color, secments, 0, 0, 0, 0, 0);
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        for(int i = 0; i < secments; i++){
            if(i == getHalted()){
                if(selected){
                    g.setColor(new ColorHandler(Color.BLUE, color.getDarkness()).getColor());
                }else{
                    g.setColor(new ColorHandler(Color.GREEN, color.getDarkness()).getColor());
                }
            }else{
                g.setColor(color.getColor());
            }
            g.fillPolygon(getPoly(i));
        }
    }
    public Polygon getPoly(int num){
        Polygon poly = new Polygon();
        Polygon polyBound = new Polygon();
        double offAngle = (360-((double)secments*(double)deadAngle))/(double)secments;
        double deg = angle+num*offAngle+num*deadAngle;
        if(num == -1){
            deg = angle+getHalted()*offAngle+getHalted()*deadAngle;
        }
        double cos = Math.cos(Math.toRadians(deg));
        double sin = Math.sin(Math.toRadians(deg));
        if(num == -1){
            polyBound.addPoint(getX(), getY());
            polyBound.addPoint(getX()+(int)(10000*cos), getY()+(int)(10000*sin));
        }
        double thick = 15d;
        poly.addPoint(getX()+(int)(size*cos), getY()+(int)(size*sin));
        poly.addPoint(getX()+(int)((size+thick)*cos), getY()+(int)((size+thick)*sin));
        deg += offAngle;
        cos = Math.cos(Math.toRadians(deg));
        sin = Math.sin(Math.toRadians(deg));
        if(num == -1){
            polyBound.addPoint(getX()+(int)(10000*cos), getY()+(int)(10000*sin));
            return polyBound;
        }
        poly.addPoint(getX()+(int)((size+thick)*cos), getY()+(int)((size+thick)*sin));
        poly.addPoint(getX()+(int)(size*cos), getY()+(int)(size*sin));
        return poly;
    }
    public int getX(){
        return (int)(x+offX/(1+(double)((double)size/30)));
    }
    public int getY(){
        return (int)(y+offY/(1+(double)((double)size/30)));
    }
    public void setAngle(double angle){
        this.angle = angle%360;
    }
    public void addAngle(double angle){
        setAngle(this.angle+angle);
    }
    public double getAngle(){
        return angle;
    }
    public int getIntAngle(){
        return (int)getAngle();
    }
    public void setSize(int size){
        this.size = size;
    }
    public void addSize(int size){
        setSize(this.size+size);
    }
    public int getSize(){
        return size;
    }
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setOffsetPos(int x, int y){
        this.offX = x;
        this.offY = y;
    }
    public void setSecments(int value){
        secments = value;
        selected = false;
    }
    public int getSecments(){
        return secments;
    }
    public void addSecments(int value){
        setSecments(getSecments()+value);
    }
    public void setHalted(int value){
        if(value > getSecments()){
            value = getSecments();
        }else if(value <= 0){
            value = 1;
        }
        halted = value;
    }
    public int getHalted(){
        return halted;
    }
    public void setSelected(boolean value){
        selected = value;
    }
    public boolean getSelected(){
        return selected;
    }
    public void setRandomHalted(){
        Random rndm = new Random();
        setHalted(rndm.nextInt(getSecments()));
    }
    public ColorHandler getColor(){
        return color;
    }
}
