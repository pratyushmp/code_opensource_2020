import java.awt.*;

public class Sprite
{
    private Image image;
    private Rectangle rect;
    private Point motion;
    
    public Sprite()
    {
        this.image = null;
        this.rect = new Rectangle(0, 0, 0, 0);
        this.motion = new Point(0, 0);
    }
    
    public void setImage(Image image)
    {
        this.image = image;
        this.rect.width = image.getWidth(null); 
        this.rect.height = image.getHeight(null);
    }
    
    public void setPosition(int x, int y)
    {
        this.rect.x = x;
        this.rect.y = y;
    }
    
    public Rectangle getRect()
    {
        return this.rect;
    }

    public int getX()
    {
        return this.rect.x;
    }
    
    public int getY()
    {
        return this.rect.y;
    }

    public int getWidth()
    {
        return this.rect.width;
    }
    
    public int getHeight()
    {
        return this.rect.height;
    }
    
    public void setMotion(int dx, int dy)
    {
        this.motion.x = dx;
        this.motion.y = dy;
    }

    public int getDX()
    {
        return this.motion.x;
    }
    
    public int getDY()
    {
        return this.motion.y;
    }
    
    public void drawOn(Graphics g)
    {
        g.drawImage(this.image, this.rect.x, this.rect.y, null);
    }
    
    public void clocktick()
    {
        this.rect.x += this.motion.x;
        this.rect.y += this.motion.y;
    }
}