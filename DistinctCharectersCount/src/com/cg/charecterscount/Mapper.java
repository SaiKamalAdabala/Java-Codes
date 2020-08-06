package com.cg.charecterscount;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Mapper {
	
	Function<String, CharecterBean>getDistinctCharactersCount(){
		return distinctCount->{
			char charecterSet[]=distinctCount.toCharArray();
			Set charecterList= new TreeSet<>();
			for(char charecter:charecterSet) {
				charecterList.add(charecter);
			}
				Integer distictElements= charecterList.size();
						
			return new CharecterBean(distinctCount,distictElements);
			
		};
	}

}
