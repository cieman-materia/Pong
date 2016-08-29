package enums;

public enum Player {
	LeftPlayer(-1), Nobody(0), RightPlayer(1);
	
	private final int player;
	
	Player(int player)
	{
		this.player = player;
	}
	
	public int getPlayerNumber () {
		return player;
	}
}
