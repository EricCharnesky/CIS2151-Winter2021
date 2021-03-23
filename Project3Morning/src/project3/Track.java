package project3;

import java.util.ArrayList;

public class Track {

    private ArrayList<Cart> carts;

    private ArrayList<Bend> bends;

    private ArrayList<Item> itemsToPickup;
    
    private ArrayList<Integer> obstaclesOnTrack;

    private int totalLength;

    public Track(ArrayList<Cart> carts, ArrayList<Bend> bends,
            ArrayList<Item> itemsToPickup, int totalLength) {
        // this is bad - should copy items
        this.carts = carts;
        this.bends = bends;
        this.itemsToPickup = itemsToPickup;
        this.totalLength = totalLength;
        obstaclesOnTrack = new ArrayList<Integer>();
    }
    
    public void moveEachCart() {
        for ( Cart cart : carts){
            int startLocation = cart.getCurrentPositionOnTrack();
            cart.moveCurrentSpeedAlongTrack();
            int endingLocation = cart.getCurrentPositionOnTrack();
            
            // this is the easy way, but not 100% correct
            for ( int obstaclePosition : obstaclesOnTrack ){
                if ( startLocation < obstaclePosition && 
                        endingLocation >= obstaclePosition )
                {
                    cart.spinOut(obstaclePosition);
                    // be careful modifying arraylists as you iterate over them
                    obstaclesOnTrack.remove(obstaclePosition);
                    break;
                }
            }
            
            endingLocation = cart.getCurrentPositionOnTrack();
            
            for ( Bend bend : bends ){
                if ( startLocation < bend.getPositionOnTrack() && 
                        endingLocation >= bend.getPositionOnTrack())
                {
                    cart.enterBend(bend);
                }
            }
            
            // might have spun out, check where we stopped
            endingLocation = cart.getCurrentPositionOnTrack();
            
            for ( Item item : itemsToPickup )
            {
                if ( startLocation < item.getPositionOnTrack() && 
                        endingLocation >= item.getPositionOnTrack())
                {
                    cart.addItem(item);
                }
            }
        }
    }

    public void dropObstacleAtLocation(int position) {
        obstaclesOnTrack.add(position);
    }

    void shootItem(int currentPositionOnTrack) {
        Cart nearestCart = null;
        for ( Cart cart : carts ){
            if ( cart.getCurrentPositionOnTrack() > currentPositionOnTrack ){
                if ( nearestCart == null ){
                    nearestCart = cart;
                }
                else if ( cart.getCurrentPositionOnTrack() < nearestCart.getCurrentPositionOnTrack() ){
                    nearestCart = cart;
                }
            }
        }
        
        if ( nearestCart != null ){
            nearestCart.spinOut(nearestCart.getCurrentPositionOnTrack());
        }
    }
}
