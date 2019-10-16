public class BouncingSprite extends Sprite
{
    public void clocktick()
    {
        super.clocktick();
        
        if (this.getY() < 0 && this.getDY() < 0)
        {
            this.setMotion(this.getDX(), - this.getDY());
        }
        else
        if ((this.getY() + this.getHeight()) > 600 && this.getDY() > 0)
        {
            this.setMotion(this.getDX(), - this.getDY());
        }     
    }
}