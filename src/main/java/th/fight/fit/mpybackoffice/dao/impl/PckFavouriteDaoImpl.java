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
import th.fight.fit.mpybackoffice.dao.PckFavouriteDao;
import th.fight.fit.mpybackoffice.domain.PckFavourite;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;



@Repository
public class PckFavouriteDaoImpl extends BaseDao implements PckFavouriteDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "PCK_FAVOURITE";
    private final String UID = "UID";
    private final String SEQ = "SEQ";
    private final String FAVOURITE_UID = "FAVOURITE_UID";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    public String getTablePckFavName() {
        return TABLE;
    }

    public String getUidName() {
        return UID;
    }

    public String getSeqName() {
        return SEQ;
    }

    public String getFavUidName() {
        return FAVOURITE_UID;
    }

    public String getIsDelName() {
        return IS_DELETE;
    }

    final RowMapper<PckFavourite> LIST_PCK_FAVOURITE_ROW_MAPPER;

    public PckFavouriteDaoImpl() {
        this.LIST_PCK_FAVOURITE_ROW_MAPPER = new RowMapper<PckFavourite>() {

            public PckFavourite mapRow(ResultSet rs, int rowNum) throws SQLException {

                final PckFavourite pckFavourite = new PckFavourite();
                pckFavourite.setUid(rs.getString(UID));
                pckFavourite.setSeq(rs.getObject(SEQ) != null ? BigInteger.valueOf(rs.getLong(SEQ)) : null);
                pckFavourite.setFavouriteUid(rs.getString(FAVOURITE_UID));
                pckFavourite.setIsDelete(rs.getString(IS_DELETE));
                pckFavourite.setCreateDate(rs.getDate(CREATE_DATE));
                Timestamp timestamp = rs.getTimestamp(CREATE_DATE);
                pckFavourite.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);
                pckFavourite.setCreateBy(rs.getString(CREATE_BY));
                pckFavourite.setUpdateDate(rs.getDate(UPDATE_DATE));
                Timestamp timeStamp = rs.getTimestamp(UPDATE_DATE);
                pckFavourite.setCreateDate(timeStamp != null ? new Date(timeStamp.getTime()) : null);
                pckFavourite.setUpdateBy(rs.getString(UPDATE_BY));
                return pckFavourite;
            }
        };
    }

    public List<PckFavourite> getPckFavourite(PckFavourite pckFavourite) throws Exception {
        List<PckFavourite> list = new ArrayList<PckFavourite>();
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (pckFavourite != null) {
                if (StringUtils.isNotEmptyOrNull(pckFavourite.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(pckFavourite.getUid());
                }
                if (pckFavourite.getSeq() != null) {
                    sql.append(" AND ").append(SEQ).append(" = ? ");
                    parameters.add(pckFavourite.getSeq());
                }
                if (StringUtils.isNotEmptyOrNull(pckFavourite.getFavouriteUid())) {
                    sql.append(" AND ").append(FAVOURITE_UID).append(" = ? ");
                    parameters.add(pckFavourite.getFavouriteUid());
                }
                if (StringUtils.isNotEmptyOrNull(pckFavourite.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(pckFavourite.getIsDelete());
                }
                if ((pckFavourite.getCreateDate()) != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(pckFavourite.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckFavourite.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(pckFavourite.getCreateBy());
                }
                if ((pckFavourite.getUpdateDate()) != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(pckFavourite.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckFavourite.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(pckFavourite.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_PCK_FAVOURITE_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;
    }

    public boolean insertPckFavourite(PckFavourite pckFavourite) throws Exception {
        boolean successFlag = false;
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + SEQ);
            parameters.add(pckFavourite.getSeq().longValue());

            if (StringUtils.isNotEmptyOrNull(pckFavourite.getUid())) {
                sql.append("," + UID);
                sql2.append(", ?");
                parameters.add(pckFavourite.getUid());
            }

            if (StringUtils.isNotEmptyOrNull(pckFavourite.getFavouriteUid())) {
                sql.append("," + FAVOURITE_UID);
                sql2.append(", ?");
                parameters.add(pckFavourite.getFavouriteUid());
            }

            if (StringUtils.isNotEmptyOrNull(pckFavourite.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(pckFavourite.getIsDelete());
            }

            if ((pckFavourite.getCreateDate()) != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(pckFavourite.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(pckFavourite.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(pckFavourite.getCreateBy());
            }

            if ((pckFavourite.getUpdateDate()) != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(pckFavourite.getUpdateDate());
            }

            if (StringUtils.isNotEmptyOrNull(pckFavourite.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(pckFavourite.getUpdateBy());
            }

            sql.append(") VALUES( ? ");
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

    public boolean updatePckFavourite(PckFavourite pckFavourite) throws Exception {
        boolean successFlag = false;
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(UID).append(" = ?, ");
            sql.append(SEQ).append(" = ?, ");
            sql.append(FAVOURITE_UID).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(SEQ).append(" = ? ");

            parameters.add(pckFavourite.getUid());
            parameters.add(pckFavourite.getSeq() != null ? pckFavourite.getSeq().longValue() : null);
            parameters.add(pckFavourite.getFavouriteUid());
            parameters.add(pckFavourite.getIsDelete());
            parameters.add(pckFavourite.getCreateDate());
            parameters.add(pckFavourite.getCreateBy());
            parameters.add(pckFavourite.getUpdateDate());
            parameters.add(pckFavourite.getUpdateBy());
            parameters.add(pckFavourite.getSeq() != null ? pckFavourite.getSeq().longValue() : null);

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
}
