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
import th.fight.fit.mpybackoffice.dao.MasMeetingRoomDao;
import th.fight.fit.mpybackoffice.domain.MasMeetingRoom;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Chayoth
 */
@Repository
public class MasMeetingRoomDaoImpl extends BaseDao implements MasMeetingRoomDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_MEETING_ROOM";
    private final String ROOM_ID = "ROOM_ID";
    private final String ROOM_TH = "ROOM_TH";
    private final String ROOM_EN = "ROOM_EN";
    private final String BUILDING_ID = "BUILDING_ID";
    private final String PROJECTER = "PROJECTER";
    private final String MONITOR = "MONITOR";
    private final String VDO_CONFERENCE = "VDO_CONFERENCE";
    private final String WHITE_BOARD = "WHITE_BOARD";
    private final String NO_OF_ATTENDEES = "NO_OF_ATTENDEES";
    private final String ROOM_PICTURE_URL = "ROOM_PICTURE_URL";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    private final String TABLE2 = "PCK_USER_MEETING_ROOM";
    private final String FROM_TIME = "FROM_TIME";
    private final String TO_TIME = "TO_TIME";
    private final String BOOKING_STATUS = "BOOKING_STATUS";

    final RowMapper<MasMeetingRoom> LIST_MASTER_MEETING_ROOM_ROW_MAPPER = new RowMapper<MasMeetingRoom>() {

        public MasMeetingRoom mapRow(ResultSet rs, int rowNum) throws SQLException {

            final MasMeetingRoom masMeetingRoom = new MasMeetingRoom();
            masMeetingRoom.setRoomId(rs.getInt(ROOM_ID));
            masMeetingRoom.setRoomTh(rs.getString(ROOM_TH));
            masMeetingRoom.setRoomEn(rs.getString(ROOM_EN));
            masMeetingRoom.setBuildingId(rs.getInt(BUILDING_ID));
            masMeetingRoom.setProjecter(rs.getString(PROJECTER));
            masMeetingRoom.setMonitor(rs.getString(MONITOR));
            masMeetingRoom.setVdoConference(rs.getString(VDO_CONFERENCE));
            masMeetingRoom.setWhiteBoard(rs.getString(WHITE_BOARD));
            masMeetingRoom.setNoOfAttendees(rs.getInt(NO_OF_ATTENDEES));
            masMeetingRoom.setRoomPictureUrl(rs.getString(ROOM_PICTURE_URL));
            masMeetingRoom.setIsDelete(rs.getString(IS_DELETE));

            masMeetingRoom.setCreateDate(rs.getDate(CREATE_DATE));
            Timestamp timestamp = rs.getTimestamp(CREATE_DATE);
            masMeetingRoom.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);

            masMeetingRoom.setCreateBy(rs.getString(CREATE_BY));

            masMeetingRoom.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestamp1 = rs.getTimestamp(UPDATE_DATE);
            masMeetingRoom.setCreateDate(timestamp1 != null ? new Date(timestamp1.getTime()) : null);

            masMeetingRoom.setUpdateBy(rs.getString(UPDATE_BY));
            return masMeetingRoom;
        }
    };

    public List<MasMeetingRoom> getMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception {
        List<MasMeetingRoom> list = new ArrayList<MasMeetingRoom>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masMeetingRoom != null) {
                if (masMeetingRoom.getRoomId() != null) {
                    sql.append(" AND ").append(ROOM_ID).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomId());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomTh())) {
                    sql.append(" AND ").append(ROOM_TH).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomTh());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomEn())) {
                    sql.append(" AND ").append(ROOM_EN).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomEn());
                }
                if (masMeetingRoom.getBuildingId() != null) {
                    sql.append(" AND ").append(BUILDING_ID).append(" = ? ");
                    parameters.add(masMeetingRoom.getBuildingId());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getProjecter())) {
                    sql.append(" AND ").append(PROJECTER).append(" = ? ");
                    parameters.add(masMeetingRoom.getProjecter());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getMonitor())) {
                    sql.append(" AND ").append(MONITOR).append(" = ? ");
                    parameters.add(masMeetingRoom.getMonitor());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getVdoConference())) {
                    sql.append(" AND ").append(VDO_CONFERENCE).append(" = ? ");
                    parameters.add(masMeetingRoom.getVdoConference());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getWhiteBoard())) {
                    sql.append(" AND ").append(WHITE_BOARD).append(" = ? ");
                    parameters.add(masMeetingRoom.getWhiteBoard());
                }
                if (masMeetingRoom.getNoOfAttendees() != null) {
                    sql.append(" AND ").append(NO_OF_ATTENDEES).append(" = ? ");
                    parameters.add(masMeetingRoom.getNoOfAttendees());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomPictureUrl())) {
                    sql.append(" AND ").append(ROOM_PICTURE_URL).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomPictureUrl());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masMeetingRoom.getIsDelete());
                }
                if (masMeetingRoom.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masMeetingRoom.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masMeetingRoom.getCreateBy());
                }
                if (masMeetingRoom.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masMeetingRoom.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masMeetingRoom.getUpdateBy());
                }

            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_MEETING_ROOM_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public boolean insertMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + ROOM_ID);

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomTh())) {
                sql.append("," + ROOM_TH);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getRoomTh());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomEn())) {
                sql.append("," + ROOM_EN);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getRoomEn());
            }

            if (masMeetingRoom.getBuildingId() != null) {
                sql.append("," + BUILDING_ID);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getBuildingId());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getProjecter())) {
                sql.append("," + PROJECTER);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getProjecter());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getMonitor())) {
                sql.append("," + MONITOR);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getMonitor());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getVdoConference())) {
                sql.append("," + VDO_CONFERENCE);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getVdoConference());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getWhiteBoard())) {
                sql.append("," + WHITE_BOARD);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getWhiteBoard());
            }

            if (masMeetingRoom.getNoOfAttendees() != null) {
                sql.append("," + NO_OF_ATTENDEES);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getNoOfAttendees());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomPictureUrl())) {
                sql.append("," + ROOM_PICTURE_URL);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getRoomPictureUrl());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getIsDelete());
            }

            if (masMeetingRoom.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getCreateBy());
            }

            if (masMeetingRoom.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masMeetingRoom.getUpdateDate());
            }

            sql.append(") VALUES(" + masMeetingRoom.getRoomId());
            sql.append(sql2.toString());
            sql.append(")");

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

            successFlag = true;

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return successFlag;
    }

    public boolean updateMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception {
        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(ROOM_TH).append(" = ?, ");
            sql.append(ROOM_EN).append(" = ?, ");
            sql.append(BUILDING_ID).append(" = ?, ");
            sql.append(PROJECTER).append(" = ?, ");
            sql.append(MONITOR).append(" = ?, ");
            sql.append(VDO_CONFERENCE).append(" = ?, ");
            sql.append(WHITE_BOARD).append(" = ?, ");
            sql.append(NO_OF_ATTENDEES).append(" = ?, ");
            sql.append(ROOM_PICTURE_URL).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(ROOM_ID).append(" = ? ");

            parameters.add(masMeetingRoom.getRoomTh());
            parameters.add(masMeetingRoom.getRoomEn());
            parameters.add(masMeetingRoom.getBuildingId());
            parameters.add(masMeetingRoom.getProjecter());
            parameters.add(masMeetingRoom.getMonitor());
            parameters.add(masMeetingRoom.getVdoConference());
            parameters.add(masMeetingRoom.getWhiteBoard());
            parameters.add(masMeetingRoom.getNoOfAttendees());
            parameters.add(masMeetingRoom.getRoomPictureUrl());
            parameters.add(masMeetingRoom.getIsDelete());
            parameters.add(masMeetingRoom.getCreateDate());
            parameters.add(masMeetingRoom.getCreateBy());
            parameters.add(masMeetingRoom.getUpdateDate());
            parameters.add(masMeetingRoom.getUpdateBy());
            parameters.add(masMeetingRoom.getRoomId() != null ? masMeetingRoom.getRoomId() : null);

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());
            successFlag = true;

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return successFlag;

    }

    public int countMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception {

        ArrayList<Object> parameters = new ArrayList<Object>();
        int count = 0;

        StringBuilder sql = new StringBuilder();

        try {

            sql.append("select count(*) as count from " + TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masMeetingRoom != null) {
                if (masMeetingRoom.getRoomId() != null) {
                    sql.append(" AND ").append(ROOM_ID).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomId());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomTh())) {
                    sql.append(" AND ").append(ROOM_TH).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomTh());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomEn())) {
                    sql.append(" AND ").append(ROOM_EN).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomEn());
                }
                if (masMeetingRoom.getBuildingId() != null) {
                    sql.append(" AND ").append(BUILDING_ID).append(" = ? ");
                    parameters.add(masMeetingRoom.getBuildingId());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getProjecter())) {
                    sql.append(" AND ").append(PROJECTER).append(" = ? ");
                    parameters.add(masMeetingRoom.getProjecter());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getMonitor())) {
                    sql.append(" AND ").append(MONITOR).append(" = ? ");
                    parameters.add(masMeetingRoom.getMonitor());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getVdoConference())) {
                    sql.append(" AND ").append(VDO_CONFERENCE).append(" = ? ");
                    parameters.add(masMeetingRoom.getVdoConference());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getWhiteBoard())) {
                    sql.append(" AND ").append(WHITE_BOARD).append(" = ? ");
                    parameters.add(masMeetingRoom.getWhiteBoard());
                }
                if (masMeetingRoom.getNoOfAttendees() != null) {
                    sql.append(" AND ").append(NO_OF_ATTENDEES).append(" = ? ");
                    parameters.add(masMeetingRoom.getNoOfAttendees());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getRoomPictureUrl())) {
                    sql.append(" AND ").append(ROOM_PICTURE_URL).append(" = ? ");
                    parameters.add(masMeetingRoom.getRoomPictureUrl());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masMeetingRoom.getIsDelete());
                }
                if (masMeetingRoom.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masMeetingRoom.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masMeetingRoom.getCreateBy());
                }
                if (masMeetingRoom.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masMeetingRoom.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masMeetingRoom.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masMeetingRoom.getUpdateBy());
                }
            }
            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            count = getJdbcTemplate().queryForObject(sql.toString(), parameters.toArray(), Integer.class
            );

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return count;
    }

}
