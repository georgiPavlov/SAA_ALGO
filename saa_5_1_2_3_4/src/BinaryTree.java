import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 5/12/16.
 */
public class BinaryTree<T> {

public static class TreeNode<T>{
    T value;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;
    private boolean hasParent;

    public TreeNode(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode(T value){
        this(value,null,null);
    }

    public void setLeftChild(TreeNode<T> value){
        this.leftChild = value;
        this.leftChild.hasParent = true;
    }

    public void setRightChild(TreeNode<T> value){
        this.rightChild = value;
        this.rightChild.hasParent= true;
    }

    public TreeNode<T> getLeftChild(){
        return leftChild;
    }

    public TreeNode<T> getRightChild(){
        return rightChild;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return value != null ? value.equals(treeNode.value) : treeNode.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}

    TreeNode<T> root;

    public BinaryTree(T value, BinaryTree<T> leftChild,
                      BinaryTree<T> rightChild) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        TreeNode<T> leftChildNode =
                leftChild != null ? leftChild.root : null;
        TreeNode<T> rightChildNode =
                rightChild != null ? rightChild.root : null;
        this.root = new TreeNode<T>(
                value, leftChildNode, rightChildNode);
    }

    public BinaryTree(T value) {
        this(value, null, null);
    }

    public TreeNode<T> getRoot()
    {
        return this.root;
    }


    public TreeNode<T> getLeftChildNode()
    {
        if (this.root != null)
        {
            return this.root.getLeftChild();
        }

        return null;
    }

    public TreeNode<T> getRightChildNode()
    {
        if (this.root != null)
        {
            return this.root.getRightChild();
        }

        return null;
    }

    private void printPreOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        // 1. Visit the left child.
        printPreOrder(root.getLeftChild());

        // 2. Visit the root of this subtree.
        System.out.print(root.getValue() + " ");

        // 3. Visit the right child.
        printPreOrder(root.getRightChild());
    }

    public void printPreOrder() {
        printPreOrder(this.root);
        System.out.println();
    }


    int maxDepth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            // compute the depth of each subtree
            int lDepth = maxDepth(node.getLeftChild());
            int rDepth = maxDepth(node.getRightChild());
            // use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    static boolean has_more_than_one= false;
    void has_two_edges(TreeNode<T> root,HashMap<T,Integer> map){
        if (root == null) {
            return;
        }

        Integer inc = 0;
        if(!map.containsKey(root.getValue())){
            map.put(root.getValue(),inc++);

        }else {
            System.out.println(inc + "inc");
            inc = map.get(root.getValue());
            System.out.println(inc + "inc");


            inc++;
            map.remove(root.getValue());
            map.put(root.getValue(),inc);
            has_more_than_one = true;
        }
        has_two_edges(root.getLeftChild(),map);
        has_two_edges(root.getRightChild(),map);
    }

    boolean has_two_edges(){
        HashMap<T,Integer> map = new HashMap<>();
        has_two_edges(root,map);
        if(has_more_than_one == true){
            return true;
        }
        return false;

    }

    static ArrayList p_members;
    static ArrayList n_members;
    private void print_positeve_negative_members(TreeNode<T> root){
        if (root == null) {
            return;
        }

        if(root.getValue() != null){
            if((Integer)root.getValue() > 0){
            p_members.add(root.getValue());
        }else {
            n_members.add(root.getValue());
        }}

        print_positeve_negative_members(root.getLeftChild());
        print_positeve_negative_members(root.getRightChild());


    }

    public void print_positeve_negative_members(){
        p_members = new ArrayList();
        n_members = new ArrayList();
        print_positeve_negative_members(root);
        System.out.println("positive");
        for (int i = 0; i < p_members.size(); i++) {
            System.out.print(p_members.get(i) + ", ");
        }
        System.out.println("negative");
        for (int i = 0; i < n_members.size(); i++) {
            System.out.print(n_members.get(i) + ", ");
        }

    }

    private static int sum =0 ;
    private void sum_even(TreeNode<T> root){
        if (root == null) {
            return;
        }

        if(root.getValue() != null){
            if((Integer)root.getValue()% 2 == 0){
                sum += (Integer) root.getValue();
            }
        }

        sum_even(root.getLeftChild());
        sum_even(root.getRightChild());


    }

    public int sum(){
        sum_even(root);
        return sum;
    }




}
