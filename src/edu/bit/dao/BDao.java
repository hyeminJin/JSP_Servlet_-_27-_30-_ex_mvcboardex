package edu.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.dto.BDto;

public class BDao {
	DataSource dataSource; //객체 생성 될 때 데이터소스 가져옴
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String bName, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			int rn = pstmt.executeUpdate();
			
			if(rn==1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	
	
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "Select * from MVC_BOARD order by bGroup desc, bStep asc";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dtos;
	}
	public BDto contentView(String strId) {
		
		upHit(strId);
		BDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "Select * from MVC_BOARD where bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				System.out.println(bHit);
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				
				Timestamp bDate = rs.getTimestamp("bDate");
				
				dto = new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dto;
	}
	
	public void upHit(String bId) {
		
		BDto dto = new BDto();
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = dataSource.getConnection();
			String query = "Update MVC_BOARD set bHit=bHit+1 where bId=?";
			pstmt = conn.prepareStatement(query);			
			pstmt.setInt(1, Integer.parseInt(bId));
		
			int rn = pstmt.executeUpdate();
			
			if(rn==1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public void modify(String bName, String bTitle, String bContent, String strId) {	
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "Update MVC_BOARD set bName = ?, bTitle = ?, bContent = ? where bId=?";
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(strId));
			
			int rn = pstmt.executeUpdate();
			
			if(rn==1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	
	
	}
	
	public void delete(String strId) {	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "DELETE FROM MVC_BOARD WHERE bId=?";
			pstmt = conn.prepareStatement(query);	
			pstmt.setInt(1, Integer.parseInt(strId));
			
			int rn = pstmt.executeUpdate();
			
			if(rn == 1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	public BDto reply_view(String strbId) {
		BDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "Select * from MVC_BOARD where bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strbId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				System.out.println(bHit);
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				
				Timestamp bDate = rs.getTimestamp("bDate");
				
				dto = new BDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, bDate);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		
		replyShape(bGroup, bStep); // 원본글에 댓글을 다는거기에 bStep=0 값이 들어감. 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ "values(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			int rn = pstmt.executeUpdate();
			
			if(rn==1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String bGroup, String bStep) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "update mvc_board set bStep=bStep+1 where bGroup=? and bStep > ?"; //? 에 0이 들어오면서 step이 증가하는 쿼리
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bStep));
		
			int rn = pstmt.executeUpdate();
			
			if(rn==1) {
				System.out.println("정상");
			}else {
				System.out.println("비정상");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	
	
}
