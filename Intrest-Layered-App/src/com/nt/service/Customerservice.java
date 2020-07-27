package com.nt.service;

import com.nt.bo.Customerbo;
import com.nt.dao.Customerdao;
import com.nt.dto.Customerdto;

public class Customerservice {

	public String insert(Customerdto dto) throws Exception{
		Customerbo bo =null;
		Customerdao dao=null;
	    int count =0;
		float vaddi=0.0f;
		
		vaddi=(dto.getAmt()*dto.getIntrest()*dto.getMonths())/100.0f;
		
		//creating bo class object 
		bo=new Customerbo();
		bo.setName(dto.getName());
		bo.setAdd(dto.getAdd());
		bo.setAmt(dto.getAmt());
		bo.setIntrest(dto.getIntrest());
		bo.setMonths(dto.getMonths());
		bo.setVaddi(vaddi);
	
		//creating dao class object
		dao=new Customerdao();
		 count=dao.record(bo);
		
	return count==0?"CUSTOMER DETAILS NOT RECORED::----->SORRY...........!!!SOME-WHERE-WENT-WRONG":
		"CUSTOMER DETAILS RECORED::"+"\n"+ "CUSTOMERNAME::------>"+dto.getName()+"\n"+"CUSTOMERADDRESS::----->"+dto.getAdd()
		+"\n"+"ACTUAL-AMOUNT::----->"+dto.getAmt()+"\n"+"INTREST::----->"+dto.getIntrest()+"\n"+"MONTHS::----->"+dto.getMonths()
		+"\n"+"VADDI::----->"+vaddi;
	}
	
}
