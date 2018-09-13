package tree;

import java.util.HashMap;
import java.util.Map;

public class   MapTest{
	private class FixHash{
		public int hashCode(){
			return 49;
		}		
	}
	public static void main(String[] args) {
		Map<FixHash, Object> map = new HashMap<>(128);
		MapTest mapTest=new MapTest();
		int index = 0 ;
		for (int i = 0; i < 10; i++) {
			MapTest.FixHash fix = mapTest.new FixHash();
			map.put(fix, index++);
		}
		System.out.println(map);
	}
}
