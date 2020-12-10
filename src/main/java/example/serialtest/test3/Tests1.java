package example.serialtest.test3;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Tests1 {

    public final static String ENGLIST_PATTERN_STR = "^[A-Za-z]+$";
    public static Pattern ENGLIST_PATTERN = Pattern.compile(ENGLIST_PATTERN_STR);


        public static void main(String[] args) {
//             String dataCode = "asdfg";
//            if (ENGLIST_PATTERN.matcher(dataCode).find()){
//                System.out.println("---------");
//                System.out.println(ENGLIST_PATTERN+"%%%%%%");
//            }else{
//                System.out.println("++++++++++");
//                System.out.println(ENGLIST_PATTERN+"++++++++++");
//            }
            String str = "|SALES_NF_SOUTH|SALES_NF_SOUTHWEST|";
             String str2 = "|SALES_NF_SOUTH||SALES_NF_SOUTHWEST|";
            System.out.println(Arrays.asList(str.split("\\|")));
            System.out.println(Arrays.asList(str2.split("\\|")));
        }

}
