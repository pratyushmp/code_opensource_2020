import java.awt.*;
import javax.swing.*;

public class PlayState extends AbstractGameState
{
    private Sprite player;
    private Sprite baddie;
    
    public PlayState(GameView view)
    {
        super(view);
        
        Image image;
        
        image = new ImageIcon("/images/player.png").getImage();
        this.player = new Sprite();
        this.player.setImage(image);
        this.player.setPosition(400, 200);
        
        image = new ImageIcon("/images/baddie.png").getImage();
        this.baddie = new BouncingSprite();
        this.baddie.setImage(image);
        this.baddie.setPosition(200, 300);
        this.baddie.setMotion(0, 10);

        this.getView().startClock(50);
    }
    
    public void drawOn(Graphics g)
    {
        Rectangle bounds = this.getView().getBounds();
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, bounds.width, bounds.height);
        
        this.player.drawOn(g);
        this.baddie.drawOn(g);
    }
    
    public void clocktick()
    {
        this.baddie.clocktick();
        
        if (this.baddie.getRect().intersects(this.player.getRect()))
        {
            this.getView().setState(new GameOverState(this.getView()));
        }
    }
    
    public void handleMouseMoved(int mouseX, int mouseY)
    {
        this.player.setPosition(mouseX, this.player.getY());
    }