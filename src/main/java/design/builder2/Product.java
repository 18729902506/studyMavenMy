package design.builder2;

import lombok.Data;

/***
 * 产品：套餐
 */
@Data
public class Product {

    //默认的套餐，
    private String builderA = "汉堡";
    private String builderB = "可乐";
    private String builderC = "薯条";
    private String builderD = "甜点";

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
