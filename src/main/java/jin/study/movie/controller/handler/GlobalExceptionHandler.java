package jin.study.movie.controller.handler;

import jin.study.movie.exception.JsonException;
import jin.study.movie.exception.TestException;
import jin.study.movie.model.Error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/20
 * \* Time: 20:49
 * \* Description:
 * \
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final String DEFAULT_ERROR_PATH = "error";

	@ExceptionHandler(TestException.class)
	public ModelAndView htmlError(HttpServletRequest request,Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg",e.getMessage());
		mv.setViewName(DEFAULT_ERROR_PATH);
		return mv;
	}

	@ExceptionHandler(JsonException.class)
	@ResponseBody
	public Error jsonError(HttpServletRequest request,Exception e){
		Error err = new Error();
		err.setMsg(e.getMessage());
		return err;
	}

}
