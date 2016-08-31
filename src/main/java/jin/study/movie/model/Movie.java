package jin.study.movie.model;

import java.io.Serializable;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 16:37
 * \* Description:
 * \
 */
public class Movie implements Serializable{

	private String name;

	private Integer star;

	public Movie() {

	}

	public Movie(String name){
		this.name = name;
		this.star = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}
}
