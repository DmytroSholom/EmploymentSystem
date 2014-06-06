package edu.system.employment.data;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	public <T> T create(T t);
	public <T> T find(Class<T> type, Object id);
	public void delete(Class type, Object id);
	public <T> T update(T t);
	public List findWithNamedQuery(String namedQueryName);
	public List findWithNamedQuery(String namedQueryName,
			Map<String, Object> parameters);
	public List findWithNamedQuery(String queryName, int resultLimit);
	public <T> List<T> findByNativeQuery(String sql, Class<T> type);
	public List findWithNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit);
}
