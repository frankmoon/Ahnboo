
import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler {
	LinkedList<String> elements = new LinkedList<String>();

	public static void main(String[] args) throws IOException {
		/** select one */

		// getReuters();
		// getBloomberg();
		getYahoo();
	}

	// works, but some latency
	private static int getReuters() throws IOException {
		String url = "https://www.reuters.com/finance/currencies/quote?destAmt=&srcAmt=1.00&srcCurr=USD&destCurr=KRW";
		Document doc = Jsoup.connect(url).get();
		Elements block = doc.getElementsByClass("fourUp currQuote");
		String[] split = block.toString().split(">");
		String curr = split[5].split("<")[0];
		String time = split[7].split("<")[0];
		System.out.println(curr + time);
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

	// works great, but slow
	private static int getYahoo() throws IOException {
		String url = "https://finance.yahoo.com/quote/usdkrw=x/";
		Document doc = Jsoup.connect(url).get();
		Elements block = doc.getElementsByAttributeValue("id", "quote-header-info");
		String[] split = block.toString().split("</div>");
		String[] split2 = split[14].split("<span");
		String curr = split2[1].split(">")[1].split("<")[0];
		String time = split2[3].split(">")[1].split("<")[0];
		System.out.println(curr);
		System.out.println(time);
		return 0;
	}
}