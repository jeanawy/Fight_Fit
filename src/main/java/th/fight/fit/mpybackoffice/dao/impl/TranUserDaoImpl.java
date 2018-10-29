/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import th.fight.fit.mpybackoffice.dao.TranUserDao;
import th.fight.fit.mpybackoffice.domain.TranUser;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Chayoth
 */
@Repository
public class TranUserDaoImpl extends BaseDao implements TranUserDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "TRAN_USER";
    private final String TRAN_ID = "TRAN_ID";
    private final String TRAN_CODE = "TRAN_CODE";
    private final String UID = "UID";
    private final String EVENT_ID = "EVENT_ID";
    private final String TRAN_REF = "TRAN_REF";
    private final String RANKING_ID = "RANKING_ID";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<TranUser> LIST_TRAN_USER_ROW_MAPPER = new RowMapper<TranUser>() {

        public TranUser mapRow(ResultSet rs, int rowNum) throws SQLException {

            final TranUser tranUser = new TranUser();
            tranUser.setTranId(rs.getObject(TRAN_ID) != null ? BigInteger.valueOf(rs.getLong(TRAN_ID)) : null);
            tranUser.setTranCode(rs.getString(TRAN_CODE));
            tranUser.setUid(rs.getString(UID));
            tranUser.setEventId(rs.getInt(EVENT_ID));
            tranUser.setTranRef(rs.getObject(TRAN_REF) != null ? BigInteger.valueOf(rs.getLong(TRAN_REF)) : null);
            tranUser.setRankingId(rs.getInt(RANKING_ID));            
            tranUser.setIsDelete(rs.getString(IS_DELETE));
            Timestamp timestamp = rs.getTimestamp(CREATE_DATE);
            tranUser.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);
            tranUser.setCreateBy(rs.getString(CREATE_BY));
            Timestamp timestamp1 = rs.getTimestamp(UPDATE_DATE);
            tranUser.setUpdateDate(timestamp1 != null ? new Date(timestamp1.getTime()) : null);
            tranUser.setUpdateBy(rs.getString(UPDATE_BY));
            return tranUser;
        }
    };

    public List<TranUser> getTranUser(TranUser tranUser) throws Exception {
        List<TranUser> list = new ArrayList<TranUser>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (tranUser != null) {
                if (tranUser.getTranId() != null) {
                    sql.append(" AND ").append(TRAN_ID).append(" = ? ");
                    parameters.add(tranUser.getTranId());
                }
                if (StringUtils.isNotEmptyOrNull(tranUser.getTranCode())) {
                    sql.append(" AND ").append(TRAN_CODE).append(" = ? ");
                    parameters.add(tranUser.getTranCode());
                }
                if (StringUtils.isNotEmptyOrNull(tranUser.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(tranUser.getUid());
                }
                if (tranUser.getEventId()!= null) {
                    sql.append(" AND ").append(EVENT_ID).append(" = ? ");
                    parameters.add(tranUser.getEventId());
                }
                if (tranUser.getTranRef() != null) {
                    sql.append(" AND ").append(TRAN_REF).append(" = ? ");
                    parameters.add(tranUser.getTranRef().longValue());
                }
                if (tranUser.getRankingId()!= null) {
                    sql.append(" AND ").append(RANKING_ID).append(" = ? ");
                    parameters.add(tranUser.getRankingId());
                }
                if (StringUtils.isNotEmptyOrNull(tranUser.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(tranUser.getIsDelete());
                }
                if (tranUser.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(tranUser.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(tranUser.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(tranUser.getCreateBy());
                }
                if (tranUser.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(tranUser.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(tranUser.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(tranUser.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_TRAN_USER_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public void insertTranUser(TranUser tranUser) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + TRAN_ID);
            parameters.add(tranUser.getTranId().longValue());

            if (StringUtils.isNotEmptyOrNull(tranUser.getTranCode())) {
                sql.append("," + TRAN_CODE);
                sql2.append(", ?");
                parameters.add(tranUser.getTranCode());
            }

            if (StringUtils.isNotEmptyOrNull(tranUser.getUid())) {
                sql.append("," + UID);
                sql2.append(", ?");
                parameters.add(tranUser.getUid());
            }

            if (tranUser.getEventId()!= null) {
                sql.append("," + EVENT_ID);
                sql2.append(", ?");
                parameters.add(tranUser.getEventId());
            }

            if (tranUser.getTranRef() != null) {
                sql.append("," + TRAN_REF);
                sql2.append(", ?");
                parameters.add(tranUser.getTranRef().longValue());
            }
            
            if (tranUser.getRankingId()!= null) {
                sql.append("," + RANKING_ID);
                sql2.append(", ?");
                parameters.add(tranUser.getRankingId());
            }

            if (StringUtils.isNotEmptyOrNull(tranUser.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(tranUser.getIsDelete());
            }

            if (tranUser.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(tranUser.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(tranUser.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(tranUser.getCreateBy());
            }

            if (tranUser.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(tranUser.getUpdateDate());
            }

            if (StringUtils.isNotEmptyOrNull(tranUser.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(tranUser.getUpdateBy());
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

    public void updateTranUser(TranUser tranUser) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(TRAN_ID).append(" = ?, ");
            sql.append(TRAN_CODE).append(" = ?, ");
            sql.append(UID).append(" = ?, ");
            sql.append(EVENT_ID).append(" = ?, ");
            sql.append(TRAN_REF).append(" = ?, ");
            sql.append(RANKING_ID).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(TRAN_ID).append(" = ? ");

            parameters.add(tranUser.getTranId());
            parameters.add(tranUser.getTranCode());
            parameters.add(tranUser.getUid());
            parameters.add(tranUser.getEventId());
            parameters.add(tranUser.getTranRef());
            parameters.add(tranUser.getRankingId());
            parameters.add(tranUser.getIsDelete());
            parameters.add(tranUser.getCreateDate());
            parameters.add(tranUser.getCreateBy());
            parameters.add(tranUser.getUpdateDate());
            parameters.add(tranUser.getUpdateBy());
            parameters.add(tranUser.getTranId() != null ? tranUser.getTranId() : null);

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
