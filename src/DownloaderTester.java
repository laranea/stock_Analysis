
public class DownloaderTester {

	public static void main(String[] args){
		Downloader a = new Downloader("C:\\Users\\Topgyal\\Desktop\\topjava\\stocks.txt","C:\\Users\\topgyal\\Desktop\\topjava\\Data\\",
				"01/01/2006","12/31/2016");
		
		a.loadAll();
	}
}
