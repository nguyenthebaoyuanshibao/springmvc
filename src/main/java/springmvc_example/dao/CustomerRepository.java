package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Customer;



/**
 * @author life
 *
 */
public interface CustomerRepository
{
	List<Customer> getAllCustomers();
}
