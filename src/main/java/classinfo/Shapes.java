package classinfo;

import java.util.Arrays;
import java.util.List;

/**
 * RTTI
 * Created by seyMour on 2016/11/18.
 * ☞seyMour☜
 */

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        shapes.forEach(Shape::draw);
    }
}
