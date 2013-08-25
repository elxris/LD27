package elxris.art;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Pool implements Art{
    List<Element> elements = new ArrayList<Element>();
    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < elements.size(); i++){
            if(!elements.get(i).isLive()){
                elements.remove(i);
                continue;
            }
            elements.get(i).draw(g);
        }
    }
    public void addArt(Art art, int life){
        elements.add(new Element(life, art));
    }
}
