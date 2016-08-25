package packagecase;

import packagecase.connection.Connection;
import packagecase.connection.ConnectionManager;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Text {

    public static void main(String[] args) {
        Connection c = ConnectionManager.getConnection();
        while (c != null) {
            System.out.println(c);
            c = ConnectionManager.getConnection();
        }
    }
}
