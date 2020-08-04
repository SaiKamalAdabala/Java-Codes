package com.cg.player;



public final class PlayerBO {

	public Player createPlayer(String data) {
		String[] playerInformation =data.split(",");
		return new Player(playerInformation[0], playerInformation[1], playerInformation[2]);
		
	}
}
