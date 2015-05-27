package demo.utils;

public class Logger {

	public static final Logger INSTANCE = new Logger();
	private Logger() {
		super();
	}
	
	public void log(Object... o){
		if(o == null)
			return;

		for(int i=0;i<o.length;i++){
			if(o[i] == null){
				continue;
			}
			System.out.println(o[i].toString());
		}
	}

}
