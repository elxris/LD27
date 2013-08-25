package elxris.art;

import java.awt.Graphics;

public class Element implements Art{
    public int lifeTicks;
    public Art art;
    public Element(int lifeTicks, Art art){
        this.lifeTicks = lifeTicks;
        this.art = art;
    }
    @Override
    public void draw(Graphics g) {
        if(!isLive()){
            art = null;
            return;
        }
        art.draw(g);
        return;
    }
    public boolean isLive(){
        if(lifeTicks < 0){
            return false;
        }else{
            lifeTicks--;
            return true;
        }
    }
}
