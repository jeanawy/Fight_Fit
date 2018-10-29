package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.ProcUserAuthDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.domain.ProcUserAuthen;
import th.fight.fit.mpybackoffice.domain.vo.ProcUserAuthenVO;
import th.fight.fit.mpybackoffice.util.StringUtils;

@Repository
public class ProcUserAuthDaoImpl extends BaseDao implements ProcUserAuthDao {

	private final String CLASS_PROC_USER_AUTH_DAO_IMPL = "ProcUserAuthDaoImpl";
	private final String METHOD_PROC_INSERT_PROC_USER_AUTH = "insertProcUserAuth";
	private final String METHOD_PROC_FIND_PROC_USER_AUTH = "findProcUserAuth";
	
	private final String SEQ_PROC_USER_AUTH = "seq_proc_user_auth";

	private final Logger log = Logger.getLogger(getClass());

	private final String TABLE = "PROC_USER_AUTH";

	private final String USER_AUTH_ID = "USER_AUTH_ID";
	private final String USER_ID = "USER_ID";
	private final String ROLE_CODE = "ROLE_CODE";
	private final String CORP_CODE = "CORP_CODE";
	private final String CREATE_DATE = "CREATE_DATE";
	private final String CREATE_BY = "CREATE_BY";
	private final String UPDATE_DTTM = "UPDATE_DTTM";
	private final String UPDATE_BY = "UPDATE_BY";
	private final String CITIZEN_ID = "CITIZEN_ID";
	private final String PASSPORT_ID = "PASSPORT_ID";
	private final String ISDELETE = "ISDELETE";
	
	@Autowired
	private SequencerDao sequencerDao;
	public long insertProcUserAuth_2(final ProcUserAuthen procUserAuthen)
			throws Exception {
		final long sequence = sequencerDao.getSeqNum(SEQ_PROC_USER_AUTH);
		StringBuffer strBuff = new StringBuffer();
		try {

			strBuff.append("INSERT INTO PROC_USER_AUTH(USER_AUTH_ID,USER_ID,ROLE_ID,CREATE_DATE, ");
			strBuff.append("CREATE_BY,UPDATE_DTTM,UPDATE_BY) ");
			strBuff.append("VALUES(?,?,?,?,?,?,?)");
			getJdbcTemplate().update(strBuff.toString(),new PreparedStatementSetter(){

				public void setValues(PreparedStatement prep)
						throws SQLException {
					prep.setLong(1, sequence);
					prep.setLong(2, procUserAuthen.getUserId().longValue());
					prep.setString(3, procUserAuthen.getRoleCode());
					prep.setDate(4, new java.sql.Date(procUserAuthen.getCreateDate().getTime()));
					prep.setString(5, procUserAuthen.getCreateBy());
					prep.setTimestamp(6, new Timestamp(procUserAuthen.getUpdateDttm().getTime()));
					prep.setString(7, procUserAuthen.getUpdateBy());
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sequence;
	}

	final RowMapper<ProcUserAuthen> FIND_ProcUserAuthen_ROW_MAPPER = new RowMapper<ProcUserAuthen>() {

		public ProcUserAuthen mapRow(ResultSet rs, int rowNum) throws SQLException {
			final ProcUserAuthen resVO = new ProcUserAuthen();

			resVO.setUserAuthenId(new BigInteger(String.valueOf(rs.getLong(USER_AUTH_ID))));
			resVO.setUserId(new BigInteger(String.valueOf(rs.getLong(USER_ID))));
			resVO.setRoleCode(rs.getString(ROLE_CODE));
			resVO.setCreateDate(rs.getDate(CREATE_DATE));
			resVO.setCreateBy(rs.getString(CREATE_BY));
			resVO.setUpdateDttm(rs.getTimestamp(UPDATE_DTTM));
			resVO.setUpdateBy(rs.getString(UPDATE_BY));
			resVO.setIsDelete(rs.getString(ISDELETE));
			
			return resVO;
		}
	};

	final RowMapper<ProcUserAuthenVO> FIND_ProcUserAuthenVO_ROW_MAPPER = new RowMapper<ProcUserAuthenVO>() {

		public ProcUserAuthenVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			final ProcUserAuthenVO resVO = new ProcUserAuthenVO();

			resVO.setUserAuthenId(new BigInteger(String.valueOf(rs.getLong(USER_AUTH_ID))));
			resVO.setUserId(new BigInteger(String.valueOf(rs.getLong(USER_ID))));
			resVO.setRoleCode(rs.getString(ROLE_CODE));
			resVO.setCitizenId(rs.getString(CITIZEN_ID));
			resVO.setPassportId(rs.getString(PASSPORT_ID));
			resVO.setCreateDate(rs.getDate(CREATE_DATE));
			resVO.setCreateBy(rs.getString(CREATE_BY));
			resVO.setUpdateDttm(rs.getTimestamp(UPDATE_DTTM));
			resVO.setUpdateBy(rs.getString(UPDATE_BY));
			
			return resVO;
		}
	};
	
	public List<ProcUserAuthen> findProcUserAuthen(ProcUserAuthen vo) throws Exception{
		List<ProcUserAuthen> resultList = null;
		
		try {
			StringBuilder sql = new StringBuilder();
			ArrayList<Object> parameters = new ArrayList<Object>();
			
			sql.append("SELECT " + USER_AUTH_ID + ", " + USER_ID + ", " + ROLE_CODE + ", " + CORP_CODE + ", " + CREATE_DATE + ", " + CREATE_BY + ", " + UPDATE_DTTM + ", " + UPDATE_BY + ", " + ISDELETE);
			sql.append(" FROM " + TABLE);
			sql.append(" WHERE 0=0 ");
			
			if(vo != null){
				
				if(vo.getUserAuthenId() != null){
					sql.append(" and " + USER_AUTH_ID + " = ? ");
					parameters.add(vo.getUserAuthenId().longValue());
					
				}
				
				if(vo.getUserId() != null){
					sql.append(" and " + USER_ID + " = ? ");
					parameters.add(vo.getUserId().longValue());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getRoleCode())){
					sql.append(" and " + ROLE_CODE + " = ? ");
					parameters.add(vo.getRoleCode());
					
				}
				
				if(vo.getCreateDate() != null){
					sql.append(" and " + CREATE_DATE + " = ? ");
					parameters.add(vo.getCreateDate());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getCreateBy())){
					sql.append(" and " + CREATE_BY + " = ? ");
					parameters.add(vo.getCreateBy());
					
				}
				
				if(vo.getUpdateDttm() != null){
					sql.append(" and " + UPDATE_DTTM + " = ? ");
					parameters.add(vo.getUpdateDttm());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getUpdateBy())){
					sql.append(" and " + UPDATE_BY + " = ? ");
					parameters.add(vo.getUpdateBy());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getIsDelete())){
					sql.append(" and " + ISDELETE + " = ? ");
					parameters.add(vo.getIsDelete());
					
				}
				
			}
			
			//LogUtil.printLogDebug(CLASS_PROC_USER_AUTH_DAO_IMPL, METHOD_PROC_FIND_PROC_USER_AUTH, "sql : " + sql.toString());
			
			resultList = getJdbcTemplate().query(sql.toString(), parameters.toArray(), FIND_ProcUserAuthen_ROW_MAPPER);
			
		} catch (Exception e) {
			//setError(log , e);
			e.printStackTrace();
		}
		
