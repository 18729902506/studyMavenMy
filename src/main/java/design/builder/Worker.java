package design.builder;

/***
 * 具体的建造者：工人
 */
public class Worker extends Builder {

    Product product;

    /***
     * 工人建房子，所以new一个Product
     */
    public Worker() {
        product = new Product();
    }

    @Override
    void builderA() {
        product.setBuilderA("地基");
        System.out.println("地基");
    }

    @Override
    void builderB() {
        product.setBuilderB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void builderC() {
        product.setBuilderC("铺电线");
        System.out.println("铺电线");
    }

    @Override
    void builderD() {
        product.setBuilderD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
