/**
 * Created by user on 5/8/16.
 */
public class Program {

    static int sum(int a,int b){
        if(a == b){
            return b;
        }
        int sumT=0;
        sumT = a + sum(++a , b);

        return sumT;
    }

    public static void main(String[] args) {
        System.out.println(sum(1,3));
    }
}
