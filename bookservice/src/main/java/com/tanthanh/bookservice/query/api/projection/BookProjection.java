package com.tanthanh.bookservice.query.api.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tanthanh.bookservice.command.api.data.Book;
import com.tanthanh.bookservice.command.api.data.BookRepository;
import com.tanthanh.bookservice.query.api.model.BookResponseModel;
import com.tanthanh.bookservice.query.api.queries.GetBooksQuery;

@Component
public class BookProjection {

	@Autowired
	private BookRepository bookRepository;
	
	 @QueryHandler
	    public BookResponseModel handle(GetBooksQuery getBooksQuery) {
		 BookResponseModel model = new BookResponseModel();
		 Book book = bookRepository.getById(getBooksQuery.getBookId());
	      BeanUtils.copyProperties(book, model);

	        return model;
	    }
}
