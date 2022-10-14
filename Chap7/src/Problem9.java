import java.util.Vector;

interface IStack<T>{
	T pop();
	boolean push(T ob);
}

class MyStack<T> implements IStack<T>{
	private Vector<T> v;
	
	public MyStack() {
		v=new Vector<T>();
	}
	
	public T pop() {
		if(v.isEmpty()) return null;
		else return v.remove(v.size()-1);
	}
	
	public boolean push(T ob) {
		v.add(ob);
		return true;
	}
}

public class Problem9 {
	public static void main(String []args) {
		IStack<Integer> stack=new MyStack<Integer>();
		for(int i=0; i<10; i++) stack.push(i);
		
		while(true) {
			Integer n=stack.pop();
			if(n==null) break;
			System.out.print(n+" ");
		}
	}
}
