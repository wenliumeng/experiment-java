package classinfo.nullobject;

import java.lang.reflect.Proxy;

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] robots = {
                new SnowRemovalRobot("SnowBe"),
                newNullRobot(SnowRemovalRobot.class)
        };
        for (Robot r : robots) {
            Robot.Test.test(r);
        }
    }
}
