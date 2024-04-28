package programs;

import java.util.ArrayList;
import java.util.List;

public class jl {

	public static void main(String[] args) {
		
		List<String> beList = new ArrayList<String>();
		beList.add("new");
		beList.add("kill");
		
		for (String string : beList) {
			System.out.println(beList.size());
			System.out.println(string);
		}

		

	}

}
