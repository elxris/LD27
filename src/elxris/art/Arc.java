package elxris.art;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import elxris.util.ColorHandler;

public class Arc implements Art{
    private int secments = 8;
    private int size = 10;
    private static int deadAngle = 1;
    private ColorHandler color;
    private int x, y, offX, offY;
    private float angle;
    public Arc(ColorHandler color, int secments, int x, int y, int offsetX, int offsetY, float angle){
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
        //g.fillOval(getX(), getY(), size, size);
        for(int i = 0; i < secments; i++){
            g.setColor(color.getColor());
            g.fillPolygon(getPoly(i));
        }
    }
    public Polygon getPoly(int num){
        Polygon poly = new Polygon();
        double offAngle = (360-(secments*deadAngle))/secments;
        double deg = angle+num*offAngle+num*deadAngle;
        double cos = Math.cos(Math.toRadians(deg));
        double sin = Math.sin(Math.toRadians(deg));
        double thick = 1.1d;
        poly.addPoint(getX()+(int)(size*cos), getY()+(int)(size*sin));
        poly.addPoint(getX()+(int)((size*thick)*cos), getY()+(int)((size*thick)*sin));
        deg += offAngle;
        cos = Math.cos(Math.toRadians(deg));
        sin = Math.sin(Math.toRadians(deg));
        poly.addPoint(getX()+(int)((size*thick)*cos), getY()+(int)((size*thick)*sin));
        poly.addPoint(getX()+(int)(size*cos), getY()+(int)(size*sin));
        return poly;
    }
    public int getX(){
        return (int)(x+offX/(1+(double)((double)size/30)));
    }
    public int getY(){
        return (int)(y+offY/(1+(double)((double)size/30)));
    }
    public void setAngle(float angle){
        this.angle = angle;
    }
    public void addAngle(float angle){
        setAngle(this.angle+angle);
    }
    public float getAngle(){
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
    public ColorHandler getColor(){
        return color;
    }
}
