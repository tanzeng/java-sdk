package com.qiniu.qbox;

import com.qiniu.qbox.auth.DigestAuthClient;
import com.qiniu.qbox.rs.GetRet;
import com.qiniu.qbox.rs.RSService;
import com.qiniu.qbox.rs.StatRet;

public class SDKTest {

	public static void main(String[] args){
		
		Config.ACCESS_KEY = "LzWIzzpDpGqWCqeSNFs5mCqgT3zQym5_Rqm2ApjE";
		Config.SECRET_KEY = "8R1PQ5PDzcIj8N97Ozk5BpQlvylXMWAS6VUUdxqZ";
		
		DigestAuthClient conn = new DigestAuthClient();
		
		String bucketName = "private";
		RSService rs = new RSService(conn, bucketName);
		
		try {
			
			rs.putFile("sdktest", "", "F:/git/qiniu-java-sdk/src/test/java/com/qiniu/qbox/AppTest.java", "");
			
			StatRet statRet = rs.stat("sdktest");
			
			System.out.println(statRet.getMimeType());
			
			// 下载资源表中的特定文件
			GetRet getRet = rs.get("sdktest", "sdktest");
			
			System.out.println(getRet.getUrl());
		
			// 以断点续下载的方式下载资源表中的某个文件
			//GetRet getIfNotModifiedRet = rs.getIfNotModified("sdktest", "sdktest", getRet.getHash());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
