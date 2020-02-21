package leetcode.referenceclass;

public class Node3 {
    public int val;
    public Node3 next;
    public Node3 random;

    public Node3() {}

    public Node3(int _val,Node3 _next,Node3 _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
