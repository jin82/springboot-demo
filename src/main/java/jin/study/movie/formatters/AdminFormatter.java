package jin.study.movie.formatters;

import jin.study.movie.model.Admin;
import jin.study.movie.service.AdminService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Locale;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 12:32
 * \* Description:
 * \
 */
@Component
public class AdminFormatter implements Formatter<Admin> {

	@Resource
	AdminService adminService;

	@Override
	public Admin parse(String s, Locale locale) throws ParseException {
		Integer id = Integer.parseInt(s);
		return adminService.info(id);
	}

	@Override
	public String print(Admin admin, Locale locale) {
		return admin.getaId()+"";
	}
}
