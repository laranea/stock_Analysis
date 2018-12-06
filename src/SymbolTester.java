import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolTester {
	private TradeArray mTrades;
	private String mSymbol;
	private BarArray mBars;
//constructors
	public SymbolTester(){
		mTrades = new TradeArray();
		mSymbol = "";
		mBars = new BarArray();
	}
//accessors and mutators
	public TradeArray getmTrades() {
		return mTrades;
	}
	public void setmTrades(TradeArray mTrades) {
		this.mTrades = mTrades;
	}
	public String getmSymbol() {
		return mSymbol;
	}
	public void setmSymbol(String mSymbol) {
		this.mSymbol = mSymbol;
	}
	public BarArray getmBars() {
		return mBars;
	}
	public void setmBars(BarArray mBars) {
		this.mBars = mBars;
	}
//method to load the bars into mBars
	void loadBars(String UserfileName) {
//open the file of data 
//go through it line by line 
//make a Bar from a line
//Bar b = new Bar(line);
//insert the bar into mBars
		BufferedReader b = null;
		String lines =null;
		try{
			b = new BufferedReader(new FileReader(UserfileName));
			int lineCounts = 0;
			while((lines = b.readLine()) != null){
				if(lineCounts > 0){
					Bar bares = new Bar(lines);
					mBars.insert(bares, lineCounts-1);
				}
				lineCounts++;
			}
 
 Bar tempS = new Bar();
 for(int i = 0; i < mBars.size();i++){
	 for(int j =0; j< mBars.size();j++){
		 if(mBars.at(j).barDate.isGreater(mBars.at(i).barDate)){
			 tempS.Change(mBars.at(i));
			 mBars.at(i).Change(mBars.at(j));
			 mBars.at(j).Change(tempS);
		 }
	 }
 }
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TradeArray test() {
		for(int i = 20; i < mBars.size()-4;i++){
			if(LongPattern(i)){		
				System.out.println("Date: " + mBars.at(i).barDate + "  Pattern found");
				Trade t = new Trade();
				float price = mBars.at(i+4).getOpen();
				float target = price + Math.min((mBars.at(i).getHigh() - getLowest(i))*(62/100.f), (mBars.at(i).getHigh()*0.5f));
				float stop = price - (Math.min((mBars.at(i).getHigh() - getLowest(i))*(62/100.f), (mBars.at(i).getHigh()*0.5f)))/2;
				String DirectionL = "long";
				System.out.println("Date: " + mBars.at(i+4).barDate + "  Open Day");
				System.out.println("Open Price: " + price );
				System.out.println("Target: " + target );
				System.out.println("Stop: " + stop);
				System.out.println("Direction: " + DirectionL );
			
				t.open(mBars.at(i+4).barDate, price, stop, target, DirectionL);
				checkTarget(t,i+4);
				System.out.println("Close price: " + t.getExitPrice());
				System.out.println("Close Date: " + t.getExitDate());
				System.out.println("-------------------------------------------");
				mTrades.insertFront(t);			
			}
			else if(ShortPattern(i)){
				System.out.println("Date: " + mBars.at(i).barDate +" Pattern found");
				Trade t = new Trade();
				float price = mBars.at(i+4).getOpen();
				float target = price - Math.min((getHighest(i) - mBars.at(i).getLow())*(62/100.f),(mBars.at(i).getLow()*0.5f));
				float stop = price + Math.min((getHighest(i) - mBars.at(i).getLow())*(62/100.f),(mBars.at(i).getLow()*0.5f))/2;
				String DirectionS = "short";
				System.out.println("Date: " + mBars.at(i+4).barDate + "  Open Day");
				System.out.println("Open Price: " + price );
				System.out.println("Target: " + target );
				System.out.println("Stop: " + stop);
				System.out.println("Direction: " + DirectionS );
				
				t.open(mBars.at(i+4).barDate, price, stop, target, DirectionS);
				checkTarget(t,i+4);
				System.out.println("Close price: " + t.getExitPrice());
				System.out.println("Close Date: " + t.getExitDate());
				System.out.println("-------------------------------------------");
				mTrades.insertFront(t);
			}
		}
		return mTrades;
	}
	public boolean isHigh20(int i){
		for (int j = i-1; j > i-21; j--){
			if (mBars.at(j).getHigh() > mBars.at(i).getHigh())
				return false;
		}
		return true;
	}
	public boolean isLow20(int i){
		for (int j = i-1; j > i-21; j--){
			if (mBars.at(j).getLow() < mBars.at(i).getLow())
				return false;
		}
		return true;
	}
//check if a bar is greater than 20 bars before it.
	public boolean LongPattern(int i){
		if(isHigh20(i) && mBars.at(i).getHigh() > mBars.at(i+1).getHigh() && 
				mBars.at(i+1).getHigh() > mBars.at(i+2).getHigh() && 
				mBars.at(i+2).getHigh() > mBars.at(i+3).getHigh()){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean ShortPattern(int i){
		if(isLow20(i) && mBars.at(i).getLow() < mBars.at(i+1).getLow() && 
				mBars.at(i+1).getLow() < mBars.at(i+2).getLow() && 
				mBars.at(i+2).getLow() < mBars.at(i+3).getLow()){
				return true;
	}
		else {
			return false;
		}
	}
	
	public float getLowest(int index){
		float newLow = 0.0f;
		for(int i = index; i > index-20; i--){
			if(mBars.at(i).getLow() < mBars.at(i-1).getLow()){
				newLow = mBars.at(i).getLow();
			}
		}
		return newLow;
	}
	public float getHighest(int index){
		float newG = 0.0f;
		for(int i = index; i > index-20; i--){
			if(mBars.at(i).getHigh() > mBars.at(i-1).getHigh()){
				newG = mBars.at(i).getLow();
			}
		}
		return newG;
	}
	
	
	public void checkTarget(Trade tr, int index){
		float newGreater = 0;
		float newLower = 0;
		if(tr.getDirection().equalsIgnoreCase("long")){	
			for(int i = index+1 ; i < index+11 ; i++){
				newGreater = mBars.at(i).getHigh();
				newLower = mBars.at(i).getLow();
				if(newGreater > tr.getTarget()){
					tr.close(mBars.at(i).barDate, newGreater);
					return;
				}
				else if(newLower < tr.getStopLoss()){
					tr.close(mBars.at(i).barDate, newLower);
					return;
				}
			}
			if(tr.getExitDate() == null ){
				tr.close(mBars.at(index+10).barDate, mBars.at(index+10).getclose());
			}
		}
		else if(tr.getDirection().equalsIgnoreCase("short")){
			for(int i = index+1 ; i < index+11 ; i++){
				newGreater = mBars.at(i).getHigh();
				newLower = mBars.at(i).getLow();
				if(newLower < tr.getTarget()){
					tr.close(mBars.at(i).barDate, newLower);
					return;
				}
				else if(newGreater > tr.getStopLoss()){
					tr.close(mBars.at(i).barDate, newGreater);
					return;
				}
			}
			if(tr.getExitDate() == null ){
				tr.close(mBars.at(index+10).barDate, mBars.at(index+10).getclose());
			}
		}
	}


	
}
