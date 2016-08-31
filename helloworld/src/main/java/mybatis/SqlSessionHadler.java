package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *sql session handler: mj
 */
public class SqlSessionHadler {
    private static SqlSessionFactory sqlSessionFactory;
    private final static Object obj=new Object();

    public  static SqlSession getSqlSession(){
        if(sqlSessionFactory==null){
            synchronized (obj){
                if(sqlSessionFactory==null){
                    try {
                        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return sqlSessionFactory.openSession();
    }

}
