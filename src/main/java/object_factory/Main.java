package object_factory;

public class Main {
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(String.format("IRobot Version: %d", iRobot.getVersion()));
    }
}
