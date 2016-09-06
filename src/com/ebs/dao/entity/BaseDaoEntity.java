package com.ebs.dao.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ebs.common.MisException;
import com.ebs.model.BasePO;

@Repository("baseDaoEntity")
public class BaseDaoEntity {

	protected static final transient Log logger = LogFactory.getLog(BaseDaoEntity.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate paraJdbcTemplate;

	@Resource
	private JdbcSplitEntity jdbcSplitEntity;

	/**
	 * 查询单个Map
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: Map<String, Object>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public Map<String, Object> selectSingleMap(String sql,
			Map<String, Object> paramMap) throws MisException {
		return this.selectSingleMap(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 查询单个Map
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: Map<String, Object>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public Map<String, Object> selectSingleMap(String sql,
			SqlParameterSource parameterSource) {
		try {
			if (StringUtils.isEmpty(sql)) {
				throw new MisException("sql语句为空！");
			}

			List<Map<String, Object>> listMap = this.paraJdbcTemplate
					.queryForList(sql, parameterSource);

			if (listMap.size() > 0) {
				return listMap.get(0);
			} else {
				return null;
			}
		} catch (MisException e) {
			throw e;
		} catch (Exception e) {
			throw new MisException(e);
		}
	}

	/**
	 * 查询Object
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: Object
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> Object queryForObject(String sql, Map<String, Object> paramMap,
			Class<T> classObject) throws MisException {
		return this.queryForObject(sql, new MapSqlParameterSource(paramMap),
				classObject);
	}

	/**
	 * 查询Object
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: Object
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> Object queryForObject(String sql,
			SqlParameterSource parameterSource, Class<T> classObject) {
		try {
			if (StringUtils.isEmpty(sql)) {
				throw new MisException("sql语句为空！");
			}

			if (parameterSource == null) {
				throw new MisException("查询参数为空！");
			}

			return this.paraJdbcTemplate.queryForObject(sql, parameterSource,
					classObject);
		} catch (EmptyResultDataAccessException e) {
			logger.debug(e);
			return null;
		} catch (Exception e) {
			throw new MisException(e);
		}
	}

	/**
	 * 查询Object
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: Object
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> Object queryForObject(String sql, Map<String, Object> paramMap,
			RowMapper<T> rowMapper) throws MisException {
		return this.queryForObject(sql, new MapSqlParameterSource(paramMap),
				rowMapper);
	}

	/**
	 * 查询Object
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: Object
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> Object queryForObject(String sql,
			SqlParameterSource parameterSource, RowMapper<T> rowMapper) {
		try {
			if (StringUtils.isEmpty(sql)) {
				logger.debug("sql语句为空！");
				throw new MisException("sql语句为空！");
			}

			if (parameterSource == null) {
				logger.debug("查询参数为空！");
				throw new MisException("查询参数为空！");
			}

			return this.paraJdbcTemplate.queryForObject(sql, parameterSource,
					rowMapper);
		} catch (EmptyResultDataAccessException e) {
			logger.debug(e);
			return null;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 查询String字符串
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: String
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public String queryForString(String sql, Map<String, Object> paramMap)
			throws MisException {
		return this.queryForString(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 查询String字符串
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @返回值: String
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public String queryForString(String sql, SqlParameterSource parameterSource) {
		try {
			return (String) this.queryForObject(sql, parameterSource,
					String.class);
		} catch (MisException e) {
			logger.debug(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 查询int
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: int
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public int queryForInt(String sql, Map<String, Object> paramMap)
			throws MisException {
		return this.queryForInt(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 查询int
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @返回值: int
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public int queryForInt(String sql, SqlParameterSource parameterSource) {
		try {
			Integer integer = (Integer) this.queryForObject(sql,
					parameterSource, Integer.class);

			return integer == null ? 0 : integer.intValue();
		} catch (MisException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 查询long
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: long
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public long queryForLong(String sql, Map<String, Object> paramMap)
			throws MisException {
		return this.queryForInt(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 查询long
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @返回值: long
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public long queryForLong(String sql, SqlParameterSource parameterSource) {
		try {
			Long longValue = (Long) this.queryForObject(sql, parameterSource,
					Long.class);

			return longValue == null ? 0 : longValue.longValue();
		} catch (MisException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 查询Map
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: String
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public Map<String, Object> queryForMap(String sql,
			Map<String, Object> paramMap) throws MisException {
		return this.queryForMap(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 查询Map
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @返回值: String
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public Map<String, Object> queryForMap(String sql,
			SqlParameterSource parameterSource) {
		try {
			if (StringUtils.isEmpty(sql)) {
				logger.debug("sql语句为空！");
				throw new MisException("sql语句为空！");
			}

			if (parameterSource == null) {
				logger.debug("查询参数为空！");
				throw new MisException("查询参数为空！");
			}

			return this.getParaJdbcTemplate().queryForMap(sql, parameterSource);
		} catch (EmptyResultDataAccessException e) {
			logger.debug(e);
			return null;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 获取列表
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @返回值: List<Map<String, Object>>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public List<Map<String, Object>> queryForList(String sql,
			Map<String, Object> paramMap) throws MisException {
		return this.queryForList(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * 获取列表
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: parameterSource 查询参数
	 * @返回值: List<Map<String, Object>>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public List<Map<String, Object>> queryForList(String sql,
			SqlParameterSource parameterSource) {
		try {
			if (StringUtils.isEmpty(sql)) {
				logger.debug("sql语句为空！");
				throw new MisException("sql语句为空！");
			}

			if (parameterSource == null) {
				logger.debug("查询参数为空！");
				throw new MisException("查询参数为空！");
			}

			return this.paraJdbcTemplate.queryForList(sql, parameterSource);
		} catch (MisException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * 获取列表
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: List<T>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> List<T> queryForList(String sql, Map<String, Object> paramMap,
			Class<T> classObject) throws MisException {
		return this.queryForList(sql, new MapSqlParameterSource(paramMap),
				new BeanPropertyRowMapper<T>(classObject));
	}

	/**
	 * 获取列表
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2016年1月6日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @参数: classObject 返回值类型
	 * @返回值: List<T>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> List<T> queryForList(String sql,
			SqlParameterSource parameterSource, Class<T> classObject)
			throws MisException {
		return this.queryForList(sql, parameterSource,
				new BeanPropertyRowMapper<T>(classObject));
	}

	/**
	 * 获取列表
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: sql sql语句
	 * @参数: paramMap 查询参数
	 * @参数: rowMapper 返回值匹配类型
	 * @返回值: List<T>
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public <T> List<T> queryForList(String sql,
			SqlParameterSource parameterSource, RowMapper<T> rowMapper) {
		try {
			if (StringUtils.isEmpty(sql)) {
				logger.debug("sql语句为空！");
				throw new MisException("sql语句为空！");
			}

			if (parameterSource == null) {
				logger.debug("查询参数为null！");
				throw new MisException("查询参数为null！");
			}

			return this.paraJdbcTemplate.query(sql, parameterSource, rowMapper);
		} catch (MisException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new MisException(e);
		}
	}

	/**
	 * jdbc方式插入数据
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcInsert(BasePO basePO) {
		this.getJdbcTemplate().update(
				"insert into " + basePO.getStrTableName() + " ("
						+ basePO.getStrFields() + ") values ("
						+ basePO.getStrInsValues() + ")");
	}

	/**
	 * jdbc带参方式插入数据，只插入不为空的字段
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcParamInsert(BasePO basePO) {
		this.getParaJdbcTemplate().update(
				"insert into " + basePO.getStrTableName() + " ("
						+ basePO.getStrInsFields() + ") values ("
						+ basePO.getStrInsParFields() + ")",
				basePO.getMapInsParValues());
	}

	/**
	 * jdbc方式更新数据
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcUpdate(BasePO basePO) {
		this.getJdbcTemplate().update(
				"update " + basePO.getStrTableName() + " set "
						+ basePO.getStrUpdValues() + " where "
						+ basePO.getStrKeyWhere());
	}

	/**
	 * jdbc带参方式更新数据，只更新被set的字段
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcParamUpdate(BasePO basePO) {
		this.getParaJdbcTemplate().update(
				"update " + basePO.getStrTableName() + " set "
						+ basePO.getStrUpdParFields() + " where "
						+ basePO.getStrKeyParWhere(),
				basePO.getMapUpdParValues());
	}

	/**
	 * jdbc带参方式删除数据
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcDelete(BasePO basePO) {
		this.getJdbcTemplate().update(
				"delete " + basePO.getStrTableName() + " where "
						+ basePO.getStrKeyWhere());
	}

	/**
	 * jdbc带参方式删除数据
	 * 
	 * @作者： 刘明磊
	 * @创建日期：2015年12月14日
	 * 
	 * @参数: basePO 实体
	 * @返回值:
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void jdbcParamDelete(BasePO basePO) {
		this.getParaJdbcTemplate().update(
				"delete from " + basePO.getStrTableName() + " where "
						+ basePO.getStrKeyParWhere(),
				basePO.getMapUpdParValues());
	}

	/**
	 * @author 闫志刚
	 * @discription : 批量更新
	 * @param listPO
	 */
	public void jdbcBatchUpdate(List<BasePO> listPO) {
		List<String> listBatchSql = new ArrayList<String>();
		for (BasePO po : listPO) {
			listBatchSql.add("update " + po.getStrTableName() + " set "
					+ po.getStrUpdValues() + " where " + po.getStrKeyWhere());
		}
		this.jdbcTemplate.batchUpdate(listBatchSql.toArray(new String[] {}));
	}

	@Deprecated
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getParaJdbcTemplate() {
		return paraJdbcTemplate;
	}

	public void setParaJdbcTemplate(NamedParameterJdbcTemplate paraJdbcTemplate) {
		this.paraJdbcTemplate = paraJdbcTemplate;
	}

	public JdbcSplitEntity getJdbcSplitEntity() {
		return jdbcSplitEntity;
	}

	public void setJdbcSplitEntity(JdbcSplitEntity jdbcSplitEntity) {
		this.jdbcSplitEntity = jdbcSplitEntity;
	}

}
