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
		// ����ɾ��ֵ���Ҳ���ֱ�ӷ���false
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
		// �����ǰ�ڵ�û���ӽڵ�
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
		// ��ǰ�ڵ���һ���ӽڵ�
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
		// ��ǰ�ڵ���������ӽڵ�
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

	//�ҵ���̽ڵ㣬����̽ڵ�����������ӵ���̽ڵ�ĸ��ڵ��������
	//��ɾ���ڵ����������Ϊ��̽ڵ��������
	//��ɾ���ڵ����������Ϊ��̽ڵ��������
	public Node getSuccessor(Node delNode){
	    Node successorParent = delNode;
	    Node successor = delNode;
	    Node current = delNode.rightChild;
	    while(current != null){
	        successorParent = successor;
	        successor = current;
	        current = current.leftChild;
	    }
	    //����̽ڵ��滻ɾ���ڵ�
	    if(successor != delNode.rightChild){
	        successorParent.leftChild = successor.rightChild;
	        successor.rightChild = delNode.rightChild;
	    }
	     
	    return successor;
	}
}
