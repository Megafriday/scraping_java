package scraping_java.scraper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Samurai implements IScraper {

	final private String aSelector = "#primary > div > div > div > article > header > h2 > a";

	public void scraping() throws IOException {

		// 対象ページ
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add("https://www.sejuku.net/blog/category/programing/node-js");
		urlList.add("https://www.sejuku.net/blog/category/programing/node-js/page/2");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/2");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/3");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/4");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/5");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/6");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/7");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/8");
		urlList.add("https://www.sejuku.net/blog/category/programing/javascript/page/9");

		for (String url : urlList) {
			getTitle(url);
		}

	}

	private void getTitle(String url) throws IOException {

		Document document = Jsoup.connect(url).get();
		Elements aElements = document.select(aSelector);

		for (Element aElement : aElements) {
			System.out.println(aElement.text());
		}

		System.out.println("------------------------------------------------------");

	}
}
