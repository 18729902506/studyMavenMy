package example.instanceoftest;

/***
 * false
 * true
 * true
 * true
 * 子类是父类的对象
 * @author s
 */
public class Test {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Man();
        Man m1 = new Man();
        System.out.println(p1 instanceof Man);
        System.out.println(p2 instanceof Man);
        System.out.println(m1 instanceof Man);
        System.out.println(m1 instanceof Person);
    }
}
