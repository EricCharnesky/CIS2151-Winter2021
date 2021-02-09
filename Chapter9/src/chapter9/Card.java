
package chapter9;


public class Card implements Comparable<Card>{
    
    private int face;

    public Card( int face )
    {
        this.face = face;
    }
    
        public int getFace() {
        return face;
    }

    // returns negative if less than, 0 if equal, positive if great
    @Override
    public int compareTo(Card o) {
        return face - o.face;
    }
    
    
}
