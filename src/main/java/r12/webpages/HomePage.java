package r12.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class HomePage extends WebPage {
	
	public HomePage() {
		add(new BookmarkablePageLink<String>("Author_Page", Author_Page.class));
		add(new BookmarkablePageLink<String>("List_Author_Page", List_Author_Page.class));
		
		add(new BookmarkablePageLink<String>("Books_Page", Books_Page.class));
		add(new BookmarkablePageLink<String>("List_Books_Page", List_Books_Page.class));
	}
}