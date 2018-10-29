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
import th.fight.fit.mpybackoffice.dao.MasSportDao;
import th.fight.fit.mpybackoffice.domain.MasSport;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Repository
public class MasSportDaoImpl extends BaseDao implements MasSportDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_SPORT";
    private final String SPORT_ID = "SPORT_ID";
    private final String SPORT_NAME = "SPORT_NAME";
    private final String SPORT_TYPE = "SPORT_TYPE";
    private final String URL_SPORT_PICTURE = "URL_SPORT_PICTURE";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<MasSport> LIST_MASTER_SPORT_ROW_MAPPER = new RowMapper<MasSport>() {

        public MasSport mapRow(ResultSet rs, int rowNum) throws SQLException {

            final MasSport masSport = new MasSport();

            masSport.setSportId(rs.getString(SPORT_ID));
            masSport.setSportName(rs.getString(SPORT_NAME));
            masSport.setSportType(rs.getString(SPORT_TYPE));
            masSport.setUrlSportPicture(rs.getString(URL_SPORT_PICTURE));
            masSport.setIsDelete(rs.getString(IS_DELETE));
            masSport.setCreateDate(rs.getDate(CREATE_DATE));
            masSport.setCreateDate(rs.getTimestamp(CREATE_DATE));
            Timestamp timestampCD = rs.getTimestamp(CREATE_DATE);
            masSport.setCreateDate(timestampCD != null ? new Date(timestampCD.getTime()) : null);
            masSport.setCreateBy(rs.getString(CREATE_BY));
            masSport.setUpdateDate(rs.getDate(UPDATE_DATE));
            masSport.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestampUD = rs.getTimestamp(UPDATE_DATE);
            masSport.setCreateDate(timestampUD != null ? new Date(timestampUD.getTime()) : null);
            masSport.setUpdateBy(rs.getString(UPDATE_BY));

            return masSport;
        }
    };

    public List<MasSport> getMasSport(MasSport masSport) throws Exception {
        List<MasSport> list = new ArrayList<MasSport>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masSport != null) {
                if (masSport.getSportId() != null) {
                    sql.append(" AND ").append(SPORT_ID).append(" = ? ");
                    parameters.add(masSport.getSportId());
                }
                if (StringUtils.isNotEmptyOrNull(masSport.getSportName())) {
                    sql.append(" AND ").append(SPORT_NAME).append(" = ? ");
                    parameters.add(masSport.getSportName());
                }
                if (StringUtils.isNotEmptyOrNull(masSport.getSportType())) {
                    sql.append(" AND ").append(SPORT_TYPE).append(" = ? ");
                    parameters.add(masSport.getSportType());
                }

                if (StringUtils.isNotEmptyOrNull(masSport.getUrlSportPicture())) {
                    sql.append(" AND ").append(URL_SPORT_PICTURE).append(" = ? ");
                    parameters.add(masSport.getUrlSportPicture());
                }

                if (StringUtils.isNotEmptyOrNull(masSport.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masSport.getIsDelete());
                }
                if (masSport.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masSport.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masSport.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masSport.getCreateBy());
                }
                if (masSport.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masSport.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masSport.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masSport.getUpdateBy());
                }
            }
            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_SPORT_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;

    }

    public boolean insertMasSport(MasSport masSport) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {
            sql.append("INSERT INTO " + TABLE + "(" + SPORT_ID);

            if (StringUtils.isNotEmptyOrNull(masSport.getSportName())) {
                sql.append("," + SPORT_NAME);
                sql2.append(", ?");
                parameters.add(masSport.getSportName());
            }
            if (StringUtils.isNotEmptyOrNull(masSport.getSportType())) {
                sql.append("," + SPORT_TYPE);
                sql2.append(", ?");
                parameters.add(masSport.getSportType());
            }
            if (StringUtils.isNotEmptyOrNull(masSport.getUrlSportPicture())) {
                sql.append("," + URL_SPORT_PICTURE);
                sql2.append(", ?");
                parameters.add(masSport.getUrlSportPicture());
            }

            if (StringUtils.isNotEmptyOrNull(masSport.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masSport.getIsDelete());
            }
            if (masSport.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masSport.getCreateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masSport.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masSport.getCreateBy());
            }
            if (masSport.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masSport.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(masSport.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(masSport.getUpdateBy());
            }
            sql.append(") VALUES(" + masSport.getSportId());
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

    public boolean updateMasSport(MasSport masSport) throws Exception {
        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(SPORT_ID).append(" = ?, ");
            sql.append(SPORT_NAME).append(" = ?, ");
            sql.append(SPORT_TYPE).append(" = ?, ");
            sql.append(URL_SPORT_PICTURE).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ? ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(SPORT_ID).append(" = ? ");

            parameters.add(masSport.getSportId());
            parameters.add(masSport.getSportName());
            parameters.add(masSport.getSportType());
            parameters.add(masSport.getUrlSportPicture());
            parameters.add(masSport.getIsDelete());
            parameters.add(masSport.getCreateDate());
            parameters.add(masSport.getCreateBy());
            parameters.add(masSport.getUpdateDate());
            parameters.add(masSport.getUpdateBy());
            parameters.add(masSport.getSportId() != null ? masSport.getSportId() : null);

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
