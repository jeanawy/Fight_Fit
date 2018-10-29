package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.ProcSessionLoginDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.domain.ProcSessionLogin;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;

@Repository
public class ProcSessionLoginDaoImpl extends BaseDao implements ProcSessionLoginDao {
	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	private static final String SEQ_NAME_PROC_SESSIONLOGIN = "seq_proc_sessionlogin";
	
	private static final String COLUMN_SID = "SID";
	private static final String COLUMN_USERNAME = "USERNAME";
	private static final String COLUMN_LOGIN_TIME = "LOGINTIME";
	private static final String COLUMN_LOGOUT_TIME = "LOGOUTTIME";
	private static final String COLUMN_CHANNEL_TYPE = "CHANNEL_TYPE";
	private static final String COLUMN_DEVICE_ID = "DEVICE_ID";
	private static final String COLUMN_TELEPHONE = "TELEPHONE";
	private static final String COLUMN_IPADDRESS = "IPADDRESS";
	
	@Autowired
	private SequencerDao sequencerDao;
	
	public long insertProcSessionLogin(final ProcSessionLogin sessionLogin) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			
			strBuff.append("insert into proc_sessionlogin(sid,username,logintime,logouttime,ipaddress) values(?,?,?,?,?)");
			final long sequence = sequencerDao.getSeqNum(SEQ_NAME_PROC_SESSIONLOGIN);
			//final long sequence = new Date().getTime();
			
