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
import th.fight.fit.mpybackoffice.dao.TranEventDao;
import th.fight.fit.mpybackoffice.domain.TranEvent;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Repository
public class TranEventDaoImpl extends BaseDao implements TranEventDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "TRAN_EVENT";
    private final String TRAN_ID = "TRAN_ID";
    private final String TRAN_CODE = "TRAN_CODE";
    private final String UID = "UID";
    private final String EVENT_ID = "EVENT_ID";
    private final String FROM_TIME = "FROM_TIME";
    private final String TO_TIME = "TO_TIME";
    private final String UID_JOIN = "UID_JOIN";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<TranEvent> LIST_TRAN_EVENT_ROW_MAPPER = new RowMapper<TranEvent>() {

        public TranEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

            final TranEvent tranEvent = new TranEvent();

            tranEvent.setTranId(rs.getObject(TRAN_ID) != null ? BigInteger.valueOf(rs.getLong(TRAN_ID)) : null);
            tranEvent.setTranCode(rs.getString(TRAN_CODE));
            tranEvent.setUid(rs.getString(UID));
            tranEvent.setToTime(rs.getDate(FROM_TIME));
            tranEvent.setFromTime(rs.getDate(TO_TIME));
            tranEvent.setUidJoin(rs.getString(UID_JOIN));
            tranEvent.setIsDelete(rs.getString(IS_DELETE));
            tranEvent.setCreateDate(rs.getDate(CREATE_DATE));
            tranEvent.setCreateDate(rs.getTimestamp(CREATE_DATE));
            Timestamp timestampCD = rs.getTimestamp(CREATE_DATE);
            tranEvent.setCreateDate(timestampCD != null ? new Date(timestampCD.getTime()) : null);
            tranEvent.setCreateBy(rs.getString(CREATE_BY));
            tranEvent.setUpdateDate(rs.getDate(UPDATE_DATE));
            tranEvent.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestampUD = rs.getTimestamp(UPDATE_DATE);
            tranEvent.setCreateDate(timestampUD != null ? new Date(timestampUD.getTime()) : null);
            tranEvent.setUpdateBy(rs.getString(UPDATE_BY));

            return tranEvent;
        }
    };

    public List<TranEvent> getTranEvent(TranEvent tranEvent) throws Exception {
        List<TranEvent> list = new ArrayList<TranEvent>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (tranEvent != null) {
                if (tranEvent.getTranId() != null) {
                    sql.append(" AND ").append(TRAN_ID).append(" = ? ");
                    parameters.add(tranEvent.getTranId());
                }
                if (StringUtils.isNotEmptyOrNull(tranEvent.getTranCode())) {
                    sql.append(" AND ").append(TRAN_CODE).append(" = ? ");
                    parameters.add(tranEvent.getTranCode());
                }
                if (StringUtils.isNotEmptyOrNull(tranEvent.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(tranEvent.getUid());
                }
                if (tranEvent.getFromTime() != null) {
                    sql.append(" AND ").append(FROM_TIME).append(" = ? ");
                    parameters.add(tranEvent.getFromTime());
                }
                if (tranEvent.getToTime() != null) {
                    sql.append(" AND ").append(TO_TIME).append(" = ? ");
                    parameters.add(tranEvent.getToTime());
                }
                if (tranEvent.getUidJoin() != null) {
                    sql.append(" AND ").append(UID_JOIN).append(" = ? ");
                    parameters.add(tranEvent.getUidJoin());
                }

                if (StringUtils.isNotEmptyOrNull(tranEvent.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(tranEvent.getIsDelete());
                }
                if (tranEvent.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(tranEvent.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(tranEvent.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(tranEvent.getCreateBy());
                }
                if (tranEvent.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(tranEvent.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(tranEvent.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(tranEvent.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_TRAN_EVENT_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public void insertTranEvent(TranEvent tranEvent) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + TRAN_ID);
            parameters.add(tranEvent.getTranId().longValue());

            if (StringUtils.isNotEmptyOrNull(tranEvent.getTranCode())) {
                sql.append("," + TRAN_CODE);
                sql2.append(", ?");
                parameters.add(tranEvent.getTranCode());
            }

            if (StringUtils.isNotEmptyOrNull(tranEvent.getUid())) {
                sql.append("," + UID);
                sql2.append(", ?");
                parameters.add(tranEvent.getUid());
            }

            if (tranEvent.getFromTime() != null) {
                sql.append("," + FROM_TIME);
                sql2.append(", ?");
                parameters.add(tranEvent.getFromTime());
            }

            if (tranEvent.getToTime() != null) {
                sql.append("," + TO_TIME);
                sql2.append(", ?");
                parameters.add(tranEvent.getToTime());
            }

            if (tranEvent.getUidJoin() != null) {
                sql.append("," + UID_JOIN);
                sql2.append(", ?");
                parameters.add(tranEvent.getUidJoin());
            }

            if (StringUtils.isNotEmptyOrNull(tranEvent.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(tranEvent.getIsDelete());
            }

            if (tranEvent.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(tranEvent.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(tranEvent.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(tranEvent.getCreateBy());
            }

            if (tranEvent.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(tranEvent.getUpdateDate());
            }

            if (StringUtils.isNotEmptyOrNull(tranEvent.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(tranEvent.getUpdateBy());
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

    public void updateTranEvent(TranEvent tranEvent) throws Exception {
ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(TRAN_ID).append(" = ?, ");
            sql.append(TRAN_CODE).append(" = ?, ");
            sql.append(UID).append(" = ?, ");
            sql.append(FROM_TIME).append(" = ?, ");
            sql.append(TO_TIME).append(" = ?, ");
            sql.append(UID_JOIN).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(TRAN_ID).append(" = ? ");

            parameters.add(tranEvent.getTranId());
            parameters.add(tranEvent.getTranCode());
            parameters.add(tranEvent.getUid());
            parameters.add(tranEvent.getFromTime());
            parameters.add(tranEvent.getToTime());
            parameters.add(tranEvent.getUidJoin());
            parameters.add(tranEvent.getIsDelete());
            parameters.add(tranEvent.getCreateDate());
            parameters.add(tranEvent.getCreateBy());
            parameters.add(tranEvent.getUpdateDate());
            parameters.add(tranEvent.getUpdateBy());
            parameters.add(tranEvent.getTranId() != null ? tranEvent.getTranId() : null);

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
