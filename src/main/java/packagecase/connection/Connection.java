package packagecase.connection;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Connection {

    private static int counter = 0;

    private static int id = counter++;

    Connection(){}

    public String toString() {
        return "Connection " + id;
    }

}
