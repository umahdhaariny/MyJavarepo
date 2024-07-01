package Datastructures;

//Inorder - left ,root ,right
//preorder - root ,left right
//postorger- left ,right ,root
class Tree{
	int data;
	Tree leftchild ;
	Tree rightchild;
	public Tree(int data)
	{
		this.data = data;
	}

}
public class MYbinaryTree {
	Tree root;
	public static void main(String args[]) {
		MYbinaryTree tree1 = new MYbinaryTree();
		
		tree1.insert(8);
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(7);
		tree1.insert(4);
		tree1.insert(9);
		tree1.insert(11);
		
		tree1.inorder();
		
	}
	public void insert(int data) {
		root =insertrec(root,data);
	}
	public Tree insertrec(Tree root ,int data) {
		
		if(root==null) {
			root=new Tree(data);
		}
			
		else if ( data<root.data)
			root.leftchild = insertrec(root.leftchild,data);
		else if(data>root.data)
			root.rightchild=insertrec(root.rightchild,data);
	
		return root;
	}
	public void inorder() {
		inorderrec(root);
	}
	
	
	public void inorderrec(Tree root) {
		//System.out.println("printing");
		if(root != null) {
		
			inorderrec(root.leftchild);
			System.out.println(root.data);
			inorderrec(root.rightchild);
		}
	}	
}
