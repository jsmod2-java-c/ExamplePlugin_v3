package net.noyark;

import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Test {

    public static void main(String... args) throws Exception{
        int a = 0;
        if(a<2) {
            for (int i = 0; i < 3; i ++) {
                System.out.println(111);
            }
        }else{
            for (int i = 0; i < 3; i ++) {
                for(int j = 0;j<4;j++)
                System.out.println(111);
            }
        }
    }


    public static Object quickSearch(Object[] objs, Object obj, Compare compare, Comparator comparator){
        Arrays.sort(objs,comparator);
        return quickSearch0(objs,obj,compare);
    }


    /**
     * 快速查找一个数组的对象
     * @return
     */
    public static Object quickSearch0(Object[] objs,Object obj,Compare compare){

        int start = 0;

        int end = objs.length;//3
        //3>>2 1

        int middle;
        while (end >= start){
            middle = (start+end)>>1;
            if(compare.compare(obj,objs[middle])==0){
                return objs[middle];
                //>0说明大于
                //<0说明小于
            }else if(compare.compare(obj,objs[middle])>0){
                start = middle;
            }else {
                end = middle - 1;
            }
        }
        return null;
    }

    public interface Compare{

        // 调用compareTo
        int compare(Object obj1,Object obj2);
    }


}

class Test1{

    int i = 0;

    int b = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test1 test1 = (Test1) o;
        return i == test1.i &&
                b == test1.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, b);
    }

    @Override
    public String toString() {
        return "Test1{" +
                "i=" + i +
                ", b=" + b +
                '}';
    }
}

class Company{

    private static Company company;

    private int allMoney = 10000;

    private Company(){

    }

    static {
        company = new Company();
    }

    public static Company getInstance(){
        return company;
    }

    public void giveMoney(Group group){
        allMoney -= group.getMoney();
    }
}

class Group{

    private static Group art;

    private static Group design;

    private static Group program;

    static {
        art = new Group();
        design = new Group();
        program = new Group();
    }

    private Group(){

    }

    private int moneyWill;

    private int money;

    public int getMoney(){
        money += moneyWill;
        return moneyWill;
    }

    private void setMoney(int moneyWill){
        this.moneyWill = moneyWill;
    }

    public static Group getArt() {
        return art;
    }

    public static Group getDesign() {
        return design;
    }

    public static Group getProgram() {
        return program;
    }
}