package com.mygdx.pong;

import com.badlogic.gdx.Game;
import com.mygdx.screens.GameScreen;

public class Pong extends Game {
	
	@Override
	public void create () {
		this.screen = new GameScreen(this);
	}
	
}
