package com.alex.designpattern.flyweight.igochessman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {

	public static final int MAX = 19;
	/**
	 * 模拟下围棋的过程
	 * 走满所有位置 19*19, 每步位置随机， 位置不能重复, 黑子先行
	 */
	public static void main(String[] args) {
		IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

		List<Coordinate> list = new ArrayList<>();

		// 初始化可用位置
		for(int x = 1; x <= MAX; x++){
			for(int y = 1; y <= MAX; y++){
				list.add(new Coordinate(x, y));
			}
		}
		int index = 1;  //步数
		String[] colors = {IgoChessman.WHITE, IgoChessman.BLACK};

		Coordinate coordinate;
		while(!list.isEmpty()){
			int randPosition = new Random().nextInt(list.size());
			coordinate = list.remove(randPosition);
			IgoChessman chess = factory.getChess(colors[index % 2]);
			chess.display(index++, coordinate);
		}
	}
}
