//DbOp.java;
//package PublicModule;
import java.sql.*;
import javax.swing.JOptionPane;
public class DbOp{
	private static String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	private static String url="jdbc:odbc:bookdb";
	private static Connection con=null;
	private DbOp(){
		try{
			if(con==null){
				Class.forName(driver);
				con=DriverManager.getConnection(url);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"���ݿ�δ�ܴ򿪣�");
			System.out.println(e.getMessage());
		}
	}
	public static ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try{
			if(con==null){
				new DbOp();
			}
			rs=con.createStatement().executeQuery(sql);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"���ݲ�ѯʧ�ܣ�");
			rs=null;
		}
		return rs;
	}
	public static int executeUpdate(String sql){
			int a=0;
		try{
			if(con==null){
				new DbOp();
			}
			a= con.createStatement().executeUpdate(sql);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"���ݿ����ʧ�ܣ�");			
			a= -1;
		}
		return a;
	}
	public static void close(){
		try{
			if(con!=null){
				
				con.close();
				con=null;
				//JOptionPane.showMessageDialog(null,"���ݿ��ѹرգ�");
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"���ݿ�δ�򿪣�");
		}
	}
}