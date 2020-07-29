package com.proyect.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.proyect.main.model.Category;

@Mapper
public interface CategoryMapper {

	@Select("select*from tb_categorias;")
	List<Category> findAll();
}