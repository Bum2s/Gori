package com.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db.DBConn;
import oracle.jdbc.OracleTypes;

public class SogaeDAO {
	//SogaeDTO에 데이터 추가
	public int insertData(SogaeDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement ps = null;
		String sql;
		
		try {
			
			sql = "insert into Sogae(nik,name,age,sung,height,edu,job,sal,hobby,place,school,ranking,user_id)";
			sql+= "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		

			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getNik());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getSung());
			ps.setInt(5, dto.getHeight());
			ps.setString(6, dto.getEdu());
			ps.setString(7, dto.getJob());
			ps.setInt(8, dto.getSal());
			ps.setString(9, dto.getHobby());
			ps.setString(10, dto.getPlace());
			ps.setString(11, dto.getSchool());
			ps.setInt(12, dto.getRanking());
			ps.setString(13, dto.getUser_id());
			
			result = ps.executeUpdate();
			
			ps.close();
		
	  	} catch (Exception e) {
			System.out.println(e.toString());
	  	}
		return result;
	 }
	
public List<SogaeDTO> getList(){
		
		List<SogaeDTO> lists = new ArrayList<SogaeDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select NIK,NAME,AGE,SUNG,HEIGHT,EDU,JOB,SAL,HOBBY,PLACE,SCHOOL,RANKING,USER_ID ";
			sql += "from SOGAE";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				SogaeDTO dto = new SogaeDTO();
				
				dto.setNik(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setSung(rs.getString(4));
				dto.setHeight(rs.getInt(5));
				dto.setEdu(rs.getString(6));
				dto.setJob(rs.getString(7));
				dto.setSal(rs.getInt("SAL"));
				dto.setHobby(rs.getString("HOBBY"));
				dto.setPlace(rs.getString("PLACE"));
				dto.setSchool(rs.getString("SCHOOL"));
				dto.setRanking(rs.getInt("RANKING"));
				dto.setUser_id(rs.getString("USER_ID"));
				
				lists.add(dto);
				
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
}




//--등급별 분류 완
public List<SogaeDTO> searchRanking(String ui, int selectRank) {
    List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("선택한 등급: " + selectRank);

        sql = "SELECT sung FROM SOGAE WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        rs = ps.executeQuery();

        String selectedSung = null;
        if (rs.next()) {
            selectedSung = rs.getString("sung");
        }

        if (selectedSung != null) {
            sql = "SELECT nik, name, sung, age, height, edu, job, sal, hobby, place, school, ranking, user_id " +
                  "FROM SOGAE " +
                  "WHERE ranking <= ? AND sung != ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, selectRank);
            ps.setString(2, selectedSung);

            rs = ps.executeQuery();

            while (rs.next()) {
                SogaeDTO dto = new SogaeDTO();
                dto.setNik(rs.getString("nik"));
                dto.setName(rs.getString("name"));
                dto.setSung(rs.getString("sung"));
                dto.setAge(rs.getInt("age"));
                dto.setHeight(rs.getInt("height"));
                dto.setEdu(rs.getString("edu"));
                dto.setJob(rs.getString("job"));
                dto.setSal(rs.getInt("sal"));
                dto.setHobby(rs.getString("hobby"));
                dto.setPlace(rs.getString("place"));
                dto.setSchool(rs.getString("school"));
                dto.setRanking(rs.getInt("ranking"));

                lists.add(dto);
            }
        }

    } catch (Exception e) {
        System.out.println(e.toString());
    } 

    return lists;
}
//--학력선택 출력~완
public List<SogaeDTO> searchEdu(String ui, String selectEdu) {
    List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    try {
        System.out.println("선택한 학력: " + selectEdu);

        sql = "SELECT sung FROM SOGAE WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        rs = ps.executeQuery();

        String selectedSung = null;
        if (rs.next()) {
            selectedSung = rs.getString("sung");
        }

        if (selectedSung != null) {
            // 입력한 selectNik과 sung이 다른 정보만 가져오기
            sql = "SELECT nik, name, sung, age, height, edu, job, sal, hobby, place, school, ranking " +
                  "FROM SOGAE " +
                  "WHERE edu = ? AND sung != ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, selectEdu);
            ps.setString(2, selectedSung);

            rs = ps.executeQuery();

            while (rs.next()) {
                SogaeDTO dto = new SogaeDTO();
                dto.setNik(rs.getString("nik"));
                dto.setName(rs.getString("name"));
                dto.setSung(rs.getString("sung"));
                dto.setAge(rs.getInt("age"));
                dto.setHeight(rs.getInt("height"));
                dto.setEdu(rs.getString("edu"));
                dto.setJob(rs.getString("job"));
                dto.setSal(rs.getInt("sal"));
                dto.setHobby(rs.getString("hobby"));
                dto.setPlace(rs.getString("place"));
                dto.setSchool(rs.getString("school"));
                dto.setRanking(rs.getInt("ranking"));

                lists.add(dto);
            }
        }

    } catch (Exception e) {
        System.out.println(e.toString());
    } 
    return lists;
}
//--연봉별 설정출력 ~완
public List<SogaeDTO> searchSal(String ui, int selectSal) {
    List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("최소연봉: " + selectSal+"만원");

        sql = "SELECT sung FROM SOGAE WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        rs = ps.executeQuery();

        String selectedSung = null;
        if (rs.next()) {
            selectedSung = rs.getString("sung");
        }

        if (selectedSung != null) {
            sql = "SELECT nik, name, sung, age, height, edu, job, sal, hobby, place, school, ranking " +
                  "FROM SOGAE " +
                  "WHERE sal > ? AND sung != ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, selectSal);
            ps.setString(2, selectedSung);

            rs = ps.executeQuery();

            while (rs.next()) {
                SogaeDTO dto = new SogaeDTO();
                dto.setNik(rs.getString("nik"));
                dto.setName(rs.getString("name"));
                dto.setSung(rs.getString("sung"));
                dto.setAge(rs.getInt("age"));
                dto.setHeight(rs.getInt("height"));
                dto.setEdu(rs.getString("edu"));
                dto.setJob(rs.getString("job"));
                dto.setSal(rs.getInt("sal"));
                dto.setHobby(rs.getString("hobby"));
                dto.setPlace(rs.getString("place"));
                dto.setSchool(rs.getString("school"));
                dto.setRanking(rs.getInt("ranking"));

                lists.add(dto);
            }
        }

    } catch (Exception e) {
        System.out.println(e.toString());
    } 
    return lists;
}


