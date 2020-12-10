package design.builder;

/***
 * 抽象的建造者，不负责建房子，只是定义一些方法，造房子的过程
 * 通过四个步骤，可以获得一个产品
 */
public abstract class Builder {

    abstract void builderA();//地基
    abstract void builderB();//钢筋工程
    abstract void builderC();//铺电线
    abstract void builderD();//粉刷

    //完工：得到产品
    abstract Product getProduct();
}
