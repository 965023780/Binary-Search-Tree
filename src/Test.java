public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        //测试空树情况下的显示
        System.out.println("max=" + bst.getMax());
        System.out.println("min=" + bst.getMin());
        //赋予初始值
        bst.insert(0);
        bst.insert(-1);
        bst.insert(2);
        bst.insert(9);
        bst.insert(4);
        bst.insert(7);
        //遍历树
        bst.scan();
        //输出树的节点个数
        System.out.println("nodeSize=" + bst.getSize());
        //输出最大值
        System.out.println("max=" + bst.getMax());
        //如果有7就输出存在
        if (bst.check(7)) {
            System.out.println("7存在");
        }
        //删除7
        bst.erase(7);
        //删除8
        bst.erase(8);
        //如果没有7就输出不存在
        if (!bst.check(7)) {
            System.out.println("7不存在");
        }
        //如果树不空就输出最小值
        if (!bst.isEmpty())
            System.out.println("min=" + bst.getMin());
        //清空树
        bst.clear();
        //如果树空，就输出树为空
        if (bst.isEmpty()) {
            System.out.println("树为空");
        }
    }
}
