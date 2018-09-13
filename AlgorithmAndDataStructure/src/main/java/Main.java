import java.util.*;

public class Main {
    public static void main(String[] args) {

        A a1=new A();
        A a2=a1;
        a1=null;
        System.out.println(a1);
        System.out.println(a2);
    }
    static class A{
        int a =11;
        public String toString(){
            return new String(""+a);
        }
    }
}