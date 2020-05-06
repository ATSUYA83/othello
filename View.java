package ocelo;

public class View {
	public static void show(Bord bord) {
		System.out.print("  ");
		for(int y=1;y<bord.getY()+1 ; y++) {
			System.out.printf("%4d",y);
		}
		for(int x=1;x<bord.getX()+1 ; x++) {
			System.out.println();
			System.out.printf("%3d",x);
			for(int y=1;y<bord.getY()+1 ;y++) {
				System.out.print(" "+bord.getState(x,y)+" ");
			}
		}
		System.out.println(" ");

	}

}
