package br.com.piano.game;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PianoGame extends ApplicationAdapter {
	
	private ShapeRenderer shape;
	private List<Key> keys;
	private KeyInputProcessor processor;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		keys = new ArrayList<Key>();
		processor = new KeyInputProcessor(this.keys, this.shape);
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
				keys.add(new Key(i, space, width, height, 1).setColor(Color.BLACK).setShapeType(ShapeType.Line));
				i=i+space;
			}
			
			int emptyKeys = 0;
			
			for(float i = space + widthBlack + (widthBlack / 2) + 3; i+width <= Gdx.graphics.getWidth(); i= i+width){
				if(emptyKeys != 2 && emptyKeys != 6){
					keys.add(new Key(i, space + (height * 1 / 4), widthBlack, (height * 3 / 4), 2).setColor(Color.BLACK).setShapeType(ShapeType.Filled));
				}
				i=i+space;
				emptyKeys++;
			}
		}
		
		for (Key key : keys) {
			key.draw(shape);
		}
		
		Gdx.input.setInputProcessor(processor);
		
	}

	@Override
	public void dispose () {
		shape.dispose();
	}
}
