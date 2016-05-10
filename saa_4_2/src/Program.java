/**
 * Created by user on 5/8/16.
 */
//Да се проектира структурата от данни "дек" (статична реализация).
//Да се реализират операции за премах¬ване, добавяне и изчистване на дека



public class Program {

    private Object[] left = new Object[26];
    private Object[] right = new Object[26];
    private int nextIndexInLeftPart = 0;
    private int nextIndexInRightPart = 0;
    private static boolean isLeftNext = true;

    private void addLeft(Object element) {
        left[nextIndexInLeftPart] = element;
        nextIndexInLeftPart++;
    }

    private void addRight(Object element) {
        right[nextIndexInRightPart] = element;
        nextIndexInRightPart++;
    }

    private boolean removeLeft(Object element) {
        boolean isRemoved = false;
        for (int i = 0; i < nextIndexInLeftPart; i++) {
            if (left[i] == element) {
                for (int j = i; j < nextIndexInLeftPart; j++) {
                    left[j] = left[j + 1];
                }

                nextIndexInLeftPart--;
                isRemoved = true;
                break;
            }
        }

        return isRemoved;
    }

    private boolean removeRight(Object element) {
        boolean isRemoved = false;
        for (int i = 0; i < nextIndexInRightPart; i++) {
            if (right[i] == element) {
                for (int j = i; j < nextIndexInRightPart; j++) {
                    right[j] = right[j + 1];
                }
                nextIndexInRightPart--;
                isRemoved = true;
                break;
            }
        }

        return isRemoved;
    }

    public void addToDeck(Object element) {
        if (isLeftNext) {
            this.addLeft(element);
            isLeftNext = false;
        } else {
            this.addRight(element);
            isLeftNext = true;
        }
    }

    public void removeFromDeck(Object element) {
        boolean isRemoved = false;
        if (this.removeLeft(element)) {
            isRemoved = true;
        } else if (this.removeRight(element)) {
            isRemoved = true;
        }

        if(isRemoved){
            System.out.println("Element found and removed.");
        }
        else{
            System.out.println("Element is not contained in the deck.");
        }
    }

    private static String join(Object[] array,int lastElementIndex){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastElementIndex - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }

        sb.append(array[lastElementIndex - 1]);

        return sb.toString();
    }

    public void printDeck() {
        System.out.println(join(this.left,this.nextIndexInLeftPart));
        System.out.println(join(this.right,this.nextIndexInRightPart));
    }

    public static void main(String[] args) {
        Program deck = new Program();
        deck.addToDeck((int) 1);
        deck.addToDeck((int) 2);
        deck.addToDeck((int) 3);
        deck.addToDeck((int) 4);
        deck.addToDeck((int) 5);
        deck.addToDeck((int) 6);
        deck.addToDeck((int) 7);
        deck.addToDeck((int) 8);

        deck.removeFromDeck((int) 3);
        deck.removeFromDeck((int) 4);

        deck.printDeck();
    }
}
