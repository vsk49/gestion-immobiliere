package modele;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// interface DAO<T, K> pour creer nos propres classes DAO
public interface DAO<T, K> {

	List<T> getAll() throws SQLException;

	Optional<T> getById(K id) throws SQLException;

	boolean insert(T t) throws SQLException;

	boolean update(T t) throws SQLException;

	boolean delete(T t) throws SQLException;

}
