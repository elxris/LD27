package elxris.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import elxris.art.Arc;
import elxris.art.Pew;
import elxris.art.Pointer;
import elxris.art.Pool;
import elxris.util.ColorHandler;
import elxris.util.Sound;
import elxris.util.Sounds;

public class Game {
    public static float camX = 0, camY = 0;
    public boolean pausa = false;
    public long time = 10*1000;
    Arc[] arcs = new Arc[5];
    public Pool pool = new Pool();
    public int timeGame = 0;
    public Sound loop, fallo, acertado;
    public int level = 1;
    public Game(){
        ColorHandler color = new ColorHandler(Color.RED, 0);
        for(int i = 0; i < arcs.length; i++){
            Arc arc = new Arc(new ColorHandler(color.getColor(), 0), 3);
            arc.setSize(i*3);
            //arc.setOffsetPos(i*10, i*w);
            arc.setPos(Frame.WIDTH/2, Frame.HEIGHT/2);
            //arc.setAngle(i*8);
            arcs[i] = arc;
        }
        loop = new Sound(Sounds.LOOP.fileName());
        fallo = new Sound(Sounds.FALLO.fileName());
        acertado = new Sound(Sounds.ACERTA.fileName());
    }
    public void draw(Graphics g){
        int ticks = Tick.frames;
        if(arcs[0].getSelected()){
            g.setColor(Color.WHITE);
            g.drawPolygon(arcs[0].getPoly(-1));
        }
        // Cada cambio de segundo
        if(timeGame%ticks == 0){
            arcs[0].setRandomHalted();
            Controls.lClick = false;
            loop.play();
        }
        for(int i = arcs.length-1; i >= 0; i--){
            if(timeGame%ticks == 0){
                arcs[i].setSize(0);
                arcs[i].getColor().setDarkness(0);
                arcs[i].addSecments(1);
            }
            arcs[i].addSize(1+i);
            arcs[i].getColor().addDarkness(-1);
            float angle = 3f;
            angle += Tick.getTicksToSeconds(timeGame)/(getLevel());
            if((timeGame/ticks)%2 == 0){
                angle *= -1;
            }
            if(!Controls.lClick){
                arcs[i].addAngle(angle);
                //arcs[i].addAngle((float)arcs[i].getSize()/800f);
            }
            arcs[i].setOffsetPos((int)camX, (int)camY);
            arcs[i].setPos(Frame.WIDTH/2+(int)camX/4, Frame.HEIGHT/2+(int)camY/4);
            arcs[i].draw(g);
        }
        g.setFont(new Font("Impact", Font.PLAIN, 120));
        g.drawString(String.format("%.2f", Tick.getTicksToSeconds(timeGame)),
                Frame.WIDTH/2+120, 150);
        g.setFont(new Font("Verdana", Font.BOLD, 14));
        g.drawString("@elxris LD27 #TenSeconds", 0, 15);
        g.drawString("Difficuly:" + this.level, 0, 30);
        pool.draw(g);
        if(Controls.timeWin != 0){
            if(Controls.timeWin == 1){
                addLevel();
            }
            if(Controls.timeWin++ > Tick.getSecondsToTick(5d)){
                Controls.timeWin = 0;
            }
            Random rndm = new Random();
            g.setFont(new Font("Impact", Font.BOLD, 100));
            g.setColor(new Color(rndm.nextInt(256), rndm.nextInt(256), rndm.nextInt(256)));
            g.drawString("You WIN!!!", Frame.WIDTH/3, Frame.HEIGHT/2);
        }
    }
    public void tick(){
        move();
        if(Controls.lClick){
            if(arcs[0].getPoly(-1).contains(Pointer.x, Pointer.y)){
                arcs[0].setSelected(true);
            }
            if(Controls.timeLClick < Tick.getSecondsToTick(0.05d)){
                if(Controls.timeLClick == 0){
                    int time = (int) Tick.getSecondsToTick(0.2d);
                    pool.addArt(new Pew(time), time);
                }
                Controls.timeLClick++;
            }else{
                Controls.lClick = false;
            }
        }
        if(timeGame < Tick.getSecondsToTick(10)){
            timeGame++;
        }else{
            Controls.timeWin++;
            timeGame = 0;
        }
        if(timeGame%Tick.frames == 0){
            if(!arcs[0].getSelected()){
                fallo.play();
                timeGame = 0;
            }else{
                acertado.play();
            }
        }
        if(timeGame == 0){
            int i = 0;
            for(Arc a:arcs){
                a.setSize(i++);
                a.setSecments(2);
            }
        }
    }
    public void move(){
        setMove(Pointer.x-Frame.WIDTH/2, Pointer.y-Frame.HEIGHT/2);
    }
    public void setMove(float x, float y){
        camX = x;
        camY = y;
        if(camX > Frame.WIDTH/4){
            camX = Frame.WIDTH/4;
        }else if(camX < -Frame.WIDTH/4){
            camX = -Frame.WIDTH/4;
        }
        if(camY > Frame.HEIGHT/4){
            camY = Frame.HEIGHT/4;
        }else if(camY < -Frame.HEIGHT/4){
            camY = -Frame.HEIGHT/4;
        }
    }
    public void addMove(float x, float y){
        setMove(camX+x, camY+y);
    }
    public void addMove(int x, int y){
        addMove((float)x, (float)y);
    }
    public float getLevel(){
        return 10f-((float)this.level)*1f;
    }
    public void addLevel(){
        this.level++;
    }
}
