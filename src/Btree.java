
import java.util.Scanner;
import java.util.Stack;

public class Btree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in=new Scanner(System.in);
		System.out.println("请输入后缀表达式：(Please input a suffix expression:)");
		String s=in.next();
			BinaryNode b=new BinaryNode('a');
		b=createTree(s);
		System.out.println("前缀表达式是：(The prefix expression is:)");
		b.preorder(b);
		System.out.println("\n中缀表达式是:(The infix expression is:)");
		b.inorder(b);
		System.out.println("\n后缀表达式是:(The suffix expression is:)");
		b.postorder(b);
		System.out.print("\n");
		
		
	}
	static BinaryNode createTree(String s){
		Stack <BinaryNode>stack=new Stack<>();
		BinaryNode tree=new BinaryNode('a');
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			BinaryNode node = new BinaryNode(c);
			if (c == '+' || c == '-' || c == '*' || c == '/') {

			node.right = stack.pop();
			node.left = stack.pop();;
			}
			stack.push(node);
			}
		return stack.pop();
	}
	

}

class BinaryNode{
	char element;
	BinaryNode left;
	BinaryNode right;
	
	public BinaryNode(char c){
		this.element=c;
		this.left=null;
		this.right=null;
	}
	public void preorder(BinaryNode b){
		System.out.print(b.element);
		if(b.left!=null)
			preorder(b.left);
		if(b.right!=null)
			preorder(b.right);
	}
	public void inorder(BinaryNode b){
		
		if(b.left!=null)
			inorder(b.left);
		System.out.print(b.element);
		if(b.right!=null)
			inorder(b.right);
	}
	public void postorder(BinaryNode b){
		
		if(b.left!=null){
			postorder(b.left);
		}	
		if(b.right!=null)
			postorder(b.right);
		System.out.print(b.element);
	}
}