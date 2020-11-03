package quadtreesimulator.scene;


import java.util.Map;


import javafx.scene.canvas.Canvas;

public abstract class AbstractScene {
	
	protected Canvas canvasNode;
	protected Map <String, Object> options;
	
	public AbstractScene() {
		
	}
	
	public void setCanvas(Canvas canvas) {
		
	}
	
	public void addOption(String UniqueName, Object option) {
		// TODO Auto-generated method stub
		
	}

	public Object getOption(String UniqueName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public AbstractScene createScene() {
		return null;
		
	}

	

}
