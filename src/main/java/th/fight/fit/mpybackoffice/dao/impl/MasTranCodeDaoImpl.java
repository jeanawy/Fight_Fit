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
import th.fight.fit.mpybackoffice.dao.MasTranCodeDao;
import th.fight.fit.mpybackoffice.domain.MasTranCode;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Chayoth
 */
@Repository
public class MasTranCodeDaoImpl extends BaseDao implements MasTranCodeDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "MAS_TRAN_CODE";
    private final String TRAN_CODE = "TRAN_CODE";
    private final String TRAN_GROUP = "TRAN_GROUP";
    private final String TRAN_CODE_TH = "TRAN_CODE_TH";
    private final String TRAN_CODE_EN = "TRAN_CODE_EN";
    private final String STATUS_USE_IN = "STATUS_USE_IN";
    private final String STATUS_ID = "STATUS_ID";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<MasTranCode> LIST_MASTER_TRAN_CODE_ROW_MAPPER = new RowMapper<MasTranCode>() {

        public MasTranCode mapRow(ResultSet rs, int rowNum) throws SQLException {

            final MasTranCode masTranCode = new MasTranCode();
            masTranCode.setTranCode(rs.getString(TRAN_CODE));
            masTranCode.setTranGroup(rs.getString(TRAN_GROUP));
            masTranCode.setTranCodeTh(rs.getString(TRAN_CODE_TH));
            masTranCode.setTranCodeEn(rs.getString(TRAN_CODE_EN));
            masTranCode.setStatusUseIn(rs.getString(STATUS_USE_IN));
            masTranCode.setStatusId(rs.getString(STATUS_ID));
            masTranCode.setIsDelete(rs.getString(IS_DELETE));

            masTranCode.setCreateDate(rs.getDate(CREATE_DATE));
            Timestamp timestamp = rs.getTimestamp(CREATE_DATE);
            masTranCode.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);

            masTranCode.setCreateBy(rs.getString(CREATE_BY));

            masTranCode.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestamp1 = rs.getTimestamp(UPDATE_DATE);
            masTranCode.setCreateDate(timestamp1 != null ? new Date(timestamp1.getTime()) : null);

            masTranCode.setUpdateBy(rs.getString(UPDATE_BY));
            return masTranCode;
        }
    };

    public List<MasTranCode> getMasTranCode(MasTranCode masTranCode) throws Exception {
        List<MasTranCode> list = new ArrayList<MasTranCode>();
        ArrayList<Object> parameters = new ArrayList<Object>();

        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (masTranCode != null) {
                if (StringUtils.isNotEmptyOrNull(masTranCode.getTranCode())) {
                    sql.append(" AND ").append(TRAN_CODE).append(" = ? ");
                    parameters.add(masTranCode.getTranCode());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getTranGroup())) {
                    sql.append(" AND ").append(TRAN_GROUP).append(" = ? ");
                    parameters.add(masTranCode.getTranGroup());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getTranCodeTh())) {
                    sql.append(" AND ").append(TRAN_CODE_TH).append(" = ? ");
                    parameters.add(masTranCode.getTranCodeTh());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getTranCodeEn())) {
                    sql.append(" AND ").append(TRAN_CODE_EN).append(" = ? ");
                    parameters.add(masTranCode.getTranCodeEn());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getStatusUseIn())) {
                    sql.append(" AND ").append(STATUS_USE_IN).append(" = ? ");
                    parameters.add(masTranCode.getStatusUseIn());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getStatusId())) {
                    sql.append(" AND ").append(STATUS_ID).append(" = ? ");
                    parameters.add(masTranCode.getStatusId());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(masTranCode.getIsDelete());
                }
                if (masTranCode.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(masTranCode.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(masTranCode.getCreateBy());
                }
                if (masTranCode.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(masTranCode.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(masTranCode.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(masTranCode.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_MASTER_TRAN_CODE_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public void insertMasTranCode(MasTranCode masTranCode) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + TRAN_CODE);

            if (StringUtils.isNotEmptyOrNull(masTranCode.getTranGroup())) {
                sql.append("," + TRAN_GROUP);
                sql2.append(", ?");
                parameters.add(masTranCode.getTranGroup());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getTranCodeTh())) {
                sql.append("," + TRAN_CODE_TH);
                sql2.append(", ?");
                parameters.add(masTranCode.getTranCodeTh());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getTranCodeEn())) {
                sql.append("," + TRAN_CODE_EN);
                sql2.append(", ?");
                parameters.add(masTranCode.getTranCodeEn());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getStatusUseIn())) {
                sql.append("," + STATUS_USE_IN);
                sql2.append(", ?");
                parameters.add(masTranCode.getStatusUseIn());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getStatusId())) {
                sql.append("," + STATUS_ID);
                sql2.append(", ?");
                parameters.add(masTranCode.getStatusId());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(masTranCode.getIsDelete());
            }

            if (masTranCode.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(masTranCode.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(masTranCode.getCreateBy());
            }

            if (masTranCode.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(masTranCode.getUpdateDate());
            }

            if (StringUtils.isNotEmptyOrNull(masTranCode.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(masTranCode.getUpdateBy());
            }

            sql.append(") VALUES(" + masTranCode.getTranCode());
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

    public void updateMasTranCode(MasTranCode masTranCode) throws Exception {
        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");

            sql.append(TRAN_GROUP).append(" = ?, ");
            sql.append(TRAN_CODE_TH).append(" = ?, ");
            sql.append(TRAN_CODE_EN).append(" = ?, ");
            sql.append(STATUS_USE_IN).append(" = ?, ");
            sql.append(STATUS_ID).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(TRAN_CODE).append(" = ? ");

            parameters.add(masTranCode.getTranGroup());
            parameters.add(masTranCode.getTranCodeTh());
            parameters.add(masTranCode.getTranCodeEn());
            parameters.add(masTranCode.getStatusUseIn());
            parameters.add(masTranCode.getStatusId());
            parameters.add(masTranCode.getIsDelete());
            parameters.add(masTranCode.getCreateDate());
            parameters.add(masTranCode.getCreateBy());
            parameters.add(masTranCode.getUpdateDate());
            parameters.add(masTranCode.getUpdateBy());
            parameters.add(masTranCode.getTranCode() != null ? masTranCode.getTranCode() : null);

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
