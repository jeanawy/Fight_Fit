package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
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
import th.fight.fit.mpybackoffice.dao.ProcUserLoginDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.domain.ProcUserLogin;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.SecurityService;
import th.fight.fit.mpybackoffice.util.StringUtils;

@Repository
public class ProcUserLoginDaoImpl extends BaseDao implements ProcUserLoginDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private static final String SEQ_PROC_USER_LOGIN = "seq_proc_user_login";
    private final String TABLE = "PROC_USER_LOGIN";
    private final String USER_ID = "USER_ID";
    private final String USER_LOGIN_ID = "USER_LOGIN_ID";
    private final String USER_NAME = "USER_NAME";
    private final String USER_TYPE = "USER_TYPE";
    private final String CORP_CODE = "CORP_CODE";
    private final String COUNTER = "COUNTER";
    private final String PASSWORD = "PASSWORD";
    private final String LAST_LOGIN_DTTM = "LAST_LOGIN_DTTM";
    private final String LAST_LOGIN_IPADDRESS = "LAST_LOGIN_IPADDRESS";

    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DTTM = "UPDATE_DTTM";
    private final String UPDATE_BY = "UPDATE_BY";

    @Autowired
    private SequencerDao sequencerDao;

    @Autowired
    private SecurityService securityService;
    
    public ProcUserLogin getProcUserLogin(final String username)
            throws Exception {
        Connection conn = null;
        PreparedStatement prep = null;
        StringBuffer strBuff = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();

        final ProcUserLogin userLogin = new ProcUserLogin();

        try {

            strBuff.append("select u.USER_LOGIN_ID as user_login_id, u.USER_ID as user_id, u.USER_NAME as user_name, ");
            strBuff.append(" u.USER_TYPE as user_type, u.corp_code as corp_code, u.counter as counter, u.password as password, ");
            strBuff.append(" u.LAST_LOGIN_DTTM as last_login_dttm, u.LAST_LOGIN_IPADDRESS as last_login_ipaddress ");
            strBuff.append(" from PROC_USER_LOGIN u ");
            strBuff.append(" where u.USER_NAME = ?");

            params.add(username);

            systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
            systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));

            getJdbcTemplate().query(strBuff.toString(),
                    new PreparedStatementSetter() {

                public void setValues(PreparedStatement prep)
                        throws SQLException {
                    prep.setString(1, username);

                }
            }, new RowMapper() {

                public Object mapRow(ResultSet rs, int index)
                        throws SQLException {
                    userLogin.setUserLoginId(BigInteger.valueOf(rs
                            .getLong("user_login_id")));
                    userLogin.setUserId(BigInteger.valueOf(rs
                            .getLong("user_id")));
                    userLogin.setUserName(rs.getString("user_name"));
                    userLogin.setUserType(rs.getString("user_type"));
                    userLogin.setCounter(rs.getInt("counter"));
                    userLogin.setPassword(rs.getString("password"));
                    userLogin.setLastLoginDttm(rs
                            .getTimestamp("last_login_dttm"));
                    userLogin.setLastLoginIpAddress(rs
                            .getString("last_login_ipaddress"));

                    return null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));

            throw e;

        }

        return userLogin.getUserLoginId() != null ? userLogin : null;
    }

    public void updateProcUserLogin(final ProcUserLogin userLogin)
            throws Exception {
        StringBuffer strBuff = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();

        try {

            strBuff.append("update proc_user_login set user_id = ?, user_name = ?, user_type = ?, COUNTER = ?, PASSWORD = ?, LAST_LOGIN_DTTM = ?, LAST_LOGIN_IPADDRESS = ? ");
            strBuff.append("where user_login_id = ? ");

            params.add(userLogin.getUserId().longValue());
            params.add(userLogin.getUserName());
            params.add(userLogin.getUserType());
            params.add(userLogin.getCounter());
            params.add("");
            params.add(userLogin.getLastLoginDttm().getTime());
            params.add(userLogin.getLastLoginIpAddress());
            params.add(userLogin.getUserLoginId().longValue());

            getJdbcTemplate().update(strBuff.toString(),
                    new PreparedStatementSetter() {

                public void setValues(PreparedStatement prep)
                        throws SQLException {
                    prep.setLong(1, userLogin.getUserId().longValue());
                    prep.setString(2, userLogin.getUserName());
                    prep.setString(3, userLogin.getUserType());
                    prep.setInt(4, userLogin.getCounter());
                    prep.setString(5, userLogin.getPassword());
                    prep.setTimestamp(6, new Timestamp(userLogin
                            .getLastLoginDttm().getTime()));
                    prep.setString(7, userLogin.getLastLoginIpAddress());
                    prep.setLong(8, userLogin.getUserLoginId()
                            .longValue());

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }

    public List<ProcUserLogin> findProcUserLoginResponsible() throws Exception {
        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ");
            sql.append("\n PRO.USER_LOGIN_ID , ");
            sql.append("\n PRO.USER_ID , ");
            sql.append("\n PRO.USER_NAME , ");
            sql.append("\n PRO.USER_TYPE , ");
            sql.append("\n PRO.CORP_CODE , ");
            sql.append("\n PRO.COUNTER , ");
            sql.append("\n PRO.PASSWORD , ");
            sql.append("\n PRO.LAST_LOGIN_DTTM , ");
            sql.append("\n PRO.LAST_LOGIN_IPADDRESS ");
            sql.append("\n FROM " + TABLE + " PRO ");
            // sql.append("\n INNER JOIN CIB.PROC_USER_AUTH AUTH ON PRO.USER_ID = AUTH.USER_ID ");
            // sql.append("\n INNER JOIN CIB.PCK_ROLE RO ON AUTH.ROLE_ID = RO.ROLE_ID ");
            // sql.append("\n WHERE RO.ROLE_CODE IN ( '"+ProjectConstant.ROLE_TYPE_OO+"' , '"+ProjectConstant.ROLE_TYPE_OM+"') ");

            List<ProcUserLogin> list = (List<ProcUserLogin>) getJdbcTemplate().query(sql.toString(), FIND_ProcUserLogin_Responsible_ROW_MAPPER);

            return list;

        } catch (Exception e) {
            //setError(log, e);
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return null;
    }

    public long insertProcUserLogin(ProcUserLogin vo) throws Exception {

        long result = 0;
        Date date = new Date();
        String encPwd = null;

        try {

            result = sequencerDao.getSeqNum(SEQ_PROC_USER_LOGIN);
            //result = new Date().getTime();

            StringBuilder sql = new StringBuilder();

            sql.append("\n INSERT INTO " + TABLE + " (");
            sql.append("\n " + USER_LOGIN_ID + " , ");
            sql.append("\n " + USER_ID + " , ");
            sql.append("\n " + USER_NAME + " , ");
            sql.append("\n " + USER_TYPE + " , ");
            sql.append("\n " + COUNTER + " , ");
            sql.append("\n " + PASSWORD + " , ");
            sql.append("\n " + LAST_LOGIN_DTTM + " , ");
            sql.append("\n " + LAST_LOGIN_IPADDRESS + " , ");

            sql.append("\n " + CREATE_DATE + " , ");
            sql.append("\n " + CREATE_BY + " , ");
            sql.append("\n " + UPDATE_DTTM + " , ");
            sql.append("\n " + UPDATE_BY + ") ");

            sql.append("\n VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

            ArrayList<Object> parameters = new ArrayList<Object>();

            parameters.add(result);

            parameters.add(Long.valueOf(vo.getUserId().toString()));

            parameters.add(vo.getUserName());

            parameters.add(vo.getUserType());

            parameters.add(vo.getCounter());

            encPwd = securityService.encryptP12(vo.getPassword());
            parameters.add(encPwd);

            parameters.add(new Date());

            parameters.add(vo.getLastLoginIpAddress());

            parameters.add(date);
            parameters.add("system");
            parameters.add(date);
            parameters.add("system");

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));

        }
        return result;

    }

    public boolean updateProcUserLoginByUserId(ProcUserLogin vo)
            throws Exception {
        boolean flagUpdate = false;
        try {
            StringBuilder sql = new StringBuilder();

            ArrayList<Object> parameters = new ArrayList<Object>();

            sql.append("\n UPDATE " + TABLE + " SET  ");

            if (StringUtils.isNotEmptyOrNull(vo.getPassword())) {
                sql.append(PASSWORD + " = ?, ");
                parameters.add(vo.getPassword());
            }

            if (StringUtils.isNotEmptyOrNull(vo.getUpdateBy())) {
                sql.append(UPDATE_BY + " = ?, ");
                parameters.add(vo.getUpdateBy());
            }

            if (vo.getUpdateDate() != null) {
                sql.append(UPDATE_DTTM + " = ? ");
                parameters.add(vo.getUpdateDate());
            }

            sql.append(" WHERE ");

            sql.append(USER_ID + " = ? ");

            parameters.add(vo.getUserId().toString());

            int rows = getJdbcTemplate().update(sql.toString(), parameters.toArray());

            if (rows > 0) {
                flagUpdate = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));

        }

        return flagUpdate;

    }

    public ProcUserLogin getProcUserLoginByUserId(String userId)
            throws Exception {
        ProcUserLogin userLogin = new ProcUserLogin();
        StringBuffer strBuff = new StringBuffer();

        try {

            strBuff.append("select u.USER_LOGIN_ID as user_login_id, u.USER_ID as user_id, u.USER_NAME as user_name, ");
            strBuff.append(" u.USER_TYPE as user_type, u.corp_code as corp_code, u.counter as counter, u.password as password, ");
            strBuff.append(" u.LAST_LOGIN_DTTM as last_login_dttm, u.LAST_LOGIN_IPADDRESS as last_login_ipaddress ");
            strBuff.append(" from PROC_USER_LOGIN u ");
            strBuff.append(" where u.user_id = ?");

            ArrayList<Object> parameters = new ArrayList<Object>();

            parameters.add(userId);

            systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
            systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            List<ProcUserLogin> list = (List<ProcUserLogin>) getJdbcTemplate().query(strBuff.toString(), parameters.toArray(), FIND_ProcUserLogin_Responsible_ROW_MAPPER);

            if (list != null && !list.isEmpty()) {
                userLogin = list.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));

            throw e;

        }

        return userLogin;
    }

    final RowMapper<ProcUserLogin> FIND_ProcUserLogin_Responsible_ROW_MAPPER = new RowMapper<ProcUserLogin>() {

        public ProcUserLogin mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            final ProcUserLogin resVO = new ProcUserLogin();
            resVO.setUserId(new BigInteger(String.valueOf(rs.getLong(USER_ID))));
            resVO.setUserLoginId(new BigInteger(String.valueOf(rs
                    .getLong(USER_LOGIN_ID))));
            resVO.setUserName(rs.getString(USER_NAME));
            resVO.setUserType(rs.getString(USER_TYPE));
            resVO.setCounter(rs.getInt(COUNTER));
            resVO.setUserName(rs.getString(USER_NAME));
            resVO.setPassword(rs.getString(PASSWORD));
            resVO.setLastLoginDttm(rs.getTimestamp(LAST_LOGIN_DTTM));
            resVO.setLastLoginIpAddress(rs.getString(LAST_LOGIN_IPADDRESS));

            return resVO;
        }
    };

}
