package example.serialtest.classtest.staticclasstest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * 静态内部类的测试
 * @author shang
 */
@Data
@ApiModel
public class Person {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "家庭")
    private Home home;

    public Person(String name) {
        this.name = name;
    }

    public static class Home{
        @ApiModelProperty(value = "家庭住址")
        private String address;
        @ApiModelProperty(value = "电话")
        private String tel;

        public Home(String address, String tel) {
            this.address = address;
            this.tel = tel;
        }
    }

    public static void main(String[] args) {
        //定义张三这个人
        Person p = new Person("张三");
        //设置张三的家庭信息
        p.setHome(new Person.Home("上海","012"));
    }
}
