
package project3;

public class HeavyCart extends Cart {
    
    private Item secondItem;
    
    public HeavyCart(Track track, int maxSpeed, int maxAcceleration, int brakeSpeed) {
        super(track, maxSpeed + 2, maxAcceleration - 2, brakeSpeed - 2);
        secondItem = null;
    }
    
    @Override
    public void addItem(Item item){
        if ( this.item == null ){
            this.item = item;
        }
        else if ( secondItem == null ){
            secondItem = item;
        }
    }
    
    @Override
    public void useItem(){
        super.useItem();
        if ( secondItem != null ){
            item = secondItem;
            secondItem = null;
        }
    }
    
}
