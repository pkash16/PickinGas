package com.pickin.gas.libgdx.game.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class PickinGasAudio {

	public static Music soundEvil = Gdx.audio.newMusic(Gdx.files
			.internal("data/audio/songevil.wav"));
	public static Music sound = Gdx.audio.newMusic(Gdx.files
			.internal("data/audio/song.wav"));

	public static void PlaySound(boolean isLooping) {
		sound.setLooping(isLooping);
		sound.play();
	}

	public static void StopSound() {
		sound.stop();
	}

	public static void DisposeSound() {
		sound.dispose();
	}

	public static void PlaySoundEvil(boolean isLooping) {
		soundEvil.setLooping(isLooping);
		soundEvil.play();
	}

	public static void StopSoundEvil() {
		soundEvil.stop();
	}

	public static void DisposeSoundEvil() {
		soundEvil.dispose();
	}

	public static void DisposeAll() {
		sound.dispose();
		soundEvil.dispose();
	}

	public static void PauseAll() {
		sound.pause();
		soundEvil.pause();
	}

	public static boolean isPlayingSound() {
		if (sound.isPlaying()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPlayingSoundEvil() {
		if (soundEvil.isPlaying()) {
			return true;
		} else {
			return false;
		}
	}

}
