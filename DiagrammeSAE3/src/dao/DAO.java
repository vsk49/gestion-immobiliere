package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

	public List<T> getAll();

	public Optional<T> getById(ID id);

	public boolean insert(T t);

	public boolean update(T t);

	public boolean delete(T t);

}
