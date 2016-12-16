package generic;

import java.util.Random;

public class g {

    public static Generator<String> generator = new Generator<String>() {
        @Override
        public String next() {
            Random random = new Random(47);
            return random.nextInt() + "";
        }
    };
}
