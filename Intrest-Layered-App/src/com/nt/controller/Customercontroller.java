package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.Customerdto;
import com.nt.service.Customerservice;
import com.nt.vo.Customervo;
@WebServlet("/controller")
public class Customercontroller extends HttpServlet {
	
	
	public void  doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		PrintWriter pw =null;
		String name=null,add=null,amt=null,intrest=null,months=null,result=null;
		Customervo vo =null;
		Customerdto dto=null;
		Customerservice cs=null;
		
		res.setContentType("text/html");
		pw=res.getWriter();
		
		
		//reading values from client
		name=req.getParameter("cname");		
		add=req.getParameter("cadd");		
		amt=req.getParameter("cadd");
		intrest=req.getParameter("cintrest");
		months=req.getParameter("cmonths");
		
		//sending the values to vo class
		vo=new Customervo();
		vo.setName(name);
		vo.setAdd(add);
		vo.setAmt(amt);
		vo.setIntrest(intrest);
		vo.setMonths(months);
		
		//sending the values to dto class
		dto=new Customerdto();
		dto.setName(vo.getName());
		dto.setAdd(vo.getAdd());
		dto.setAmt(Float.parseFloat(vo.getAmt()));
		dto.setIntrest(Float.parseFloat(vo.getIntrest()));
		dto.setMonths(Float.parseFloat(vo.getAmt()));
		
		//sending to service class object
		try {
		cs= new Customerservice();
		result=cs.insert(dto);
		pw.println(result);
		
	}catch(Exception e) {
		e.printStackTrace();
        
		pw.println("<h1 text-align='center'>INTERNAL-PROBLEM</h1>");
		
	}
		
		pw.println("<h2 style='color:red;text-align:center'><a href='input.html'>HOME</a></h2>");
	
}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}

}
