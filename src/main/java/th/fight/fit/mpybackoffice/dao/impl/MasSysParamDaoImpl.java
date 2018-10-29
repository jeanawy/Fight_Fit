package th.fight.fit.mpybackoffice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.MasSysParamDao;
import th.fight.fit.mpybackoffice.domain.MasSystemParam;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.Utility;

@Repository
public class MasSysParamDaoImpl extends BaseDao implements MasSysParamDao {
	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	private final String TABLE = "MAS_SYSPARAM";
	private final String PARAMKEY = "PARAMKEY";
	private final String CATEGORY = "CATEGORY";
	private final String DESCRIPTION = "DESCRIPTION";
	private final String DATATYPE = "DATATYPE";
	private final String VALUE = "VALUE";
	private final String MINVALUE = "MIN_VALUE";
	private final String MAXVALUE = "MAX_VALUE";
	private final String UNIT = "UNIT";
	private final String ROLEID = "ROLEID";
	private final String VERSION = "VERSION";
	private final String CREATE_DATE = "CREATE_DATE";
	private final String CREATE_BY = "CREATE_BY";
	private final String UPDATE_DTTM = "UPDATE_DTTM";
	private final String UPDATE_BY = "UPDATE_BY";
	private final String ROWNUM = "ROWNUM";

