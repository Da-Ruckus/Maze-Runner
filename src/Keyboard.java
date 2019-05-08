import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard {
	
	

boolean up = false;
boolean down = false;
boolean left = false;
boolean right = false;



boolean a = false;
boolean d = false;

	public void KeyboardInput(KeyEvent key, GraphicsContext gc) {
		if (key.getEventType() == KeyEvent.KEY_PRESSED) {

			if (key.getCode() == KeyCode.ESCAPE) {
				System.exit(0);
			}

			

			if (key.getCode() == KeyCode.A) {
				a = true;
			}

			if (key.getCode() == KeyCode.D) {
				d = true;
			}
			
			
			if (key.getCode() == KeyCode.UP) {
				up = true;
			}
	
			if (key.getCode() == KeyCode.DOWN) {
				System.out.println(1);

				down = true;
			}
			
			if (key.getCode() == KeyCode.LEFT) {
				left = true;
			}

			if (key.getCode() == KeyCode.RIGHT) {
				right = true;
			}
			
		}
		if (key.getEventType() == KeyEvent.KEY_RELEASED) {

			
			if (key.getCode() == KeyCode.A) {
				a = false;
			}

			if (key.getCode() == KeyCode.D) {
				d = false;
			}
			

			if (key.getCode() == KeyCode.UP) {
				up = false;
			}

			if (key.getCode() == KeyCode.DOWN) {
				down = false;
			}
			if (key.getCode() == KeyCode.LEFT) {
				left = false;
			}

			if (key.getCode() == KeyCode.RIGHT) {
				right = false;
			}
			
			
			

		}
	}	

}
