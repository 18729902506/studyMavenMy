package example.serialtest.test1;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Person implements Serializable {

    private String name;
}
