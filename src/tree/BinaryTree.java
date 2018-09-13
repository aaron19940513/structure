package tree;

public class BinaryTree implements Tree {

	private Node root;

	@Override
	public Node find(int key) {
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.data > key) {
				currentNode = currentNode.leftChild;
			} else if (currentNode.data < key) {
				currentNode = currentNode.rightChild;
			} else {
				return currentNode;
			}
		}
		return null;
	}

	@Override
	public boolean insert(int data) {
		Node insertNode = new Node(data);
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.data > data) {
				if (currentNode.leftChild != null) {
					currentNode = currentNode.leftChild;
				} else {
					currentNode.leftChild = insertNode;
					break;
				}
			} else if (currentNode.data < data && currentNode.rightChild != null) {
				if (currentNode.leftChild != null) {
					currentNode = currentNode.rightChild;
				} else {
					currentNode.rightChild = insertNode;
					break;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public void infixOrder(Node current) {
		infixOrder(current.leftChild);
		System.out.println(" " + current.data);
		infixOrder(current.rightChild);
	}

	@Override
	public void preOrder(Node current) {
		System.out.println(" " + current.data);
		preOrder(current.leftChild);
		preOrder(current.rightChild);

	}

	@Override
	public void postOrder(Node current) {
		System.out.println(" " + current.data);
		postOrder(current.leftChild);
		postOrder(current.rightChild);
	}

	@Override
	public Node findMax() {
		Node parent = null;
		Node currentNode = root;
		while (currentNode != null) {
			parent = currentNode;
			currentNode = currentNode.rightChild;
		}
		return parent;
	}

	@Override
	public Node findMin() {
		Node parent = null;
		Node currentNode = root;
		while (currentNode != null) {
			parent = currentNode;
			currentNode = currentNode.leftChild;
		}
		return parent;
	}

	@Override
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		// 查找删除值，找不到直接返回false
		while (current.data != key) {
			parent = current;
			if (current.data > key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		// 如果当前节点没有子节点
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
			return true;
		}
		// 当前节点有一个子节点
		if ((current.leftChild == null && current.rightChild != null)
				|| (current.rightChild == null && current.leftChild != null)) {
			Node childNode = current.leftChild==null?current.rightChild:current.leftChild;
			if (current == root) {
				root = childNode;
			} else if (isLeftChild) {
				parent.leftChild = childNode;
			} else {
				parent.rightChild = childNode;
			}
			return true;
		}
		// 当前节点存在两个子节点
		if (current.leftChild != null && current.rightChild != null) {
			Node successor =  getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
			return true;
		}
		return false;
	}

	//找到后继节点，将后继节点的右子树连接到后继节点的父节点的左子树
	//被删除节点的右子树成为后继节点的右子树
	//被删除节点的左子树成为后继节点的左子树
	public Node getSuccessor(Node delNode){
	    Node successorParent = delNode;
	    Node successor = delNode;
	    Node current = delNode.rightChild;
	    while(current != null){
	        successorParent = successor;
	        successor = current;
	        current = current.leftChild;
	    }
	    //将后继节点替换删除节点
	    if(successor != delNode.rightChild){
	        successorParent.leftChild = successor.rightChild;
	        successor.rightChild = delNode.rightChild;
	    }
	     
	    return successor;
	}
}
