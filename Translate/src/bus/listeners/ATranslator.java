package bus.listeners;

import java.util.HashMap;
import java.util.Map;

public class ATranslator  implements Translator {
	static Map<String, String> map = new HashMap<String,String>();
	public String translate(String original) {
		String retVal = map.get(original);
		if(retVal != null) return retVal;
		else return "";
	}
	static {
		map.put("hello", "ni hao");
		map.put("spicy", "la");
		map.put("not spicy", "bu la");
	}	
}
