package br.com.piano.game;

import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class KeyInputProcessor implements InputProcessor {
	private Key touched;
	private List<Key> keys;
	private ShapeRenderer shape;

	public KeyInputProcessor(List<Key> keys, ShapeRenderer shape) {
		this.keys = keys;
		this.shape = shape;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Key touched = null;
		for (Key key : keys) {
			touched = key;
			if (touched.isInside(screenX, screenY)) {
				touched.defaultValues();
			}
		}
		if (touched != null) {
			touched.draw(shape);
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touched = null;
		for (Key key : keys) {
			if (key.isInside(screenX, screenY)) {
				key.setColor(Color.RED).setShapeType(ShapeType.Filled);
				if(touched == null){
					touched = key;
				} else if(!touched.isUp(key.z())) {
					this.touched.defaultValues();
					this.touched = key;
				}
			}
		}
		if (this.touched != null) {
			touched.draw(shape);
		}
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}
}
