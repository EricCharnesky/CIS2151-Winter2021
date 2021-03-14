
package midtermreview;

import java.util.ArrayList;

public class MidtermReview {

    
    public static void main(String[] args) {
        String message = "This is the midterm review";
        String badlyEncryptedMessage = badEncryptionEveningEdition(message);
        System.out.println(badlyEncryptedMessage);
        //System.out.println(undoBadEncryption(badlyEncryptedMessage));
        
        
        ArrayList<Beverage> beverages = new ArrayList<Beverage>();
        beverages.add( new Cup("coffee cup", 12));
        beverages.add( new Mug("coffee mug", 12, "black"));
        
        for ( Beverage beverage : beverages )
        {
            beverage.fill();
            System.out.println(beverage.drink(5));
        }
    }
    
    public static String badEncryption(String message)
    {
        char[] letters = message.toCharArray();
        for ( int index = 0; index < letters.length; index++)
        {
            if ( !Character.isWhitespace(letters[index]) )
            {
                letters[index] += index;
            }
        }
        return new String(letters);
    }
    
    public static String undoBadEncryption(String message)
    {
        char[] letters = message.toCharArray();
        for ( int index = 0; index < letters.length; index++)
        {
            if ( !Character.isWhitespace(letters[index]) )
            {
                letters[index] -= index;
            }
        }
        return new String(letters);
    }
    
    
    public static String badEncryptionEveningEdition(String message)
    {
        char[] letters = message.toCharArray();
        
        for ( int index = 0; index < letters.length; index++)
        {
            if ( !Character.isWhitespace(letters[index]) )
            {
                letters[index] += index;
            }
        }
        
        return new String(letters);
    }
    
   
}
