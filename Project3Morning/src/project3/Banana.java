
package project3;

public class Banana implements Item {

    private int positionOnTrack;

    public Banana(int positionOnTrack) {
        this.positionOnTrack = positionOnTrack;
    }
    
    @Override
    public void use(Cart cart, Track track) {
        track.dropObstacleAtLocation(cart.getCurrentPositionOnTrack());
    }

    @Override
    public int getPositionOnTrack() {
        return positionOnTrack;
    }
    
}
