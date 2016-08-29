package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.mygdx.gameobjects.Ball;
import com.mygdx.gameobjects.Paddle;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import enums.Player;
import helpers.AI;

public class GameWorld {
	
	private Ball ball;
	private Paddle paddleLeft;
	private Paddle paddleRight;
	private int worldHight, worldWidth;
	private int pointsLeft, pointsRight;
	private AI ai;
	
	public GameWorld()
	{
		worldWidth = Gdx.graphics.getWidth();
		worldHight = Gdx.graphics.getHeight();
		
		ball = new Ball(new Circle(worldWidth/2, worldHight/2, 10),worldWidth, worldHight);
		
		paddleLeft = new Paddle(new Rectangle(0, worldHight/2 - 70/2, 25, 70), Player.LeftPlayer, 250, worldHight);
		paddleRight = new Paddle(new Rectangle(worldWidth - 25, worldHight/2 - 70/2, 25, 70), Player.RightPlayer, 250, worldHight);
		
		pointsLeft = 0;
		pointsRight = 0;
		
		ai = new AI(ball, paddleRight);
	}
	
	public void update(float delta)
	{		
		ai.update();
		
		paddleLeft.update(delta);
		paddleRight.update(delta);
		
		ball.update(delta);
		
		ball.colides(paddleLeft, paddleRight);
		
		if(ball.getWinner() == Player.LeftPlayer)
		{
			pointsLeft++;
			if(pointsLeft < 5)
			{
				ball.reset(Player.RightPlayer);
			}
			else
			{
				ball.reset(Player.RightPlayer);
				ball.stop();
				ai.stop();
			}
		}
		else if(ball.getWinner() == Player.RightPlayer)
		{
			pointsRight++;
			if(pointsRight < 5)
			{
				ball.reset(Player.LeftPlayer);
			}
			else
			{
				ball.reset(Player.LeftPlayer);
				ball.stop();
				ai.stop();
			}
		}
		
	}
	
	public Ball getBall()
	{
		return ball;
	}

	public Paddle getPaddleLeft()
	{
		return paddleLeft;
	}
	
	public Paddle getPaddleRight()
	{
		return paddleRight;
	}
	
	public int getLeftPonts()
	{
		return pointsLeft;
	}
	
	public int getRightPonts()
	{
		return pointsRight;
	}
}
