package r12.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import r12.model.Books;

public class BooksPage extends WebPage {
	
	public BooksPage() {
		Form form = new Form("formInsertBooks", new CompoundPropertyModel(new Books()));
		form.add(new Label("titleLabel", getString("title")));
		form.add(new Label("isbnLabel", getString("isbn")));
		form.add(new Label("idAuthorLabel", getString("idAuthor")));
		form.add(new RequiredTextField("title"));
		form.add(new RequiredTextField("isbn"));
		form.add(new RequiredTextField("idAuthor"));
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(form);

	}

}