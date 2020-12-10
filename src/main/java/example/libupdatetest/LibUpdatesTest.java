package example.libupdatetest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


/***
 * @author shang
 * @date 2020-09-11
 */
public class LibUpdatesTest {

    /***
     * map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
     * 错误认知：getOrDefault()方法会在get到的结果为null时返回默认值
     * 正解：如果为空，还是会返回null，而不是默认值
     */
    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>(5);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", null);
        map.forEach((k, v) -> System.out.println(k + "," + v));
        String v1 = map.getOrDefault("1", "");
        String v3 = map.getOrDefault("3", "100");
        String v4 = map.getOrDefault("4", "");
        Assert.assertEquals(v1, "a");
        Assert.assertNull(v3);
        Assert.assertEquals(v4, "");
    }

    /***
     * Iterable new method : forEach
     * 打印出a  b  c
     */
    @Test
    public void testIterable() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(System.out::println);
    }

    /***
     * Collection new methods :removeIf,stream,parallelStream
     */
    @Test
    public void testList() {
        //Arrays.asList("a","b","c")生成的是Arrays$ArrayList 没有实现remove()方法，调用removeIf()会报异常
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeIf("a"::equalsIgnoreCase);
        assertThat(list, contains("b", "c"));

        list.replaceAll(x -> x + "1");
        assertThat(list, contains("b1", "c1"));
    }

    /**
     * String new method : join
     */
    @Test
    public void testString() {
        //可变参数
        String str = String.join("", "a", "b", "c");
        Assert.assertEquals(str, "abc");
        String str2 = String.join(",","a","b","c");
        Assert.assertEquals(str2,"a,b,c");
    }

}
