package com.mickey.T01_serverlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;

/**
 * 當服務器關閉時將網頁計數器寫入T29_ServletContextNum.txt，當服務器開啟時放入ServletContext對象中
 */
public class T29_ServletContextNums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	
	//覆寫init初始化方法，將數據讀到ServletContext對象中
	@Override
	public void init() {
		//獲取文件路徑
		String path = this.getServletContext().getRealPath("doc/T29_ServletContextNum.txt");
		AllUseUtil.getLogger(myClass, "path="+path);
		//申明流對象
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String txtNums = br.readLine();
//			AllUseUtil.getLogger(myClass, "init-nums="+txtNums);
			int nums = txtNums!=null ? Integer.parseInt(txtNums) : 0;
			AllUseUtil.getLogger(myClass, "init-nums="+nums);
			this.getServletContext().setAttribute("nums", nums);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//覆寫銷毀方法，存儲計數器到文件中
	@Override
	public void destroy() {
		//獲取文件路徑
		String path = this.getServletContext().getRealPath("doc/T29_ServletContextNum.txt");
		//獲取網頁計數器		
		String nums = this.getServletContext().getAttribute("nums").toString();
		//聲明流對象
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			bw.write(nums);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) fw.close();
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
