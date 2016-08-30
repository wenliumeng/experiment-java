package delegation;

/**
 * 代理模式
 * Created by Administrator on 2016/8/30.
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name){
        this.name = name;
    }

    public void up(int velocity){
        controls.up(velocity);
    }

}
