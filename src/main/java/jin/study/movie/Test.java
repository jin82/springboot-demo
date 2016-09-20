package jin.study.movie;


/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/01
 * \* Time: 16:32
 * \* Description:
 * \
 */
public class Test {

	public static void main(String[] args) {
		try{
			Class clazz = Class.forName("jin.study.movie.model.Admin");
			Object o = clazz.newInstance();
			System.out.println(o);
		}catch (Exception e){
			e.printStackTrace();
		}



	}
}
