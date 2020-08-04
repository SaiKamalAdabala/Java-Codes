package com.cg.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.cg.Team.Team;
import com.cg.Team.TeamBO;
import com.cg.match.Match;
import com.cg.match.MatchBO;
import com.cg.player.Player;
import com.cg.player.PlayerBO;

public class UserInterface {
	
	public static void main(String[] args) throws IOException {
		
		Player player;
		Team team;
		Match match;
		PlayerBO playerbo= new PlayerBO();
		TeamBO teambo= new TeamBO();
		MatchBO matchbo= new MatchBO();
		
		Scanner sc= new Scanner(System.in);
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
		
		//playerCount and player details
		System.out.println("Please enter the player count : ");
		int playerCount = sc.nextInt();
		Player[] players= new Player[playerCount];
		for(int m=1,n=0;m<=playerCount;m++,n++)
		{
			
			System.out.println("Please enter the Player" +m+" details");
			String input= bufferedReader.readLine();
			player = playerbo.createPlayer(input);
			players[n]= player;
			
			
		}
		 
		//TeamCount and team details
		System.out.println("Please enter the team count:");
		int teamCount=sc.nextInt();
		Team[] teams= new Team[teamCount];
		for(int k=1,l=0;k<=teamCount;k++,l++) 
		{
			System.out.println("Please enter team"+k+ "details" );
			String input= bufferedReader.readLine();
			team=teambo.createTeam(input, players);
			teams[l]=team;
			
		}
		
		//MatchCount and match details
		System.out.println("Please enter the MatchCount");
		int matchCount= sc.nextInt();
		Match[] matches = new Match[matchCount];
		for(int p=1,q=0;p<=matchCount;p++,q++) 
		{
			
			System.out.println("Please enter the match"+p+ "Details");
			String input= bufferedReader.readLine();
			match =matchbo.createMatch(input, teams);
			matches[q]= match;
		}
		
		
		//userInterface Display
		
		do {
			
			System.out.println("Menu:");
			System.out.println("1) Find Team");
			System.out.println("2) Find All Matches In A Specific Venue");
			System.out.println("Please choose and type 1 or 2");
			
	
	int input=sc.nextInt();
	
	switch(input){
	
	case 1:
		
		System.out.println("Please enter the Match Date");
		String matchDate=sc.next();
		Team[] teamm=matchbo.findTeam(matchDate, matches);
		System.out.println("Teams:");
		System.out.println(teamm[0].getName()+ ", "+teamm[1].getName());
			break;
		
		
case 2:
		
		System.out.println("Please enter the TeamName:");
		String teamName=sc.next();
		matchbo.findAllMatchesOfTeam(teamName, matches);
			break;
	
		
	default:
		System.out.println("Please choose and enter ValidInput");
		break;
	
	}
	System.out.println("Do You Want To Continue? Type Yes ot No");
		
		}
	while(sc.next().equalsIgnoreCase("yes"));
		
	
	}
}



