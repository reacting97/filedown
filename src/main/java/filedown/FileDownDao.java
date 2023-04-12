package filedown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class FileDownDao {
	private DBConnect dbconn;
	
	public FileDownDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(FileDownVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into filedown values(seq_filedown.nextval,?,sysdate,?,?,?,0)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getWriter());
			pstmt.setString(2,vo.getTitle());
			pstmt.setString(3,vo.getContent());
			pstmt.setString(4,vo.getFname());
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄이 생성되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateCnt(int num) {
		Connection conn = dbconn.conn();
		String sql = "update filedowun set cnt=cnt+1 where num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			int num2 = pstmt.executeUpdate();
			System.out.println(num2+"줄이 수정되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public FileDownVo select(int num) {
		Connection conn = dbconn.conn();
		String sql = "select * from filedown where num=?";
		FileDownVo vo=null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new FileDownVo(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public ArrayList<FileDownVo> selectAll() {
		Connection conn = dbconn.conn();
		ArrayList<FileDownVo> list = new ArrayList<FileDownVo>();
		String sql = "select * from filedown";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new FileDownVo(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void update(FileDownVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update filedowun set title = ?, content = ? where num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3,vo.getNum());
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄이 수정되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int num) {
		Connection conn = dbconn.conn();
		String sql = "delete filedown where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			int num2 = pstmt.executeUpdate();
			System.out.println(num2+"줄이 삭제되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
