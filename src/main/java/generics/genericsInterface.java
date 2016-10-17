package generics;

interface Gen<T>{
    T next();
}

/**
 * 泛型接口
 */
public class genericsInterface implements Gen<String>{
    @Override
    public String next() {
        return null;
    }
}

class genImpl implements Gen<Integer> {
    @Override
    public Integer next() {
        return null;
    }
}