package design.builder2;

public class Test {

    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();
        Product product =  worker.getProduct();
        //Product{builderA='汉堡', builderB='可乐', builderC='薯条', builderD='甜点'}
        System.out.println(product.toString());


        //链式编程   在原来的固定的基础上可以自由组合，如果不组合，也有默认的套餐
       Product product2 =  worker.builderA("全家桶").builderB("雪碧").getProduct();
        //Product{builderA='全家桶', builderB='雪碧', builderC='薯条', builderD='甜点'}
        System.out.println(product2.toString());
    }
}
