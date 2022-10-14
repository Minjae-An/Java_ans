import java.util.*;

class Command{
	private String cmd;
	private String var;
	private String value;
	
	public Command(String cmd, String var, String value) {
		this.cmd=cmd;
		this.var=var;
		this.value=value;
	}
	
	public String getCmd() {return cmd;}
	public String getVar() {return var;}
	public String getValue() {return value;}
	
	public void showInfo() {
		System.out.println("["+cmd+" "+var+" "+value+"]");
	}
}

class SuperCom{
	private ArrayList<Command> commandList;
	private HashMap<String, Integer> variables;
	private Scanner in;
	
	public SuperCom() {
		commandList=new ArrayList<>();
		variables=new HashMap<>();
		in=new Scanner(System.in);
	}
	
	public boolean isNum(String value) {
		try {
			Integer.parseInt(value);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void printVars() {
		Set<String> keys=variables.keySet();
		Iterator<String> it=keys.iterator();
		
		while(it.hasNext()) {
			String key=it.next();
			System.out.print(key.toUpperCase()+":"+variables.get(key)+" ");
		}
		
		System.out.println();
	}
	
	public void run() {
		System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO를 입력하면 작동합니다.");
		
		while(true) {
			System.out.print(">>");
			String str=in.nextLine();
			if(str.equals("go")) break;
			String[] info=str.split(" ");
			commandList.add(new Command(info[0], info[1], info[2]));
		}
		
		boolean isFinish=false;
		
		for(int i=0; i<commandList.size(); i++) {
			Command c=commandList.get(i);
			
			String cmd=c.getCmd();
			String var=c.getVar();
			String value=c.getValue();
			
			switch(cmd) {
			case "mov":
				variables.put(var, Integer.parseInt(value)); break;
				
			case "add":
				if(isNum(value))
					variables.replace(var, variables.get(var), variables.get(var)+Integer.parseInt(value));
				else
					variables.replace(var, variables.get(var), variables.get(var)+variables.get(value));
				break;
				
			case "sub":
				variables.replace(var, variables.get(var), variables.get(var)-Integer.parseInt(value));
				break;
				
			case "jn0":
				if(variables.get(var)!=0) i=Integer.parseInt(value)-1;
				break;
				
			case "prt":
				c.showInfo();
				printVars();
				System.out.println("출력할 결과는 "+variables.get(var)+". 프로그램 실행 끝");
				isFinish=true;
				break;
			}
			
			if(isFinish) break;
		}
		
		in.close();
	}
}

public class Problem13{
	public static void main(String []args) {
		SuperCom comApp=new SuperCom();
		comApp.run();
	}
}