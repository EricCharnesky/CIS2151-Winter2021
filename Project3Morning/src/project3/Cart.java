package project3;

public abstract class Cart {

    protected Item item;
    protected int maxSpeed;
    protected int currentSpeed;
    protected int brakeSpeed;
    protected int maxAcceleration;
    protected Track track;
    protected boolean lostTurn;
    protected int currentPositionOnTrack;

    public Cart(Track track, int maxSpeed, int maxAcceleration, int brakeSpeed) {
        this.track = track;
        this.maxSpeed = maxSpeed;
        this.maxAcceleration = maxAcceleration;
        this.brakeSpeed = brakeSpeed;
        item = null;
        currentSpeed = 0;
        lostTurn = false;
        currentPositionOnTrack = 0;
    }
    
    public void moveCurrentSpeedAlongTrack(){
        currentPositionOnTrack += currentSpeed;
        if ( currentSpeed > maxSpeed ){
            currentSpeed = maxSpeed;
        }
    }
    
    public void addItem(Item item){
        if ( this.item == null ){
            this.item = item;
        }
    }
    
    public void spinOut(int position){
        currentSpeed = 0;
        currentPositionOnTrack = position;
    }

    public void accelerate(int accelerationAmount) {
        if (accelerationAmount > maxAcceleration) {
            accelerationAmount = maxAcceleration;
        }

        currentSpeed += accelerationAmount;

        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    public void brake(int brakeAmount) {

        // brakeAmount = brakeAmount > brakeSpeed ? brakeSpeed : brakeAmount;
        if (brakeAmount > brakeSpeed) {
            brakeAmount = brakeSpeed;
        }

        currentSpeed -= brakeAmount;

        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void useItem() {
        if (item != null) {
            item.use(this, track);
            item = null;
        }
    }

    public void enterBend(Bend bend) {
        if ( currentSpeed > bend.getMaxSpeed() ){
            spinOut(bend.getPositionOnTrack());
        }
    }

    public Item getItem() {
        return item;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getBrakeSpeed() {
        return brakeSpeed;
    }

    public int getMaxAcceleration() {
        return maxAcceleration;
    }

    public Track getTrack() {
        return track;
    }

    public boolean isLostTurn() {
        return lostTurn;
    }

    public void setLostTurn(boolean lostTurn) {
        this.lostTurn = lostTurn;
    }

    public int getCurrentPositionOnTrack() {
        return currentPositionOnTrack;
    }

    void speedBoost(int speedToGoAboveMax) {
        currentSpeed = maxSpeed + speedToGoAboveMax;
    }
    
}
