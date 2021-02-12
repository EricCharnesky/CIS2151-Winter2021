
package chapter9.evening;

// this is just an example, not the real card class
public class Card implements Comparable<Card>{
    
    private int face;
    
    public Card(int face)
    {
        this.face = face;
    }

    public int getFace() {
        return face;
    }

    @Override // returns negative value if it's less than other, 0 if it's equal, positive if it's greater than other
    public int compareTo(Card other) {
        return face - other.face;
    }
    
    
    
}
