package com.cg.Team;


import com.cg.player.Player;

public class TeamBO {

	
	public Team createTeam(String data, Player[] playerList) {
		Team team = new Team();
		String[] teamInformation= data.split(",");
		team.setName(teamInformation[0]);
		for(Player player : playerList) {
			if(player.getName().equalsIgnoreCase(teamInformation[1])) {
				team.setPlayer(player);
			}
		}
		return team;
		
	
		
	}
}
