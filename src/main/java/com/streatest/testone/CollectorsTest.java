package com.streatest.testone;

import org.junit.Test;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * @author shang
 * @date 2020-09-11
 */
public class CollectorsTest {

    private List<Dish> getMenu() {
        return Dish.getMenu();
    }

    @Test
    public void toMap() {
        //如果name重复，会报异常，java.lang.IllegalStateException: Duplicate key FISH
        Map<String, Dish.Type> nameTypeMap = getMenu().stream().collect(Collectors.toMap(Dish::getName, Dish::getType));
        //{season fruit=OTHER, chicken=MEAT, pizza=OTHER, salmon=FISH, beef=MEAT, rice=OTHER, pork=MEAT, prawns=FISH, french fries=OTHER}
        System.out.println(nameTypeMap);

        //注意：按照往常的思维，往一个map中放入一个已经存在的key，会把原来的key给覆盖掉，但是Collectors.toMap()会抛出异常，有type相同的对象，转map的时候就会报错，所以需要自己传一个方法进去
        //此写法是错误的，java.lang.IllegalStateException: Duplicate key pork
        Map<Dish.Type, Dish> typeDishMap = getMenu().stream().collect(Collectors.toMap(Dish::getType, Function.identity()));
        //此写法是正确的
        Map<Dish.Type, Dish> typeDishMap2 = getMenu().stream().collect(Collectors.toMap(Dish::getType, Function.identity(), (dto1, dto2) -> dto2));
        //type肯定有重复，所以需要去重，保留最后一个  {MEAT=chicken, OTHER=pizza, FISH=salmon}
        System.out.println(typeDishMap);
        System.out.println(typeDishMap2);
    }

    @Test
    public void joining() {
        //pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon
        System.out.println(getMenu().stream().map(Dish::getName).collect(Collectors.joining(",")));
    }


    /***
     *根据对象的某属性进行去重
     */
    @Test
    public void distinctByObjField(){
        ArrayList<Dish> distinctDishList = getMenu().stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Dish::getType))), ArrayList::new));
        System.out.println("根据type去重" + distinctDishList);
    }

    @Test
    public void testGroupingBy() {
        //无序   {MEAT=[pork, beef, chicken], OTHER=[french fries, rice, season fruit, pizza], FISH=[prawns, salmon]}
        Map<Dish.Type, List<Dish>> dishesByType = getMenu().stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        //简单有序分组  {MEAT=[pork, beef, chicken], OTHER=[french fries, rice, season fruit, pizza], FISH=[prawns, salmon]}
        //加上LinkedHashMap::new更严谨写  这点，就可以进行有序排序，原始的HashMap是无序的，分组后，顺序有可能会乱，以组分出来的，各组的数量，可能是乱的，但是hashMap还以为是分组前的数量，这样就会乱套
        LinkedHashMap<Dish.Type, List<Dish>> dishesByType2 = getMenu().stream().collect(Collectors.groupingBy(Dish::getType, LinkedHashMap::new, Collectors.toList()));
        System.out.println(dishesByType2);

        //分组后计数   {MEAT=3, OTHER=4, FISH=2}
        Map<Dish.Type, Long> typesCount = getMenu().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);

        //map的value是Optional 分组后取热量最大值   {MEAT=Optional[pork], OTHER=Optional[pizza], FISH=Optional[salmon]}
        Map<Dish.Type, Optional<Dish>> mostCaloricByType1 = getMenu().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType1);

        //map的value是Dish   分组后取热量最大值      {OTHER=pizza, MEAT=pork, FISH=salmon}
        Map<Dish.Type, Dish> mostCaloricByType2 = getMenu().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);

        //map的value是Dish的另一种写法      分组取热量最大:{OTHER=pizza, MEAT=pork, FISH=salmon}
        Map<Dish.Type, Dish> mostCaloricByType3 = getMenu().stream()
                .collect(Collectors.toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("分组取热量最大:" + mostCaloricByType3);

        //分组后取某属性的算术运算值
        Map<Dish.Type, IntSummaryStatistics> dishTypeSummaryStatistics = getMenu().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summarizingInt(Dish::getCalories)));
        IntSummaryStatistics intSummaryStatistics = dishTypeSummaryStatistics.get(Dish.Type.MEAT);
        System.out.println("分组后求" + Dish.Type.MEAT + "卡路里数量" + intSummaryStatistics.getMax());
        System.out.println("分组后求" + Dish.Type.MEAT + "卡路里数量" + intSummaryStatistics.getMin());
        System.out.println("分诅后求" + Dish.Type.MEAT + "卡路里数量" + intSummaryStatistics.getSum());
        System.out.println("分诅后求" + Dish.Type.MEAT + "卡路里数量" + intSummaryStatistics.getCount());
        System.out.println("分诅后求" + Dish.Type.MEAT + "卡路里数量" + intSummaryStatistics.getAverage());
    }

    @Test
    public void test_add(){
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = ++num;
        }
        System.out.println(num);
    }
}
