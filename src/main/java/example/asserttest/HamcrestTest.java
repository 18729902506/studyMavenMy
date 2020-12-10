package example.asserttest;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.IsNaN.notANumber;

/***
 * @author shang
 * @date 2020-09-10
 *  使用Hamcrest匹配器进行测试，需要添加Hamcrest的依赖，使用assertThat()方法进行匹配，它是需要静态导入的
 *  已测试为目的，能组合成灵活表达式的匹配器类库
 * @see <a href = "https://blog.csdn.net/neven7/article/details/42489723">匹配器常用方法总结</a>
 */
public class HamcrestTest {

    @Test
    public void testAssert(){
        assertThat(Math.sqrt(-1), is(notANumber()));
        //allOf()，所有条件都满足，相当于&&
        assertThat("myName", allOf(startsWith("my"), containsString("Name")));
        //anyOf()，只满足一个就可以，相当于||
        assertThat("myName", anyOf(startsWith("my"), containsString("name")));
    }


}
