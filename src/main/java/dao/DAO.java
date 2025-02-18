package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {

	List<T> getAll() throws DAOException;

	Optional<T> getById(K id) throws DAOException;

	boolean insert(T t) throws DAOException;

	boolean update(T t) throws DAOException;

	boolean delete(T t) throws DAOException;

}
