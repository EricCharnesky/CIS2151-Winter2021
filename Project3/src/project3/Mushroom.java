
package project3;


public class Mushroom implements Item {

    private int position;

    public Mushroom(int position) {
        this.position = position;
    }
    
    @Override
    public void use(Cart cart, Track track) {
        cart.speedBusrt();
    }

    @Override
    public int getPositionOnTrack() {
        return position;
    }
    
}
