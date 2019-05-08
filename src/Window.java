import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {
	Color color2 = Color.RED;	

	@Override
	public void start(Stage stage) throws Exception {
		
		Canvas canvas = new Canvas(300, 300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		BorderPane game = new BorderPane();
		game.setCenter(canvas);

		Scene scene = new Scene(game, 400, 400, Color.BLACK);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> this.key.KeyboardInput(key, gc));
		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> this.key.KeyboardInput(key, gc));
		stage.setScene(scene);
		stage.setTitle("Maze Runner");
		stage.show();

		player.controllable = true;
		key.up = false;
		//animatedrect.controllable2 = true;
		new AnimationTimer() {

			@Override
			public void handle(long now) {

				gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

				player.update(key,gc);
				
				Iterator<Rectangle> rect2Iter = rect.iterator();
				while (rect2Iter.hasNext()) {
					Rectangle rect3= rect2Iter.next();
					
					double playerX1 = player.getRectX() - 5;
					double playerY1 = player.getRectY() - 5;

					double playerX2 = player.getRectX() + 5;
					double playerY2 = player.getRectY() + 5;

					double barriersX1 = rect3.getRectX() - rect3.width / 2;
					double barriersY1 = rect3.getRectY() - rect3.height / 2;

					double barriersX2 = rect3.getRectX() + rect3.width / 2;
					double barriersY2 = rect3.getRectY() + rect3.height / 2;
				
				
					if (playerX2 >= barriersX1 && playerY2 >= barriersY1 && barriersX2 >= playerX1 && barriersY2 >= playerY1) {
						
						if(key.up) {
						player.setRectY(player.getRectY()+1);
						key.up=false;
						
						}
						
						if(key.down) {
							player.setRectY(player.getRectY()-1);
							key.down=false;
							
							}
						
						
						if(key.right) {
							player.setRectX(player.getRectX()-1);
							key.right=false;
							
							}
						
						if(key.left) {
							player.setRectX(player.getRectX()+1);
							key.left=false;
							
							}
						
						
					}
				}
				
				player.draw2(gc);
				
				Iterator<Rectangle> rectIter = rect.iterator();
				while (rectIter.hasNext()) {
					rectIter.next().frame(key, gc);
				}

		/*		Iterator<Shape> iter = shape.iterator();
				while (iter.hasNext()) {
					Shape temp = iter.next();
					temp.update(key,gc);
					temp.draw(gc);

							}
*/
			//	if (bulletX2 >= shipX1 && bulletY2 >= shipY1 && shipX2 >= bulletX1 && shipY2 >= bulletY1) {
			//		iter5.remove();
			//	}
				
		//		if () {
		//			iter5.remove();
		//		}
				
				
			}

		}.start();

	}


	Circle circle = new Circle();
	Keyboard key = new Keyboard();//X ,  Y ,  
	Rectangle player = new Rectangle(10, 10, 10, 10);//
	
	List<Shape> shape = new ArrayList<Shape>();

	public void init() {
		
		rect.add (new Rectangle(0, 0, 600, 5));
		rect.add (new Rectangle(300, 0, 5, 500 ));
		
		rect.add (new Rectangle(100, 275, 400, 5 ));
		rect.add (new Rectangle(0, 150, 5, 250));
										
		//( X , Y ,length, width)
		rect.add (new Rectangle(100, 25, 310,5 ));
		
		rect.add (new Rectangle(175, 50, 250,5 ));
		
		rect.add (new Rectangle(100, 75, 310,5 ));
		
		rect.add (new Rectangle(175, 100, 250,5 ));

		rect.add (new Rectangle(100, 125, 310,5 ));
		
		rect.add (new Rectangle(175, 150, 250,5 ));

		rect.add (new Rectangle(100, 175, 310,5 ));
		
		rect.add (new Rectangle(175, 200, 250,5 ));

		rect.add (new Rectangle(100, 225, 310,5 ));
		
		rect.add (new Rectangle(175, 250, 250,5 ));
		
	}

	List<Rectangle> rect = new ArrayList<Rectangle>();
	
}
