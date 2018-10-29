/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigDecimal;
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
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Repository
public class PckProfileDaoImpl extends BaseDao implements PckProfileDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String TABLE = "PCK_PROFILE";
    private final String UID = "UID";
    private final String PROFILE_ID = "PROFILE_ID";
    private final String FIRST_NAME = "FIRST_NAME";
    private final String LAST_NAME = "LAST_NAME";
    private final String NICK_NAME = "NICK_NAME";
    private final String POSITION_NO = "POSITION_NO";
    private final String MOBILE_PHONE = "MOBILE_PHONE";
    private final String EMAIL = "EMAIL";
    private final String PICTURE_URL = "PICTURE_URL";
    private final String IS_DELETE = "IS_DELETE";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String CREATE_BY = "CREATE_BY";
    private final String UPDATE_DATE = "UPDATE_DATE";
    private final String UPDATE_BY = "UPDATE_BY";

    final RowMapper<PckProfile> LIST_PCK_PROFILE_ROW_MAPPER = new RowMapper<PckProfile>() {

        public PckProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
            final PckProfile pckProfile = new PckProfile();
            pckProfile.setUid(rs.getString(UID));
            pckProfile.setProfileId(rs.getString(PROFILE_ID));
            pckProfile.setFirstName(rs.getString(FIRST_NAME));
            pckProfile.setLastName(rs.getString(LAST_NAME));
            pckProfile.setNickName(rs.getString(NICK_NAME));
            pckProfile.setPositionNo(rs.getString(POSITION_NO));
            pckProfile.setMobilePhone(rs.getString(MOBILE_PHONE));
            pckProfile.setEmail(rs.getString(EMAIL));

            pckProfile.setPictureUrl(rs.getString(PICTURE_URL));
            pckProfile.setIsDelete(rs.getString(IS_DELETE));

            pckProfile.setCreateDate(rs.getDate(CREATE_DATE));
            Timestamp timestamp = (rs.getTimestamp(CREATE_DATE));
            pckProfile.setCreateDate(timestamp != null ? new Date(timestamp.getTime()) : null);

            pckProfile.setCreateBy(rs.getString(CREATE_BY));

            pckProfile.setUpdateDate(rs.getTimestamp(UPDATE_DATE));
            Timestamp timestampS = (rs.getTimestamp(UPDATE_DATE));
            pckProfile.setCreateDate(timestampS != null ? new Date(timestampS.getTime()) : null);

            pckProfile.setUpdateBy(rs.getString(UPDATE_BY));
            return pckProfile;

        }
    };

    public List<PckProfile> getPckProfile(PckProfile pckProfile) throws Exception {
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertPckProfile(PckProfile pckProfile) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();

        try {

            sql.append("INSERT INTO " + TABLE + "(" + UID);
            parameters.add(pckProfile.getUid());

            if (StringUtils.isNotEmptyOrNull(pckProfile.getProfileId())) {
                sql.append("," + PROFILE_ID);
                sql2.append(", ?");
                parameters.add(pckProfile.getProfileId());
            }
            if (StringUtils.isNotEmptyOrNull(pckProfile.getFirstName())) {
                sql.append("," + FIRST_NAME);
                sql2.append(", ?");
                parameters.add(pckProfile.getFirstName());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getLastName())) {
                sql.append("," + LAST_NAME);
                sql2.append(", ?");
                parameters.add(pckProfile.getLastName());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getNickName())) {
                sql.append("," + NICK_NAME);
                sql2.append(", ?");
                parameters.add(pckProfile.getNickName());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getPositionNo())) {
                sql.append("," + POSITION_NO);
                sql2.append(", ?");
                parameters.add(pckProfile.getPositionNo());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getMobilePhone())) {
                sql.append("," + MOBILE_PHONE);
                sql2.append(", ?");
                parameters.add(pckProfile.getMobilePhone());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getEmail())) {
                sql.append("," + EMAIL);
                sql2.append(", ?");
                parameters.add(pckProfile.getEmail());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getPictureUrl())) {
                sql.append("," + PICTURE_URL);
                sql2.append(", ?");
                parameters.add(pckProfile.getPictureUrl());
            }

            if (StringUtils.isNotEmptyOrNull(pckProfile.getIsDelete())) {
                sql.append("," + IS_DELETE);
                sql2.append(", ?");
                parameters.add(pckProfile.getIsDelete());
            }

            if (pckProfile.getCreateDate() != null) {
                sql.append("," + CREATE_DATE);
                sql2.append(", ?");
                parameters.add(pckProfile.getCreateDate());
            }
            if (StringUtils.isNotEmptyOrNull(pckProfile.getCreateBy())) {
                sql.append("," + CREATE_BY);
                sql2.append(", ?");
                parameters.add(pckProfile.getCreateBy());
            }
            if (pckProfile.getUpdateDate() != null) {
                sql.append("," + UPDATE_DATE);
                sql2.append(", ?");
                parameters.add(pckProfile.getUpdateDate());
            }
            if (StringUtils.isNotEmptyOrNull(pckProfile.getUpdateBy())) {
                sql.append("," + UPDATE_BY);
                sql2.append(", ?");
                parameters.add(pckProfile.getUpdateBy());
            }

            sql.append(") VALUES( ? ");
            sql.append(sql2.toString());
            sql.append(")");

        

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void updatePckProfile(PckProfile pckProfile) throws Exception {
        ArrayList<Object> parameters = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();

        try {
            sql.append(" UPDATE ").append(TABLE).append(" SET ");

            sql.append(PROFILE_ID).append(" = ?, ");
            sql.append(FIRST_NAME).append(" = ?, ");
            sql.append(LAST_NAME).append(" = ?, ");
            sql.append(NICK_NAME).append(" = ?, ");
            sql.append(POSITION_NO).append(" = ?, ");
            sql.append(MOBILE_PHONE).append(" = ?, ");
            sql.append(EMAIL).append(" = ?, ");

            sql.append(PICTURE_URL).append(" = ?, ");

            sql.append(IS_DELETE).append(" = ?, ");

            sql.append(CREATE_DATE).append(" = ?, ");
            sql.append(CREATE_BY).append(" = ?, ");
            sql.append(UPDATE_DATE).append(" = ?, ");
            sql.append(UPDATE_BY).append(" = ?, ");

            sql.append(" WHERE ").append(UID).append(" = ? ");

            parameters.add(pckProfile.getProfileId());
            parameters.add(pckProfile.getFirstName());
            parameters.add(pckProfile.getLastName());
            parameters.add(pckProfile.getNickName());

            parameters.add(pckProfile.getPositionNo());
            parameters.add(pckProfile.getMobilePhone());

            parameters.add(pckProfile.getEmail());

            parameters.add(pckProfile.getPictureUrl());

            parameters.add(pckProfile.getIsDelete());

            parameters.add(pckProfile.getCreateDate());
            parameters.add(pckProfile.getCreateBy());
            parameters.add(pckProfile.getUpdateDate());
            parameters.add(pckProfile.getUpdateBy());
            parameters.add(pckProfile.getUid());

          

            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
