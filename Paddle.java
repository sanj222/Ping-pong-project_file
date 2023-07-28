import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    int id;
    int yvel;
    int speed=10;
    Paddle(int x, int y, int PaddleWidth, int PaddleHeight, int id){
            super(x,y,PaddleWidth,PaddleHeight);
            this.id=id;
    }
    public void KeyPressed(KeyEvent e){
       switch(id)
       {
           case 1:
               if(e.getKeyCode()==KeyEvent.VK_W){
                   setYdirection(-speed);
               }
               if(e.getKeyCode()==KeyEvent.VK_S){
                   setYdirection(speed);
               }
               break;
           case 2:
               if(e.getKeyCode()==KeyEvent.VK_UP){
                   setYdirection(-speed);
               }
               if(e.getKeyCode()==KeyEvent.VK_DOWN){
                   setYdirection(speed);
               }

       }
    }

    private void setYdirection(int direction) {
        yvel=direction;
    }

    public void KeyReleased(KeyEvent e){
            switch (id){
                case 1:
                    if(e.getKeyCode()==KeyEvent.VK_W)
                    {setYdirection(0);}
                    if(e.getKeyCode()==KeyEvent.VK_S)
                    {setYdirection(0);}
                case 2:
                    if(e.getKeyCode()==KeyEvent.VK_UP)
                    {setYdirection(0);}
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    {setYdirection(0);}

            }
    }
    public void move(){
        y=y+yvel;
    }
    public void draw(Graphics g){
            if(id==1)
            {
                g.setColor(Color.yellow);
            }
            else if(id==2)
            {
                g.setColor(Color.red);
            }
            g.fillRect(x,y,width,height);
    }
}
