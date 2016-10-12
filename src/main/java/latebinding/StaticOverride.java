package latebinding;

public class StaticOverride {
    public static void main(String[] args) {
        StaticSup sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.get());

        System.out.println(StaticSub.staticGet());
        System.out.println(StaticSup.staticGet());
    }
}

class StaticSup {

    public static String staticGet(){
        return "sup staticGet";
    }

    public String get(){
        return "sup Get";
    }
}

class StaticSub extends StaticSup{

    public static String staticGet(){
        return "sub staticGet";
    }

    @Override
    public String get() {
        return "sub Get";
    }
}