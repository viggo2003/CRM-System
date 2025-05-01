package se.yrgo.services.customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.yrgo.domain.Call;
import se.yrgo.domain.Customer;

public class CustomerManagementMockImpl implements CustomerManagementService {
	private HashMap<String, Customer> customerMap;

	public CustomerManagementMockImpl() {
		customerMap = new HashMap<String,Customer>();
		customerMap.put("OB74", new Customer("OB74" ,"Fargo Ltd", "some notes"));
		customerMap.put("NV10", new Customer("NV10" ,"North Ltd", "some other notes"));
		customerMap.put("RM210", new Customer("RM210" ,"River Ltd", "some more notes"));
	}


	@Override
	public void newCustomer(Customer newCustomer) {
		customerMap.put(newCustomer.getCustomerId(), newCustomer);

	}

	@Override
	public void updateCustomer(Customer changedCustomer) {
		customerMap.replace(changedCustomer.getCustomerId(), changedCustomer);


	}


	@Override
	public void deleteCustomer(Customer oldCustomer) {
		customerMap.remove(customerMap.get(oldCustomer.getCustomerId()));

	}

	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
		customerMap.get(customerId);
		Customer customer = customerMap.get(customerId);
		return customer;
	}

	public List<Customer> findCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();

        for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
            if (entry.getValue().getCompanyName() == name)
                customers.add(entry.getValue());
        }
        return customers;
    }

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer>customers = new ArrayList<>(); 
		for(Customer i : customerMap.values()){
			customers.add(i);

		}
		return customers; 
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		return customerMap.get(customerId);
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		//First find the customer
		Customer customer = customerMap.get(customerId);
		customer.addCall(callDetails);


		//Call the addCall on the customer

	}

}
