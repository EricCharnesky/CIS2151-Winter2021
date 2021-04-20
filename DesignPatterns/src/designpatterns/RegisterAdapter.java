
package designpatterns;


public class RegisterAdapter {
    
    private Register register;
    
    public RegisterAdapter(Register register){
        this.register = register;
    }
    
    public void chargeForRentableItem(RentableItem rentableItem){
        register.addTransation(rentableItem.getRent());
    }
    
    public void chargeForTaxableItem(TaxableItem taxableItem){
        register.addTransation(taxableItem.getTotalCost());
    }
}
