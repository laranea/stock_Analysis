
public class yahooTester {

	public static void main(String[] args){
		yahooData data = new yahooData("GOOG","C:/TopPrj/","1/1/2010","12/31/2016");
		if(data.load()){
			System.out.println("it works!");
		}
		else{
			System.out.println("it does not work");
		}
	}
	
}
