package com.alex.designpattern.flyweight.igochessman;

import java.util.HashMap;
import java.util.Map;

public class IgoChessmanFactory {

	private Map<String, IgoChessman> pool;
	private static volatile IgoChessmanFactory instance = null;

	private IgoChessmanFactory(){
		pool = new HashMap<>();
	}

	public static IgoChessmanFactory getInstance(){
		if(instance == null){
			synchronized (IgoChessmanFactory.class){
				if(instance == null){
					instance = new IgoChessmanFactory();
				}
			}
		}
		return instance;
	}

	public IgoChessman getChess(String color){
		IgoChessman chessman = pool.get(color);
		if(null == chessman){
			if(IgoChessman.BLACK.equalsIgnoreCase(color)){
				chessman = new BlackIgoChessman();
				pool.put(color, chessman);
			}else if(IgoChessman.WHITE.equalsIgnoreCase(color)){
				chessman = new WhiteIgoChessman();
				pool.put(color, chessman);
			}
		}
		return chessman;
	}
}
