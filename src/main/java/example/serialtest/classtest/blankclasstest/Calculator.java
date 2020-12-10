package example.serialtest.classtest.blankclasstest;

enum Ops{ADD,SUB}

public class Calculator {

    private int i,j,result;

    public Calculator() {
    }

    public Calculator(int i, int j) {
        this.i = i;
        this.j = j;
    }

    protected void setOperator(Ops ops){
        result = ops.equals(Ops.ADD) ? i+j : i-j;
    }

    /***
     * 取得运算结果
     * @return
     */
    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        Calculator c1 = new Calculator(1,2){
            {
                setOperator(Ops.ADD);
            }
        };
        //3  它首先会调用父类有两个参数的构造函数，而不是无参构造，这是匿名类的构造函数与普通类的区别
        System.out.println(c1.getResult());
    }
}
