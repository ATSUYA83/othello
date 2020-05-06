package ocelo;

import java.util.ArrayList;

public class Rule {
	private static final int[][] dir     = {{-1,-1},// 左下
            { 0,-1},// 下
            { 1,-1},// 右下
            { 1, 0},//右
            { 1, 1},//右上
            { 0, 1},//上
            {-1, 1},//左上
            {-1, 0}};//左

	public static boolean actionCheck(int xx,int yy,Bord bord,String myColor,String opColor) {
		//指定カ所に打てるときtrue
		boolean result=false;
		if(bord.getState(xx,yy)!="―") {
			result = false;
			return result;
		}
		else {

			out:for(int i=0;i<dir.length;i++) {
				int j = xx,k = yy;
				j += dir[i][0];
				k += dir[i][1];
//				System.out.println(j);
//				System.out.println(k);


				if(bord.getState(j, k)==opColor) {
				while(true) {
					j += dir[i][0]; // 更に先のマスをチェックしてみる。
                    k += dir[i][1];
					if(bord.getState(j, k)==myColor) {
						result=true;
						break out;
				}
					else if(bord.getState(j, k)==opColor) {
						continue;
					}
					else {
					break;
					}
					}
			}
			}
		}
		return result;
	}
	public static ArrayList<ArrayList<Integer>> passCheck(Bord bord,String myColor,String opColor) {
		ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<bord.getX()+1;i++) {
			for(int k =1;k<bord.getY()+1;k++) {
				if(actionCheck(i,k,bord,myColor,opColor)) {
					ArrayList<Integer> num3 = new ArrayList<Integer>();
				    num3.add(i);
				    num3.add(k);

					list1.add(num3);
				}


			}
		}
		return list1;
	}

	public static Bord reverse(Bord bord,int x,int y,String myColor,String opColor) {
		bord.setState(x, y, myColor);
		for(int i=0;i<dir.length;i++) {
			int j=x,k=y;
			j += dir[i][0];
			k += dir[i][1];
			if(bord. getState(j, k) == opColor) {
				out:while(true) {
					j += dir[i][0]; // 更に先のマスをチェックしてみる。
                    k += dir[i][1];
                    if(bord.getState(j, k)==myColor) {
                    	while(true) {
                    		j -= dir[i][0]; // 自分の色があったのでバックしてひっくろかえす
                            k -= dir[i][1];
//            				System.out.println(j);
//            				System.out.println(k);
                            if(bord.getState(j, k)==myColor) {
                            	break out;
                            }
                            bord.setState(j, k, myColor);
                    	}

                    	}
                    else if(bord. getState(j, k) == opColor) {
                		continue;
                    }
                    else {
                    	break;
                    }

				}
			}

		}

		return bord;
	}
	public static void judge(Bord bord) {
		int b =0;
		int w = 0;
		for(int i=1;i<bord.getX()+1;i++) {
			for(int k =1;k<bord.getY()+1;k++) {
				if(bord.getState(i, k)=="●") {
					b +=1;
				}
				else if(bord.getState(i, k)=="○") {
					w +=1;
				}
				else {
					break;
				}
			}
		}
		System.out.println("○:"+ w + "\n●:"+b);

	}


	}


