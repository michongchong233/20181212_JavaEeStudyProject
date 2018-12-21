package com.mickey.T01_serverlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;

/**
 * ��A�Ⱦ������ɱN�����p�ƾ��g�JT29_ServletContextNum.txt�A��A�Ⱦ��}�Үɩ�JServletContext��H��
 */
public class T29_ServletContextNums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	
	//�мginit��l�Ƥ�k�A�N�ƾ�Ū��ServletContext��H��
	@Override
	public void init() {
		//��������|
		String path = this.getServletContext().getRealPath("doc/T29_ServletContextNum.txt");
		AllUseUtil.getLogger(myClass, "path="+path);
		//�ө��y��H
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
	
	//�мg�P����k�A�s�x�p�ƾ�����
	@Override
	public void destroy() {
		//��������|
		String path = this.getServletContext().getRealPath("doc/T29_ServletContextNum.txt");
		//��������p�ƾ�		
		String nums = this.getServletContext().getAttribute("nums").toString();
		//�n���y��H
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
