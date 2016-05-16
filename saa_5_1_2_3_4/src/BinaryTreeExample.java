/**
 * Created by user on 5/12/16.
 */
public class BinaryTreeExample {
    public static void main(String[] args) {
        // Create the binary tree from the sample.
        BinaryTree<Integer> binaryTree =
                new BinaryTree<Integer>(14,
                        new BinaryTree<Integer>(19,
                                new BinaryTree<Integer> (23),
                                new BinaryTree<Integer> (6,
                                        new BinaryTree<Integer>(10),
                                        new BinaryTree<Integer>(21))),
                        new BinaryTree<Integer>(19,
                                new BinaryTree<Integer>(3),
                                null));

        // Traverse and print the tree in pre-order manner.
        binaryTree.printPreOrder();
        int res = binaryTree.maxDepth(binaryTree.root);
        System.out.println(res);
        System.out.println(binaryTree.has_two_edges());
        binaryTree.print_positeve_negative_members();
        System.out.println(binaryTree.sum());

        // Console output:
        // 23 19 10 6 21 14 3 15
    }
}
