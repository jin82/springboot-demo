package jin.study.movie.service.impl;

import jin.study.movie.mapper.AdminMapper;
import jin.study.movie.model.Admin;
import jin.study.movie.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 23:58
 * \* Description:
 * \
 */
@Service
public class AdminServiceImpl implements AdminService{

	private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Resource
	private AdminMapper adminMapper;

	@Override
	public boolean login(Integer id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		if (admin != null) {
			return true;
		}else{
			return false;
		}

	}

	@Cacheable(value = "admin",keyGenerator = "wiselyKeyGenerator")
	@Override
	public Admin info(Integer id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		logger.info("数据库查询");
		return admin;
	}

	@CacheEvict(value = "admin",allEntries = true)
	@Override
	public Admin edit(Admin admin) {
		adminMapper.updateByPrimaryKeySelective(admin);
		return admin;
	}

}
