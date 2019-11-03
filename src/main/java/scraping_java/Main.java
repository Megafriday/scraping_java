package scraping_java;

import java.io.IOException;

import scraping_java.scraper.Samurai;
import scraping_java.scraper.IScraper;

public class Main {

	public static void main(String[] args) throws IOException {

		IScraper scraper = new Samurai();
		//		IScraper scraper = new Sbfl();

		scraper.scraping();
	}

}
