
package project3;


public class NPCFactory {
    
    public Motorcycle getMotorcycle(Track track){
        Motorcycle motorcycle = new Motorcycle(track, 10, 3, 6);
        return motorcycle;
    }
    
    public LightCart getLightCart(Track track){
        LightCart lightCart = new LightCart(track, 10, 3, 6);
        return lightCart;
    }
    
    public LightCart getFasterLightCart(Track track){
        LightCart lightCart = new LightCart(track, 12, 3, 6);
        return lightCart;
    }
}
