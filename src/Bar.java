//Design and code a class Bar that has the following properties:
//Date for the day
//floats o, h, l, c, adjC
//v (int),  
//provide accessors for open it would be open(), etc...
//provide mutators 
//range that returns the difference from high to low
//constructor with all arguments 
//constructor that accepts a string int form: "mm-dd-yyyy, open, high, low, close, volume, adjClose"

public class Bar {
 Date barDate = new Date();
 private float open;
 private float high;
 private float low;
 private float close;
 private float adjC;
 private long volume;
 public Bar(){
	 barDate = new Date();
	 open = high = low = close = adjC = 0.0f;
	 volume = 0;
 }
 public Bar(Date d, float open, float high, float low, float close, long volume, float adjClose){
	 this.barDate = new Date(d);
	 setOpen(open);
	 setHigh(high);
	 setLow(low);
	 setClose(close);
	 setVolume(volume);
	 setAdjClose(adjClose);
 }
 public Bar(String d, float open, float high, float low, float close, long volume, float adjClose){
	 this.barDate = new Date(d);
	 setOpen(open);
	 setHigh(high);
	 setLow(low);
	 setClose(close);
	 setVolume(volume);
	 setAdjClose(adjClose);
 }
 
 public Bar(String all){
	 String[] info = all.split(",");
	 if(info.length != 7){
		 System.out.println("invalid format");
		 return;
	 }
	 for(int i = 0; i < info.length;i++){
		 info[i] = info[i].trim();
	 }
	barDate = new Date(info[0]);
	setOpen(Float.parseFloat(info[1]));
	setHigh(Float.parseFloat(info[2]));
	setLow(Float.parseFloat(info[3]));
	setClose(Float.parseFloat(info[4]));
	setVolume(Long.parseLong(info[5]));
	setAdjClose(Float.parseFloat(info[6]));
 }
 
 public void setOpen(float Open){
	 this.open = Open;
 }
 public void setHigh(float High){
	 this.high = High;
 }
 public void setLow(float Low){
	 this.low = Low;
 }
 public void setClose(float Close){
	 this.close = Close;
 }
 public void setVolume(long Volume){
	 this.volume = Volume;
 }
 public void setAdjClose(float AdjClose){
	 this.adjC = AdjClose;
 }
 public float getOpen(){  
	 return this.open;
 }
 public float getHigh(){
	 return this.high;
 }
 public float getLow(){
	 return this.low;
 }
 public float getclose(){
	 return this.close;
 }
 public long getVolume(){
	 return this.volume;
 }
 public float getAdjClose(){
	 return this.adjC;
 }
 public float range(){
	 return this.high-this.low;
 }
 public void Change(Bar a){
	 this.barDate = a.barDate;
	 this.high = a.high;
	 this.close = a.close;
	 this.adjC = a.adjC;
	 this.low = a.low;
	 this.volume = a.volume;
	 this.open = a.open;
 }
 public void print(){
	 System.out.println("Date: "+this.barDate +"\nOpen: "+this.open+"\nHigh: "+ this.high+ "\nLow: " + this.low 
			 +"\nClose: " + this.close + "\nVolume: " + this.volume + "\nAdjClose: " + this.adjC);
	 System.out.println("----------------------------------------------------");
 }
}
