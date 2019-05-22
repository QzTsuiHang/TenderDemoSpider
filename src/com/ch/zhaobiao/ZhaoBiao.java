package com.ch.zhaobiao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ch.down.HttpDynamical;
import com.ch.down.HttpStatical;
import com.ch.pojo.KeyWord;
import com.ch.pojo.WebSite;
import com.ch.util.MysqlOperation;

public class ZhaoBiao {
	MysqlOperation operation = new MysqlOperation();
	Connection conn = operation.mysqlConn();
	KeyWord keyword = new KeyWord();
	List<KeyWord> listKeyWord = null;
	Statement stKeyWord = null;

	public void collect() throws SQLException{
		Statement st = conn.createStatement();		
		String sql = "SELECT * FROM website";
		ArrayList<String> url = new ArrayList<>();
		List<WebSite> listWebSite = operation.webSiteQuery(conn,st,sql);
		for (WebSite webSite : listWebSite) {
			//判断是否采集 state，1 采集，0 不采集
			if(webSite.getState()==1){
				//判断是否站内搜索 issearcher，1 是，0 不是				
				if(webSite.getIssearcher()==1){
					//获取关键字拼接网址
					String sqlKeyWord = "SELECT * FROM keyword";
					stKeyWord = conn.createStatement();
					listKeyWord = operation.keyWordQuery(conn, stKeyWord, sqlKeyWord);
					int pagenum = webSite.getPagenum();
					//判断第一页是否从0,1开始(是否为空)
					if(webSite.getPageone()==null){
						//拼接关键字，获得采集入口网址
						for (KeyWord keyWord : listKeyWord) {
							System.out.println("采集关键字" +keyWord.getKeyword()+ "开始");
							String urls = webSite.getCrawerurl()+keyWord.getKeyword();
							url.add(urls);
						}
					} 						
				} else if(webSite.getIssearcher()==0){
					//拼接页数，获得采集入口网址
					String urls = webSite.getCrawerurl();					
					url.add(urls);
				}
				
				//判断网页类型 1 静态，2 异步
				
				if(webSite.getUrlwebtype()==1){
					//静态 client，jsoup；1xpath，2css
					HttpStatical statical = new HttpStatical();
					
					
					 
				} else if(webSite.getUrlwebtype()==2){
					//异步 selenium，unit
					HttpDynamical dynamical = new HttpDynamical();
								
				}
				if(webSite.getPreurl()!=null){
					String urlZi = "";
				} else {
					String urlZi = "";
				}
				//redis去重
				//判断内容页类型
				if(webSite.getContentwebtype()==1){
					
				} else if (webSite.getContentwebtype()==2){
					
				}
				if(webSite.getContenttype()==1){
					
				} else if (webSite.getContenttype()==2){
					
				}
				if(webSite.getCharset()=="urf-8"){
					
				}else if(webSite.getCharset()=="gb2312"){
					
				}
		
		}else {
				System.out.println("该网址不采集");
				break;				
			}
		}
		}

	

	public static void main(String[] args) throws SQLException {
		ZhaoBiao zb = new ZhaoBiao();
		zb.collect();
	}
}