package ocelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		System.out.println("行数を指定");
        int x = scan.nextInt();
        System.out.println("列数を指定");
        int y = scan.nextInt();

		//盤面の生成
		Bord bord = new Bord(x,y);
		View.show(bord);

		String yourColor="○";
		String cpuColor="●";


		System.out.println("\n先攻後攻を指定\n先攻 => 0\n後攻 => 1");
		int num =scan.nextInt();

		//後攻選択の時cpuに初手を打たせる
		if(num == 1) {
			yourColor="●";
			cpuColor="○";
			ArrayList<ArrayList<Integer>> cpuSelectionsFirst =Rule.passCheck(bord, cpuColor, yourColor);//パスチェック
			bord = Cpu.action(bord, cpuSelectionsFirst,yourColor,cpuColor);//cpuの手番、ボードを返す

			View.show(bord);
	}
		int passCounter=0;

		//終了判定（互いにパスをしたとき）までループ
		while(true) {
			if(passCounter==2) {//ゲーム終了判定
				Rule.judge(bord);
				System.out.println("Finished.");
				break;
			}
			passCounter=0;//パスリセット

			//打てるところがあるかチェック
			ArrayList<ArrayList<Integer>> yourSelections =Rule.passCheck(bord, yourColor, cpuColor);

			//打てるところの表示
			for(int i=0;i<yourSelections.size();i++) {
				System.out.println(yourSelections.get(i));

			}
			//手がないとき自動パス
			if(yourSelections.size()==0) {
				passCounter+=1;
				System.out.println("you took pass.");
			}

			else{
				while(true) {
				System.out.println("あなたの手番\n行を指定");
				int xx = scan.nextInt();
				System.out.println("列を指定");
				int yy = scan.nextInt();
				ArrayList<Integer> num3 = new ArrayList<Integer>();
			    num3.add(xx);
			    num3.add(yy);
				System.out.println(num3);

				//打ったところが有効な時リバースする
				if(yourSelections.contains(num3)) {
					bord = Rule.reverse(bord, xx, yy, yourColor, cpuColor);
					break;
				}
				//打ったところが無効な時やり直し
				else {
					System.out.println("そこには打てません\n打ちなおしてください");
					continue;
				}
			}
			View.show(bord);//出力
		}


			//cpuのターン開始
			ArrayList<ArrayList<Integer>> cpuSelections =Rule.passCheck(bord, cpuColor, yourColor);
			if(cpuSelections.size()==0) {
				passCounter+=1;
				System.out.println("cpu took pass.");
			}

			//打てるとき打てるカ所からランダムで打つ
			else{
				bord = Cpu.action(bord, cpuSelections,yourColor,cpuColor);
			}
			View.show(bord);//出力




		}

	}

}