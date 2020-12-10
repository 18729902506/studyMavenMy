package design.builder;

/***
 * 指挥：核心，负责指挥构建工程，工程如何构建，由它决定    指挥就是客户自己
 * 用于指导具体构建者如何构建产品，控制调用先后次序，并向调用者返回完整的产品类，有时需要简化，可以把Director和抽象建造者进行结合
 * 通过静态内部类方式实现零件无序装配构造，更灵活，使用时可以根据用户需求自由定义更改内容，并且无需改变具体的构造方式
 * 点餐，服务员搭配任意几种食物，售给客户，把指挥者交给用户来操作
 */
public class Director {

    /***
     * 指挥工人按照顺序建房子（核心的构建顺序可以任意呦指挥者控制）
     * @param builder
     * @return
     */
    public Product build(Builder builder){
        builder.builderA();
        builder.builderB();
        builder.builderC();
        builder.builderD();

        return builder.getProduct();
    }
}
