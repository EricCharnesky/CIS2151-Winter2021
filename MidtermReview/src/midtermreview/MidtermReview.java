
package midtermreview;

public class MidtermReview {

    
    public static void main(String[] args) {
        String message = "This is the midterm review";
        String badlyEncryptedMessage = badEncryptionEveningEdition(message);
        System.out.println(badlyEncryptedMessage);
        //System.out.println(undoBadEncryption(badlyEncryptedMessage));
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
