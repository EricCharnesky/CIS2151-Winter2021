
package project3;


public class Shell implements Item {

    private int positionOnTrack;

    public Shell(int positionOnTrack) {
        this.positionOnTrack = positionOnTrack;
    }
    
    @Override
    public int getPositionOnTrack() {
        return positionOnTrack;
    }

    @Override
    public void use(Cart cart, Track track) {
        track.shootItem(cart.getCurrentPositionOnTrack());
    }
    
}
