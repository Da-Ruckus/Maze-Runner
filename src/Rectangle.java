import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
	Color color = Color.BLUE;
	Color color2 = Color.RED;
	int height = 100;
	int width = 100;
	double degrees = 0;
	boolean rotate = false;
	boolean controllable = false;
	boolean controllable2 = false;
	private int rectY = 50;
	private int rectX = 50;

	public Rectangle(int X, int Y, int width, int height/* ,Color color*/) {
		this.height = height;
		this.width = width;

		setRectX(X);
		setRectY(Y);
	}

	public void frame(Keyboard key, GraphicsContext gc) {
		update(key,gc);
		draw(gc);
	}
	
	public int getRectY() {
		return rectY + height / 2;
	}

	public void setRectY(int rectY) {
		this.rectY = rectY - height / 2;
	}

	public int getRectX() {
		return rectX + width / 2;
	}

	public void setRectX(int rectX) {
		this.rectX = rectX - width / 2;
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(color);
		
		gc.save();
		gc.translate(getRectX(), getRectY());
		gc.setFill(color);
		
		gc.rotate(degrees);
		gc.fillRect(0 - width / 2, 0 - height / 2, width, height);
		gc.translate(-getRectX(), -getRectY());
		gc.restore();

	}

	public void draw2(GraphicsContext gc) {
		gc.setFill(color2);
		
		gc.save();
		gc.translate(getRectX(), getRectY());
		gc.setFill(color2);
		
		gc.rotate(degrees);
		gc.fillRect(0 - width / 2, 0 - height / 2, width, height);
		gc.translate(-getRectX(), -getRectY());
		gc.restore();

	}
	
	@Override
	public boolean collision(Shape a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Keyboard key,GraphicsContext gc) {
		
		if(rotate) 
		{
			degrees++;
				
		}
		if(controllable )
		{
			if (key.up) {
				setRectY(getRectY() - 1);
			}
			if (key.down) {
			setRectY(getRectY() + 1);

			}
			if (key.left) {
				setRectX(getRectX() - 1);
			}
			if (key.right) {
				setRectX(getRectX() + 1);
					}
	
		}
		if(controllable)
		{
			
		
			if (key.a) {
				setRectX(getRectX() - 1);
			}
			if (key.d) {
				setRectX(getRectX() + 1);
			}

			
		}
		
	}
}

