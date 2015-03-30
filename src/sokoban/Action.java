package sokoban;


public class Action {
	private boolean stonePush;
	String direction;
	
	public Action(boolean stonePush, String direction){
		this.stonePush = stonePush;
		this.direction = direction;
	}

	public boolean isStonePush() {
		return stonePush;
	}

	public String getDirection(){
		return direction;
	}
	
	
}
