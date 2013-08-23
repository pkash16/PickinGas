package com.pickin.gas.libgdx.game.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
import com.pickin.gas.libgdx.game.Models.Gas;
import com.pickin.gas.libgdx.game.Models.Ship;
import com.pickin.gas.libgdx.game.Screens.GameScreen;

public class World {

	PickinGas game;
	Ship ship;
	Gas gas;
	SpriteBatch batch;
	Stage stage;
	TextButton button;
	TextButtonStyle buttonStyle;
	BitmapFont font;
	TextureAtlas buttonatlas;
	Skin buttonskin;

	public World(PickinGas game) {
		this.game = game;
		ship = new Ship(32, 32, 0, 0, 0);
		ship.makeSprite(new Texture("data/pictures/objects/ship.png"));
		gas = new Gas(32, 32, 0, 0, 0);
		gas.makeSprite(new Texture("data/pictures/objects/gas.png"));
		gas.newGas();

		batch = new SpriteBatch();
		ship.setGas(1000);
		Gdx.input.setInputProcessor(new InputHandler(this));
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true, batch);
		font = new BitmapFont(
				Gdx.files.internal("data/fonts/blackFont/font.fnt"), false);
		buttonStyle = new TextButtonStyle();
		buttonatlas = new TextureAtlas("data/pictures/9pngs/button/button.pack");
		buttonskin = new Skin(buttonatlas);
		buttonStyle.up = buttonskin.getDrawable("button");
		buttonStyle.down = buttonskin.getDrawable("buttoninvert");
		buttonStyle.pressedOffsetX = 1;
		buttonStyle.pressedOffsetY = -1;
		buttonStyle.font = font;
	}

	// Rendering
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.app.log(game.LOG, String.valueOf(ship.gas));
		batch.begin();
		ship.draw(batch);
		gas.draw(batch);
		batch.end();
		if (ship.gas < 0) {
			Gdx.input.setInputProcessor(stage);
			stageDraw();
		}

	}

	// Logic
	public void update() {

		if (ship.getBounds().overlaps(gas.getBounds())) {
			ship.setGas(ship.getGas() + 50);
			gas.newGas();
		}

		ship.update();
		gas.update();
		if (ship.gas < 250) {
			PickinGasAudio.StopSound();
			if (PickinGasAudio.isPlayingSoundEvil() == false) {
				PickinGasAudio.PlaySoundEvil(true);
			}
		} else {
			PickinGasAudio.StopSoundEvil();
			if (PickinGasAudio.isPlayingSound() == false) {
				PickinGasAudio.PlaySound(true);
			}
		}
	}

	public void dispose() {
		ship.dispose();
		batch.dispose();
		gas.dispose();
		stage.dispose();
		buttonatlas.dispose();
		font.dispose();
		buttonskin.dispose();
	}

	public void stageDraw() {
		button = new TextButton("You ran out of Gas! Click me to restart",
				buttonStyle);
		button.setWidth(600);
		button.setHeight(100);
		button.setX(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2);
		button.setY(Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);
		button.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new GameScreen(game));
				super.clicked(event, x, y);
			}
			
		});
		stage.addActor(button);
		stage.act();
		stage.draw();
	}

}
