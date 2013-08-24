package elxris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tick extends Timer{
    private static final long serialVersionUID = -282652776786022160L;
    private static int c = 0;
    private static long date;
    public Tick(final int frames, final Canvas canvas) {
        super(1000/frames, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.tick();
                if(++c%frames == 0){
                    date = System.currentTimeMillis()-(date);
                    System.out.print(date+"ms, ");
                    date = System.currentTimeMillis();
                    if(c%(frames*12) == 0){
                        System.out.println();
                        c = 0;
                    }
                }
            }
        });
    }
}
