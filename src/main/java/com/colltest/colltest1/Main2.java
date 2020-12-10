package com.colltest.colltest1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***
 * @author shang
 * @date 2019/09/07
 */
public class Main2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6,2,8,1,9);
        //[6,2,8,1,9]
//        System.out.println(numbers);
        //[1,2,6,8,9]
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);

        /***
         * 如果输出的对象想以字符串的形式呈现出来，实体类就必须重写toString()方法
         * 如果在实体类中不重写toString()方法，那么输出的就是对象的地址，即使调用了  toString()方法，因为这块调用的toString()方法是Object对象中的方法
         * Movie{title='Back to the future'}
         * Movie{title='Lord of the rings'}
         * Movie{title='Pulp fiction'}
         * Movie{title='Wang's way'}
         */
        List<Movie> movies = Arrays.asList(
          new Movie("Lord of the rings"),
          new Movie("Back to the future"),
          new Movie("Wang's way"),
          new Movie("Pulp fiction")
        );
        movies.sort(Comparator.comparing(Movie::getTitle));
        for (Movie mo:movies) {
            System.out.println(mo.toString());
        }

        List<String> list2 = Arrays.asList("Milan","london","San Francisco","Tokyo","New Delhi");
       //[Milan, london, San Francisco, Tokyo, New Delhi]
        System.out.println(list2);

        //london, Milan, New Delhi, San Francisco, Tokyo]    不区分大小写
        list2.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list2);

        list2.sort(Comparator.naturalOrder());
        //[Milan, New Delhi, San Francisco, Tokyo, london]   返回首先排序大写字母的比较器
        System.out.println(list2);
    }

}
