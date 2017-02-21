package r12.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class HomePage extends WebPage {
	
	public HomePage() {
		add(new BookmarkablePageLink<String>("AuthorPage", AuthorPage.class));
		add(new BookmarkablePageLink<String>("ListAuthorPage", ListAuthorPage.class));
		
		add(new BookmarkablePageLink<String>("BooksPage", BooksPage.class));
		add(new BookmarkablePageLink<String>("ListBooksPage", ListBooksPage.class));
	}
}