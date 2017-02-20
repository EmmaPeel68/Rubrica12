package r12.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;


import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePicker;
import r12.model.Author;

public class Author_Page extends WebPage {
	
	public Author_Page() {

		Form form = new Form("form_Insert_Author", new CompoundPropertyModel(new Author()));
		form.add(new Label("name_Author_Label", getString("name_Author")));
		form.add(new Label("date_OfBirth_Label", getString("date_OfBirth")));
		form.add(new RequiredTextField("name_Author"));
		DatetimePicker datetimePicker = new DatetimePicker("date_OfBirth", "yyyy-MM-dd");
		form.add(datetimePicker);
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		add(form);
	}
}