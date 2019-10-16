import java.awt.*;
import java.awt.event.*;

public class GameOverState extends AbstractGameState
{
    public GameOverState(GameView view)
    {
        super(view);
    }
    
    public void drawOn(Graphics g)
    {
        Rectangle bounds = this.getView().getBounds();
        g.setColor(Color.RED);
        g.fillRect(0, 0, bounds.width, bounds.height);
        g.setColor(Color.BLACK);
        Font font = new Font("Sans-Serif", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("Game Over! Press SPACE to EXIT", 50, 250);
    }
            
    public void handleKeyPressed(int keyCode)
    {
        if (keyCode == KeyEvent.VK_SPACE)
        {
           System.exit(0);
        }
    }
}