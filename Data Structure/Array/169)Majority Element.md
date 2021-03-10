```java
import java.util.HashMap;

public class leetcode {
	public static void main(String[] args) {
		int[] num = {2, 2, 1, 1, 1, 2, 2};
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i=0;i<num.length;i++) {
			if(!hm.containsKey(num[i]))
				hm.put(num[i], 1);
			else
				hm.put(num[i], hm.get(num[i])+1);
		}
		
		int answer = 0;
		for(int key : hm.keySet()) {
			if(hm.get(key) > num.length/2)
				answer = key;
		}
		
		System.out.println(answer);
	}

}
```
