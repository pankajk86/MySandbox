import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinyURL {

	private static Long GLOBAL_ID = 1L;
	private static Map<Long, String> id2UrlMap = new HashMap<>();
	private static Map<String, Long> url2IdMap = new HashMap<>();
	
	public static void main(String[] args) {
		
		List<String> urls = new ArrayList<>();
		urls.addAll(Arrays.asList("http://www.google.com/abc/def.html",
				"http://www.facebook.com/abc/xyz.html",
				"http://www.microsoft.com/abc/pqrs.html",
				"http://www.apple.com/abc/lmn.html",
				"http://www.ebay.com/abc/stuv.html"));
		
		for(String url: urls) {
			// create Tiny URL
			String tinyURL = getTinyURL(url);
			System.out.println(tinyURL);
			
			// get back original URL
			String actualURL = getActualURL(tinyURL);
			System.out.println(actualURL);
			System.out.println("--------------");
		}
	}

	private static String getTinyURL(String url) {
		
		if(url2IdMap.containsKey(url)) {
			return Base62.id2TinyUrl(url2IdMap.get(url));
		} else {
			GLOBAL_ID++;
			url2IdMap.put(url, GLOBAL_ID);
			id2UrlMap.put(GLOBAL_ID, url);
			return Base62.id2TinyUrl(url2IdMap.get(url));
		}
	}
	
	private static String getActualURL(String shortURL) {
		
		Long id = Base62.tinyUrl2Id(shortURL);
		
		if(id2UrlMap.containsKey(id)) {
			return id2UrlMap.get(id);
		}
		
		return null;
	}

}

/*
 * It may be used to create object while persisting in database.
 */
class Tiny {
	Long id;
	String url;
	String tinyUrl;
	
	public Tiny(Long id, String url) {
		this.id = id; this.url = url;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
	
	public String getTinyUrl() {
		return this.tinyUrl;
	}
}