			params.add(sequence);
			params.add(sessionLogin.getUsername());
			params.add(sessionLogin.getLoginTime().getTime());
			params.add(sessionLogin.getLogoutTime().getTime());
			params.add(sessionLogin.getIpAddress());
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {
				
				public void setValues(PreparedStatement prep) throws SQLException {
					
					prep.setLong(1, sequence);
					prep.setString(2, sessionLogin.getUsername());
					prep.setTimestamp(3, new Timestamp(sessionLogin.getLoginTime().getTime()));
					prep.setTimestamp(4, new Timestamp(sessionLogin.getLogoutTime().getTime()));
					prep.setString(5, sessionLogin.getIpAddress());
					
				}
			});
			
			return sequence;
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;
			
		}
		
	}

	public ProcSessionLogin getProcSessionLogin(final String username) throws Exception{
		StringBuffer strBuff = new StringBuffer();
		List<ProcSessionLogin> resultList = null;
		ArrayList<Object> params = new ArrayList<Object>();
		
		// Edited by Ratapong W. 20151202.
		try {
			strBuff.append("select * from proc_sessionlogin where username = ? order by logouttime desc");
			
			params.add(username);
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			resultList = getJdbcTemplate().query(strBuff.toString(), new PreparedStatementSetter() {
				
				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setString(1, username);
					
				}
			}, new RowMapper() {

				public Object mapRow(ResultSet rs, int index) throws SQLException {
					ProcSessionLogin sessionLogin = new ProcSessionLogin();
					
					sessionLogin.setSid(BigInteger.valueOf(rs.getLong("SID")));
					sessionLogin.setUsername(rs.getString("username"));
					sessionLogin.setLoginTime(rs.getTimestamp("logintime"));
					sessionLogin.setLogoutTime(rs.getTimestamp("logouttime"));
					sessionLogin.setIpAddress(rs.getString("ipaddress"));
					
					return sessionLogin;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			throw e;
		}
		
		return resultList != null && resultList.size() > 0 ? resultList.get(0) : null;
		
	}	
	
	public void updateProcSessionLogin(final ProcSessionLogin sessionLogin) throws Exception{
		StringBuffer strBuff = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			strBuff.append("update proc_sessionlogin set username = ?, logintime = ?, logouttime = ?, ipaddress = ? ");
			strBuff.append("where sid = ? ");
			
			params.add(sessionLogin.getUsername());
			params.add(sessionLogin.getLoginTime().getTime());
			params.add(sessionLogin.getLogoutTime().getTime());
			params.add(sessionLogin.getIpAddress());
			params.add(sessionLogin.getSid().longValue());

			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {
				
				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setString(1, sessionLogin.getUsername());
					prep.setTimestamp(2, new Timestamp(sessionLogin.getLoginTime().getTime()));
					prep.setTimestamp(3, new Timestamp(sessionLogin.getLogoutTime().getTime()));
					prep.setString(7, sessionLogin.getIpAddress());
					prep.setLong(8, sessionLogin.getSid().longValue());
					
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			throw e;
		}
		
	}
	
	public void deleteProcSessionLogin(final BigInteger sessionLoginId) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			strBuff.append("delete from proc_sessionlogin where SID = ?");
			
			params.add(sessionLoginId);
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {
				
				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setLong(1, sessionLoginId.longValue());
					
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			throw e;
		}
		
	}
	
	
	public boolean deleteByUserID(final String userName) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		boolean flag = false;  
 		ArrayList<Object> params = new ArrayList<Object>();
		
		try {  
				strBuff.append("DELETE  FROM PROC_SESSIONLOGIN WHERE USERNAME=?");
                
				params.add(userName);
				
				systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
				systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
				
				int record  = getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {
						public void setValues(PreparedStatement prep) throws SQLException {
							prep.setString(1, userName);
						}
				});
					
				if(record >0){
					flag = true;
				}  
				
				 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return flag;
	}
	
	// Added by Ratapong W. 20151202.
	public List<ProcSessionLogin> findProcSessionLogin(ProcSessionLogin vo) throws Exception{
		StringBuffer sql = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			sql.append("SELECT * FROM PROC_SESSIONLOGIN ");
			sql.append("WHERE 0=0 ");
			
			if(vo != null){
				if(vo.getSid() != null){
					sql.append(" and ");
					sql.append(COLUMN_SID);
					sql.append(" = ? ");
					params.add(vo.getSid().longValue());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getUsername())){
					sql.append(" and ");
					sql.append(COLUMN_USERNAME);
					sql.append(" = ? ");
					params.add(vo.getUsername());
					
				}
				
				if(vo.getLoginTime() != null){
					sql.append(" and ");
					sql.append(COLUMN_LOGIN_TIME);
					sql.append(" = ? ");
					params.add(vo.getLoginTime());
					
				}
				
				if(vo.getLogoutTime() != null){
					sql.append(" and ");
					sql.append(COLUMN_LOGOUT_TIME);
					sql.append(" = ? ");
					params.add(vo.getLogoutTime());
					
				}
				
				if(StringUtils.isNotEmptyOrNull(vo.getIpAddress())){
					sql.append(" and ");
					sql.append(COLUMN_IPADDRESS);
					sql.append(" = ? ");
					params.add(vo.getIpAddress());
					
				}
				
				systemLogger.debug(LogFormatter.common("sql : " + sql.toString()));
				systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
				
				List<ProcSessionLogin> procSessionLoginList = getJdbcTemplate().query(sql.toString(), params.toArray(), FIND_ProcSessionLogin_ROW_MAPPER);
				
				return procSessionLoginList != null && procSessionLoginList.size() > 0 ? procSessionLoginList : null;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;
			
		}
		
		return null;
		
	}
	
	final RowMapper<ProcSessionLogin> FIND_ProcSessionLogin_ROW_MAPPER = new RowMapper<ProcSessionLogin>() {
		
		public ProcSessionLogin mapRow(ResultSet rs, int arg1) throws SQLException {
			ProcSessionLogin vo = new ProcSessionLogin();
			vo.setSid(BigInteger.valueOf(rs.getLong(COLUMN_SID)));
			vo.setLoginTime(rs.getTimestamp(COLUMN_LOGIN_TIME));
			vo.setLogoutTime(rs.getTimestamp(COLUMN_LOGOUT_TIME));
			vo.setIpAddress(rs.getString(COLUMN_IPADDRESS));
			
			return vo;
		}
	};
	
}
