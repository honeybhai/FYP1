/**
 * @author Muhammad Haris
 * Nov 14, 2013
 */
package edu.bnu.fyp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class GenericDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/* To insert/update a single record */
	public int insertOrUpdate(String sql, Object object) throws Exception {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(object);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public void delete(String sql, Object...params){
		
		jdbcTemplate.update(sql, params);
		
	}
	/* To insert or update list of records */
	public void insertOrUpdateAll(String sql, List<?> objects) throws Exception {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(objects.toArray());
		namedParameterJdbcTemplate.batchUpdate(sql, batch);
	}

	/* To find a single record against id */
	public Object findById(String sql, Class objectType, Long id) throws Exception {
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(objectType), id);
	}
	public Object findByEmail(String sql, Class objectType, String email) throws Exception {
		
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(objectType), email);
	}

	public Long getMax(String sql){
		return jdbcTemplate.queryForLong(sql);
	}
	/* To find more than 1 records against given params (params can be empty to fetch all records) */
	public List<?> findAll(String sql, Class objectType, Object... params) throws Exception {
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(objectType), params);
	}
	public List<?> findByQuery(String sql, RowMapper<?> rowMapper, Object... params) throws Exception {
		return jdbcTemplate.query(sql, rowMapper, params);
	}
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		/* once datasource is set, instantiate jdbcTemplate and namedParameterJdbcTemple */
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
}