	public List<MasSystemParam> getMasSysParam(MasSystemParam masSystemParam) {
		StringBuilder sql = new StringBuilder();
		List<MasSystemParam>list = null;
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		try {
			
			sql.append("SELECT "+TABLE+".* FROM "+TABLE+" ");
			
			//sql.append("SELECT row_number() over(ORDER BY PARAMKEY)as ROWNUM,"+TABLE+".* FROM "+TABLE+" ");
			sql.append(" WHERE 0=0 ");
			
			if(masSystemParam != null) {
				if(!Utility.isEmptyOrNull(masSystemParam.getParamKey())) {
					sql.append(" AND PARAMKEY = ? ");
					parameters.add(masSystemParam.getParamKey());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getCategory())) {
					sql.append(" AND CATEGORY = ? ");
					parameters.add(masSystemParam.getCategory());
					
				}
				
				
				if(!Utility.isEmptyOrNull(masSystemParam.getDescription())) {
					sql.append(" AND DESCRIPTION = ? ");
					parameters.add(masSystemParam.getDescription());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getDataType())) {
					sql.append(" AND DATATYPE = ? ");
					parameters.add(masSystemParam.getDataType());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getValue())) {
					sql.append(" AND VALUE = ? ");
					parameters.add(masSystemParam.getValue());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getMinValue())) {
					sql.append(" AND MIN_VALUE = ? ");
					parameters.add(masSystemParam.getMinValue());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getMaxValue())) {
					sql.append(" AND MAX_VALUE = ? ");
					parameters.add(masSystemParam.getMaxValue());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getUnit())) {
					sql.append(" AND UNIT = ? ");
					parameters.add(masSystemParam.getUnit());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getRoleId())) {
					sql.append(" AND ROLEID like ? ");
					parameters.add("%" + masSystemParam.getRoleId() + "%");
					
				}
				
				if(masSystemParam.getCreateDate() != null) {
					sql.append(" AND CREATE_DATE = ? ");
					parameters.add(masSystemParam.getCreateDate());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getCreateBy())) {
					sql.append(" AND CREATE_BY = ? ");
					parameters.add(masSystemParam.getCreateBy());
					
				}
				
				if(masSystemParam.getUpdateDttm() != null) {
					sql.append(" AND UPDATE_DTTM = ? ");
					parameters.add(masSystemParam.getUpdateDttm());
					
				}
				
				if(!Utility.isEmptyOrNull(masSystemParam.getUpdateBy())) {
					sql.append(" AND UPDATE_BY = ? ");
					parameters.add(masSystemParam.getUpdateBy());
					
				}
					
			}

			systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
			systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));
			
			list = (List<MasSystemParam>) getJdbcTemplate().query(sql.toString(), parameters.toArray(), FIND_MAS_SYSPARAM_ROW_MAPPER);
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
		}
		
		return list;
	}
	
	public void updateMasSysParam(MasSystemParam masSystemParam) {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE "+TABLE+" ");
			sql.append("SET "+CATEGORY+"= ? ");
			sql.append(","+DESCRIPTION+"= ? ");
			sql.append(","+DATATYPE+"= ? ");
			sql.append(","+VALUE+"= ? ");
			sql.append(","+MINVALUE+"= ? ");
			sql.append(","+MAXVALUE+"= ? ");
			sql.append(","+UNIT+"= ? ");
			sql.append(","+ROLEID+"= ? ");
			sql.append(","+VERSION+"= ? ");
			sql.append(","+CREATE_DATE+"= ? ");
			sql.append(","+CREATE_BY+"= ? ");
			sql.append(","+UPDATE_DTTM+"= ? ");
			sql.append(","+UPDATE_BY+"= ? ");
			sql.append("WHERE "+PARAMKEY+" = ?");
			
			ArrayList<Object>parameters = new ArrayList<Object>();
			
			parameters.add(masSystemParam.getCategory());
			parameters.add(masSystemParam.getDescription());
			parameters.add(masSystemParam.getDataType());
			parameters.add(masSystemParam.getValue());
			parameters.add(masSystemParam.getMinValue());
			parameters.add(masSystemParam.getMaxValue());
			parameters.add(masSystemParam.getUnit());
			parameters.add(masSystemParam.getRoleId());
			parameters.add(masSystemParam.getVersion());
			parameters.add(masSystemParam.getCreateDate());
			parameters.add(masSystemParam.getCreateBy());
			parameters.add(masSystemParam.getUpdateDttm());
			parameters.add(masSystemParam.getUpdateBy());
			parameters.add(masSystemParam.getParamKey());
			
			systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
			systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));
			
			getJdbcTemplate().update(sql.toString(), parameters.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
		}
		
	}

	public MasSystemParam getMasSysParamByParamKey(String paramKey) {
		StringBuilder sql = new StringBuilder();
		List<MasSystemParam>list = null;
		ArrayList<Object> parameters = new ArrayList<Object>();

		try {
			
			sql.append("SELECT "+TABLE+".* FROM "+TABLE+" ");
			
			//sql.append("SELECT row_number() over()as ROWNUM,"+TABLE+".* FROM "+TABLE+" ");
			sql.append("WHERE 0=0 ");
			
			if(!Utility.isEmptyOrNull(paramKey)){
				sql.append(" AND PARAMKEY = ? ");
				parameters.add(paramKey);
				
			}
			
			list = (List<MasSystemParam>) getJdbcTemplate().query(sql.toString(), parameters.toArray(), FIND_MAS_SYSPARAM_ROW_MAPPER);
			
			systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
			systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));
			
			if(list != null && !list.isEmpty()){
				return list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
		}
		
		return null;
	}

	final RowMapper<MasSystemParam> FIND_MAS_SYSPARAM_ROW_MAPPER = new RowMapper() {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			final MasSystemParam masSystemParam = new MasSystemParam();
            masSystemParam.setParamKey(rs.getString(PARAMKEY));
            masSystemParam.setCategory(rs.getString(CATEGORY));
            masSystemParam.setDescription(rs.getString(DESCRIPTION));
            masSystemParam.setDataType(rs.getString(DATATYPE));
            masSystemParam.setValue(rs.getString(VALUE));
            masSystemParam.setMinValue(rs.getString(MINVALUE));
            masSystemParam.setMaxValue(rs.getString(MAXVALUE));
            masSystemParam.setUnit(rs.getString(UNIT));
            masSystemParam.setRoleId(rs.getString(ROLEID));
            masSystemParam.setVersion(rs.getInt(VERSION));
            masSystemParam.setCreateDate(rs.getDate(CREATE_DATE));
            masSystemParam.setCreateBy(rs.getString(CREATE_BY));
            masSystemParam.setUpdateDttm(rs.getTimestamp(UPDATE_DTTM));
            masSystemParam.setUpdateBy(rs.getString(UPDATE_BY));
			
			return masSystemParam;
		}
	};

}
