package com.threadtest.demo.sss;

/***
 * 推导lambda表达式
 */
public class LambdaTest {

    /***
     * 2、静态内部类
     */
    static class LikeImpl2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("I Like Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new LikeImpl();
        like.lambda();

        like = new LikeImpl2();
        like.lambda();


        /**
         * 3、局部内部类
         */
        class LikeImpl3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I Like Lambda3");
            }
        }
        like = new LikeImpl3();
        like.lambda();

        /***
         * 4、匿名内部类，没有类的名称，必须借助接口或者父类
         */
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like.lambda();

        /***
         * 匿名内部类推导过去就是lambda表达式
         * 类，接口都不要了，其次方法也不用要，方法的参数要
         * 5、用lambda表达式简化
         * 接口只有一个类，只有一个方法，所以类和方法都可以不用，只留方法后面的东西
         */
        like = ()->{
            System.out.println("I Like Lambda5");
        };
        like.lambda();
    }
}

/***
 * 0、定义一个函数式接口
 * 如果只包含唯一一个抽象方法，那么它就是一个函数式接口
 * 对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
 */
interface ILike {
    void lambda();
}

/***
 * 1、实现类
 */
class LikeImpl implements ILike {

    @Override
    public void lambda() {
        System.out.println("I Like Lambda");
    }
}