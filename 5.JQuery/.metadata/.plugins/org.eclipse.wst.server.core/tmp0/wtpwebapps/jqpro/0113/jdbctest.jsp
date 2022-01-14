<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<style>
	table{
		border : 1px solid green;
		border-collapse: collapse;
	}
	td{
		width : 200px;
		height: 50px;
		text-align: center;
	}
	</style>
    <%
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "MJH96";
    String pass = "java";
    String driver = "oracle.jdbc.driver.OracleDriver";
    
    Class.forName(driver);
    System.out.println("드라이버로딩");
    
    //Connection객체
    Connection con = DriverManager.getConnection(url, user, pass);
    //Statement
    Statement stmt = con.createStatement();
    
    String sql = "select MEM_ID, MEM_NAME from member";
    
    //resultSet
    ResultSet rs = stmt.executeQuery(sql);
    
    %>
    <table border="1">
    <%
    while(rs.next()){
    %>
    	<tr>
    	<td>아이디</td>
    	<td><%=rs.getString("mem_id")%></td>
    	
    	<td>이름</td>
    	<td><%=rs.getString("mem_name")%></td>
  		</tr>
   <%	
    }
    %>
    </table>
    