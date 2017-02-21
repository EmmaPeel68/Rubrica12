package r12.webpages;


import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import r12.service.ServiceAuthor;
import r12.model.Author;
import r12.service.ServiceAuthor;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class List_Author_Page extends WebPage {
	private static final long serialVersionUID = -1935854748907274886L;
	
	@SpringBean
	ServiceAuthor servaut;
	
	private static final Logger logger = LogManager.getLogger(List_Author_Page.class.getName());
	
	private String currentNameSearch = null;
	
	private List listAuthor = Collections.emptyList();
	
	public List_Author_Page(PageParameters parameters) {
		currentNameSearch = parameters.get("currentSearchTerm").toString();
		logger.debug("Cargando la pagina con el parametro " + currentNameSearch);
		initComponents();
	}
	
	public List_Author_Page() {
		initComponents();
	}

	private void initComponents() {
		addForm();
		addFeedBackPanel();
		addListAuthorView();
	}
	
	private void addForm() {
		Form form = new Form("formListAuthor", new CompoundPropertyModel(new Author())) {
			@Override
			protected void onSubmit() {
				super.onSubmit();
				listAuthor.clear();
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("currentSearchTerm", ((Author) getModelObject()).getNameAuthor());
				pageParameters.add("currentSearchTerm", ((Author) getModelObject()).getDateOfBirth());
				setResponsePage(List_Author_Page.class, pageParameters);
			}
		};
		form.add(new TextField("nameAuthor"));
		form.add(new TextField("dateOfBirth"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListAuthorView() {
		Author author = new Author();
		author.setNameAuthor(currentNameSearch);
		listAuthor = servaut.find_Authors(author);
		ListView listview = new ListView("author-group", listAuthor) {
			@Override
			protected void populateItem(ListItem item) {
				Author author = (Author) item.getModelObject();
				item.add(new Label("authorName", author.getNameAuthor()));
				item.add(new Label("dateOfBirth", author.getDateOfBirth()));
			}
		};
		add(listview);
	}

}
