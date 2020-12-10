package com.demo.testtwo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/***
 * @author shang
 */
@Data
public class Apple {
    private Integer weight;
    private String color;
    static List<Apple> inventory;
    private String country;

    public Apple() {

    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        //result是用来累积结果的List,开始为空，然后一个个加入绿苹果
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //高亮显示的代码会仅仅选出绿苹果
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * 方法作为Predicate参数p传递进去
     *
     * @param
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //苹果符合p所代表的条件吗，test方法就是用来判断一个对象是否符合指定的规则
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //传递方法
        filterApples(inventory, Apple::isGreenApple);
        filterApples(inventory, Apple::isHeavyApple);
        //Lambda表达式
        filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);

        filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));

        //按重量递减排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        //如果两个苹果一样重，进一步按照国家排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
    }

    public static void filterApples(List<Apple> inventory) {
        List<Apple> heavyApples1 = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
        List<Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
    }
}
