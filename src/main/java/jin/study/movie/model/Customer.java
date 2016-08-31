package jin.study.movie.model;

import java.io.Serializable;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 16:49
 * \* Description:
 * \
 */
public class Customer implements Serializable{

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
