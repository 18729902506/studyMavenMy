package example.serialtest.test3;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author shang
 */
public class CollectionUtilsTest {

    public static void main(String[] args) {
        //判断集合是否为空  true   true
        System.out.println(CollectionUtils.isEmpty(null));
        System.out.println(CollectionUtils.isEmpty(new ArrayList()));

        //判断集合是否不为空 false  false
        System.out.println(CollectionUtils.isNotEmpty(null));
        System.out.println(CollectionUtils.isNotEmpty(new ArrayList()));

        String[] arrayA = new String[]{"A","B","C","H"};
        String[] arrayB = new String[]{"B","D","M","G"};
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //两个集合取并集     A B C D M G H
        System.out.println(ArrayUtils.toString(CollectionUtils.union(listA,listB)).contains("A")+"=======");

        //两个集合取交集   B
        System.out.println(ArrayUtils.toString(CollectionUtils.intersection(listA,listB)));

        //两个集合取交集的补集  A C D M G H
        System.out.println(ArrayUtils.toString(CollectionUtils.disjunction(listA,listB)));

        //两个集合取差集，arrayA扣除arrayB  A-B = A C H     B-A = D M G
        System.out.println(ArrayUtils.toString(CollectionUtils.subtract(listA,listB)));

        System.out.println("str");

        String m = "mn_test,asc";
        System.out.println(m.contains("test")+"+++++");
    }
}
