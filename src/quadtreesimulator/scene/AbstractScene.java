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
		options = new HashMap();
		addOption("displayFPS", new SimpleBooleanProperty(false));
	}

	public void setCanvas(Canvas canvas) {         	//   FINISH THIS GUY

	}

	public Canvas getCanvas() {

		return null;
	}

	public double w() {
		double w = canvasNode.getWidth();
		return w;
	}

	public double h() {
		double h = canvasNode.getHeight();
		return h;
	}

	public GraphicsContext gc() {
		GraphicsContext gc = canvasNode.getGraphicsContext2D();
		return gc;
	}

	public void addOption(String UniqueName, Object option) {
		// TODO Auto-generated method stub
		if (options.containsKey(UniqueName)) {
			throw new IllegalStateException("UniqueName already exists");
		}

		options.put(UniqueName, option);
	}

	public Object getOption(String UniqueName) {				 // CHECK IF THIS IS RIGHT
		// TODO Auto-generated method stub
		Object opt = options.get(UniqueName);
		return opt;
	}

	public abstract AbstractScene createScene();

}
