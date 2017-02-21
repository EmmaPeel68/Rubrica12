package r12.webpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import r12.model.Books;
import r12.service.ServiceBooks;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class List_Books_Page extends WebPage {
	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	ServiceBooks servBooks;

	private static final Logger logger = LogManager.getLogger(List_Books_Page.class.getName());

	private String currentNameSearchBook = null;

	private List listBook = Collections.emptyList();

	public List_Books_Page(PageParameters parameters) {
		currentNameSearchBook = parameters.get("currentSearchTerm").toString();
		logger.debug("Cargando la pagina con el parametro " + currentNameSearchBook);
		initComponents();
	}

	public List_Books_Page() {
		initComponents();
	}

	private void initComponents() {
		addFormBook();
		addFeedBackPanel();
		addListBookView();
	}

	private void addFormBook() {
		Form form = new Form("formListBook", new CompoundPropertyModel(new Books())) {
			@Override
			protected void onSubmit() {
				super.onSubmit();
				listBook.clear();
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("currentSearchTerm", ((Books) getModelObject()).getTitle());
				pageParameters.add("currentSearchTerm", ((Books) getModelObject()).getIsbn());
				pageParameters.add("currentSearchTerm", ((Books) getModelObject()).getIdAuthor());
				setResponsePage(List_Author_Page.class, pageParameters);
			}
		};
		form.add(new TextField("title"));
		form.add(new TextField("isbn"));
		form.add(new TextField("idAuthor"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListBookView() {
		Books books = new Books();// service.newEntity()
		books.setTitle(currentNameSearchBook);
		listBook = servBooks.find_Books_ByidAuthor(books.getIdAuthor());
		if (StringUtils.isNumeric(currentNameSearchBook)) {
			books.setIsbn(Integer.parseInt(currentNameSearchBook));
		}
		listBook = servBooks.find_Books(books);
		ListView listview = new ListView("book-group", listBook) {
			@Override
			protected void populateItem(ListItem item) {
				Books book = (Books) item.getModelObject();
				item.add(new Label("title", book.getTitle()));
				item.add(new Label("isbn", book.getIsbn()));
				item.add(new Label("idAuthor", book.getIdAuthor()));
			}
		};
		add(listview);
	}

}
