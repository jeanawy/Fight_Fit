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
import th.fight.fit.mpybackoffice.dao.MasStatusDao;
import th.fight.fit.mpybackoffice.domain.MasStatus;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sukrit_p
 */
@Repository
public class MasStatusDaoImpl extends BaseDao implements MasStatusDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_STATUS";
    private final String STATUS_USE_IN = "STATUS_USE_IN";
    private final String STATUS_ID = "STATUS_ID";
    private final String STATUS_TH = "STATUS_TH";
    private final String STATUS_EN = "STATUS_EN";
    private final String CAN_USE = "CAN_USE";
    private final String COLOR = "COLOR";
    private final String IS_DELETE = "IS_DELETE";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    
    final RowMapper<MasStatus> LIST_MAS_STATUS_ROW_MAPPER = new RowMapper<MasStatus>() {
        public MasStatus mapRow(ResultSet rs, int i) throws SQLException {

            final MasStatus masStatus = new MasStatus();
            masStatus.setStatusUseIn(rs.getString(STATUS_USE_IN));
            masStatus.setStatusId(rs.getString(STATUS_ID));
            masStatus.setStatusTh(rs.getString(STATUS_TH));
            masStatus.setStatusEn(rs.getString(STATUS_EN));
            masStatus.setCanUse(rs.getString(CAN_USE));
            masStatus.setColor(rs.getString(COLOR));
            masStatus.setIsDelete(rs.getString(IS_DELETE));
            masStatus.setCreateDate(rs.getDate(CREATE_DATE));
            Timestamp timestamp = (rs.getTimestamp(CREATE_DATE));
            masStatus.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);

            masStatus.setCreateBy(rs.getString(CREATE_BY));

            masStatus.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestamp1 = rs.getTimestamp(UPDATE_DATE);
            masStatus.setCreateDate(timestamp1 != null ? new Date(timestamp1.getTime()) : null);

            masStatus.setUpdateBy(rs.getString(UPDATE_BY));
            return masStatus;
        }
    };

   public List<MasStatus> getMasStatus(MasStatus masStatus) throws Exception {
        List<MasStatus> list = new ArrayList<MasStatus>();
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masStatus != null) {
                if (StringUtils.isNotEmptyOrNull(masStatus.getStatusUseIn())) {
                    sql.append(" AND ").append(STATUS_USE_IN).append(" = ? ");
                    parameters.add(masStatus.getStatusUseIn());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getStatusId())) {
                    sql.append(" AND ").append(STATUS_ID).append(" = ? ");
                    parameters.add(masStatus.getStatusId());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getStatusTh())) {
                    sql.append(" AND ").append(STATUS_TH).append(" = ? ");
                    parameters.add(masStatus.getStatusTh());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getStatusEn())) {
                    sql.append(" AND ").append(STATUS_EN).append(" = ? ");
                    parameters.add(masStatus.getStatusTh());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getCanUse())) {
                    sql.append(" AND ").append(CAN_USE).append(" = ? ");
                    parameters.add(masStatus.getCanUse());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getColor())) {
                    sql.append(" AND ").append(COLOR).append(" = ?");
                    parameters.add(masStatus.getColor());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masStatus.getIsDelete());
                }
                if (masStatus.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masStatus.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masStatus.getCreateBy());
                }
                if (masStatus.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masStatus.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masStatus.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masStatus.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MAS_STATUS_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public void insertMasStatus(MasStatus masStatus) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append(" INSERT INTO ").append(TABLE).append(" ( ").append(STATUS_USE_IN).append(", ").append(STATUS_ID);
            parameters.add(masStatus.getStatusUseIn());
            parameters.add(masStatus.getStatusId());

            if (StringUtils.isNotEmptyOrNull(masStatus.getStatusTh())) {
                sql.append("," + STATUS_TH);
                sql2.append(", ?");
                parameters.add(masStatus.getStatusTh());
            }

            if (StringUtils.isNotEmptyOrNull(masStatus.getStatusEn())) {
                sql.append("," + STATUS_EN);
                sql2.append(", ?");
                parameters.add(masStatus.getStatusEn());
            }
            if (StringUtils.isNotEmptyOrNull(masStatus.getCanUse())) {
                sql.append("," + CAN_USE);
                sql2.append(", ?");
                parameters.add(masStatus.getCanUse());
            }
            if (StringUtils.isNotEmptyOrNull(masStatus.getColor())) {
                sql.append("," + COLOR);
                sql2.append(", ?");
                parameters.add(masStatus.getColor());
            }
            if (StringUtils.isNotEmptyOrNull(masStatus.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masStatus.getIsDelete());
            }

            if (masStatus.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masStatus.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(masStatus.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masStatus.getCreateBy());
            }

            if (masStatus.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masStatus.getUpdateDate());
            }

            if (masStatus.getUpdateBy() != null) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(masStatus.getUpdateBy());
            }

            sql.append(") VALUES( ?, ? ");
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

    public void updateMasStatus(MasStatus masStatus) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(STATUS_TH).append(" = ?, ");
            sql.append(STATUS_EN).append(" = ?, ");
            sql.append(CAN_USE).append(" = ?, ");
            sql.append(COLOR).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(STATUS_USE_IN).append(" = ? ");
            sql.append(" AND ").append(STATUS_ID).append(" =  ? ");

            parameters.add(masStatus.getStatusTh());
            parameters.add(masStatus.getStatusEn());
            parameters.add(masStatus.getCanUse());
            parameters.add(masStatus.getColor());
            parameters.add(masStatus.getIsDelete());
            parameters.add(masStatus.getCreateDate());
            parameters.add(masStatus.getCreateBy());
            parameters.add(masStatus.getUpdateDate());
            parameters.add(masStatus.getUpdateBy());
            parameters.add(masStatus.getStatusUseIn() != null ? masStatus.getStatusUseIn() : null);
            parameters.add(masStatus.getStatusId() != null ? masStatus.getStatusId() : null);

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
