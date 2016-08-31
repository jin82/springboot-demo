package jin.study.movie.utils;

import jin.study.movie.model.Movie;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 16:25
 * \* Description:
 * \
 */
public class MovieNameEditor extends PropertyEditorSupport{
	@Override
	public String getAsText() {
		Movie movie = (Movie)getValue();
		if (movie == null) {
			return "";
		}else{
			return movie.getName();
		}
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.hasText(text)){
			setValue(new Movie(text));
		}else{
			setValue(null);
		}
	}
}
