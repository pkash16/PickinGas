package com.pickin.gas.libgdx.game.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pickin.gas.libgdx.game.PickinGas;
import com.pickin.gas.libgdx.game.TweenAccessors.SpriteTween;

public class SplashScreen implements Screen {

	PickinGas game;
	Texture splashTexture;
	Sprite splashSprite;
	SpriteBatch batch;
	TweenManager manager;
	TweenCallback cb;

	public SplashScreen(PickinGas game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		manager.update(delta);
		batch.begin();
		splashSprite.draw(batch);
		batch.end();

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		manager = new TweenManager();
		splashTexture = new Texture("data/pictures/splashscreen.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		splashSprite = new Sprite(splashTexture);
		splashSprite.setX(Gdx.graphics.getWidth() / 2 - splashSprite.getWidth()
				/ 2);
		splashSprite.setY(Gdx.graphics.getHeight() / 2
				- splashSprite.getHeight() / 2);
		splashSprite.setColor(1, 1, 1, 0);
		batch = new SpriteBatch();
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		cb = new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				game.setScreen(new MainMenu(game));
				Gdx.app.log(game.LOG, "tweencallback");

			}
		};
		Tween.to(splashSprite, SpriteTween.ALPHA, 2.5f).target(1)
				.repeatYoyo(1, 0).ease(TweenEquations.easeOutQuad)
				.setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
				.start(manager);

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
		splashTexture.dispose();
		batch.dispose();
	}

}
