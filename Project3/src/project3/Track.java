package project3;

import java.util.ArrayList;

public class Track {

    private ArrayList<Cart> carts;  // added a position attribute to Cart
    // private ArrayList<Integer> cartPositions;

    private ArrayList<Bend> bends;

    private ArrayList<Item> itemsToPickup; // or add a position attribute to item classes

    private ArrayList<Integer> obstacleOnTrack;
    private final int endPosition;

    public Track(int endPosition, ArrayList<Cart> carts, ArrayList<Bend> bends, ArrayList<Item> itemsToPickup) {
        this.endPosition = endPosition;
        
        this.carts = carts; // this is bad form - I didn't ask for copy constructor, so, meh?
        this.bends = bends;
        this.itemsToPickup = itemsToPickup;

        obstacleOnTrack = new ArrayList<Integer>();
    }
    
    public boolean isRaceOver()
    {
        for ( Cart cart : carts )
        {
            if ( cart.getPositionOnTrack() >= endPosition )
                return true;
        }
        return false;
    }

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public ArrayList<Bend> getBends() {
        return bends;
    }

    public ArrayList<Item> getItemsToPickup() {
        return itemsToPickup;
    }

    public ArrayList<Integer> getObstacleOnTrack() {
        return obstacleOnTrack;
    }

    public Bend getNextBend(Cart cart) {
        Bend closestBend = null;
        for (Bend bend : bends) {
            if (bend.getPositionOnTrack() > cart.getPositionOnTrack()) {
                if (closestBend == null) {
                    closestBend = bend;
                } else {
                    if (closestBend.getPositionOnTrack() > bend.getPositionOnTrack()) {
                        closestBend = bend;
                    }
                }
            }
        }
        return closestBend;
    }

    public void moveEachCart() {
        for (Cart cart : carts) {
            int currentPosition = cart.getPositionOnTrack();
            cart.move();
            int movedPosition = cart.getPositionOnTrack();

            for (Bend bend : bends) {
                if (currentPosition <= bend.getPositionOnTrack()
                        && movedPosition > bend.getPositionOnTrack()) {
                    cart.enterBend(bend);
                }
            }

            // in case they spun out in the bend
            movedPosition = cart.getPositionOnTrack();

            for (Integer obstacle : obstacleOnTrack) {
                if (currentPosition <= obstacle && movedPosition > obstacle) {
                    cart.spinOut(obstacle);

                    // remove the banana
                    obstacleOnTrack.remove(obstacle);

                    // only allowed to hit 1 banana
                    break;
                }
            }
        }
    }

    public void dropObstacleAtLocation(Cart cart) {
        obstacleOnTrack.add(cart.getPositionOnTrack());
    }

    void shootShell(Cart cart) {
        int currentPosition = cart.getPositionOnTrack();

        Cart nearestAheadCart = null;

        for (Cart otherCart : carts) {
            if (cart.getPositionOnTrack() > currentPosition) {
                if (nearestAheadCart == null) {
                    nearestAheadCart = cart;
                } else {
                    if (nearestAheadCart.getPositionOnTrack() > cart.getPositionOnTrack()) {
                        nearestAheadCart = cart;
                    }
                }
            }
        }

        if (nearestAheadCart != null) {
            nearestAheadCart.spinOut(nearestAheadCart.getPositionOnTrack());
        }
    }
}
