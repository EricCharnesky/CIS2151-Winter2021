
package project3;

public class Mushroom implements Item{

    private int positionOnTrack;

    public Mushroom(int positionOnTrack) {
        this.positionOnTrack = positionOnTrack;
    }
    
    @Override
    public int getPositionOnTrack() {
        return positionOnTrack;
    }

    @Override
    public void use(Cart cart, Track track) {
        cart.speedBoost(10);
    }
    
}
