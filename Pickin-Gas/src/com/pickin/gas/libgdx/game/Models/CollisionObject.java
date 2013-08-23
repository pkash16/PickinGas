package com.pickin.gas.libgdx.game.Models;

import com.badlogic.gdx.math.Rectangle;

public abstract class CollisionObject extends Object {

	Rectangle bounds;

	public CollisionObject(float width, float height, float x, float y, float rotation) {
		super(width, height, x, y, rotation);
		bounds = new Rectangle(x,y,width,height);
	}

	/**
	 * @return the bounds
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * @param bounds the bounds to set
	 */
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void update(){
		bounds.width = width;
		bounds.height = height;
		bounds.setX(position.x);
		bounds.setY(position.y);
	}
	
	

}
