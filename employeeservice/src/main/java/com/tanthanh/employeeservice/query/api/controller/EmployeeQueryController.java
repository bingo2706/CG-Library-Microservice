package com.tanthanh.employeeservice.query.api.controller;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanthanh.employeeservice.query.api.model.EmployeeReponseModel;
import com.tanthanh.employeeservice.query.api.queries.GetEmployeesQuery;



@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {

	@Autowired 
	private QueryGateway queryGateway;
	
	@GetMapping("/{employeeId}")
    public EmployeeReponseModel getEmployeeDetail(@PathVariable String employeeId) {
        GetEmployeesQuery getEmployeesQuery = new GetEmployeesQuery();
        getEmployeesQuery.setEmployeeId(employeeId);

        EmployeeReponseModel employeeReponseModel =
        queryGateway.query(getEmployeesQuery,
                ResponseTypes.instanceOf(EmployeeReponseModel.class))
                .join();

        return employeeReponseModel;
    }
}
