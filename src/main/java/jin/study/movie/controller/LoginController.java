package jin.study.movie.controller;

import jin.study.movie.exception.JsonException;
import jin.study.movie.exception.TestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/17
 * \* Time: 17:23
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping
	public String login(String username,String password){
		return "login";
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

	@RequestMapping("htmlerror")
	public String htmlError(){
		throw new TestException("html Error!");
	}

	@RequestMapping("jsonerror")
	public String jsonError(){
		throw new JsonException("json Error!");
	}

}