//--나이별 설정

public List<SogaeDTO> searchAge(String ui, int selectAge) {
    List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("최대나이: " + selectAge+"살");

        sql = "SELECT sung FROM SOGAE WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        rs = ps.executeQuery();

        String selectedSung = null;
        if (rs.next()) {
            selectedSung = rs.getString("sung");
        }

        if (selectedSung != null) {
            sql = "SELECT nik, name, sung, age, height, edu, job, sal, hobby, place, school, ranking " +
                  "FROM SOGAE " +
                  "WHERE age <= ? AND sung != ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, selectAge);
            ps.setString(2, selectedSung);

            rs = ps.executeQuery();

            while (rs.next()) {
                SogaeDTO dto = new SogaeDTO();
                dto.setNik(rs.getString("nik"));
                dto.setName(rs.getString("name"));
                dto.setSung(rs.getString("sung"));
                dto.setAge(rs.getInt("age"));
                dto.setHeight(rs.getInt("height"));
                dto.setEdu(rs.getString("edu"));
                dto.setJob(rs.getString("job"));
                dto.setSal(rs.getInt("sal"));
                dto.setHobby(rs.getString("hobby"));
                dto.setPlace(rs.getString("place"));
                dto.setSchool(rs.getString("school"));
                dto.setRanking(rs.getInt("ranking"));

                lists.add(dto);
            }
        }

    } catch (Exception e) {
        System.out.println(e.toString());
    }  return lists;
}

