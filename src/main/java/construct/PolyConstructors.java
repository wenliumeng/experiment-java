package construct;

/**
 * 构造函数中调用该类的非private方法
 * 在构造器内唯一能够安全调用的方法是final方法（private自动属于final方法）
 * Created by seyMour on 2016/9/10.
 * ☞Keenyoda☜
 */

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        radius = radius;
        System.out.println("RoundGlyph.RoundGlyph() radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlypg.draw(),radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
