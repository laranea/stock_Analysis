
public class Trade {
	private Date entryDate, exitDate;
	private float entryPrice, exitPrice, stopLoss, target;
	private String Direction, Result;
	
	public Trade(){
		this.entryDate = new Date("0/0/0");
		this.exitDate = null;
		this.entryPrice = 0.0f;
		this.exitPrice = 0.0f;
		this.stopLoss = 0.0f;
		this.target = 0.0f;
		this.Direction = "none";
	}
	public Trade(Date d, float price, float target, float stop, String Direction){
		this.entryDate = new Date(d);
		this.entryPrice = price;
		this.stopLoss = stop;
		this.target = target;
		this.Direction = Direction;
	}
	
	//accessors and setter
	public Date getEntryDate(){
		return this.entryDate;
	}
	public Date getExitDate(){
		return this.exitDate;
	}
	public float getEntryPrice(){
		return this.entryPrice;
	}
	public float getExitPrice(){
		return this.exitPrice;
	}
	public float getStopLoss(){
		return this.stopLoss;
	}
	public float getTarget(){
		return this.target;
	}
	public String getDirection(){
		return this.Direction;
	}
	public void setEntryDate(Date d){
		this.entryDate = new Date(d);
	}
	public void setExitDate(Date d){
		this.exitDate = new Date(d);
	}
	public void setEntryPrice(float e){
		this.entryPrice = e;
	}
	public void setExitPrice(float e){
		this.exitPrice = e;
	}
	public void setStopLoss(float s){
		this.stopLoss = s;
	}
	public void setTarget(float t){
		this.target = t;
	}
	public void setDirection(String d){
		this.Direction = d;
	}
	public void open(Date d, float price, float stop, float target, String Direction){
		this.entryDate = new Date(d);
		this.entryPrice = price;
		this.stopLoss = stop;
		this.target = target;
		this.Direction = Direction;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public void close(Date c, float price){
		this.exitDate = new Date(c);
		this.exitPrice = price;
	}
	public float PL(){
		if(this.Direction.equals("long")){
			return (this.exitPrice - this.entryPrice);
		}
		else{
			return (this.entryPrice - this.exitPrice);
		}
	}
	public float percentPL(){
		if(this.Direction.equals("long")){
			return (this.exitPrice - this.entryPrice)/this.entryPrice*100;
		}
		else{
			return (this.entryPrice - this.exitPrice)/this.entryPrice*100;
		}
	}
	public String toString(){
		String st = entryDate.toString() + ", " + entryPrice + ", " + stopLoss + ", " +
					target + ", " + exitPrice + ", " + exitDate.toString() + ", " + Direction;
		return st;
	}
	public void print(){
		System.out.println(this.toString());
	}
}
