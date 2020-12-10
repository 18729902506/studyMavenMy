package example.serialtest.test3;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Method {

//    private static boolean judgeCustomerName(String str){
//        boolean flag = false;
//            if (StringUtils.isNotBlank(str)){
//                flag = true;
//            }else{
//                flag = false;
//            }
//        return flag;
//    }

    public static void main(String[] args) {
//        System.out.println(judgeCustomerName("1234"));
//        String date = "2019-12-08 14:31:58";
//        System.out.println(date.substring(5,7));

//        System.out.println(Arrays.asList("test").contains(null));
//        System.out.println(Collections.singletonList(null).contains("test"));
//        System.out.println(!Collections.singletonList(null).contains("test"));
//        System.out.println(Collections.singleton(null).contains(null));

//        String str = null;
//        if (!Collections.singletonList(str).contains("test") || null==str){
//            System.out.println("不包含");
//        }else{
//            System.out.println("包含");
//        }
        Entity en = new Entity(null,null);
        Entity en2 = new Entity(null,"123");
        Entity en3 = new Entity(null,"123_test");
        Entity en4 = new Entity("asd","123");
        Entity en5 = new Entity("asd","123_test");
        List<Entity> entityList = new ArrayList<>();
        entityList.add(en);
        entityList.add(en2);
        entityList.add(en3);
        entityList.add(en4);
        entityList.add(en5);
        for (Entity entity : entityList){
            if (StringUtils.isNotBlank(entity.getCustomerName())){
//                System.out.println("sss"+entity);
            }else if (null == entity.getCustomerName() && null == entity.getUsername() ){
//                System.out.println("ccc"+entity);
            }else if (null == entity.getCustomerName() && !Collections.singletonList(entity.getUsername()).contains("test")){
//                System.out.println("bbb"+entity);
            }
        }
//        System.out.println(Arrays.asList(null).toString().contains("test"));
//        System.out.println(StringUtils.isBlank(null));
//        System.out.println("true".equals(null));

        // false  false  true
//        System.out.println(Collections.singleton(null).toString().contains("test"));
//        System.out.println(Collections.singleton("1234").toString().contains("test"));
//        System.out.println(Collections.singleton("test123").toString().contains("test"));

//        System.out.println("--------------");
        //false false false
//        System.out.println(Collections.singleton(null).contains("test"));
//        System.out.println(Collections.singleton("1234").contains("test"));
//        System.out.println(Collections.singleton("test123").contains("test"));

        String str = "test123,234_test,test,yuio";
//        System.out.println(str.split(","));

        String pages = "1,5,3,8,9";
        //返回一个字符串数组
        String[] split = pages.split(",");
        for(String s : split){
//            System.out.println(s+" ");
        }

        String init[] = {"One","Two","Three","One","Two","Three"};
        List<String> list1 = new ArrayList<>(Arrays.asList(init));
        List<String> list2 = new ArrayList<>(Arrays.asList(init));

        //[Two, Three, One, Two, Three]
        //[Two, Three, Two, Three]
        list1.remove("One");
//        System.out.println(list1);

        list2.removeAll(Collections.singleton("One"));
//        System.out.println(list2);


        String str2 = "abc,mn,kio";
        System.out.println(str2.contains("c")+"___");

        for (String s : str2.split(",")){
            System.out.println(s.equals("c")+"!!!!!!!!!!");
        }










    }
}