		return resultList;
		
	}
	
	public long insertProcUserAuth(ProcUserAuthen vo) throws Exception{
		// Edited by Ratapong W. 20150812.
		long sequence = 0;

		try{

			sequence = sequencerDao.getSeqNum(SEQ_PROC_USER_AUTH);
			//sequence = new Date().getTime();

			StringBuilder sql = new StringBuilder();
			StringBuilder sql2 = new StringBuilder();

			ArrayList<Object> parameters = new ArrayList<Object>();

			sql.append("INSERT INTO "+TABLE+" (" + USER_AUTH_ID);

			if(vo.getUserId() != null){
				sql.append(", " + USER_ID);
				sql2.append(",?");
				parameters.add(vo.getUserId().longValue());

			}

			if(StringUtils.isNotEmptyOrNull(vo.getRoleCode())){
				sql.append(", " + ROLE_CODE);
				sql2.append(",?");
				parameters.add(vo.getRoleCode());

			}

			if(vo.getCreateDate() != null){
				sql.append(", " + CREATE_DATE);
				sql2.append(",?");
				parameters.add(vo.getCreateDate());

			}

			if(StringUtils.isNotEmptyOrNull(vo.getCreateBy())){
				sql.append(", " + CREATE_BY);
				sql2.append(",?");
				parameters.add(vo.getCreateBy());

			}

			if(vo.getUpdateDttm() != null){
				sql.append(", " + UPDATE_DTTM);
				sql2.append(",?");
				parameters.add(vo.getUpdateDttm());

			}

			if(StringUtils.isNotEmptyOrNull(vo.getUpdateBy())){
				sql.append(", " + UPDATE_BY);
				sql2.append(",?");
				parameters.add(vo.getUpdateBy());

			}

			if(StringUtils.isNotEmptyOrNull(vo.getIsDelete())){
				sql.append(", " + ISDELETE);
				sql2.append(",?");
				parameters.add(vo.getIsDelete());
				
			}
			
			sql.append(") VALUES(" + sequence);
			sql.append(sql2.toString());
			sql.append(")");

			//LogUtil.printLogDebug(CLASS_PROC_USER_AUTH_DAO_IMPL, METHOD_PROC_INSERT_PROC_USER_AUTH, "sql : " + sql.toString());

			getJdbcTemplate().update(sql.toString(), parameters.toArray());

		}catch(Exception e){
			//setError(log , e);
			e.printStackTrace();
			
		}
		return sequence;

	}

	public void updateProcUserAuth(ProcUserAuthen procUserAuthen)
			throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		try{
			
			// Editd by Ratapong W. 20150824.
			stringBuffer.append("UPDATE "+TABLE);
			stringBuffer.append(" SET " +USER_ID+" = ?, ");
			stringBuffer.append(ROLE_CODE+" = ?,");
			stringBuffer.append(CORP_CODE+" = ?,");
			stringBuffer.append(CREATE_DATE+" = ?,");
			stringBuffer.append(CREATE_BY+" = ?,");
			stringBuffer.append(UPDATE_DTTM+" = ?,");
			stringBuffer.append(UPDATE_BY+" = ?, ");
			stringBuffer.append(ISDELETE+" = ? ");
			stringBuffer.append(" WHERE " + USER_AUTH_ID + " = ? ");

			ArrayList<Object> parameters = new ArrayList<Object>();
			parameters.add(procUserAuthen.getUserId() != null ? procUserAuthen.getUserId().longValue() : null);
			parameters.add(procUserAuthen.getRoleCode());
			parameters.add(procUserAuthen.getCreateDate());
			parameters.add(procUserAuthen.getCreateBy());
			parameters.add(procUserAuthen.getUpdateDttm());
			parameters.add(procUserAuthen.getUpdateBy());
			parameters.add(procUserAuthen.getIsDelete());
			parameters.add(procUserAuthen.getUserAuthenId().longValue());
			
			getJdbcTemplate().update(stringBuffer.toString(), parameters.toArray());

		}catch (Exception e) {
			//setError(log, e);
			e.printStackTrace();
			
		}

	}

	public List<ProcUserAuthenVO> findProcUserAuthByCorpCode(String corpCode) throws Exception{
		List<ProcUserAuthenVO> resultList = null;
		
		try {
			StringBuilder sql = new StringBuilder();
			ArrayList<Object> parameters = new ArrayList<Object>();
			
			sql.append("select ua.user_auth_id, ua.user_id, cu.citizen_id, cu.passport_id, ua.role_code, ua.corp_code, ua.create_date, ua.create_by, ua.update_dttm, ua.update_by ");
			sql.append("from " + TABLE + " ua ");
			sql.append("inner join proc_corp_user_profile cu on cu.cust_id = ua.user_id ");
			sql.append("where ua.corp_code = ? and ua.isdelete = 'N' ");
			
			parameters.add(corpCode);
			
			//LogUtil.printLogDebug(CLASS_PROC_USER_AUTH_DAO_IMPL, METHOD_PROC_FIND_PROC_USER_AUTH, "sql: " + sql.toString());
			
			resultList = (List<ProcUserAuthenVO>) getJdbcTemplate().query(sql.toString(), parameters.toArray(), FIND_ProcUserAuthenVO_ROW_MAPPER);

		} catch (Exception e) {
			//setError(log, e);
			e.printStackTrace();
		}
		
		return resultList;
		
	}

	final RowMapper<ProcUserAuthen> FIND_ProcUserAuthenByUserId_ROW_MAPPER = new RowMapper<ProcUserAuthen>() {

		public ProcUserAuthen mapRow(ResultSet rs, int rowNum) throws SQLException {
			final ProcUserAuthen resVO = new ProcUserAuthen();

			resVO.setUserId(BigInteger.valueOf(rs.getLong(USER_ID)));
			resVO.setUserAuthenId(BigInteger.valueOf(rs.getLong(USER_AUTH_ID)));
			resVO.setRoleCode(rs.getString(ROLE_CODE));
			resVO.setCreateDate(rs.getDate(CREATE_DATE));
			resVO.setCreateBy(rs.getString(CREATE_BY));
			resVO.setUpdateDttm(rs.getTimestamp(UPDATE_DTTM));
			resVO.setUpdateBy(rs.getString(UPDATE_BY));
			resVO.setIsDelete(rs.getString(ISDELETE));

			return resVO;
		}
	};
}
