
package project3;


public class Shell implements Item {

    private int position;

    public Shell(int position) {
        this.position = position;
    }
    
    @Override
    public void use(Cart cart, Track track) {
        track.shootShell(cart);
    }
    
    @Override
    public int getPositionOnTrack() {
        return position;
    }
    
}
