package slidenerd.vivz.roboguicedemo;

import com.google.inject.Singleton;

/**
 * Created by vivz on 03/09/15.
 */
@Singleton
public class Square implements Shape {
    float size;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public float getArea() {
        return size * size;
    }
}
