import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {
    int xvel;
    int yvel;
    int initialspeed = 5;
    Random random;

    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
        int RandomXdirection = random.nextInt(2);
        if (RandomXdirection == 0) {
            RandomXdirection--;
        }
        setXDirection(RandomXdirection);
        int RandomYDirection = random.nextInt(2);
        if (RandomYDirection==0) {
            RandomYDirection--;
        }
        setYDirection(RandomYDirection);

    }

    public void setYDirection(int randomYDirection) {
        yvel = randomYDirection;
    }

    public void move() {
        x += xvel;
        y += yvel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, width, height);

        g.setColor(Color.white);
        g.drawLine(1000 / 2, 0, 1000 / 2, 555);
    }


    public void setXDirection(int randomXdirection) {
        xvel = randomXdirection;
    }
}