public List<SogaeDTO> getRandom(String ui) {
	List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = DBConn.getConnection();
        System.out.println("접속한 아이디: " + ui);

        String sql = "SELECT * FROM (SELECT * FROM SOGAE WHERE user_id != ? AND sung != (SELECT sung FROM SOGAE WHERE user_id = ?) ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM <= 1";
       // String sql = "SELECT * FROM (SELECT * FROM SOGAE ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM <= 1";
        // PreparedStatement 생성
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        ps.setString(2, ui);

        rs = ps.executeQuery();

        if (rs.next()) {
            SogaeDTO dto = new SogaeDTO();
            dto.setNik(rs.getString("nik"));
            dto.setName(rs.getString("name"));
            dto.setSung(rs.getString("sung"));
            dto.setAge(rs.getInt("age"));
            dto.setHeight(rs.getInt("height"));
            dto.setEdu(rs.getString("edu"));
            dto.setJob(rs.getString("job"));
            dto.setSal(rs.getInt("sal"));
            dto.setHobby(rs.getString("hobby"));
            dto.setPlace(rs.getString("place"));
            dto.setSchool(rs.getString("school"));
            dto.setRanking(rs.getInt("ranking"));

            lists.add(dto);
            // 나머지 필드도 필요에 따라 추가
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lists;
}



public List<SogaeDTO> getRecommand(String ui) {
    List<SogaeDTO> lists = new ArrayList<>();
    Connection conn = DBConn.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    try {
        System.out.println(" 접속된 유저 ID : " + ui);

        sql = "SELECT sung FROM SOGAE WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ui);
        rs = ps.executeQuery();

        String selectedSung = null;
        if (rs.next()) {
            selectedSung = rs.getString("sung");
        }

        if (selectedSung != null) {
        	sql = "SELECT nik, name, sung, age, height, edu, job, sal, hobby, place, school, ranking, user_id " +
                     "FROM SOGAE " +
                     "WHERE sung != ? AND age BETWEEN (SELECT age FROM SOGAE WHERE user_id = ?) - 6 AND (SELECT age FROM SOGAE WHERE user_id = ?) + 6";

            ps = conn.prepareStatement(sql);
            ps.setString(1, selectedSung);
            ps.setString(2, ui);
            ps.setString(3, ui);

            rs = ps.executeQuery();

            while (rs.next()) {
                SogaeDTO dto = new SogaeDTO();
                dto.setNik(rs.getString("nik"));
                dto.setName(rs.getString("name"));
                dto.setSung(rs.getString("sung"));
                dto.setAge(rs.getInt("age"));
                dto.setHeight(rs.getInt("height"));
                dto.setEdu(rs.getString("edu"));
                dto.setJob(rs.getString("job"));
                dto.setSal(rs.getInt("sal"));
                dto.setHobby(rs.getString("hobby"));
                dto.setPlace(rs.getString("place"));
                dto.setSchool(rs.getString("school"));
                dto.setRanking(rs.getInt("ranking"));
                lists.add(dto);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } 
    return lists;
}



public List<SogaeDTO> getSogaeNik(String nik) {
	 List<SogaeDTO> lists = new ArrayList<>();
	    Connection conn = DBConn.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql;
	    
	try {
        sql = "SELECT * FROM SOGAE WHERE NIK = ?";

        	ps = conn.prepareStatement(sql); 
            ps.setString(1, nik);
             rs = ps.executeQuery(); 
                while (rs.next()) {
                	SogaeDTO dto = new SogaeDTO();
                	dto.setNik(rs.getString("nik"));
                    dto.setName(rs.getString("name"));
                    dto.setSung(rs.getString("sung"));
                    dto.setAge(rs.getInt("age"));
                    dto.setHeight(rs.getInt("height"));
                    dto.setEdu(rs.getString("edu"));
                    dto.setJob(rs.getString("job"));
                    dto.setSal(rs.getInt("sal"));
                    dto.setHobby(rs.getString("hobby"));
                    dto.setPlace(rs.getString("place"));
                    dto.setSchool(rs.getString("school"));
                    dto.setRanking(rs.getInt("ranking"));

                    lists.add(dto);
                    
                }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return lists; 
}

}

