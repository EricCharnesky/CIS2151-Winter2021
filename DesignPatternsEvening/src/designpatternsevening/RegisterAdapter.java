
package designpatternsevening;

public class RegisterAdapter {
    private Register register;

    public RegisterAdapter(Register register) {
        this.register = register;
    }
    
    public void addItemTransaction(Item item){
        register.enterTransaction(item.getTotalPrice());
    }
    
}
