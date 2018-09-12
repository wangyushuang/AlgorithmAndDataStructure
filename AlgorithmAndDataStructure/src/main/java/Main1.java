import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int hou = in.nextInt();
            int peo = in.nextInt();
            if(hou<3 || peo<2){
                System.out.println("0 0");
                continue;
            }

            int max=hou-peo;
            if(peo*2>=hou) {
                System.out.println("0 " + (hou - peo));
                continue;
            }
            System.out.println("0 " +(peo-1));
        }
    }
}
