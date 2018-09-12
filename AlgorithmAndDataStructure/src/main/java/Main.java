import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new B(23).a);

    }
}

class A{
    public static int a=10;
    static{
        System.out.println("static A");
    }
    {
        System.out.println("common A");
    }

    public A(int c){
        System.out.println("cons A");
    }

    public A(int c,int d){

    }
}

class B extends A{
    public static int a=22;
    static {
        System.out.println("static B");
    }
    {
        System.out.println("common B");
    }
    public B(int c){
        super(c,2);
        System.out.println("cons B");
    }
}