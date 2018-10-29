/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.sk
 */
package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.PckUserSessionDao;
import th.fight.fit.mpybackoffice.domain.PckUserSession;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sukrit_p
 */
@Repository
public class PckUserSessionDaoImpl extends BaseDao implements PckUserSessionDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "PCK_USER_SESSION";
    private final String SID = "SID";
    private final String JACK = "JACK";
    private final String UID = "UID";
    private final String SID_STATUS = "SID_STATUS";
    private final String SESSION_TIME = "SESSION_TIME";

    final RowMapper<PckUserSession> LIST_PCK_USER_SESSION_ROW_MAPPER = new RowMapper<PckUserSession>() {

        public PckUserSession mapRow(ResultSet rs, int rowNum) throws SQLException {

            final PckUserSession pckUserSession = new PckUserSession();
            pckUserSession.setSid(rs.getString(SID));
            pckUserSession.setJack(rs.getString(JACK));
            pckUserSession.setUid(rs.getString(UID));
            pckUserSession.setSidStatus(rs.getString(SID_STATUS));
            Timestamp timestamp = rs.getTimestamp(SESSION_TIME);
            pckUserSession.setSessionTime(timestamp != null ? new Date(timestamp.getTime()) : null);
            pckUserSession.setCreateDate(rs.getDate(CREATE_DATE));
            pckUserSession.setCreateBy(rs.getString(CREATE_BY));
            pckUserSession.setUpdateDate(rs.getDate(UPDATE_DTTM));
            pckUserSession.setUpdateBy(rs.getString(UPDATE_BY));
            return pckUserSession;
        }
    };

    public List<PckUserSession> getPckUserSession(PckUserSession pckUserSession) throws Exception {
        List<PckUserSession> list = new ArrayList<PckUserSession>();
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (pckUserSession != null) {
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getSid())) {
                    sql.append(" AND ").append(SID).append(" = ? ");
                    parameters.add(pckUserSession.getSid());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getJack())) {
                    sql.append(" AND ").append(JACK).append(" = ? ");
                    parameters.add(pckUserSession.getJack());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(pckUserSession.getUid());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getSidStatus())) {
                    sql.append(" AND ").append(SID_STATUS).append(" = ? ");
                    parameters.add(pckUserSession.getSidStatus());
                }
                if (pckUserSession.getSessionTime() != null) {
                    sql.append(" AND ").append(SESSION_TIME).append(" = ? ");
                    parameters.add(pckUserSession.getSessionTime());
                }
                if (pckUserSession.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(pckUserSession.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(pckUserSession.getCreateBy());
                }
                if (pckUserSession.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DTTM).append(" = ? ");
                    parameters.add(pckUserSession.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserSession.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(pckUserSession.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_PCK_USER_SESSION_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;

    }

    public void insertPckUserSession(PckUserSession pckUserSession) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + SID);
            parameters.add(pckUserSession.getSid());

            if (StringUtils.isNotEmptyOrNull(pckUserSession.getJack())) {
                sql.append("," + JACK);
                sql2.append(", ?");
                parameters.add(pckUserSession.getJack());
            }

            if (StringUtils.isNotEmptyOrNull(pckUserSession.getUid())) {
                sql.append("," + UID);
                sql2.append(", ?");
                parameters.add(pckUserSession.getUid());
            }

            if (StringUtils.isNotEmptyOrNull(pckUserSession.getSidStatus())) {
                sql.append("," + SID_STATUS);
                sql2.append(", ?");
                parameters.add(pckUserSession.getSidStatus());
            }

            if (pckUserSession.getSessionTime() != null) {
                sql.append("," + SESSION_TIME);
                sql2.append(", ?");
                parameters.add(pckUserSession.getSessionTime());
            }

            if (pckUserSession.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(pckUserSession.getCreateDate());
            }
            if (StringUtils.isNotEmptyOrNull(pckUserSession.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(pckUserSession.getCreateBy());
            }
            if (pckUserSession.getUpdateDate() != null) {
                sql.append("," + UPDATE_DTTM);
                sql2.append(", ?");
                parameters.add(pckUserSession.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(pckUserSession.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(pckUserSession.getUpdateBy());
            }

            sql.append(") VALUES( ? ");
            sql.append(sql2.toString());
            sql.append(")");

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
    }

    public void updatePckUserSession(PckUserSession pckUserSession) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(JACK).append(" = ?, ");
            sql.append(UID).append(" = ?, ");
            sql.append(SID_STATUS).append(" = ?, ");
            sql.append(SESSION_TIME).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DTTM).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(SID).append(" = ? ");

            parameters.add(pckUserSession.getJack());
            parameters.add(pckUserSession.getUid());
            parameters.add(pckUserSession.getSidStatus());
            parameters.add(pckUserSession.getSessionTime());
            parameters.add(pckUserSession.getCreateDate());
            parameters.add(pckUserSession.getCreateBy());
            parameters.add(pckUserSession.getUpdateDate());
            parameters.add(pckUserSession.getUpdateBy());
            parameters.add(pckUserSession.getSid());

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
    }

    public void deleteSessionLogin(PckUserSession pckUserSession) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {

            if (StringUtils.isNotEmptyOrNull(pckUserSession.getSid())) {

                sql.append(" DELETE FROM ").append(TABLE);
                sql.append(" WHERE ").append(SID).append(" = ? ");
                parameters.add(pckUserSession.getSid());

            }
            if (StringUtils.isNotEmptyOrNull(pckUserSession.getUid())) {

                sql.append(" DELETE FROM ").append(TABLE);
                sql.append(" WHERE ").append(UID).append(" = ? ");
                parameters.add(pckUserSession.getUid());

            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
    }
}
