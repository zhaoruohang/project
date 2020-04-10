package com.zrh.util;

import java.util.Comparator;

import com.zrh.entity.ModulesDto;

public class ModulesDtoCompator implements Comparator<ModulesDto> {

	public int compare(ModulesDto o1, ModulesDto o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}

	

}
