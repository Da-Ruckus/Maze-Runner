
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

	Color color;
	
	int x;
	int y;
	
	public abstract void draw(GraphicsContext gc);
	
	public abstract boolean collision(Shape a);
	
	public abstract void update(Keyboard key,GraphicsContext gc);

	
}
