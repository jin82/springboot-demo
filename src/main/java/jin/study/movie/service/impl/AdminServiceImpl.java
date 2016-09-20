package jin.study.movie.service.impl;

import jin.study.movie.mapper.AdminMapper;
import jin.study.movie.model.Admin;
import jin.study.movie.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
		Admin admin = info(id);
		return admin != null;

	}

	//@Cacheable(value = "admin",keyGenerator = "wiselyKeyGenerator")
	@Cacheable(value = "admin",key="#id.toString()")
	@Override
	public Admin info(Integer id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		logger.info("数据库查询");
		return admin;
	}

	@CachePut(value = "admin" ,key="#admin.aId.toString()")
	@Override
	public Admin edit(Admin admin) {
		adminMapper.updateByPrimaryKeySelective(admin);
		admin = adminMapper.selectByPrimaryKey(admin.getaId());
		return admin;
	}

	@CacheEvict(value = "admin",allEntries = true)
	@Override
	public void flushAll(){

	}

}
