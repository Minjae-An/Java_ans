
class TV{
	private String name;
	private int releaseYear;
	private int size;
	
	public TV(String name, int realeaseYear, int size) {
		this.name=name;
		this.releaseYear=releaseYear;
		this.size=size;
	}
	
	public void show() {
		System.out.print(name+"에서 만든 "+releaseYear+"형 "+size+"인치 TV");
	}
}

public class Number1 {
	public static void main(String []args) {
		TV myTV=new TV("LG", 2017, 32);
		myTV.show();
	}
}
