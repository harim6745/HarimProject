package Movie.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author User
 * DB���� Ŭ����
 */
public class MemberDao {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/project_db";
	private Connection conn;
	

	private static MemberDao instance;
	
	private MemberDao () throws ClassNotFoundException, SQLException {
		Class.forName("com."
				+ "mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static MemberDao getInstance() throws ClassNotFoundException, SQLException {
		if (null == instance) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	
	// �α���
/**
 * 
 * @param vo �� �ҷ�����
 * @return �α��� ���� true, ���� false
 */

		public boolean loginMember(MemberVo vo) {
			
			boolean result = false; 
			
			try {			
			String sql = "SELECT id, password1 FROM member WHERE id = ? && password1 = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getId());
		    ps.setString(2, vo.getPassword1());
			
			ResultSet rs = ps.executeQuery();


			if (rs.next()) {
				vo = new MemberVo();
				vo.setId(rs.getString(1));
			    vo.setPassword1(rs.getString(2)); 
				
    			result = true;
			}
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return result;
	        }      
			
		
	

	/**
	 * 
	 * @param vo �� �ҷ�����
	 * @return ȸ������ ���� true, ���� false
	 */
	// ȸ�� ����
	    public boolean insertMember(MemberVo vo){    
	       
	        boolean result = false;       
	        
	        try {
	              
	            String sql = "INSERT INTO member(id, password1, password2, phone) VALUES (?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	    		
	            ps.setString(1,vo.getId());
	            ps.setString(2,vo.getPassword1());
	            ps.setString(3,vo.getPassword2());
	            ps.setString(4,vo.getPhone());
	            
	            if(ps.executeUpdate() > 0) {
	    			result = true;
	    		}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{          
	            try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }      
	        return result;
	    }     
	    
	    

	    // ȸ�� ����
	    public boolean updateMember(MemberVo vo){
		       
		        boolean result = false;
		        
		        try {
		            String sql = "UPDATE member SET password1 = ? , password2 = ?, phone = ? WHERE id = ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		           
		            ps.setString(1,vo.getId());
		            ps.setString(2,vo.getPassword1());
		            ps.setString(3,vo.getPassword2());
		            ps.setString(4,vo.getPhone());   
		            
		            if(ps.executeUpdate() > 0) {
		    			result = true;
		    		}
		           
		        } catch (Exception e) {
		            e.printStackTrace();
		        }finally{          
		            try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		        }      
		        return result;
		    }
	    
	    
	    // ȸ�� ����

	    public boolean deleteMember(String id){        
	        boolean result = false;
	        
	        try {
	           
	            String sql = "DELETE FROM member WHERE id = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, id);
	            
	            if(ps.executeUpdate() > 0) {
	    			result = true;
	    		}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }          
	        return result;
	    }
	
	    
	    
	// no�� ����Ͽ� Ư�� ��� ��ȸ
	public MemberVo select(String id, String password1) throws SQLException {
		String sql = "SELECT * FROM member WHERE id = ? and password1 = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, password1);
				
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			return null;
		}

		MemberVo vo = new MemberVo();
		vo.setNo(rs.getInt(1));
		vo.setId(rs.getString(2));
		vo.setPassword1(rs.getString(3));
		vo.setPassword2(rs.getString(4));
		vo.setPhone(rs.getString(5));
		
		return vo; 
	}
	
	
	// Membervo�� ��� ������ DB�� ����
	public boolean insert(MemberVo vo) {
		String sql = "INSERT INTO member(id, password1, password2, phone) VALUES(?, ?, ?, ?)";
		
		return false;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	
	}

	
	
}
	

