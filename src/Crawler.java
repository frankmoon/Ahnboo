
import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler {
	LinkedList<String> elements = new LinkedList<String>();

	public static void main(String[] args) throws IOException {
		/** select one */
		getReuters();
		// getBloomberg();
	}

	// works, but some latency
	private static int getReuters() throws IOException {
		String url = "https://www.reuters.com/finance/currencies/quote?destAmt=&srcAmt=1.00&srcCurr=USD&destCurr=KRW";
		Document doc = Jsoup.connect(url).get();
		Elements curr = doc.getElementsByClass("fourUp currQuote");
		System.out.println(curr);
		return 0;
	}

	// doesn't work
	private static int getBloomberg() throws IOException {
		String url = "https://www.bloomberg.com/quote/USDKRW:CUR";
		Document doc = Jsoup.connect(url).get();
		Elements curr = doc.getElementsByClass("pseudoMainContent");
		System.out.println(curr);
		return 0;
	}
}