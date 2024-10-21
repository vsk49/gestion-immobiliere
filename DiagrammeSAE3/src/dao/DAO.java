package dao;

import java.util.List;

public interface DAO<T> {

	public T getById(String id);
	
	public List<T> getAll();
	
	public void update(T t);
	
	public void delete(T t);
	
}
