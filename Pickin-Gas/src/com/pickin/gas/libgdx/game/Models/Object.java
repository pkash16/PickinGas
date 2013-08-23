package com.pickin.gas.libgdx.game.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {
	public Vector2 position;
	public float width, height, rotation;
	public Texture objectTexture;
	public Sprite objectSprite;

	public Object(float width, float height, float x, float y, float rotation) {
		this.width = width;
		this.height = height;
		this.rotation = rotation;
		position = new Vector2(x, y);
	}

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation
	 *            the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * @return the objectTexture
	 */
	public Texture getObjectTexture() {
		return objectTexture;
	}

	/**
	 * @param objectTexture
	 *            the objectTexture to set
	 */
	public void setObjectTexture(Texture objectTexture) {
		this.objectTexture = objectTexture;
	}

	/**
	 * @return the objectSprite
	 */
	public Sprite getObjectSprite() {
		return objectSprite;
	}

	/**
	 * @param objectSprite
	 *            the objectSprite to set
	 */
	public void setObjectSprite(Sprite objectSprite) {
		this.objectSprite = objectSprite;
		objectSprite.setPosition(position.x, position.y);
		objectSprite.setRotation(rotation);
	}

	public void makeSprite(Texture objectTexture) {
		objectSprite = new Sprite(objectTexture);
		objectSprite.setPosition(position.x, position.y);
		objectSprite.setRotation(rotation);
	}

	public void draw(SpriteBatch batch) {
		objectSprite.draw(batch);
	}

	public void dispose() {
		objectTexture.dispose();
	}

	public void pointAt(int x2, int y2) {
		if (x2 != position.x || y2 != position.y) {
			if (position.x < x2 && position.y < y2) {
				rotation = (float) Math.toDegrees(Math.atan((x2 - position.x)
				/ (y2 - position.y))) + 180;
			} else if (position.x > x2 && position.y < y2) {
				rotation = (float) (180 - Math.toDegrees(Math.atan((position.x - x2)
						/ (y2 - position.y))));
			} else if (position.x < x2 && position.y > y2) {
				rotation = (float) Math.toDegrees(Math.atan((position.y - y2)
						/ (x2 - position.x))) + 270;
			} else if (position.x > x2 && position.y > y2) {
				rotation = (float) (90 - Math.toDegrees(Math.atan((position.y - y2)
						/ (position.x - x2))));

			}
		}
	}

}
