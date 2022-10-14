import java.util.Scanner;

class Book{
	private String title;
	private String author;
	
	public Book(String title, String author) {
		this.title=title;
		this.author=author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	
}

public class BookArray {
	
	private Book []books=null;
	private Scanner scanner=new Scanner(System.in);
	
	
	public BookArray(int n) {
		books=new Book [n]; // 레퍼런스 배열 생성
		
		for(int i=0; i<books.length; i++) {
			System.out.print("제목>>");
			String name=scanner.nextLine();
			System.out.print("저자>>");
			String author=scanner.nextLine();
			
			books[i]=new Book(name, author);
		}			
	}
	
	
	public void manage() {
		for(int i=0; i<books.length; i++) {
			System.out.print(books[i].getTitle()+","+books[i].getAuthor());
		}
	}
	
	public static void main(String []args) {
		BookArray bArray=new BookArray(5);
		bArray.manage();
	}
}
