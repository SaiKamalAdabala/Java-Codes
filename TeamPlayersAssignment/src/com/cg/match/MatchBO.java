package com.cg.match;


import com.cg.Team.Team;

public class MatchBO {
	
	
	private Team findteam(String team, Team[] teamList) {
		for(Team team1 : teamList) {
			if(team1.getName().equalsIgnoreCase(team)) {
				
				return team1;
			}
		}
		
		return null;
	}
	//create match method
	public Match createMatch(String info,Team[] teamList) {
		String[] matchInfo = info.split(",");
		Match match = new Match();
		match.setDate(matchInfo[0]);
		System.out.println(matchInfo[1]+" "+matchInfo[2]);
		Team t1 = findteam(matchInfo[1], teamList);
		Team t2 = findteam(matchInfo[2], teamList);
		
		match.setTeamone(t1);
		match.setTeamtwo(t2);
		match.setVenue(matchInfo[3]);
		return match;	
	}
	
	
	//find team method
	public Team[] findTeam(String matchDate,Match[] matchList) {
		Team[] team2 =new Team[2];//= new Team();
		for(Match m : matchList) {
			if(m.getDate().equals(matchDate)) {
				team2[0]=m.getTeamone();
				team2[1]=m.getTeamtwo();
				
				return team2;
			}
		}
		return team2;		
	}
	
	
	//findAllMatches method
	
	public void findAllMatchesOfTeam(String teamName, Match[] matchesList) {
		for(Match m : matchesList) {
			if(m.getTeamone().getName().equalsIgnoreCase(teamName) || m.getTeamtwo().getName().equalsIgnoreCase(teamName)) {
				System.out.println(m);
			}
		}
	}

	

}
