package com.streatest.testone;

import java.util.Arrays;
import java.util.List;

public class Dish {

    private String name;

    /***
     *素材
     */
    private boolean vegetarian;

    /***
     * 卡路里
     */
    private int calories;
    private Type type;

    public Dish() {
    }

    public Dish(String name, boolean vegetarian,int calories, Type type) {
        this.calories = calories;
        this.name = name;
        this.vegetarian = vegetarian;
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type{
        MEAT,FISH,OTHER
    }

    /***
     * 获取菜单
     * @return 菜单集合
     */
    static List<Dish> getMenu(){
        return Arrays.asList(
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("salmon", false, 450, Type.FISH));
//                new Dish("salmon", false, 450, Dish.Type.FISH));
    }
}
