package ocelo;

import java.util.ArrayList;
import java.util.Random;

public class Cpu {
	public static Bord action(Bord bord,ArrayList<ArrayList<Integer>> cpuSelections,String yourColor,String cpuColor) {
		int selectionSize=cpuSelections.size();
		Random r = new Random();
		ArrayList<Integer> selection=cpuSelections.get(r.nextInt(selectionSize));
		//ボードに打つ
		int x = selection.get(0);
		int y = selection.get(1);
		bord = Rule.reverse(bord, x, y, cpuColor, yourColor);

		return bord;

	}


}
