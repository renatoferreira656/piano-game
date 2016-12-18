package br.com.piano.game;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PianoGame extends ApplicationAdapter {
	
	private ShapeRenderer shape;
	private List<Key> keys;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		keys = new ArrayList<Key>();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		int qtd = 8;
		float space = 10;
		float width = ((Gdx.graphics.getWidth() - (qtd * (space + 3))) / qtd );
		float height = Gdx.graphics.getHeight() - 30;
		float widthBlack = (width / 2);
		if(keys.isEmpty()){
			for(float i = space; i+width <= Gdx.graphics.getWidth(); i= i+width){
				keys.add(new Key(i, space, width, height).setColor(Color.BLACK).setShapeType(ShapeType.Line));
				i=i+space;
			}
			
			int third = 0;
			
			for(float i = space + widthBlack + (widthBlack / 2) + 3; i+width <= Gdx.graphics.getWidth(); i= i+width){
				if(third != 2){
					keys.add(new Key(i, space + (height * 1 / 4), widthBlack, (height * 3 / 4)).setColor(Color.BLACK).setShapeType(ShapeType.Filled));
				}
				i=i+space;
				third++;
			}
		}
		
		for (Key key : keys) {
			key.draw(shape);
		}
		
		Gdx.input.setInputProcessor(getInputProcessor());
		
	}

	private InputProcessor getInputProcessor() {
		return new InputProcessor() {
			
			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				for (Key key : keys) {
					if (key.isInside(screenX, screenX)){
						key.setColor(Color.BLACK).defaultValues().draw(shape);
					}
				}
				return false;
			}
			
			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}
			
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				for (Key key : keys) {
					if (key.isInside(screenX, screenX)){
						key.setColor(Color.RED).setShapeType(ShapeType.Filled).draw(shape);
					}
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
		};
	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
