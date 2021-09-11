package leetcode.test0751to0800;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。

译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。

 

示例 1：



输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
示例 2：



输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
示例 3：

输入：graph = [[1],[]]
输出：[[0,1]]
示例 4：

输入：graph = [[1,2,3],[2],[3],[]]
输出：[[0,1,2,3],[0,2,3],[0,3]]
示例 5：

输入：graph = [[1,3],[2],[3],[]]
输出：[[0,1,2,3],[0,3]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] book = new boolean[graph.length];

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        
        list.add(0);
        book[0] = true;
        allPathsSourceTarget(0, graph, book, lists, list);

        return lists;
    }

    public void allPathsSourceTarget(int addr, int[][] graph, boolean[] book, List<List<Integer>> lists, List<Integer> list) {
        if(addr == graph.length-1){
            lists.add(list);
            return;
        }

        for(int address: graph[addr]){
            if(book[address]){
                continue;
            }
            book[address] = true;
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(address);
            allPathsSourceTarget(address, graph, book, lists, temp);
            book[address] = false;
        }

        
    }
}
