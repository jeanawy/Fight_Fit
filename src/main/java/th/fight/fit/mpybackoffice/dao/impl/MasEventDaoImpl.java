/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.dao.impl;

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
import th.fight.fit.mpybackoffice.dao.MasEventDao;
import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Repository
public class MasEventDaoImpl extends BaseDao implements MasEventDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_EVENT";
    private final String EVENT_ID = "EVENT_ID";
    private final String EVENT_LOCATION_ID = "EVENT_LOCATION_ID";
    private final String SPORT_ID = "SPORT_ID";
    private final String TEAM_ID = "TEAM_ID";
    private final String TEAM_SIZE = "TEAM_SIZE";
    
    private final String EVENT_NAME = "EVENT_NAME";
    private final String FROM_TIME = "FROM_TIME";
    private final String TO_TIME = "TO_TIME";
    private final String NO_OF_JOIN = "NO_OF_JOIN";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<MasEvent> LIST_MASTER_EVENT__ROW_MAPPER = new RowMapper<MasEvent>() {

        public MasEvent mapRow(ResultSet rs, int rowNum) throws SQLException {

            final MasEvent masEvent = new MasEvent();

            masEvent.setEventId(rs.getInt(EVENT_ID));
            masEvent.setEventLocationId(rs.getString(EVENT_LOCATION_ID));
            masEvent.setSportId(rs.getString(SPORT_ID));
            masEvent.setTeamId(rs.getString(TEAM_ID));
            masEvent.setTeamSize(rs.getString(TEAM_SIZE));
            masEvent.setEventName(rs.getString(EVENT_NAME));
            masEvent.setFromTime(rs.getDate(FROM_TIME));
            masEvent.setToTime(rs.getDate(TO_TIME));
            masEvent.setNoOfJoin(rs.getString(NO_OF_JOIN));
            masEvent.setIsDelete(rs.getString(IS_DELETE));
            masEvent.setCreateDate(rs.getDate(CREATE_DATE));
            masEvent.setCreateDate(rs.getTimestamp(CREATE_DATE));
            Timestamp timestampCD = rs.getTimestamp(CREATE_DATE);
            masEvent.setCreateDate(timestampCD != null ? new Date(timestampCD.getTime()) : null);
            masEvent.setCreateBy(rs.getString(CREATE_BY));
            masEvent.setUpdateDate(rs.getDate(UPDATE_DATE));
            masEvent.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestampUD = rs.getTimestamp(UPDATE_DATE);
            masEvent.setCreateDate(timestampUD != null ? new Date(timestampUD.getTime()) : null);
            masEvent.setUpdateBy(rs.getString(UPDATE_BY));

            return masEvent;
        }
    };

    public List<MasEvent> getMasEvent(MasEvent masEvent) throws Exception {
        List<MasEvent> list = new ArrayList<MasEvent>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masEvent != null) {
                if (masEvent.getEventId() != null) {
                    sql.append(" AND ").append(EVENT_ID).append(" = ? ");
                    parameters.add(masEvent.getEventId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getEventLocationId())) {
                    sql.append(" AND ").append(EVENT_LOCATION_ID).append(" = ? ");
                    parameters.add(masEvent.getEventLocationId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getSportId())) {
                    sql.append(" AND ").append(SPORT_ID).append(" = ? ");
                    parameters.add(masEvent.getSportId());
                }

                if (StringUtils.isNotEmptyOrNull(masEvent.getTeamId())) {
                    sql.append(" AND ").append(TEAM_ID).append(" = ? ");
                    parameters.add(masEvent.getTeamId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getTeamSize())) {
                    sql.append(" AND ").append(TEAM_SIZE).append(" = ? ");
                    parameters.add(masEvent.getTeamSize());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getEventName())) {
                    sql.append(" AND ").append(EVENT_NAME).append(" = ? ");
                    parameters.add(masEvent.getEventName());
                }
                if (masEvent.getFromTime() != null) {
                    sql.append(" AND ").append(FROM_TIME).append(" = ? ");
                    parameters.add(masEvent.getFromTime());
                }
                if (masEvent.getToTime() != null) {
                    sql.append(" AND ").append(TO_TIME).append(" = ? ");
                    parameters.add(masEvent.getToTime());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getNoOfJoin())) {
                    sql.append(" AND ").append(NO_OF_JOIN).append(" = ? ");
                    parameters.add(masEvent.getNoOfJoin());
                }

                if (StringUtils.isNotEmptyOrNull(masEvent.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masEvent.getIsDelete());
                }
                if (masEvent.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masEvent.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masEvent.getCreateBy());
                }
                if (masEvent.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masEvent.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masEvent.getUpdateBy());
                }
            }
            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_EVENT__ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;

    }

    public boolean insertMasEvent(MasEvent masEvent) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {
            sql.append("INSERT INTO " + TABLE + "(" + EVENT_ID);

            if (StringUtils.isNotEmptyOrNull(masEvent.getEventLocationId())) {
                sql.append("," + EVENT_LOCATION_ID);
                sql2.append(", ?");
                parameters.add(masEvent.getEventLocationId());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getSportId())) {
                sql.append("," + SPORT_ID);
                sql2.append(", ?");
                parameters.add(masEvent.getSportId());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getTeamId())) {
                sql.append("," + TEAM_ID);
                sql2.append(", ?");
                parameters.add(masEvent.getTeamId());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getTeamSize())) {
                sql.append("," + TEAM_SIZE);
                sql2.append(", ?");
                parameters.add(masEvent.getTeamSize());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getEventName())) {
                sql.append("," + EVENT_NAME);
                sql2.append(", ?");
                parameters.add(masEvent.getEventName());
            }
            if (masEvent.getFromTime()!= null) {
                sql.append("," + FROM_TIME);
                sql2.append(", ?");
                parameters.add(masEvent.getFromTime());
            }
            if (masEvent.getToTime()!= null) {
                sql.append("," + TO_TIME);
                sql2.append(", ?");
                parameters.add(masEvent.getToTime());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getNoOfJoin())) {
                sql.append("," + NO_OF_JOIN);
                sql2.append(", ?");
                parameters.add(masEvent.getNoOfJoin());
            }

            if (StringUtils.isNotEmptyOrNull(masEvent.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masEvent.getIsDelete());
            }
            if (masEvent.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masEvent.getCreateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masEvent.getCreateBy());
            }
            if (masEvent.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masEvent.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masEvent.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(masEvent.getUpdateBy());
            }
            sql.append(") VALUES(" + masEvent.getEventId());
            sql.append(sql2.toString());
            sql.append(")");

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

            successFlag = true;

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));

        }
        return successFlag;
    }

    public boolean updateMasEvent(MasEvent masEvent) throws Exception {
        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(EVENT_ID).append(" = ?, ");
            sql.append(EVENT_LOCATION_ID).append(" = ?, ");
            sql.append(SPORT_ID).append(" = ?, ");
            sql.append(TEAM_ID).append(" = ?, ");
            sql.append(TEAM_SIZE).append(" = ?, ");
            sql.append(EVENT_NAME).append(" = ?, ");
            sql.append(FROM_TIME).append(" = ?, ");
            sql.append(TO_TIME).append(" = ?, ");
            sql.append(NO_OF_JOIN).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ? ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(EVENT_ID).append(" = ? ");

            parameters.add(masEvent.getEventId());
            parameters.add(masEvent.getEventLocationId());
            parameters.add(masEvent.getSportId());
            parameters.add(masEvent.getTeamId());
            parameters.add(masEvent.getTeamSize());
            parameters.add(masEvent.getEventName());
            parameters.add(masEvent.getFromTime());
            parameters.add(masEvent.getToTime());
            parameters.add(masEvent.getNoOfJoin());
            parameters.add(masEvent.getIsDelete());
            parameters.add(masEvent.getCreateDate());
            parameters.add(masEvent.getCreateBy());
            parameters.add(masEvent.getUpdateDate());
            parameters.add(masEvent.getUpdateBy());
            parameters.add(masEvent.getEventId() != null ? masEvent.getEventId() : null);

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

            successFlag = true;

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));

        }

        return successFlag;
    }

    public List<MasEvent> getSearchMasEvent(MasEvent masEvent, Integer index, Integer rowPerPage) throws Exception {
        List<MasEvent> list = new ArrayList<MasEvent>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masEvent != null) {
                if (masEvent.getEventId() != null) {
                    sql.append(" AND ").append(EVENT_ID).append(" = ? ");
                    parameters.add(masEvent.getEventId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getEventLocationId())) {
                    sql.append(" AND ").append(EVENT_LOCATION_ID).append(" = ? ");
                    parameters.add(masEvent.getEventLocationId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getSportId())) {
                    sql.append(" AND ").append(SPORT_ID).append(" = ? ");
                    parameters.add(masEvent.getSportId());
                }

                if (StringUtils.isNotEmptyOrNull(masEvent.getTeamId())) {
                    sql.append(" AND ").append(TEAM_ID).append(" = ? ");
                    parameters.add(masEvent.getTeamId());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getTeamSize())) {
                    sql.append(" AND ").append(TEAM_SIZE).append(" = ? ");
                    parameters.add(masEvent.getTeamSize());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getEventName())) {
                    sql.append(" AND ").append(EVENT_NAME).append(" = ? ");
                    parameters.add(masEvent.getEventName());
                }
                  if (masEvent.getFromTime() != null) {
                    sql.append(" AND ").append(FROM_TIME).append(" = ? ");
                    parameters.add(masEvent.getFromTime());
                }
                if (masEvent.getToTime() != null) {
                    sql.append(" AND ").append(TO_TIME).append(" = ? ");
                    parameters.add(masEvent.getToTime());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getNoOfJoin())) {
                    sql.append(" AND ").append(NO_OF_JOIN).append(" = ? ");
                    parameters.add(masEvent.getNoOfJoin());
                }

                if (StringUtils.isNotEmptyOrNull(masEvent.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masEvent.getIsDelete());
                }
                if (masEvent.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masEvent.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masEvent.getCreateBy());
                }
                if (masEvent.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masEvent.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEvent.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masEvent.getUpdateBy());
                }

                sql.append(" order by ").append(EVENT_ID);

                if (index != null && rowPerPage != null) {
                    sql.append(" offset ? rows ");
                    sql.append(" fetch next ? rows only ");
                    parameters.add(index);
                    parameters.add(rowPerPage);
                }
            }
            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_EVENT__ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;

    }

}
