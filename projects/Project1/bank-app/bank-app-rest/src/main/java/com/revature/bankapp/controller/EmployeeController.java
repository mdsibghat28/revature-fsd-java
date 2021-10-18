package com.revature.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transactions;

@Path("/employees")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private EmployeeDaoImpl dao = new EmployeeDaoImpl();

	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("email") String email, @PathParam("password") String password) {
		System.out.println("Customer email: " + email);
		try {
			Employee employee = dao.getEmployeeUserId(email);
			if (employee == null) {
				return Response.status(401).build();
			} else if (employee.getPassword().equals(password)) {
				System.out.println("Success");
				return Response.ok().entity(employee).build();
			} else {
				System.out.println("failed");
				return Response.status(401).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
	
	@GET
	@Path("/customers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response customers() {
		try {
			List<Customer> customerList;
			customerList = dao.viewCustomer();
			return Response
					.ok()
					.entity(customerList)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response accounts() {
		try {
			List<Account> accountList;
			accountList = dao.viewAccount();
			return Response
					.ok()
					.entity(accountList)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
	
	@GET
	@Path("/transactions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response transactions() {
		try {
			List<Transactions> transactionList;
			transactionList = dao.viewTransaction();
			return Response
					.ok()
					.entity(transactionList)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
	
}
