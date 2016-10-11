package interclass2;

public class Base {

    protected class Inter implements interface1{

        public Inter() {}

        @Override
        public String say() {
            return "Hi";
        }
    }
}
