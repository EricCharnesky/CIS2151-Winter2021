
package project3;

public class Banana implements Item {

    private int position;

    public Banana(int position) {
        this.position = position;
    }

    @Override
    public void use(Cart cart, Track track) {
        track.dropObstacleAtLocation(cart);
    }
    
    @Override
    public int getPositionOnTrack() {
        return position;
    }
    
}
