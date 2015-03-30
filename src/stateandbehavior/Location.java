package stateandbehavior;

public class Location {
	int x;
	int y;
	public Location(){
		this.x = 0;
		this.y = 0;
	}
	public void up(){
		this.y--;
	}
	public void down(){
		this.y++;
	}
	public void left(){
		this.x--;
	}
	public void right(){
		this.x++;
	}
	public String toString(){
		return "x:"+x+"	y:"+y;
	}
	public static void main(String[] args) {
		Location loc = new Location();
		System.out.println(loc);
		loc.up();
		System.out.println(loc);
		loc.right();
		System.out.println(loc);
		loc.down();
		System.out.println(loc);
		loc.left();
		System.out.println(loc);
	}

}
