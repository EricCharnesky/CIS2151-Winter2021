package project3;

public class HeavyCart extends Cart {

    Item secondItem;

    public HeavyCart(Track track, int maxSpeed, int acceleration, int breakSpeed) {
        super(track, maxSpeed + 2, acceleration - 2, breakSpeed - 2);
        secondItem = null;
    }

    @Override
    public void addItem(Item item) {
        if (this.item == null) {
            this.item = item;
        } else if (secondItem == null) {
            secondItem = item;
        }
    }
    
    @Override
    public void useItem()
    {
        if ( item != null ){
            item.use(this, track);
            item = secondItem;
            secondItem = null;
        }
    }
}
