package com.mygdx.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.gameworld.GameRender;
import com.mygdx.gameworld.GameWorld;
import com.mygdx.helpers.InputHandler;

public class GameScreen implements Screen {
	
	private Game game;
	private GameWorld gameWorld;
	private GameRender gameRender;
	
	public GameScreen(Game game) {
		this.game = game;
		gameWorld = new GameWorld();
		gameRender = new GameRender(gameWorld, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(new InputHandler(gameWorld.getPaddleLeft()));
		
	}
	
	@Override
	public void render(float delta) {
		//Gdx.app.log("GameScreen FPS", (1/delta) + "");
		gameWorld.update(delta);
		gameRender.render();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
