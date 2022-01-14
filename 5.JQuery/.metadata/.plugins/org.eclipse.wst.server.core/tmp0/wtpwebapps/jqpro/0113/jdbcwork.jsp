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
    
    String sql = "select * from lprod";
    
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
    			"lprod_id" : "<%=rs.getString("lprod_id")%>",
    			"lprod_gu" :"<%=rs.getString("lprod_gu")%>",
    			"lprod_nm" :"<%=rs.getString("lprod_nm")%>"
    		}
    			
    	<%	
    		i++;
    		}
    	%>
    ]
    