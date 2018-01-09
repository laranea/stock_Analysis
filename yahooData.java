//This class is downloading historical data for a specific stock
//starting at a date and finishing at specific date. 
//the data is going to be saved in a specified directory
//as a csv file. The name of the file will be Symbol_Daily.csv
//yahooData ("MSFT", "C:/myData/", "01/01/2006", "12/31/2016");
//yahoo.load();

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class yahooData {
	private String mSymbol;
	private String mDirectory;
	private Date mStartDate, mEndDate;
	private String mFileName;
	//constructors
	yahooData(){
		mSymbol = " ";
		mDirectory = "./";
		mStartDate = new Date("0/0/0");
		mEndDate = new Date("0/0/0");
		mFileName = mDirectory + " ";
	}
	yahooData(String s, String d, Date st, Date end){
		mSymbol = s;
		mDirectory = d;
		mStartDate = new Date(st);
		mEndDate = new Date(end);
		mFileName = mDirectory + mSymbol + "_Daily.csv";
	}	
	yahooData(String s, String d, String st, String end){
		mSymbol = s;
		mDirectory = d;
		mStartDate = new Date(st);
		mEndDate = new Date(end);
		mFileName = mDirectory + mSymbol + "_Daily.csv";
	}	
	yahooData(String s, String d, String f, Date st, Date end){
		mSymbol = s;
		mDirectory = d;
		mStartDate = new Date(st);
		mEndDate = new Date(end);
		mFileName = mDirectory + f;
	}
	
	//load the data from yahoo
	//The re is a class File is to manipulate files, creation deletion moving etc..
	//fileReader allows you to read character by character from a file, or an array of characters
	//bufferreader allows you to read a line from fileReader
	public boolean load() {
		//create a URL a string 
		String strUrl = "http://chart.finance.yahoo.com/table.csv?s=";
		strUrl += mSymbol + "&a=" + (mStartDate.getMonth()-1) + "&b=" + 
				+ mStartDate.getDay() + "&c="+mStartDate.getYear();
		strUrl += "&d=" + (mEndDate.getMonth()-1) + "&e=" + 
				+ mEndDate.getDay() + "&f="+mEndDate.getYear();
		strUrl += "&g=d&ignore=.csv";
		System.out.println(strUrl);
		//create a URL and connect to yahoo
		try{
		URL urlYahoo = new URL(strUrl);
		URLConnection urlConn = urlYahoo.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buffer = new BufferedReader(inStream);
		File outputFile = new File(mFileName);
		if(outputFile.exists()){
			System.out.println("File Exists. Do you want to ovewrite it? [y/n]");
			Scanner sc = new Scanner(System.in);
			char ans = sc.nextLine().charAt(0);
			if(ans == 'n' || ans == 'N'){
				return true;
			}
		}
		FileWriter outFile = new FileWriter(mFileName);
		BufferedWriter bOut = new BufferedWriter(outFile);
		String lineStr;
		while((lineStr = buffer.readLine()) != null){
			bOut.write(lineStr+"\n");
		}
		
		bOut.close();
		
		}catch(MalformedURLException e){
			System.out.println("Exception: " + e.getMessage());
		return false;
		}catch(IOException e){
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	//accessors
	public String getSymbol() {
		return mSymbol;
	}
	public String getDirectory() {
		return mDirectory;
	}
	public Date getStartDate() {
		return mStartDate;
	}
	public Date getEndDate() {
		return mEndDate;
	}
	public String getFileName() {
		return mFileName;
	}
	//mutators
	public void setData(String s, String d, Date st, Date end){
		mSymbol = s;
		mDirectory = d;
		mStartDate = new Date(st);
		mEndDate = new Date(end);
		mFileName = mDirectory + mSymbol + "_Daily.csv";
	}
	public void setData(String s, String d, String f, Date st, Date end){
		mSymbol = s;
		mDirectory = d;
		mStartDate = new Date(st);
		mEndDate = new Date(end);
		mFileName = mDirectory + f;
	}
	public void setSymbol(String s) {
		mSymbol = s;
		mFileName = mDirectory + mSymbol + "_Daily.csv";
	}
	public void setDirectory(String d){
		mDirectory = d;
	}
	public void setStartDate(Date d) {
		mStartDate = new Date(d);
	}
	public void setEndDate(Date d) {
		mEndDate = new Date(d);
	}
	public void setFileName(String f){
		mFileName = f;
	}
}