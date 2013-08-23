package com.pickin.gas.libgdx.game.Models;

import com.badlogic.gdx.Gdx;

public class Ship extends MovableCollisionObject {

	public int gas;
	public float gasCounter;
	
	public Ship(float width, float height, float x, float y, float rotation) {
		super(width, height, x, y, rotation);
		gas = 1000;
		gasCounter = 0;
	}
	
	public void update(){
		position.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime() * speed));
		objectSprite.setOrigin(objectSprite.getWidth() / 2, objectSprite.getHeight() / 2);
		if (velocity.x != 0 || velocity.y != 0) {
			rotation = velocity.angle() - 90;
		}
		gas += gasCounter;
		super.update();
	}

	/**
	 * @return the gas
	 */
	public int getGas() {
		return gas;
	}

	/**
	 * @param gas the gas to set
	 */
	public void setGas(int gas) {
		this.gas = gas;
	}

	/**
	 * @return the gasCounter
	 */
	public float getGasCounter() {
		return gasCounter;
	}

	/**
	 * @param gasCounter the gasCounter to set
	 */
	public void setGasCounter(float gasCounter) {
		this.gasCounter = gasCounter;
	}
	
	

}
