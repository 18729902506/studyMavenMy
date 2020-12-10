package design.builder2;

/***
 * 建造者，建造具体的产品
 */
public abstract class Builder {

    //只是建造的时候，存在一些默认值
    abstract Builder builderA(String msg);//汉堡
    abstract Builder builderB(String msg);//可乐
    abstract Builder builderC(String msg);//薯条
    abstract Builder builderD(String msg);//甜点

    //完工：得到产品
    abstract Product getProduct();
}
