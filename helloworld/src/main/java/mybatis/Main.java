package mybatis;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Map;

/**
 * Created by majun on 15/9/10.
 */
public class Main {
    public static void main(String[]args) throws IOException {
        SqlSession sqlSession = SqlSessionHadler.getSqlSession();
        Map objects = sqlSession.selectMap("selectAll","id");
        System.out.println(objects);
    }

}
