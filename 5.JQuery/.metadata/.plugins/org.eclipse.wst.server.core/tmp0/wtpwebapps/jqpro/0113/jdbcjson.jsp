<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    
    [
    	<%
    		int i = 0;
    		while(rs.next()){
    			if(i>0) out.print(",");
    	%>		
    		{
    			"id" : "<%=rs.getString("mem_id")%>",
    			"name" :"<%=rs.getString("mem_name")%>"
    		}
    			
    	<%	
    		i++;
    		}
    	%>
    ]
    