/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.domain.PckUserLogin;
import th.fight.fit.mpybackoffice.dao.PckUserLoginDao;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Panaporn
 */
@Repository
public class PckUserLoginDaoImpl extends BaseDao implements PckUserLoginDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "PCK_USER_LOGIN";

    private final String UID = "UID";
    private final String TOKEN = "TOKEN";
    private final String MOBILE_INDEX_MENU = "MOBILE_INDEX_MENU";
    private final String BOS_INDEX_MENU = "BOS_INDEX_MENU";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String UPDATE_DATE = "UPDATE_DATE";

    final RowMapper<PckUserLogin> LIST_PCK_USER_LOGIN_ROW_MAPPER = new RowMapper<PckUserLogin>() {
        public PckUserLogin mapRow(ResultSet rs, int rowNum) throws SQLException {

            final PckUserLogin pckUserLogin = new PckUserLogin();
            pckUserLogin.setUid(rs.getString(UID));
            pckUserLogin.setToken(rs.getString(TOKEN));
            pckUserLogin.setMobileIndexMenu(rs.getString(MOBILE_INDEX_MENU));
            pckUserLogin.setBosIndexMenu(rs.getString(BOS_INDEX_MENU));
            pckUserLogin.setCreateDate(rs.getDate(CREATE_DATE));

            pckUserLogin.setCreateBy(rs.getString(CREATE_BY));
            pckUserLogin.setUpdateDate(rs.getDate(UPDATE_DATE));
            pckUserLogin.setUpdateBy(rs.getString(UPDATE_BY));

            return pckUserLogin;
        }
    };

    public List<PckUserLogin> getPckUserLogin(PckUserLogin pckUserLogin) throws Exception {
        List<PckUserLogin> list = new ArrayList<PckUserLogin>();
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        try {

            sql.append(" SELECT * FROM ").append(TABLE);
            sql.append(" WHERE 0 = 0 ");

            if (pckUserLogin != null) {
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getUid())) {
                    sql.append(" AND ").append(UID).append(" = ? ");
                    parameters.add(pckUserLogin.getUid());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getToken())) {
                    sql.append(" AND ").append(TOKEN).append(" = ? ");
                    parameters.add(pckUserLogin.getToken());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getMobileIndexMenu())) {
                    sql.append(" AND ").append(MOBILE_INDEX_MENU).append(" = ? ");
                    parameters.add(pckUserLogin.getMobileIndexMenu());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getBosIndexMenu())) {
                    sql.append(" AND ").append(BOS_INDEX_MENU).append(" = ? ");
                    parameters.add(pckUserLogin.getBosIndexMenu());
                }
                if (pckUserLogin.getCreateDate() != null) {
                    sql.append(" AND ").append(CREATE_DATE).append(" = ? ");
                    parameters.add(pckUserLogin.getCreateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getCreateBy())) {
                    sql.append(" AND ").append(CREATE_BY).append(" = ? ");
                    parameters.add(pckUserLogin.getCreateBy());
                }
                if (pckUserLogin.getUpdateDate() != null) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(pckUserLogin.getUpdateDate());
                }
                if (StringUtils.isNotEmptyOrNull(pckUserLogin.getUpdateBy())) {
                    sql.append(" AND ").append(UPDATE_DATE).append(" = ? ");
                    parameters.add(pckUserLogin.getUpdateBy());
                }

            }

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            list = getJdbcTemplate().query(sql.toString(), parameters.toArray(), LIST_PCK_USER_LOGIN_ROW_MAPPER);

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
        return list;

    }

    public void insertPckUserLogin(PckUserLogin pckUserLogin) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + UID);
            parameters.add(pckUserLogin.getUid());

            if (StringUtils.isNotEmptyOrNull(pckUserLogin.getToken())) {
                sql.append("," + TOKEN);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getToken());
            }

            if (StringUtils.isNotEmptyOrNull(pckUserLogin.getMobileIndexMenu())) {
                sql.append("," + MOBILE_INDEX_MENU);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getMobileIndexMenu());
            }

            if (StringUtils.isNotEmptyOrNull(pckUserLogin.getBosIndexMenu())) {
                sql.append("," + BOS_INDEX_MENU);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getBosIndexMenu());
            }

            if (pckUserLogin.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getCreateDate());
            }

            if (StringUtils.isNotEmptyOrNull(pckUserLogin.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getCreateBy());
            }

            if (pckUserLogin.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(pckUserLogin.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(pckUserLogin.getUpdateBy());
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

    public void updatePckUserLogin(PckUserLogin pckUserLogin) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");
            sql.append(MOBILE_INDEX_MENU).append(" = ?, ");
            sql.append(BOS_INDEX_MENU).append(" = ?, ");
            sql.append(TOKEN).append(" = ?, ");
            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ? ");
            sql.append(" WHERE ").append(UID).append(" = ? ");

            parameters.add(pckUserLogin.getMobileIndexMenu());
            parameters.add(pckUserLogin.getBosIndexMenu());
            parameters.add(pckUserLogin.getToken());
            parameters.add(pckUserLogin.getCreateDate());
            parameters.add(pckUserLogin.getCreateBy());
            parameters.add(pckUserLogin.getUpdateDate());
            parameters.add(pckUserLogin.getUpdateBy());
            parameters.add(pckUserLogin.getUid() != null ? pckUserLogin.getUid() : null);

            systemLogger.info(LogFormatter.common("sql : " + sql.toString()));
            systemLogger.info(LogFormatter.common("param : " + Arrays.toString(parameters.toArray())));

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
    }

    public void deleteUserLogin(String uid) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {

            sql.append(" DELETE FROM ").append(TABLE);
            sql.append(" WHERE ").append(UID).append(" = ? ");

            parameters.add(uid);

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
