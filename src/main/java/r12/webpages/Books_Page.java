package r12.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import r12.model.Books;

public class Books_Page extends WebPage {
	
	public Books_Page() {
		Form form = new Form("form_Insert_Books", new CompoundPropertyModel(new Books()));
		form.add(new Label("title_Label", getString("title")));
		form.add(new Label("isbn_Label", getString("isbn")));
		form.add(new Label("idAuthor_Label", getString("idAuthor")));
		form.add(new RequiredTextField("title"));
		form.add(new RequiredTextField("isbn"));
		form.add(new RequiredTextField("idAuthor"));
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(form);

	}

}