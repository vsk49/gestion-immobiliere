package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

	public List<T> getAll();

	public Optional<T> getById(ID id);

	public void insert(T t);

	public void update(T t);

	public void delete(T t);

}
