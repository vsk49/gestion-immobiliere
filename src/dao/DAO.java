package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

	public List<T> getAll() throws DAOException;

	public Optional<T> getById(ID id) throws DAOException;

	public boolean insert(T t) throws DAOException;

	public boolean update(T t) throws DAOException;

	public boolean delete(T t) throws DAOException;

}
