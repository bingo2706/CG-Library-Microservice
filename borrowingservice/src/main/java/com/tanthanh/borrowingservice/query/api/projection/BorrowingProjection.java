package com.tanthanh.borrowingservice.query.api.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tanthanh.borrowingservice.command.api.data.BorrowRepository;
import com.tanthanh.borrowingservice.command.api.data.Borrowing;
import com.tanthanh.borrowingservice.query.api.model.BorrowingResponseModel;
import com.tanthanh.borrowingservice.query.api.queries.GetListBorrowingByEmployeeQuery;
import com.tanthanh.commonservice.model.BorrowingResponseCommonModel;
import com.tanthanh.commonservice.query.GetListBorrowingByEmployee;

@Component
public class BorrowingProjection {
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@QueryHandler
	public List<BorrowingResponseModel> handle(GetListBorrowingByEmployeeQuery query){
		List<BorrowingResponseModel> list  = new ArrayList<>();
		List<Borrowing> listEntity = borrowRepository.findByEmployeeId(query.getEmployeeId());
		listEntity.forEach(s ->{
			BorrowingResponseModel model = new BorrowingResponseModel();
			model.setBookId(s.getBookId());
			model.setBorrowingDate(s.getBorrowingDate());
			model.setEmployeeId(s.getEmployeeId());
			model.setId(s.getId());
			model.setReturnDate(s.getReturnDate());
			list.add(model);
		});
		return list;
	}
	@QueryHandler
	public List<BorrowingResponseCommonModel> handle(GetListBorrowingByEmployee query){
		List<BorrowingResponseCommonModel> list  = new ArrayList<>();
		List<Borrowing> listEntity = borrowRepository.findByEmployeeId(query.getEmployeeId());
		listEntity.forEach(s ->{
			BorrowingResponseCommonModel model = new BorrowingResponseCommonModel();
			model.setBookId(s.getBookId());
			model.setBorrowingDate(s.getBorrowingDate());
			model.setEmployeeId(s.getEmployeeId());
			model.setId(s.getId());
			model.setReturnDate(s.getReturnDate());
			list.add(model);
		});
		return list;
	}
	
}
