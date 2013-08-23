package com.pickin.gas.libgdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.pickin.gas.libgdx.game.Background.PickinGasAudio;
import com.pickin.gas.libgdx.game.Screens.SplashScreen;

public class PickinGas extends Game {
	public final static String VERSION = "0.01 Pre Alpha";
	public final String LOG = "Game";
	public FPSLogger log;

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
		log = new FPSLogger();
	}

	@Override
	public void dispose() {
		PickinGasAudio.DisposeAll();
		super.dispose();
	}

	@Override
	public void render() {
		// log.log();
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
