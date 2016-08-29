package com.mygdx.gameobjects;

import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.enums.Player;
import com.badlogic.gdx.math.Intersector;

public class Ball {
	
	private final float BALLVELOCITY = 250;
	
	private Circle ball;
	private int gameWidth, gameHeight;
	private Vector2 velocity;
	private float startX, startY;
	private Player winner = Player.Nobody;
	
	private Random randomGenerator = new Random();
	
	public Ball(Circle circle, int gameWidth, int gameHeight)
	{
		ball = circle;
		startX = ball.x;
		startY = ball.y;
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		velocity = new Vector2(0,0);
		
		reset(Math.round(randomGenerator.nextFloat()) == 0 ? BALLVELOCITY : -BALLVELOCITY);
	}
	
	public void update(float delta)
	{
		ball.x += velocity.x * delta;
		ball.y += velocity.y * delta;
		
		checkColision();
	}
	
	private void checkColision()
	{
		if(ball.y - ball.radius <= 0)
		{
			ball.y = ball.radius;
			velocity.y = -velocity.y;
		}
		else if(ball.y + ball.radius >= gameHeight)
		{
			ball.y = gameHeight - ball.radius;
			velocity.y = -velocity.y;
		}
		
		if( ball.x - ball.radius <= 0 )
		{
			ball.x = ball.radius;
			winner = Player.RightPlayer;
		}
		else if(ball.x + ball.radius >= gameWidth )
		{
			ball.x = gameWidth - ball.radius;
			winner = Player.LeftPlayer;
		}
	}
	
	public void colides(Paddle leftPaddle, Paddle rightPaddle)
	{
		if(Intersector.overlaps(ball,leftPaddle.getPaddleRectangle()))
			{				
				velocity.x = -velocity.x;
				ball.x = leftPaddle.getPaddleRectangle().getWidth() + ball.radius;
			}
		else if(Intersector.overlaps(ball,rightPaddle.getPaddleRectangle()))
			{
				velocity.x = -velocity.x;
				ball.x = rightPaddle.getPaddleRectangle().getX() - ball.radius;
			} 
	}
	
	public void reset(Player toPlayer)
	{
		ball.x = startX;
		ball.y = startY;
		
		reset(toPlayer.getPlayerNumber() * BALLVELOCITY);
	}
	
	private void reset(float xVelocity)
	{
		ball.x = startX;
		ball.y = startY;
		velocity.x =  xVelocity;
		velocity.y =  Math.round(randomGenerator.nextFloat()) == 0 ? BALLVELOCITY : -BALLVELOCITY;
		winner = Player.Nobody;
	}
	
	public void stop()
	{
		velocity.set(0,0);
	}
	
	public Player getWinner()
	{
		return winner;
	}
	
	public float getX() {
        return ball.x;
    }

    public float getY() {
        return ball.y;
    }

    public float getRadius() {
        return ball.radius;
    }
    
}
