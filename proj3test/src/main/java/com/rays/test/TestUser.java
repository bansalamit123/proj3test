package com.rays.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws ParseException {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		//testSearch();
		testAuthentication();
	}

	private static void testAuthentication() {
		UserModel model=new UserModel();
		UserDTO dto=model.authenticate("bansalamit168@gmail.com", "12345");
		if(dto!=null) {
			  System.out.println(dto.getId());
			  System.out.println(dto.getName());
			  System.out.println(dto.getLoginId());
			  System.out.println(dto.getPassword());
			  System.out.println(dto.getDob());
			  System.out.println(dto.getAddress());
			
		}
		else
			System.out.println("Invalid LoginId And Password");
		
		
	}

	private static void testSearch() {
		UserModel model=new UserModel();
		UserDTO dto=new UserDTO ();
		dto.setName("Himanshu");
		List list=model.search(dto,1,1);
		  Iterator it=list.iterator();
		  while(it.hasNext()) {
			  dto=(UserDTO)it.next();
			  System.out.println(dto.getId());
			  System.out.println(dto.getName());
			  System.out.println(dto.getLoginId());
			  System.out.println(dto.getPassword());
			  System.out.println(dto.getDob());
			  System.out.println(dto.getAddress());
			 
			  
		  }
		
		
		
	}

	private static void testFindByPk() {
		UserModel model=new UserModel();
		UserDTO dto=model.findByPk(1);
		
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
	
	
		
	}

	private static void testDelete() {
		UserModel model=new UserModel();
		UserDTO dto=new UserDTO();
		dto.setId(3);
		model.delete(dto);
		
	}

	private static void testUpdate() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserDTO dto=new UserDTO();
		dto.setId(1);
		dto.setName("Lokesh");
		dto.setLoginId("lokesh168@gmail.com");
		dto.setPassword("1234");
		dto.setAddress("indore");
		dto.setDob(sdf.parse("1999-10-09"));
		  UserModel model=new UserModel();
			model.update(dto);
		
	}

	private static void testAdd() {
		UserDTO dto=new UserDTO();
		dto.setName("Himanshu");
		dto.setLoginId("bansalamit168@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("bhopal");
	    UserModel model=new UserModel();
		model.add(dto);
		
	}
	
	
	

}
