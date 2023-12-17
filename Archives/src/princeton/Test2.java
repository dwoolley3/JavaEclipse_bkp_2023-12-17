
import java.util.*;

public class Test2 {

	public static void main(String[] args){
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Doug", 2); 
		hm.put("Craig", 3); 
		hm.put("Brad", 4); 
		hm.put("Alice", 1); 
		
		System.out.println(hm.containsKey("Doug"));
		System.out.println(hm.containsValue(22));
		for (Map.Entry<String, Integer> ent : hm.entrySet())
			System.out.println(ent.getKey() + "-" + ent.getValue());
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		tm.put("Doug", 2); 
		tm.put("Craig", 3); 
		tm.put("Brad", 4); 
		tm.put("Alice", 1); 
		
		System.out.println(tm.containsKey("Doug"));
		System.out.println(tm.containsValue(22));
		for (Map.Entry<String, Integer> ent : tm.entrySet())
			System.out.println(ent.getKey() + "-" + ent.getValue());
		
		LinkedHashMap<String, Integer> lm = new LinkedHashMap<String, Integer>();
		lm.put("Doug", 2); 
		lm.put("Craig", 3); 
		lm.put("Brad", 4); 
		lm.put("Alice", 1); 
		
		System.out.println(lm.containsKey("Doug"));
		System.out.println(lm.containsValue(22));
		for (Map.Entry<String, Integer> ent : lm.entrySet())
			System.out.println(ent.getKey() + "-" + ent.getValue());
		
	}
}
