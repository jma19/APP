package mybatis;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by majun on 15/9/11.
 */
public class MainTest {
    private String url = "jdbc:mysql://localhost:3307/student" ;
    private String username = "root" ;
    private String password = "" ;

    @Before
    public void setUp() throws Exception {
        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
    }

    @Test
    public void should_get_sql_connection() throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, username, password) ;
            assertThat(con!=null,is(true));
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
    }
}