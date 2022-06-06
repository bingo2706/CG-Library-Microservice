package com.tanthanh.employeeservice.query.api.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tanthanh.commonservice.model.BookResponseCommonModel;
import com.tanthanh.commonservice.model.EmployeeResponseCommonModel;
import com.tanthanh.commonservice.query.GetDetailsBookQuery;
import com.tanthanh.commonservice.query.GetDetailsEmployeeQuery;
import com.tanthanh.employeeservice.command.api.data.Employee;
import com.tanthanh.employeeservice.command.api.data.EmployeeRepository;
import com.tanthanh.employeeservice.query.api.model.EmployeeReponseModel;
import com.tanthanh.employeeservice.query.api.queries.GetEmployeesQuery;

@Component
public class EmployeeProjection {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@QueryHandler
    public EmployeeReponseModel handle(GetEmployeesQuery getEmployeesQuery) {
		EmployeeReponseModel model = new EmployeeReponseModel();
	 Employee employee = employeeRepository.getById(getEmployeesQuery.getEmployeeId());
      BeanUtils.copyProperties(employee, model);

        return model;
    }
	@QueryHandler
    public EmployeeResponseCommonModel handle(GetDetailsEmployeeQuery getDetailsEmployeeQuery) {
		EmployeeResponseCommonModel model = new EmployeeResponseCommonModel();
	 Employee employee = employeeRepository.getById(getDetailsEmployeeQuery.getEmployeeId());
      BeanUtils.copyProperties(employee, model);

        return model;
    }
}
