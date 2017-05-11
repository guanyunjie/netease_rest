package com.netease.web;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netease.service.NeteaseService;
import com.netease.util.RequireUtil;

/**
 * Servlet implementation class PublicControl
 */
@WebServlet("/PublicControl")
public class PublicControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static NeteaseService neteaseService = new NeteaseService();
    public PublicControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		BufferedReader reader = request.getReader();
		StringBuffer json = new StringBuffer();
		String line = "";
		while((line = reader.readLine()) != null){
			json.append(line);
		}
		
		if(neteaseService == null)
			neteaseService = new NeteaseService();
		
		String result = RequireUtil.invoke(json.toString(),neteaseService);
		
		response.getOutputStream().write(result.getBytes());
	}
}
