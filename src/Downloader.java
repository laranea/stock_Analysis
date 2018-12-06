/*
//design and code class Downloader (wrapper for yahooData) 
that has the following properties:
//fileName: for a file containing symbols to download from yahoo
//yahooData object to connect to yahoo and dowload the stock
//startDate and endDate for the period to
//Directory where to download all the data. 
//Write a tester to download all the data you need (stocks.txt and indices.txt on blackboard).
//method loadAll() to download all symbols in the input file.
*/
import java.io.*;
public class Downloader extends yahooData {
	private String mFileName;
	private BufferedReader buf; 
	private FileReader fr;
	public Downloader(String f, String D, String start, String last){
		super("unknown", D, start, last);
		mFileName  = f;
	}

	public String getmFileName() {
		return mFileName;
	}

	public void setmFileName(String mFileName) {
		this.mFileName = mFileName;
	}
	//method loadAll
	public boolean loadAll(){
		//open the symbol file
	
		try{
		fr = new FileReader(mFileName);
		buf = new BufferedReader(fr);
		//read one symbol at the time and download it
		String symbol;
		while((symbol = buf.readLine())!=null){
			//change the symbol to current symbol and the output file as well
			this.setSymbol(symbol);
			if(!this.load()){
				System.out.println("Unable to load " + symbol);
				return false;
			}
		}
		buf.close();
		fr.close();
		}catch(IOException e){
			System.out.println("Message " + e.getMessage());
		}

		return true;
	}
	
}
