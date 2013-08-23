package com.pickin.gas.libgdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.pickin.gas.libgdx.game.PickinGas;
import com.pickin.gas.libgdx.game.Background.World;

public class GameScreen implements Screen {

	PickinGas game;
	World world;

	public GameScreen(PickinGas game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		world.update();
		world.render();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		world = new World(game);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		world.dispose();
	}

}
