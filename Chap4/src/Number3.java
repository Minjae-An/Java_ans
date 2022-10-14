
class Song{
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song() {
		title=artist=country=null;
		year=0;
	}
	
	public Song(String title, String artist, int year, String country) {
		this.title=title;
		this.artist=artist;
		this.year=year;
		this.country=country;
	}
	
	public void show() {
		System.out.print(year+"년 "+country+"국적의 "+artist+"가 부른 "+title);
	}
	
}
public class Number3 {
	public static void main(String []args) {
		Song song=new Song("Dancing Queen", "ABBA", 1987, "스웨덴");
		song.show();
	}
}
