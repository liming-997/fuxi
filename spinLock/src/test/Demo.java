package test;

public class Demo {
    public int add(int a, int b) {
        try {
            return a + b;
        }catch(Exception e){
            System.out.println("catch 语句");
        }finally {
            System.out.println("finally 语句");
        }
        return 0;
    }

    public static void main(String[] args) {
         Demo demo = new Demo();
        System.out.println("和是：" + demo.add(9,34));
    }

}
