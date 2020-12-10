package com.streatest.testone;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

             List<Dish> menu = Arrays.asList(
                  new Dish("port",false,800,Dish.Type.MEAT),
                  new Dish("beef",false,700,Dish.Type.MEAT),
                  new Dish("chicken",false,400,Dish.Type.MEAT),
                  new Dish("french fries",true,530,Dish.Type.MEAT),
                  new Dish("rice",true,530,Dish.Type.OTHER),
                  new Dish("season fruit",true,120,Dish.Type.OTHER),
                  new Dish("pizza",true,550,Dish.Type.OTHER),
                  new Dish("prowns",false,300,Dish.Type.FISH),
                  new Dish("salmon",false,450,Dish.Type.FISH)
            );


        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d: menu){
            //用累加器筛选元素
            if (d.getCalories()<400){
                lowCaloricDishes.add(d);
            }
        }


        //用匿名类对菜肴进行排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(),d2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes){
            //处理排序后的菜名列表
            lowCaloricDishesName.add(d.getName());
        }


        List<String> lowCaloricDishesName2 =
                menu.stream()
                        //选出400卡路里以下的菜肴
                .filter(d -> d.getCalories() < 400)
                        //按照卡路里排序
                .sorted(Comparator.comparing(Dish::getCalories))
                        //提取菜肴的名称
                .map(Dish::getName)
                        //将所有名称保存在list中
                .collect(Collectors.toList());

//        Map<Dish.Type>,List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType))

        //如何利用流来选择出两个荤菜？
        List<Dish> dishes = menu.stream()
                                .filter(d -> d.getType() == Dish.Type.MEAT)
                                .limit(2)
                                .collect(Collectors.toList());

        //菜单里有多少种菜
        long howManyDishes = menu.stream().collect(Collectors.counting());

        //也可以写成
        long howManyDishes2 = menu.stream().count();


        //查找流中的最大值与最小值
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        //要是menu为null，那就没有要返回的菜了
        Optional<Dish> mostCaloriesDish =  menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        //拿到菜单的各个热量，再求和  4380
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories:"+totalCalories);

        //利用summarizingInt()方法，获取菜单中元素的个数，菜肴热量的总和，最大值，最小值，平均值
        //IntSummaryStatistics{count=9, sum=4380, min=120, average=486.666667, max=800}
        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);


        String shortMenu =  menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        //port,beef,chicken,french fries,rice,season fruit,pizza,prowns,salmon
        System.out.println(shortMenu);
    }

}
