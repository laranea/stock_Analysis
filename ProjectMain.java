
// Name: Topgyal Gurung
// Class: MAC 286-3018
// n-Bar Rally/Decline Project
// Created by Topgyal Gurung on May 31st, 2017
// Copyright © 2017 Topgyal Gurung. All rights reserved

// download all stocks from yah00(yahooData)
//load one stock or one index at a time into an array of Bars
//go through array from old to new day
//if pattern found, create a trade, then check winner or loser and record the data and move on.

public class ProjectMain {
	public static void main(String[] args){
        
    //create a test that accepts a file of stocks to be tested
			SymbolTester symbol = new SymbolTester();
			symbol.loadBars("C:\\Users\\topgyal\\Desktop\\topjava\\stocksData\\GOOG_Daily.csv");
			TradeArray trade = new TradeArray();
			
			
	//Test should return a Vector f trades TradeArray
			trade = symbol.test();
	//Your tradeArray should have method called statistics
			trade.stats("topgyal");
	//	TradeArray trade = new TradeArray();
		
	}
}
