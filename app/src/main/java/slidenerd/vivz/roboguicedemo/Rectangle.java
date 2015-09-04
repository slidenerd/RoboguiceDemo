package slidenerd.vivz.roboguicedemo;

/**
 * Created by vivz on 04/09/15.
 */
public class Rectangle implements Shape {
    float length;
    float breadth;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBreadth() {
        return breadth;
    }

    public void setBreadth(float breadth) {
        this.breadth = breadth;
    }

    @Override
    public float getArea() {
        return length * breadth;
    }
}
