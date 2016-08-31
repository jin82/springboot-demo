package jin.study.movie.controller;

import jin.study.movie.model.Customer;
import jin.study.movie.model.Movie;
import jin.study.movie.utils.MovieNameEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 15:49
 * \* Description:
 * \
 */
@RestController
public class IndexController {

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Movie.class,new MovieNameEditor());
	}


	@RequestMapping(value = "/{msg}", method = RequestMethod.GET)
	public Map<String,String> msg(@PathVariable String msg) {
		Map<String, String> resultMsg = new HashMap<>();
		resultMsg.put("key",msg);
		return resultMsg;
	}

	@RequestMapping(value = "/movie/{movie}", method = RequestMethod.GET)
	public Movie binderMsg(@PathVariable Movie movie) {
		return movie;
	}

	@RequestMapping(value = "/customer/{age}",method = RequestMethod.GET)
	public Customer formatterMsg(@PathVariable("age") Customer customer){
		return customer;
	}

}
