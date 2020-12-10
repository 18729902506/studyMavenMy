package design.builder2;

/***
 * 具体的建造者：
 */
public class Worker extends Builder {

    Product product;

    /***
     * 服务员建产品，所以new一个Product
     */
    public Worker() {
        product = new Product();
    }

    /***
     * 返回当前的产品
     * @param msg
     * @return
     */
    @Override
    Builder builderA(String msg) {
        product.setBuilderA(msg);
        return this;
    }

    @Override
    Builder builderB(String msg) {
        product.setBuilderB(msg);
        return this;
    }

    @Override
    Builder builderC(String msg) {
        product.setBuilderC(msg);
        return this;
    }

    @Override
    Builder builderD(String msg) {
        product.setBuilderD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
