package example.stopWatchTest;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        StopWatchTest.test();
//        StopWatchTest2.test2();

        String expression = "$(1001)";
//        expression = expression.replaceAll("AND", "");
//        System.out.println(expression);
        for (char charTmp : expression.toCharArray()){
            System.out.println(charTmp);
        }

    }
}
