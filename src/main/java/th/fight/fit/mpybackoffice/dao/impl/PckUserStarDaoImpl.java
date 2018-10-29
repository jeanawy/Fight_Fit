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

import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.PckUserStarDao;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.PckUserStar;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author ธนากร
 */
@Repository
public class PckUserStarDaoImpl extends BaseDao implements PckUserStarDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "PCK_USER_STAR";
    private final String UID = "UID";
    private final String STAR_TYPE = "STAR_TYPE";
    private final String STAR_GIVE_BAL = "STAR_GIVE_BAL";
    private final String STAR_RECEIVE_BAL = "STAR_RECEIVE_BAL";
    private final String GEN_GIVE_AMOUNT = "GEN_GIVE_AMOUNT";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<PckUserStar> LIST_PCK_USER_STAR_ROW_MAPPER = new RowMapper<PckUserStar>() {

        public PckUserStar mapRow(ResultSet rs, int rowNum) throws SQLException {

            final PckUserStar pckUserStar = new PckUserStar();
            pckUserStar.setUid(rs.getString(UID));
            pckUserStar.setStarType(rs.getString(STAR_TYPE));
            pckUserStar.setStarGiveBal(rs.getInt(STAR_GIVE_BAL));
            pckUserStar.setStarReceiveBal(rs.getInt(STAR_RECEIVE_BAL));
            pckUserStar.setGenGiveAmount(rs.getInt(GEN_GIVE_AMOUNT));
            pckUserStar.setIsDelete(rs.getString(IS_DELETE));

            Timestamp timestamp = rs.getTimestamp(CREATE_DATE);
            pckUserStar.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);

            pckUserStar.setCreateBy(rs.getString(CREATE_BY));
            pckUserStar.setUpdateDate(rs.getDate(UPDATE_DATE));

            Timestamp timestamp1 = rs.getTimestamp(UPDATE_DATE);
            pckUserStar.setUpdateDate(timestamp1 != null ? new Date(timestamp1.getTime()) : null);

            pckUserStar.setUpdateBy(rs.getString(UPDATE_BY));
            return pckUserStar;
        }
    };

    public List<PckUserStar> getPckUserStar(PckUserStar pckUserStar) throws Exception {
        List<PckUserStar> list = new ArrayList<PckUserStar>();
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (pckUserStar != null) {
                if (StringUtils.isNotEmptyOrNull(pckUserStar.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(pckUserStar.getUid());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserStar.getStarType())) {
                    sql.append(" AND ").append(STAR_TYPE).append(" = ? ");
                    parameters.add(pckUserStar.getStarType());
                }
                if ((pckUserStar.getStarGiveBal()) != null) {
                    sql.append(" AND ").append(STAR_GIVE_BAL).append(" = ? ");
                    parameters.add(pckUserStar.getStarGiveBal());
                }
                if ((pckUserStar.getStarReceiveBal()) != null) {
                    sql.append(" AND ").append(STAR_RECEIVE_BAL).append(" = ? ");
                    parameters.add(pckUserStar.getStarReceiveBal());
                }
                if ((pckUserStar.getGenGiveAmount()) != null) {
                    sql.append(" AND ").append(GEN_GIVE_AMOUNT).append(" = ? ");
                    parameters.add(pckUserStar.getGenGiveAmount());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserStar.getIsDelete())) {
                    sql.append(" AND ").append(IS_DELETE).append(" = ? ");
                    parameters.add(pckUserStar.getIsDelete());
                }
                if ((pckUserStar.getCreateDate()) != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(pckUserStar.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserStar.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(pckUserStar.getCreateBy());
                }
                if ((pckUserStar.getUpdateDate()) != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(pckUserStar.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserStar.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_BY).append(" = ? ");
                    parameters.add(pckUserStar.getUpdateBy());
                }
            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_PCK_USER_STAR_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return list;

    }

    public void updatePckUserStar(PckUserStar pckUserStar) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(STAR_GIVE_BAL).append(" = ?, ");
            sql.append(STAR_RECEIVE_BAL).append(" = ?, ");
            sql.append(GEN_GIVE_AMOUNT).append(" = ?, ");
            sql.append(IS_DELETE).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(UID).append(" = ? ");
            sql.append(" AND ").append(STAR_TYPE).append(" = ? ");

            parameters.add(pckUserStar.getStarGiveBal());
            parameters.add(pckUserStar.getStarReceiveBal());
            parameters.add(pckUserStar.getGenGiveAmount());
            parameters.add(pckUserStar.getIsDelete());
            parameters.add(pckUserStar.getCreateDate());
            parameters.add(pckUserStar.getCreateBy());
            parameters.add(pckUserStar.getUpdateDate());
            parameters.add(pckUserStar.getUpdateBy());
            parameters.add(pckUserStar.getUid() != null ? pckUserStar.getUid() : null);
            parameters.add(pckUserStar.getStarType());

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
