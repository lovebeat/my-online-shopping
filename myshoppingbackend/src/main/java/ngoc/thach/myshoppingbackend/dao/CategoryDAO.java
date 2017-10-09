package ngoc.thach.myshoppingbackend.dao;

import java.util.List;

import ngoc.thach.myshoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);
}
