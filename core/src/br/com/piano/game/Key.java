package br.com.piano.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Key {
	private int z;
	private float x;
	private float y;
	private float sizeX;
	private float sizeY;
	private Color color;
	private ShapeType shapeType;
	private Rectangle rectangle;
	private ShapeType defaultShape;
	private Color defaultColor;

	public Key(float x, float y, float sizeX, float sizeY, int z) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.z = z;
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
		if (this.defaultColor == null) {
			this.defaultColor = this.color;
		}
		return this;
	}

	public Key setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
		if (this.defaultShape == null) {
			this.defaultShape = shapeType;
		}
		return this;
	}

	public boolean isInside(float x, float y) {
		return rectangle.contains(new Vector2(x, y));
	}

	public Key defaultValues() {
		this.shapeType = this.defaultShape;
		this.color = this.defaultColor;
		return this;
	}

	public int z() {
		return this.z;
	}

	public boolean isUp(int z) {
		return z < this.z;
	}

	@Override
	public String toString() {
		return "Key [ x1:" + rectangle.getX() + ", x2:" + (rectangle.getX() + rectangle.getWidth()) + ", y1:"
				+ rectangle.getY() + ", y2:" + (rectangle.getY() + rectangle.getHeight()) + "]";
	}

}