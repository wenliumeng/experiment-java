package access.connection;

/**
 * Created by Administrator on 2016/8/25.
 */
public class ConnectionManager {

    private static Connection[] connections = new Connection[5];

    private static int count = 0;

    static {
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new Connection();
        }
    }

    public static Connection getConnection(){
        if(count < connections.length){
            return connections[count++];
        }
        return null;
    }
}
