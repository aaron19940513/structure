package tree;

public class Node {
	int data; // �ڵ�����
	Node leftChild; // ���ӽڵ������
	Node rightChild; // ���ӽڵ������
	boolean isDelete;// ��ʾ�ڵ��Ƿ�ɾ��

	public Node(int data) {
		this.data = data;
	}

	// ��ӡ�ڵ�����
	public void display() {
		System.out.println(data);
	}
}
