package design.builder;

import lombok.Data;

/***
 * 产品：房子
 * 为了测试输出，可以重写toString()方法
 */
@Data
public class Product {

    private String builderA;
    private String builderB;
    private String builderC;
    private String builderD;

    @Override
    public String toString() {
        return "Product{" +
                "builderA='" + builderA + '\'' +
                ", builderB='" + builderB + '\'' +
                ", builderC='" + builderC + '\'' +
                ", builderD='" + builderD + '\'' +
                '}';
    }
}
