package com.pickin.gas.libgdx.game.Background;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.pickin.gas.libgdx.game.Screens.MainMenu;

public class InputHandler implements InputProcessor {
	World world;

	public InputHandler(World world) {
		this.world = world;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {

		case Keys.W:
			world.ship.getVelocity().y = 1;
			world.ship.setGasCounter(-1);
			break;
		case Keys.S:
			world.ship.getVelocity().y = -1;
			world.ship.setGasCounter(-1);
			break;
		case Keys.A:
			world.ship.getVelocity().x = -1;
			world.ship.setGasCounter(-1);
			break;
		case Keys.D:
			world.ship.getVelocity().x = 1;
			world.ship.setGasCounter(-1);
			break;
		case Keys.ESCAPE:
			world.game.setScreen(new MainMenu(world.game));
		default:
			break;

		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {

		case Keys.W:
			if (world.ship.getVelocity().y == 1) {
				world.ship.getVelocity().y = 0;
				world.ship.setGasCounter(0);
			}
			break;
		case Keys.S:
			if (world.ship.getVelocity().y == -1) {
				world.ship.getVelocity().y = 0;
				world.ship.setGasCounter(0);
			}
			break;
		case Keys.A:
			if (world.ship.getVelocity().x == -1) {
				world.ship.getVelocity().x = 0;
				world.ship.setGasCounter(0);
			}
			break;
		case Keys.D:
			if (world.ship.getVelocity().x == 1) {
				world.ship.getVelocity().x = 0;
				world.ship.setGasCounter(0);
			}
			break;
		default:
			break;

		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		world.ship.setVelocity(new Vector2(0, 0));
		world.ship.setGasCounter(0);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		world.ship.velocity.lerp(new Vector2(screenX
				- (Gdx.graphics.getWidth() / 2), (Gdx.graphics.getHeight() / 2)
				- screenY), Gdx.graphics.getDeltaTime() / 15);
		world.ship.setGasCounter(-1);
		return true;
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
