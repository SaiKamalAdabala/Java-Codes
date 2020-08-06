package com.cg.charecterscount;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Mapper {
	
//	Function<String, CharecterBean>getDistinctCharactersCount(){
//		return distinctCharecterCount->{
//			char charecter[]=distinctCharecterCount.toCharArray();
//			Set charecterList= new TreeSet<>();
//			for(char charecters:charecter) {
//				charecterList.add(charecters);
//			}
//				Integer distictElements= charecterList.size();
//						
//			return new CharecterBean(distinctCharecterCount,distictElements);
//			
//		};
//	}
	
	public static Function<String, CharectersCount>getDistinctCharecterCount(){
		return stringName->{
			
			int charecterCount= (int) stringName.chars().distinct().count();
			return new CharectersCount(stringName,charecterCount);
				
		
		
	};
	
	}

}
