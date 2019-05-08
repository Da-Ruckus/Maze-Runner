import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {

	boolean down = false;
	boolean up = false;
	boolean left = false;
	boolean right = false;
	
	int Y = 150;
	int X = 150;
	
	int i = 0;
	int j = 0;
	
	
	
	public Circle (  ) {
		
		// Initial ball direction
		
		if (number == 1 && number != 2) {
			down=true;
		}

		else {
			up = true;
			}

		if (number == 3 && number != 4) {
			right=true;
			}

		else {
			left=true;
			 }

		
	}
	
	
	
	

	Random generator = new Random();
	int number = generator.nextInt(4) + 1;

	
	//@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

		gc.setFill(color.RED);
		gc.fillRoundRect(X, Y, 20, 20, 20, 20);

	}

	//@Override
	public boolean collision(Shape a) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public void update(Keyboard key,GraphicsContext gc) {

	 int width =(int) gc.getCanvas().getWidth();
		
	 int height= (int) gc.getCanvas().getHeight();
		
	//	System.out.println(number);

	
		// Update
		if (down == true) {
			Y++;
			}

		else {
			up = true;
			Y--;
		}

		if (left==true) {
			X--;
		}

		else {
			right = true;
			X++;
		}
	
		
		// collision
		
		if(Y <= 0 ) {
			down=true;
			up=false;
		}
		if(Y >= height ) {
			down=false;
			up=true;
		}
		
		if( X <= 0 ) {
			right=true;
			left=false;
		}
		
		if(X >= width ) {
			right=false;
			left=true;
		}
	
	
		
		
		
		
	}


}
