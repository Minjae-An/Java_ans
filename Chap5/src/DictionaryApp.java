
abstract class PairMap{
	protected String[] keyArray;
	protected String[] valueArray;
	abstract String get(String key);
	abstract void put(String key, String value);
	
	abstract String delete(String key);
	
	abstract int length();
}

class Dictionary extends PairMap{
	private int index;
	private int size;
	
	public Dictionary(int size) {
		index=0;
		this.size=size;
		
		keyArray=new String[size];
		valueArray=new String[size];
		
		for(int i=0; i<keyArray.length; i++) {
			keyArray[i]=new String();
			valueArray[i]=new String();
		}
	}
	
	public String get(String key) {
		int idx=-1;
		for(int i=0; i<keyArray.length; i++) {
			if(key.equals(keyArray[i])) {
				idx=i;
				break;
			}
		}
		
		if(idx==-1) {
			return null;
		}
		
		return valueArray[idx];
	}
	
	public void put(String key, String value) {
		if(index>=size) {
			System.out.println("저장 공간 부족");
			return;
		}
		
		for(int i=0; i<keyArray.length; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i]=value;
				return;
			}
		}
		
		keyArray[index]=key;
		valueArray[index]=value;
		
		index++;
	}
	
	public String delete(String key) {
		int idx=-1;
		String value="";
		
		for(int i=0; i<keyArray.length; i++)
			if(key.equals(keyArray[i])) {
				idx=i;
				value=valueArray[idx];
				
				for(int j=idx; j<keyArray.length-1; j++) {
					keyArray[j]=keyArray[j+1];
					valueArray[j]=valueArray[j+1];
				}
				break;
			}
		
		if(idx==-1) {
			System.out.println("해당 키를 가진 값이 존재하지 않음");
			return null;
		}
		
		index--;
		
		return value;
	}
	
	public int length() {
		return index;
	}
}



public class DictionaryApp {
	public static void main(String []args) {
		Dictionary dic=new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		
		System.out.println(dic.delete("황기태"));
		
		System.out.println("황기태의 값은 "+dic.get("황기태"));
	}
}
