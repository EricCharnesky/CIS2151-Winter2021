package project3;

public abstract class Cart {

    protected int maxSpeed;
    protected int maxAcceleration;
    protected int maxBreakSpeed;
    protected int positionOnTrack;
    protected int currentSpeed;
    protected Item item;
    protected Track track;
    protected boolean lostTurn;

    public Cart(Track track, int maxSpeed, int acceleration, int breakSpeed) {
        this.track = track;
        this.maxSpeed = maxSpeed;
        this.maxAcceleration = acceleration;
        this.maxBreakSpeed = breakSpeed;

        currentSpeed = 0;
        positionOnTrack = 0;
        item = null;
        lostTurn = false;
    }

    public void move() {
        positionOnTrack += currentSpeed;
        if ( currentSpeed > maxSpeed)
        {
            currentSpeed = maxSpeed;
        }
    }

    public void setLostTurn(boolean lostTurn) {
        this.lostTurn = lostTurn;
    }

    public Track getTrack() {
        return track;
    }

    public boolean isLostTurn() {
        return lostTurn;
    }

    public void useItem() {
        if (item != null) {
            item.use(this, track);
            item = null;
        }
    }

    public void addItem(Item item) {
        if (this.item == null) {
            this.item = item;
        }
    }

    public Item getItem() {
        return item;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxAcceleration() {
        return maxAcceleration;
    }

    public int getMaxBreakSpeed() {
        return maxBreakSpeed;
    }

    public int getPositionOnTrack() {
        return positionOnTrack;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void enterBend(Bend bend) {
        if (currentSpeed > bend.getMaxSpeed()) {
            spinOut(bend.getPositionOnTrack());
        }
    }

    public void accelerate(int acceleration) {
        if (acceleration > maxAcceleration) {
            acceleration = maxAcceleration;
        }
        currentSpeed += acceleration;

        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    public void breaking(int breakingAmount) {
        if (breakingAmount > maxBreakSpeed) {
            breakingAmount = maxBreakSpeed;
        }

        currentSpeed -= breakingAmount;

        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void spinOut(int positionSpunOut) {
        currentSpeed = 0;
        positionOnTrack = positionSpunOut;
    }

    void speedBusrt() {
        currentSpeed = maxSpeed + 5;
    }
}
