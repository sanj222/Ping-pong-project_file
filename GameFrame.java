import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    GameFrame()
    {
        setTitle("Ping Pong Game");
        getContentPane().setBackground(Color.black); //setting bg color
        GamePanel panel=new GamePanel(); //creating new game panel
        add(panel); //adding the panel to the frame
        pack(); //used when we are having a panel to have same size of the frame as panel
        setResizable(false); //doesnt allow to change the size of frame
        setVisible(true);
        // This method call sets the visibility of the JFrame window to true, making it visible on the screen.
        setLocationRelativeTo(null);
        //This method call positions the JFrame window relative to a specified component or screen position.herein centre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //The argument JFrame.EXIT_ON_CLOSE specifies that when the user closes the JFrame window,
        // the program should terminate and exit.
    }
    public static void main(String[] args){
        GameFrame obj=new GameFrame(); //creating new frame

    }


}
