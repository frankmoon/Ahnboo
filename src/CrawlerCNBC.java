import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlerCNBC {

	public static void Crawlerrs() throws IOException {
		String url = "https://www.cnbc.com/quotes/?symbol=KRW=";
		Document doc = Jsoup.connect(url).get();
		Elements curre = doc.getElementsByClass("last original ng-binding");
		System.out.println(curre);
		return;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while (true) {Crawlerrs();}
	}

}
