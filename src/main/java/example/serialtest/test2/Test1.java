package example.serialtest.test2;

public class Test1 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0;i<10;i++){
            count = count++;
        }
        //count = 0;
        System.out.println("count="+count);
    }
}
