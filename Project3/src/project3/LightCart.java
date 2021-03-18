package project3;

public class LightCart extends Cart {

    public LightCart(Track track, int maxSpeed, int acceleration, int breakSpeed) {
        super(track, maxSpeed - 2, acceleration + 2, breakSpeed + 2);
    }

    @Override
    public void enterBend(Bend bend) {
        if ( currentSpeed > bend.getMaxSpeed() )
        {
            breaking(currentSpeed - bend.getMaxSpeed());
        }
        super.enterBend(bend);
    }

}
