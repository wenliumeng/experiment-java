package mapkeyvalue;

/**
 * 对象作为map的key，覆盖hashcode()也不能确定key的唯一性，必须复写equal
 * Created by seymour on 2017/4/23.
 */
public class Object1 {

    int id;

    public Object1(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Object1 object1 = (Object1) o;

        return id == object1.id;

    }
}
