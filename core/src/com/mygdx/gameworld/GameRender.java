package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameRender {
	
	private GameWorld gameWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private int gameWidth, gameHeight;
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	
	public GameRender(GameWorld gameWorld, int gameWidth, int gameHeight)
	{
		this.gameWorld = gameWorld;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true,gameWidth,gameHeight);
		
		shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        spriteBatch = new SpriteBatch();  
        //spriteBatch.setProjectionMatrix(cam.combined);
        font = new BitmapFont();
        font.setColor(Color.WHITE);
	}
	
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		
        shapeRenderer.begin(ShapeType.Filled);
        
        shapeRenderer.setColor(Color.DARK_GRAY);
        shapeRenderer.rect(0, 0, gameWidth, gameHeight);
        
        shapeRenderer.end();
        
        
        spriteBatch.begin();
        
        font.draw(spriteBatch, gameWorld.getLeftPonts() + "", gameWidth/4, gameHeight/2);
        font.draw(spriteBatch, gameWorld.getRightPonts() + "", gameWidth / 4 * 3, gameHeight/2);
        
        spriteBatch.end();
        
        
        shapeRenderer.begin(ShapeType.Filled);
        
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(gameWidth/2 - 2, 0, 4, gameHeight);
        
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(gameWorld.getBall().getX(), gameWorld.getBall().getY(), gameWorld.getBall().getRadius());
        
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(gameWorld.getPaddleLeft().getPaddleRectangle().x, gameWorld.getPaddleLeft().getPaddleRectangle().y, gameWorld.getPaddleLeft().getPaddleRectangle().width, gameWorld.getPaddleLeft().getPaddleRectangle().height);
        shapeRenderer.rect(gameWorld.getPaddleRight().getPaddleRectangle().x, gameWorld.getPaddleRight().getPaddleRectangle().y, gameWorld.getPaddleRight().getPaddleRectangle().width, gameWorld.getPaddleRight().getPaddleRectangle().height);
        
        shapeRenderer.end();
        
	}
}
