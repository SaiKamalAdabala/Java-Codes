package com.cg.charecterscount;

import java.util.Arrays;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		Filter filter= new Filter();
		Mapper mapper= new Mapper();
		List<String> stringList= Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra","allanna", "allannah", "allessandra", "allianna", "allyanna","anastaisa", "anastashia", "anastasia", "annabella", "annabelle","annebelle");
		stringList.stream().filter(filter.nameStartingWithPrefix("aa")).map(mapper.getDistinctCharecterCount()).forEach(System.out::println);
		
	}

}
