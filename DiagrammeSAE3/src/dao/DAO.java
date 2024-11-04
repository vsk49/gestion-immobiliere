package dao;

import java.util.List;

public interface DAO<T> {

	public List<T> getAll();

	public T getById(String id);

	public void insert(T t);

	public void update(T t);

	public void delete(T t);

}
