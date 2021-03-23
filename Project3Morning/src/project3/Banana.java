
package project3;

public class Banana implements Item {

    @Override
    public void use(Cart cart, Track track) {
        track.dropObstacleAtLocation(cart);
    }
    
}
