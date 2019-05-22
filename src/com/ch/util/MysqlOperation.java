package com.ch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ch.pojo.CrawlerData;
import com.ch.pojo.KeyWord;
import com.ch.pojo.WebSite;

public class MysqlOperation {
	/**
	 * 返回数据库的链接
	 * @return
	 */
	public Connection mysqlConn(){
	       // 驱动程序名      
		   String driver = "com.mysql.jdbc.Driver";  
		   // URL指向要访问的数据库名world        
		   String url = "jdbc:mysql://localhost:3306/spiderzhaobiao?characterEncoding=utf8";  
		   // MySQL配置时的用户名           
		   String user = "root";           
		   // MySQL配置时的密码          
		   String password = "123";
		   Connection conn = null;
		    // 加载驱动程序        
		   try {
			Class.forName(driver);
		  // 连接数据库  
			conn = DriverManager.getConnection(url, user, password);
		   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   return conn;
	}
	/**
	 * mysql数据库查询
	 * @param conn
	 * @param sql
	 * @return
	 */
	public ResultSet mysqlQuery(Connection conn,Statement st,String sql){
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 封装website表
	 * @param conn
	 * @param st
	 * @param sql
	 * @return
	 */
	public List<WebSite> webSiteQuery(Connection conn,Statement st,String sql){
		ResultSet rs = null;
		List<WebSite> list = new ArrayList();
		try {
			rs = st.executeQuery(sql);
			while(rs.next()){
				WebSite site = new  WebSite();
				site.setId(rs.getInt("id"));
				site.setPid(rs.getInt("pid"));
				site.setCrawerurl(rs.getString("crawerurl"));
				site.setUrlrule(rs.getString("urlrule"));
				site.setPreurl(rs.getString("preurl"));
				site.setPageone(rs.getString("pageone"));
				site.setBid_numrule(rs.getString("bid_numrule"));
				site.setTend_namerule(rs.getString("tend_namerule"));
				site.setTdreerule(rs.getString("tdreerule"));
				site.setBagencyrule(rs.getString("bagencyrule"));
				site.setBtyperule(rs.getString("btyperule"));
				site.setTdcontrule(rs.getString("tdcontrule"));
				site.setCapsorrule(rs.getString("capsorrule"));
				site.setBgetrule(rs.getString("bgetrule"));
				site.setTplacerule(rs.getString("tplacerule"));
				site.setValibrule(rs.getString("valibrule"));
				site.setQreqrule(rs.getString("qreqrule"));
				site.setActdrule(rs.getString("actdrule"));
				site.setValiprerule(rs.getString("valiprerule"));
				site.setBopentrule(rs.getString("bopentrule"));
				site.setOpplacerule(rs.getString("opplacerule"));
				site.setLmrule(rs.getString("lmrule"));
				site.setPhonerule(rs.getString("phonerule"));
				site.setFmrule(rs.getString("fmrule"));
				site.setDaterule(rs.getString("daterule"));
				site.setState(rs.getInt("state"));
				site.setAllcontentrule(rs.getString("allcontentrule"));
				site.setPagenextxpath(rs.getString("pagenextxpath"));
				site.setPagenextcss(rs.getString("pagenextcss"));
				site.setContenttype(rs.getInt("contenttype"));
				site.setPagenum(rs.getInt("pagenum"));
				site.setUrlwebtype(rs.getInt("urlwebtype"));
				site.setIssearcher(rs.getInt("issearcher"));
				site.setContentwebtype(rs.getInt("contentwebtype"));
				site.setStartenum(rs.getInt("startenum"));
				site.setCharset(rs.getString("charset"));

				list.add(site);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * CrawlerData查询方法
	 * @param conn
	 * @param st
	 * @param sql
	 * @return
	 */
	public List<CrawlerData> crawlerDataQuery(Connection conn,Statement st,String sql){
		ResultSet rs = null;
		List<CrawlerData> list = new ArrayList();
		try {
			rs = st.executeQuery(sql);
			while(rs.next()){
				CrawlerData data = new  CrawlerData();
				data.setId(rs.getInt("id"));
				data.setBidding_number(rs.getString("bidding_numbers"));
				data.setThe_tender_name(rs.getString("the_tender_name"));
				data.setTenderee(rs.getString("tenderee"));
				data.setBidding_type(rs.getString("bidding_type"));
				data.setTender_content(rs.getString("tender_content"));
				data.setCapital_source(rs.getString("capital_source"));
				data.setBudget(rs.getString("budget"));
				data.setTo_the_place(rs.getString("to_the_place"));
				data.setValidity_bids(rs.getString("validity_bids"));
				data.setQua_req(rs.getString("qua_req"));
				data.setBid_opentime(rs.getString("bid_opentime"));
				data.setOpenplace(rs.getString("openplace"));
				data.setLinkman(rs.getString("linkman"));
				data.setPhone(rs.getString("phone"));
				data.setFacsimile(rs.getString("facsimile"));
				data.setDate(rs.getString("date"));
				data.setAllcontent(rs.getString("allcontent"));
				data.setContenttype(rs.getInt("contenttype"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * KeyWord查询方法
	 * @param conn
	 * @param st
	 * @param sql
	 * @return
	 */
	public List<KeyWord> keyWordQuery(Connection conn,Statement st,String sql){
		ResultSet rs = null;
		List<KeyWord> list = new ArrayList();
		try {
			rs = st.executeQuery(sql);
			while(rs.next()){
				KeyWord word = new KeyWord();
				word.setId(rs.getInt("id"));
				word.setKeyword(rs.getString("keyword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public Integer InformationInsert(Connection conn,Statement st,String sql){
		int sucess = 0; 
		try {
		 sucess = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sucess;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public void closeMysqlConn(Connection conn,Statement st,ResultSet rs){
		try {
				if(conn!=null){
					conn.close();
					conn = null;
				}
				if(st!=null){
					st.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	 
	public static void main(String[] args){
		MysqlOperation operation  = new MysqlOperation();
		Connection conn = operation.mysqlConn();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select * from website";
			List<WebSite> list = operation.webSiteQuery(conn, st, sql);
			for(WebSite site:list){
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		operation.closeMysqlConn(conn, st, rs);
	 
	}
}

