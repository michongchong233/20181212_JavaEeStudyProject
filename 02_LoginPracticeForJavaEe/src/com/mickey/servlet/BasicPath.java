package com.mickey.servlet;

public class BasicPath {
	public static String SignIn = "SignIn.jsp";
	enum PagePath{
		SignIn("SignIn.jsp"),
		SignUp("SignUp.jsp");
		
		private String filePath;
		
		private PagePath(String filePath) {
			this.filePath = filePath;
		}
		
		public String getPagePath() {
			return this.filePath;
		}
	}
	
	enum PicPath{
		MyLogo("image/myLogo.png");
		
		private String filePath;
		
		private PicPath(String filePath) {
			this.filePath = filePath;
		}
		
		public String getPagePath() {
			return this.filePath;
		}
	}
	
}
