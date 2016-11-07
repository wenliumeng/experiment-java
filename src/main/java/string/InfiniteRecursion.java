package string;

public class InfiniteRecursion {

    @Override
    public String toString() {
        //循环递归,应该调用Object的toString方法
//        return "InfiniteRecursion" + this;
        return super.toString();
    }

    public static void main(String[] args) {
        InfiniteRecursion i = new InfiniteRecursion();
        System.out.println(i);
    }

}
