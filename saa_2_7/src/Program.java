import java.util.ArrayList;

/**
 * Created by user on 5/7/16.
 */
public class Program {
    static int[][] mass = {
            {3,3,3,2},
            {1,2,3,4},
            {4,5,3,2},
            {1,2,3,4}
    };

    static int currentX=0;
    static int currentY =0;

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(mass.length);
        System.out.println(list.size());
        int totalSize = mass.length * mass.length;
        int inc = 1;
        list.add(mass[currentY][currentX]);
        if(mass.length > 1){
            currentX++;
        }
        while (list.size() != totalSize){
            moveDown(inc);
            moveLeft(inc);
            inc++;
        }
        System.out.println(isTrue());



    }

    static void moveDown(int inc){
         list.add(mass[currentY][currentX]);
        for (int i = 0; i < inc ; i++) {
            ++currentY;
            list.add(mass[currentY][currentX]);
        }
    }

   static void moveLeft(int inc){
        list.add(mass[currentY][currentX]);
        for (int i = 0; i < inc ; i++) {
            --currentX;
            list.add(mass[currentY][currentX]);
        }
        currentX = inc + 1;
        currentY = 0;
    }

   static boolean isTrue(){
       int countUp=0;
       int countDown = 0;
       boolean isFirst1 = false;
       boolean isFirst2 = false;

       for (int i = 1; i < list.size(); i++) {

            if(list.get(i) <= list.get(i-1)){
               if(countUp == 0){
                   isFirst1 = true;
               }
                if(countUp != 0 && !isFirst2){
                    return false;
                }
                countDown++;
            } else if(list.get(i) <= list.get(i-1) ){
                if(countDown == 0){
                    isFirst2 = true;
                }
                if(countDown != 0 && !isFirst1){
                    return false;
                }
               countUp++;

            }

       }
       return true;
   }


}
