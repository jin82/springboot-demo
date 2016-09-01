package jin.study.movie.service;

import jin.study.movie.model.Admin;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 23:57
 * \* Description:
 * \
 */
public interface AdminService {
	boolean login(Integer id);

	Admin info(Integer id);

	Admin edit(Admin admin);
}
