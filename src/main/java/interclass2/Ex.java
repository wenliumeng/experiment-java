package interclass2;

public class Ex extends Base {
    interface1 getInter(){
        //内部类与向上转型
        return this.new Inter();
    }

    public static void main(String[] args) {
        Ex ex = new Ex();
        System.out.println(ex.getInter().say());
    }
}
