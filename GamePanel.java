import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends Panel implements Runnable {
    int Width=1000;
    int Height=(int)(0.555*Width);
    Dimension screen=new Dimension(Width,Height);

    int paddlewidth=25;
    int paddleheight=100;
    int balldia=20;

    Image image;
    Graphics graphics;

    Paddle p1,p2;

    Ball ball;

    Score score=new Score(Width,Height);
    Thread GameThread;
    GamePanel(){
        setPreferredSize(screen);
        GameThread=new Thread(this);
        //This line creates a new instance of the Thread class and assigns it to the GameThread variable.
        addKeyListener(new AL());
        //This line adds a new instance of the AL class as a key listener to the game panel
        // allowing the game panel to handle keyboard input.
        setFocusable(true);
        //This method call enables the game panel to receive keyboard focus, ensuring that it can process keyboard events.
        GameThread.start();
        //This line starts the GameThread thread, initiating the game loop and allowing the code within the run() method
        // to execute.
        newPaddle();
        newBall();

    }

    private void newBall() {
        Random random=new Random();
        ball=new Ball(Width/2,random.nextInt(Height-balldia),balldia,balldia);
    }

    private void newPaddle() {
        p1=new Paddle(0, (Height-paddleheight)/2, paddlewidth, paddleheight,1);
        p2=new Paddle(Width-paddlewidth, (Height-paddleheight)/2, paddlewidth, paddleheight,2);
    }

    public void paint(Graphics g) {
        super.paint(g);
        image=createImage(getWidth(),getHeight());
        graphics=image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    private void draw(Graphics g){
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);
       score.draw(g);
    }

    @Override
    public void run() {
        long lastTime=System.nanoTime();
        double amountofTicks=60; //1sec=60ticks
        double ns=1000000000/amountofTicks; //how many nanosecs are there in 1 tick
        double delta=0;

        while(true)
        {
            long Now=System.nanoTime();
            delta+=(Now-lastTime)/ns;
            lastTime=Now;
            if(delta>=1)
            {
                repaint();
                move();
                CheckCollision();
                delta--;
            }
        }
    }

    private void CheckCollision() {
        if(ball.y<=0)
        {
            ball.setYDirection(-ball.yvel);
        }
        if(ball.y>=Height-balldia)
        {
            ball.setYDirection(-ball.yvel);
        }
        if(ball.intersects(p1)){
          ball.xvel=-ball.xvel;
          ball.xvel++;
          if(ball.yvel>0)
          {ball.yvel++;}
          else{
              ball.yvel--;}
          ball.setYDirection(ball.yvel);
          ball.setXDirection(ball.xvel);
        }

        if(ball.intersects(p2))
        {
            ball.xvel=-ball.xvel;
            ball.xvel--;
            if(ball.yvel>0)
            {ball.yvel++;}
            else{
                ball.yvel--;}
            ball.setYDirection(ball.yvel);
            ball.setXDirection(ball.xvel);
        }
        if(p1.y<=0)
        {
            p1.y=0;
        }
        if(p1.y>=Height-paddleheight)
        {
            p1.y=Height-paddleheight;
        }
        if(p2.y<=0)
        {
            p2.y=0;
        }
        if(p2.y>=Height-paddleheight)
        {
            p2.y=Height-paddleheight;
        }
        if(ball.x>=Width-balldia)
        {
            newBall();
            newPaddle();
            score.player1++;
        }
        if(ball.x<=0)
        {
            newBall();
            newPaddle();
            score.player2++;
        }
        if (score.player1 == 10 || score.player2 == 10) {
            endGame();
        }
    }

    private void endGame() {
        String message;
        if (score.player1 == 10) {
            message = "Player 1 wins!";
        } else {
            message = "Player 2 wins!";
        }
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void move() {
        p1.move();
        p2.move();
        ball.move();
    }

    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            p1.KeyPressed(e);
            p2.KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
           // super.keyReleased(e);
            p1.KeyReleased(e);
            p2.KeyReleased(e);
        }
    }
}
