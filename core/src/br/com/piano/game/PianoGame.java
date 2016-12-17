package br.com.piano.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PianoGame extends ApplicationAdapter {
	ShapeRenderer shape;
	private OrthographicCamera cam;
	private FitViewport viewport;
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
	    viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
	    shape = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		int space = 2;
		int qtd = 8;
		float width = ((Gdx.graphics.getWidth() - (qtd * space)) / qtd );
		float height = Gdx.graphics.getHeight() * 3/4;
		float widthBlack = (width / 2);
		shape.begin(ShapeType.Line);
		for(float i = space; i+width <= Gdx.graphics.getWidth(); i= i+width){
			shape.setColor(Color.BLACK);
			shape.rect(i, space, width, height);
			i=i+space;
		}
		
		shape.end();
		shape.begin(ShapeType.Filled);
		for(float i = widthBlack + (widthBlack / 2) + 3; i+width <= Gdx.graphics.getWidth(); i= i+width){
			shape.setColor(Color.BLACK);
			shape.rect(i, space + (height / 2), widthBlack, (height / 2));
			i=i+space;
		}
		
		shape.end();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
