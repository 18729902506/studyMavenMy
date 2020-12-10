package example.springtest.springaoptest2;

import lombok.Data;

@Data
public class User {

    private String productPriceModify;

    public User(String productPriceModify) {
        this.productPriceModify = productPriceModify;
    }
}
