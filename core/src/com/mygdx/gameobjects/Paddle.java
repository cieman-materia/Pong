package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.enums.Player;

public class Paddle {
	
	private Rectangle paddleRectangle;
	private Player owner;
	private float velocity;
	private float paddleVelocity;
	private int gameHeight;
	
	public Paddle(Rectangle rectangle, Player owner, float velocity, int gameHeight)
	{
		this.paddleRectangle = rectangle;
		this.owner = owner;
		this.velocity = velocity;
		paddleVelocity = 0;
		
		this.gameHeight = gameHeight;
	}
	
	public void update(float delta)
	{
		paddleRectangle.y += paddleVelocity * delta;
		
		if(paddleRectangle.y <= 0)
		{
			paddleRectangle.y = 0;
		}
		
		if(paddleRectangle.y + paddleRectangle.height >= gameHeight)
		{
			paddleRectangle.y = gameHeight - paddleRectangle.height;
		}
	}
	
	public void moveUp()
	{

		paddleVelocity = -velocity;
	}
	
	public void moveDown()
	{

		paddleVelocity = velocity;
	}
	
	public void moveStop()
	{

		paddleVelocity = 0;
	}
	
	public Rectangle getPaddleRectangle() 
	{
		return paddleRectangle;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	

}
