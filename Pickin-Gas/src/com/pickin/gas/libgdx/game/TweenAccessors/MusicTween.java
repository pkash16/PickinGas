package com.pickin.gas.libgdx.game.TweenAccessors;

import com.badlogic.gdx.audio.Music;

import aurelienribon.tweenengine.TweenAccessor;

public class MusicTween implements TweenAccessor<Music> {

	public static final int VOLUME = 0;

	@Override
	public int getValues(Music target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case VOLUME:
			returnValues[0] = target.getVolume();
			return 1;
		default:
			return 0;
		}
	}

	@Override
	public void setValues(Music target, int tweenType, float[] newValues) {
		switch( tweenType ){
		case VOLUME:
			target.setVolume(newValues[0]);
			break;
		default:
			break;
		}

	}

}
