package utility;

public class Node {

	private Node [] children;
	private int depth;
	private double x, y;
	private double width, height;
	private boolean empty;
	
	public Node(int depth, double x, double y, double width, double height) {
		
		this.depth = depth;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		empty = true;
	}
	
	public void push(int[] buffer, int rowSize, int color) {
		
	}
	
	public void clear() {
		
	}
	
	private void divide() {
		
	}
}
