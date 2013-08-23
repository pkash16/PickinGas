package com.pickin.gas.libgdx.game.Models;

import java.util.Date;
import java.util.Random;

public class Gas extends MovableCollisionObject {

	Random random;
	
	public Gas(float width, float height, float x, float y, float rotation) {
		super(width, height, x, y, rotation);
		random = new Random(new Date().getTime());
	}
	
	public void newGas(){
		position.x = random.nextInt(608);
		position.y = random.nextInt(448);
		update();
	}
	
	public void update(){
		super.update();
	}
	
}
