package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.CustomerRepository;
import springmvc_example.model.Customer;


/**
 * @author life
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired private CustomerRepository customerRepository;
	
	/* (non-Javadoc)
	 * @see com.packt.webstore.service.CustomerService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers()
	{
		return this.customerRepository.getAllCustomers();
	}

}
