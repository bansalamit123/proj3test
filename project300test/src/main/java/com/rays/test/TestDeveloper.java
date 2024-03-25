package com.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.dto.DeveloperDTO;
import com.rays.model.DeveloperModel;

public class TestDeveloper {
	public static void main(String[] args) {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() {
		DeveloperModel model = new DeveloperModel();
		DeveloperDTO dto = new DeveloperDTO();
		List list = model.search(dto);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			dto = (DeveloperDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getDob());
			System.out.println(dto.getDepartment());
			System.out.println(dto.getProject());
			System.out.println(dto.getStatus());

		}

	}

	private static void testFindByPk() {
		DeveloperModel model = new DeveloperModel();
		DeveloperDTO dto = model.findByPk(1);
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getDob());
		System.out.println(dto.getDepartment());
		System.out.println(dto.getProject());
		System.out.println(dto.getStatus());

	}

	private static void testDelete() {
		DeveloperDTO dto = new DeveloperDTO();
		dto.setId(3);
		DeveloperModel model = new DeveloperModel();
		model.delete(dto);

	}

	private static void testUpdate() {
		DeveloperDTO dto = new DeveloperDTO();
		dto.setId(3);
		dto.setName("Himanshu");
		dto.setDob(new Date());

		dto.setDepartment("Vivo");
		dto.setProject("Proj3");
		dto.setStatus("Done");
		DeveloperModel model = new DeveloperModel();
		model.update(dto);

	}

	private static void testAdd() {
		DeveloperDTO dto = new DeveloperDTO();
		dto.setName("Lavish");
		dto.setDob(new Date());

		dto.setDepartment("Vivo");
		dto.setProject("Proj3");
		dto.setStatus("Done");
		DeveloperModel model = new DeveloperModel();
		model.add(dto);

	}

}
