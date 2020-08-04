package com.cg.Team;

import com.cg.player.Player;

public class Team {
	
	private String name;
	private Player player;
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
	public Team() {
		super();
		}
	
	public Team(String name,Player player) {
		super();
		this.name=name;
		this.player=player;
	}
	
	
	@Override
	public String toString() {
		return String.format("Team [Name=%s, Player=%s]", name, player);
	}
}
