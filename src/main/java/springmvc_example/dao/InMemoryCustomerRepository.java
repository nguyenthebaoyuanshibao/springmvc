package springmvc_example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import springmvc_example.model.Customer;


/**
 * @author life
 *
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository
{
	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	/**
	 * default cutomers in customer list
	 */
	public InMemoryCustomerRepository()
	{
		Customer customer1 = new Customer();
		customer1.setAddress("Ankara");
		customer1.setCustomerId(1);
		customer1.setName("Volkan");
		customer1.setNoOfOrdersMade(5);
		
		Customer customer2 = new Customer();
		customer2.setAddress("Istanbul");
		customer2.setCustomerId(2);
		customer2.setName("Hilmi");
		customer2.setNoOfOrdersMade(2);

		this.listOfCustomers.add(customer1);
		this.listOfCustomers.add(customer2);
	}
	
	/* (non-Javadoc)
	 * @see com.packt.webstore.domain.repository.CustomerRepository#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers()
	{
		return this.listOfCustomers;
	}

}
