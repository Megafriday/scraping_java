package scraping_java.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Sbfl implements IScraper{

	final private String titleSelector = "section > a > div.entry-inner > header > h2";
	final private String aSelector = "#godios-wrapper > div > main > section > a";

	public void scraping() throws IOException {

		// 対象ページ
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add("https://sbfl.net/blog/category/it/");
		urlList.add("https://sbfl.net/blog/category/it/page/2/");
		urlList.add("https://sbfl.net/blog/category/it/page/3/");
		urlList.add("https://sbfl.net/blog/category/it/page/4/");
		urlList.add("https://sbfl.net/blog/category/it/page/5/");
		urlList.add("https://sbfl.net/blog/category/it/page/6/");
		urlList.add("https://sbfl.net/blog/category/it/page/7/");
		urlList.add("https://sbfl.net/blog/category/it/page/8/");
		urlList.add("https://sbfl.net/blog/category/it/page/9/");
		urlList.add("https://sbfl.net/blog/category/it/page/10/");

		for (String url : urlList) {
			getTitle(url);
		}

	}

	private void getTitle(String url) throws IOException {

		Document document = Jsoup.connect(url).get();
		Elements titleElements = document.select(titleSelector);
		Elements aElements = document.select(aSelector);

		List<String> titles = titleElements.eachText();
		List<String> as = aElements.eachAttr("href");

		for (int i = 0; i < titles.size(); i++) {
			System.out.println(titles.get(i) + "：（" + as.get(i) + "）");
		}

		System.out.println("------------------------------------------------------");
	}
}
