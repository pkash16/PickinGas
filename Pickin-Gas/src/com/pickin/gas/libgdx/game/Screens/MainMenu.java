package com.pickin.gas.libgdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pickin.gas.libgdx.game.PickinGas;

public class MainMenu implements Screen {

	Stage stage;
	PickinGas game;
	TextureAtlas buttonatlas;
	Skin buttonskin;
	SpriteBatch batch;
	TextButton button, settings, exit;
	TextButtonStyle buttonStyle;
	BitmapFont font;

	public MainMenu(PickinGas game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		stage = new Stage(width, height, true);
		stage.clear();

		Gdx.input.setInputProcessor(stage);

		buttonStyle.up = buttonskin.getDrawable("button");
		buttonStyle.down = buttonskin.getDrawable("buttoninvert");
		buttonStyle.pressedOffsetX = 1;
		buttonStyle.pressedOffsetY = -1;
		buttonStyle.font = font;

		button = new TextButton("Play!", buttonStyle);
		button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new GameScreen(game));
				super.clicked(event, x, y);
			}
			
		});
		button.setWidth(400);
		button.setHeight(100);
		button.setX(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2);
		button.setY(Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);
		
		settings = new TextButton("Settings", buttonStyle);
		settings.setWidth(400);
		settings.setHeight(50);
		settings.setX(Gdx.graphics.getWidth() / 2 - settings.getWidth() / 2);
		settings.setY(Gdx.graphics.getHeight() / 2 - settings.getHeight() / 2 - 100);
		
		exit = new TextButton("Exit", buttonStyle);
		exit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
				super.clicked(event, x, y);
			}
		});
		exit.setWidth(400);
		exit.setHeight(50);
		exit.setX(Gdx.graphics.getWidth() / 2 - exit.getWidth() / 2);
		exit.setY(Gdx.graphics.getHeight() / 2 - exit.getHeight() / 2 - 175);
		
		stage.addActor(button);
		stage.addActor(settings);
		stage.addActor(exit);

	}

	@Override
	public void show() {
		font = new BitmapFont(
				Gdx.files.internal("data/fonts/blackFont/font.fnt"), false);
		buttonStyle = new TextButtonStyle();
		buttonatlas = new TextureAtlas("data/pictures/9pngs/button/button.pack");
		buttonskin = new Skin(buttonatlas);
		batch = new SpriteBatch();
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
		buttonatlas.dispose();
		buttonskin.dispose();
		batch.dispose();
		font.dispose();
		stage.dispose();
	}

}
