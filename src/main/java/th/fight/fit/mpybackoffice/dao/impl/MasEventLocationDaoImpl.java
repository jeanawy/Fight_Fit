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
import th.fight.fit.mpybackoffice.dao.MasEventLocationDao;
import th.fight.fit.mpybackoffice.domain.MasEventLocation;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Repository
public class MasEventLocationDaoImpl extends BaseDao implements MasEventLocationDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_EVENT_LOCATION";
    private final String EVENT_LOCATION_ID = "EVENT_LOCATION_ID";
    private final String LATITUDE = "LATITUDE";
    private final String LONGTITUDE = "LONGTITUDE";
    private final String LOCATION_NAME = "LOCATION_NAME";
    private final String LOCATION_PICTURE_URL = "LOCATION_PICTURE_URL";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<MasEventLocation> LIST_MASTER_EVENT_LOCATION_ROW_MAPPER = new RowMapper<MasEventLocation>() {

        public MasEventLocation mapRow(ResultSet rs, int rowNum) throws SQLException {

            final MasEventLocation masEventLocation = new MasEventLocation();

            masEventLocation.setEventLocationId(rs.getString(EVENT_LOCATION_ID));
            masEventLocation.setLongitude(rs.getDouble(LONGTITUDE));
            masEventLocation.setLatitude(rs.getDouble(LATITUDE));
            masEventLocation.setLocationName(rs.getString(LOCATION_NAME));
            masEventLocation.setLocationPictureUrl(rs.getString(LOCATION_PICTURE_URL));
            masEventLocation.setIsDelete(rs.getString(IS_DELETE));
            masEventLocation.setCreateDate(rs.getDate(CREATE_DATE));
            masEventLocation.setCreateDate(rs.getTimestamp(CREATE_DATE));
            Timestamp timestampCD = rs.getTimestamp(CREATE_DATE);
            masEventLocation.setCreateDate(timestampCD != null ? new Date(timestampCD.getTime()) : null);
            masEventLocation.setCreateBy(rs.getString(CREATE_BY));
            masEventLocation.setUpdateDate(rs.getDate(UPDATE_DATE));
            masEventLocation.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestampUD = rs.getTimestamp(UPDATE_DATE);
            masEventLocation.setCreateDate(timestampUD != null ? new Date(timestampUD.getTime()) : null);
            masEventLocation.setUpdateBy(rs.getString(UPDATE_BY));

            return masEventLocation;
        }
    };

    public List<MasEventLocation> getMasEventLocation(MasEventLocation masEventLocation) throws Exception {
        List<MasEventLocation> list = new ArrayList<MasEventLocation>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masEventLocation != null) {
                if (masEventLocation.getEventLocationId() != null) {
                    sql.append(" AND ").append(EVENT_LOCATION_ID).append(" = ? ");
                    parameters.add(masEventLocation.getEventLocationId());
                }
                if (masEventLocation.getLatitude() != null) {
                    sql.append(" AND ").append(LATITUDE).append(" = ? ");
                    parameters.add(masEventLocation.getLatitude());
                }
                if (masEventLocation.getLongitude() != null) {
                    sql.append(" AND ").append(LONGTITUDE).append(" = ? ");
                    parameters.add(masEventLocation.getLongitude());
                }

                if (StringUtils.isNotEmptyOrNull(masEventLocation.getLocationName())) {
                    sql.append(" AND ").append(LOCATION_NAME).append(" = ? ");
                    parameters.add(masEventLocation.getLocationName());
                }
                if (StringUtils.isNotEmptyOrNull(masEventLocation.getLocationPictureUrl())) {
                    sql.append(" AND ").append(LOCATION_PICTURE_URL).append(" = ? ");
                    parameters.add(masEventLocation.getLocationPictureUrl());
                }

                if (StringUtils.isNotEmptyOrNull(masEventLocation.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masEventLocation.getIsDelete());
                }
                if (masEventLocation.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masEventLocation.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEventLocation.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masEventLocation.getCreateBy());
                }
                if (masEventLocation.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masEventLocation.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masEventLocation.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masEventLocation.getUpdateBy());
                }
            }
            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_EVENT_LOCATION_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public boolean insertMasEventLocation(MasEventLocation masEventLocation) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {
            sql.append("INSERT INTO " + TABLE + "(" + EVENT_LOCATION_ID);

            if (masEventLocation.getLatitude() != null) {
                sql.append("," + LATITUDE);
                sql2.append(", ?");
                parameters.add(masEventLocation.getLatitude());
            }
            if (masEventLocation.getLongitude() != null) {
                sql.append("," + LONGTITUDE);
                sql2.append(", ?");
                parameters.add(masEventLocation.getLongitude());
            }
            if (StringUtils.isNotEmptyOrNull(masEventLocation.getLocationName())) {
                sql.append("," + LOCATION_NAME);
                sql2.append(", ?");
                parameters.add(masEventLocation.getLocationName());
            }
            if (StringUtils.isNotEmptyOrNull(masEventLocation.getLocationPictureUrl())) {
                sql.append("," + LOCATION_PICTURE_URL);
                sql2.append(", ?");
                parameters.add(masEventLocation.getLocationPictureUrl());
            }
            if (StringUtils.isNotEmptyOrNull(masEventLocation.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masEventLocation.getIsDelete());
            }
            if (masEventLocation.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masEventLocation.getCreateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masEventLocation.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masEventLocation.getCreateBy());
            }
            if (masEventLocation.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masEventLocation.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masEventLocation.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(masEventLocation.getUpdateBy());
            }
            sql.append(") VALUES(");
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

    public boolean updateMasEventLocation(MasEventLocation masEventLocation) throws Exception {

        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(EVENT_LOCATION_ID).append(" = ?, ");
            sql.append(LATITUDE).append(" = ?, ");
            sql.append(LONGTITUDE).append(" = ?, ");
            sql.append(LOCATION_NAME).append(" = ?, ");
            sql.append(LOCATION_PICTURE_URL).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ? ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(EVENT_LOCATION_ID).append(" = ? ");

            parameters.add(masEventLocation.getEventLocationId());
            parameters.add(masEventLocation.getLatitude());
            parameters.add(masEventLocation.getLongitude());
            parameters.add(masEventLocation.getLocationName());
            parameters.add(masEventLocation.getLocationPictureUrl());
            parameters.add(masEventLocation.getIsDelete());
            parameters.add(masEventLocation.getCreateDate());
            parameters.add(masEventLocation.getCreateBy());
            parameters.add(masEventLocation.getUpdateDate());
            parameters.add(masEventLocation.getUpdateBy());
            parameters.add(masEventLocation.getEventLocationId() != null ? masEventLocation.getEventLocationId() : null);

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

}
