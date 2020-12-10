package example.serialtest.test3;

import lombok.Data;

@Data
public class Entity {

    private String customerName;
    private String username;
    private Integer testing;
    private String enableStatus;
    private String createDate;
    private String gmtModified;

    public Entity(String customerName, String username) {
        this.customerName = customerName;
        this.username = username;
        this.testing = testing;
        this.enableStatus = enableStatus;
        this.createDate = createDate;
        this.gmtModified = gmtModified;
    }
}
