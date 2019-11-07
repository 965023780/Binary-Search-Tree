import sun.security.x509.IPAddressName;

public class BST<T extends Comparable> {
    private T value;
    private Node<T> root = null;
    private int size = 0;

    //添加元素
    public void insert(T value) {
        size++;
        if (root == null) {
            this.root = new Node<T>(value);
            return;
        }
        Node<T> index = root;
        Node<T> parent = root;
        Node<T> newNode = new Node<T>(value);
        while (index != null) {
            parent = index;
            if (index.value.compareTo(value) < 0) {
                index = index.left;
            } else {
                index = index.right;
            }
        }
        if (parent.value.compareTo(value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    //删除元素
    public void erase(T value) {
        Node<T> index = root;
        Node<T> parent = null;
        while (index != null&&index.value.compareTo(value)!=0) {
            parent=index;
            if (index.value.compareTo(value) < 0) {
                index = index.left;
            } else if (index.value.compareTo(value) > 0) {
                index = index.right;
            }
        }
        if (index == null) {
            System.out.println("No this data:" + value);
            return;
        }
        if (index.left == null && index.right == null) {
            if (index == root) {
                root = null;
            } else if (parent.right == index) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } else if (index.left == null) {
            if (index == root) {
                root = index.right;
            } else if (parent.right == index) {
                parent.right = index.right;
            } else {
                parent.left = index.right;
            }
        } else if (index.right == null) {
            if (index == root) {
                root = index.left;
            } else if (parent.right == index) {
                parent.right = index.left;
            } else {
                parent.left = index.left;
            }
        } else {
            Node<T> anotherNode = getNode(index);
            if (index == root) {
                root = anotherNode;
            } else if (parent.right == index) {
                parent.right = anotherNode;
            } else {
                parent.left = anotherNode;
            }
            anotherNode.left = index.left;
        }
    }

    //树的旋转
    private Node<T> getNode(Node<T> node) {
        Node<T> anotherNode = node;
        Node<T> anotherNodeParent = node;
        Node<T> index = node.right;
        while (index != null) {
            anotherNodeParent = anotherNode;
            anotherNode = index;
            index = index.left;
        }
        while (anotherNode != node.right) {
            anotherNodeParent.left = anotherNode.right;
            anotherNode.right = node.right;
        }
        return anotherNode;
    }

    //得到最大值
    public T getMax() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    //得到最小值
    public T getMin() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    //寻找树中是否存在该数
    public boolean check(T value) {
        if (root == null) {
            return false;
        }
        Node<T> index = root;
        while (index != null) {
            if (index.value.compareTo(value) < 0) {
                index = index.left;
            } else if (index.value.compareTo(value) > 0) {
                index = index.right;
            } else {
                return true;
            }
        }
        return false;
    }

    //树是否为空
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    //清空树
    public void clear() {
        root = null;
    }

    //得到树的节点数
    public int getSize() {
        return size;
    }

    //树的遍历
    public void scan() {
        iterator(root);
    }

    //树的遍历
    private void iterator(Node<T> node) {
        if (node == null) {
            return;
        }
        iterator(node.right);
        System.out.println("num:" + node.value);
        iterator(node.left);
    }

    private static class Node<T extends Comparable> {
        private T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

}
