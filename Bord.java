package ocelo;

import java.util.Arrays;

public class Bord {
	private int x ;
	private int y ;
	private String state[][]; //三次元にしてターンを記憶させるのもあり
	public Bord(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = new String[x+2][y+2];
		for (int i = 0, len = state.length; i < len; i++)
		    Arrays.fill(state[i], "―");

		this.state[(x/2)][(y/2)]="●";
		this.state[(x/2)][(y/2)+1]="○";
		this.state[(x/2)+1][(y/2)]="○";
		this.state[(x/2)+1][(y/2)+1]="●";

	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getState(int x,int y) {
		return state[x][y];
	}
	public void setState(int x,int y,String state) {
		this.state[x][y] = state;
	}

}
