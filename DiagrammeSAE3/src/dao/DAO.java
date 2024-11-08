package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

	public List<T> getAll();

	public Optional<T> getById(ID id);

	public void insert(T t) throws IllegalArgumentException;

	public void update(T t) throws IllegalArgumentException;

	public void delete(T t) throws IllegalArgumentException;

}
