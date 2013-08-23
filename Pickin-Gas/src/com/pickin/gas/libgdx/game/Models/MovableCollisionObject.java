package com.pickin.gas.libgdx.game.Models;

import com.badlogic.gdx.math.Vector2;

public abstract class MovableCollisionObject extends CollisionObject {

	public Vector2 velocity;
	float speed;
	
	public MovableCollisionObject(float width, float height, float x, float y, float rotation) {
		super(width, height, x, y, rotation);
		velocity = new Vector2(0,0);
		speed = 50;
	}
	

	/**
	 * @return the velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}


	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}


	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void update(){
		objectSprite.setX(position.x);
		objectSprite.setY(position.y);
		objectSprite.setRotation(rotation);
		super.update();
	}
	

}
