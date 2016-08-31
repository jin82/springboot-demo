package jin.study.movie.formatters;

import jin.study.movie.model.Customer;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 16:40
 * \* Description:
 * \
 */
public class CustomerFormatter implements Formatter<Customer> {

	@Override
	public Customer parse(String s, Locale locale) throws ParseException {
		Customer customer = new Customer();
		customer.setName(s);
		if("one".equals(s)){
			customer.setAge(1);
			return customer;
		}else if("five".equals(s)){
			customer.setAge(5);
			return customer;
		}else{
			return null;
		}
	}

	@Override
	public String print(Customer customer, Locale locale) {
		return customer.getName();
	}
}
