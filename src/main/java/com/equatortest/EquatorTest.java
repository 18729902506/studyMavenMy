package com.equatortest;

import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.List;

/***
 * @author s
 * @date 2019/10/31
 */
public class EquatorTest {

    @Test
    public void test() {
//        Equator equator = new GetterBaseEquator();
//        User user1 = new User(1,"王");
//        User user2 = new User(2,"尚");
        //判断属性是否完全相等   false
//        System.out.println(equator.isEquals(user,claa));
        //获取不同的属性
//        List<FieldInfo> diffFields = equator.getDiffFields(user1, user2);

//        Multimap<String, String> map = ArrayListMultimap.create();
//        map.put("name","姓名");
//        map.put("name","dictConvertor");
//        map.put("name111","姓名111");
//        map.put("name111","dictConvertor");
//
//        for (FieldInfo fieldInfo : diff) {
//            fieldInfo.getFieldName() == map
//            AbcConvertor convertor = SpringUtil.getBean("dictConvertor");
//            Stirng newVvvv = convertor.convert(12)
//        }

        //[FieldInfo{fieldName='name', fieldType=class java.lang.String, firstVal=王, secondVal=尚},
        // FieldInfo{fieldName='id', fieldType=class java.lang.Integer, firstVal=1, secondVal=2}]

//        System.out.println(diffFields);

//        Map<String,String> map = new HashMap<>();
//        map.put("name","姓名");
//        map.put("name2","尚");

//        for (FieldInfo fieldInfo : diffFields){
//            String fieldName = fieldInfo.getFieldName();
//            String join = StringUtils.join(map.keySet(), ",");
//            String[] split = join.split(",");
//            for (String s : split){
//                System.out.println(s+"***********");
//            }

        //id  name
//            System.out.println(fieldName);


    Multimap<String, String> map = ArrayListMultimap.create();
        map.put("PRODUCT","productName");
        map.put("USER","userName");
        map.put("CUSTOMER_DETAIL","customerName");
        map.put("CUSTOMER_DETAIL","managerId");
        //[productName, userName, customerName, managerId]
        System.out.println(map.values());
        //[userName]
        System.out.println(map.get("USER"));
        //userName
        System.out.println((String) map.get("USER").toArray()[0]);
}
}
