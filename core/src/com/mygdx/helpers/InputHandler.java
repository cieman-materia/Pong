package com.mygdx.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.gameobjects.Paddle;

public class InputHandler implements InputProcessor {

    private Paddle playerPaddle;

    public InputHandler(Paddle paddle) {
        playerPaddle = paddle;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	return false;
    }

    @Override
    public boolean keyDown(int keycode) {
    	if(keycode == Keys.UP)
    	{
    		playerPaddle.moveUp();
    		return true;
    	}else if(keycode == Keys.DOWN)
    	{
    		playerPaddle.moveDown();
    		return true;
    	}
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

    	playerPaddle.moveStop();
    	return true;

    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
