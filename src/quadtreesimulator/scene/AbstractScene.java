package quadtreesimulator.scene;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractScene {

	protected Canvas canvasNode;
	protected Map<String, Object> options;

	public AbstractScene() {
		options = new HashMap<String, Object>();
		addOption("displayFPS", new SimpleBooleanProperty( false));
	}

	public void setCanvas(Canvas canvas) {
			
	}

	public Canvas getCanvas() {

		return null;
	}

	public double w() {

		return canvasNode.getWidth();
	}

	public double h() {

		return canvasNode.getHeight();
	}
	
	public GraphicsContext gc() {
		
		return canvasNode.getGraphicsContext2D();
	}

	public void addOption(String UniqueName, Object option) {
		// TODO Auto-generated method stub
		if (options.containsKey(UniqueName)) {
			throw new IllegalStateException("UniqueName already exists");
		}
	}

	public Object getOption(String UniqueName) {
		// TODO Auto-generated method stub
		return UniqueName;
	}

	public AbstractScene createScene() {
		return null;

	}

}
