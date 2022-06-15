package com.tanthanh.bookservice.query.api.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tanthanh.bookservice.command.api.data.Book;
import com.tanthanh.bookservice.command.api.data.BookRepository;
import com.tanthanh.bookservice.query.api.model.BookResponseModel;
import com.tanthanh.bookservice.query.api.queries.GetAllBooksQuery;
import com.tanthanh.bookservice.query.api.queries.GetBooksQuery;
import com.tanthanh.commonservice.model.BookResponseCommonModel;
import com.tanthanh.commonservice.query.GetDetailsBookQuery;
import com.tanthanh.commonservice.query.GetListBookQuery;

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
	 @QueryHandler
	    public BookResponseCommonModel handle(GetDetailsBookQuery getDetailsBookQuery) {
		 BookResponseCommonModel model = new BookResponseCommonModel();
		 Book book = bookRepository.getById(getDetailsBookQuery.getBookId());
	      BeanUtils.copyProperties(book, model);

	        return model;
	    }
	 @QueryHandler
	 public List<BookResponseCommonModel> handle(GetListBookQuery getListBookQuery){
		 List<Book> listEntity = bookRepository.findAll();
		 List<BookResponseCommonModel> listbook = new ArrayList<>();
		 listEntity.forEach(s -> {
			 BookResponseCommonModel model = new BookResponseCommonModel();
			 BeanUtils.copyProperties(s, model);
			 listbook.add(model);
		 });
		 return listbook;
	 }
	 @QueryHandler List<BookResponseModel> handle(GetAllBooksQuery getAllBooksQuery){
		 List<Book> listEntity = bookRepository.findAll();
		 List<BookResponseModel> listbook = new ArrayList<>();
		 listEntity.forEach(s -> {
			 BookResponseModel model = new BookResponseModel();
			 BeanUtils.copyProperties(s, model);
			 listbook.add(model);
		 });
		 return listbook;
	 }
}
