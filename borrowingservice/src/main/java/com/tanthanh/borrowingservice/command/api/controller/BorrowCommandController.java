package com.tanthanh.borrowingservice.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanthanh.borrowingservice.command.api.command.CreateBorrowCommand;
import com.tanthanh.borrowingservice.command.api.model.BorrowRequestModel;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowCommandController {

	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String addBookBorrowing(@RequestBody BorrowRequestModel model) {
		CreateBorrowCommand command = 
			new CreateBorrowCommand(model.getBookId(), model.getEmployeeId(), model.getBorrowingDate(),UUID.randomUUID().toString());
		commandGateway.sendAndWait(command);
		
		return "Book borrowing added";
	}
}
