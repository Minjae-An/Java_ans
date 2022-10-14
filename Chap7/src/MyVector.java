import java.util.Vector;
import java.util.Scanner;
import java.util.Iterator;

public class MyVector {

	public static void printAll(Vector<Integer> v) {
		System.out.println("용량은 "+v.capacity());
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void printAllIterator(Vector<Integer> v) {
		Iterator<Integer> it=v.iterator();
		
		while(it.hasNext()) {
			Integer n=it.next();
			// int n=it.next(); // auto unboxing
			System.out.print(n+" ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Vector<Integer> v=new Vector<Integer>(10000);
		
		Scanner scanner=new Scanner(System.in);
		for(int i=0; i<11; i++) {
			int n=scanner.nextInt();
			v.add(n);
		}
		
		printAll(v);
		Integer ref=v.remove(3);
		v.add(ref);
		printAllIterator(v);
		scanner.close();
	}
}
