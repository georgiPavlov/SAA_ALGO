/**
 * Created by user on 5/7/16.
 */
public class Program {


    public static void main(String[] args) {
        int[] mass = {4,2,8,7,3,10};
        int count =1;
        int maxCount = 0;
        int countOf = 0;

        for (int i = 1; i <mass.length ; i++) {
            if(mass[i] <= mass[i-1]){
                count++;
            }else {
                System.out.println("count: " + count);
                if(maxCount < count){
                    maxCount = count;
                }
                count=1;
                countOf++;
            }
        }
        System.out.println("max count: " + maxCount );
        System.out.println("count of: " + countOf);

    }

}
