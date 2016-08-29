package com.mygdx.helpers;

import java.util.Random;

import com.mygdx.enums.States;
import com.mygdx.gameobjects.Ball;
import com.mygdx.gameobjects.Paddle;

public class AI {
	private Ball ball;
	private Paddle paddle;
	private Random randomGenerator;
	private States state;
	
	public AI(Ball ball, Paddle paddle)
	{
		this.ball = ball;
		this.paddle = paddle;
		randomGenerator = new Random();
		state = States.Ok;
	}
	
	public void update()
	{ 
		if(state == States.Ok && randomGenerator.nextDouble() < 0.2)
		{
			
			if(ball.getY() < paddle.getPaddleRectangle().getY()  + paddle.getPaddleRectangle().getHeight()/2)
			{
				paddle.moveUp();
			}
			else if(ball.getY() > paddle.getPaddleRectangle().getY() + paddle.getPaddleRectangle().getHeight()/2)
			{
				paddle.moveDown();
			}
		}
	}
	
	public void stop()
	{
		paddle.moveStop();
		state = States.Stop;
	}

}
