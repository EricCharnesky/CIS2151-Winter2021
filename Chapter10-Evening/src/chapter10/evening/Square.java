package chapter10.evening;

public class Square extends Rectangle {

    public Square(int length) {
        super(); // it will be called implicity even if we don't explicity call it

        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setSideLength(int index, int length) {
        super.setLength(length);
        super.setWidth(length);
    }
    
    @Override
    public void setWidth(int width)
    {
        super.setLength(width);
        super.setWidth(width);
    }
    
    @Override
    public void setLength(int length)
    {
        super.setLength(length);
        super.setWidth(length);
    }
    
}
