import java.awt.*;

public class Score extends Rectangle {
    int width;
    int height;
    int player1;
    int player2;
    Score(int width, int height){
        this.height=height;
        this.width=width;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.BOLD,50));
        g.drawString(String.valueOf(player1), width/2-60,80);
        g.drawString(String.valueOf(player2),width/2+60,80);
    }

}
