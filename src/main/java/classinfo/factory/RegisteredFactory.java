package classinfo.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 工厂模式 泛型
 * Created by seyMour on 2016/11/23.
 * ☞seyMour☜
 */

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    //Factory
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    //new FuelFilter
    static List<Part> partFactories1 = new ArrayList<>();

    static {
        FuelFilter fuelFilter = new FuelFilter();
        partFactories1.add(fuelFilter);
        partFactories1.add(new AirFilter.Factory().create());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());


    }

    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part{}

class FuelFilter extends Filter {
    public static class Factory implements classinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements classinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements classinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements classinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

public class RegisteredFactory {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
