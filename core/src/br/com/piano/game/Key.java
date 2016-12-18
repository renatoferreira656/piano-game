package br.com.piano.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Key {
	private float x;
	private float y;
	private float sizeX;
	private float sizeY;
	private Color color;
	private ShapeType shapeType;
	private Rectangle rectangle;
	private ShapeType defaultShape;

	public Key(float x, float y, float sizeX, float sizeY){
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		rectangle = new Rectangle(x, y, sizeX, sizeY);
	}
	
	public void draw(ShapeRenderer shape) {
		shape.begin(shapeType);
		shape.setColor(color);
		shape.rect(x, y, sizeX, sizeY);
		shape.end();
	}

	public Key setColor(Color color) {
		this.color = color;
		return this;
	}
	
	public Key setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
		if(this.defaultShape == null){
			this.defaultShape = shapeType;
		}
		return this;
	}
	public boolean isInside(float x, float y){
		return rectangle.contains(new Vector2(x, y));
	}
	
	public Key defaultValues(){
		this.shapeType = this.defaultShape;
		return this;
	}
}