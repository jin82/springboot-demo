package jin.study.movie.controller;

import jin.study.movie.model.Admin;
import jin.study.movie.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 0:00
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Resource
	AdminService adminService;

	@GetMapping(value = "/{id}")
	public Admin loginTest(@PathVariable("id") Admin admin) {
		return admin;
	}



	@PostMapping(value = "/{id}")
	public Admin editAdmin(@PathVariable Integer id, Admin admin){
		admin.setaId(id);
		adminService.edit(admin);
		return admin;
	}
}
