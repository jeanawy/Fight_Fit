package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sound.midi.Sequence;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.ProcUserProfileDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.domain.ProcUserProfile;
import th.fight.fit.mpybackoffice.util.Utility;

@Repository
public class ProcUserProfileDaoImpl extends BaseDao implements
        ProcUserProfileDao {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    
    private final Logger log = Logger.getLogger(getClass());

    private static final String CLASS_PROC_USER_PROFILE_DAO_IMPL = "ProcUserProfileDaoImpl";
    private static final String METHOD_COUNT_PROC_USER_PROFILE = "countProcUserProfile";
    private static final String METHOD_UPDATE_USER_PROFILE = "updateUserProfile";
    private static final String METHOD_INSERT_USER_PROFILE = "insertProcUserProfile";
    private static final String METHOD_FIND_PROC_USER_PROFILE_RESPONSIBLE = "findProcUserProfileResponsible";
    private static final String SEQ_PROC_USER_PROFILE = "seq_proc_user_profile";
    private final String TABLE = "PROC_USER_PROFILE";

    private final String USER_ID = "USER_ID";
    private final String TITLE_ID = "TITLE_ID";
    private final String NAME_TH = "NAME_TH";
    private final String NAME_EN = "NAME_EN";
    private final String SURNAME_TH = "SURNAME_TH";
    private final String SURNAME_EN = "SURNAME_EN";
    private final String FULL_NAME_TH = "FULL_NAME_TH";
    private final String FULL_NAME_EN = "FULL_NAME_EN";
    private final String CITIZEN_ID = "CITIZEN_ID";
    private final String PASSPORT_ID = "PASSPORT_ID";
    private final String SEX = "SEX";
    private final String EMAIL = "EMAIL";
    private final String MOBILENUMBER = "MOBILENUMBER";
    private final String REMARK_OTHER = "REMARK_OTHER";
    private final String REMARK = "REMARK";
    private final String VERSION = "VERSION";
    private final String STATUS = "STATUS";
    private final String CREATE_IPADDRESS = "CREATE_IPADDRESS";
    private final String UPDATE_IPADDRESS = "UPDATE_IPADDRESS";
    private final String ROLE_CODE = "ROLE_CODE";
    private final String BRANCH_CODE = "BRANCH_CODE";
    private final String USER_NAME = "USER_NAME";
    private final String CREATE_DATE = "CREATE_DATE";
    private final String LAST_LOGIN_DTTM = "LAST_LOGIN_DTTM";
    private final String BRANCHNAME_TH = "BRANCHNAME_TH";
    private final String STATUS_NAME_TH = "STATUS_NAME_TH";
    private final String STATUS_NAME_EN = "STATUS_NAME_EN";

    // for Manage Crop user
    private final String CORP_CODE = "CORP_CODE";
    private final String CORP_NAME_TH = "CORP_NAME_TH";
    private final String CORP_NAME_EN = "CORP_NAME_EN";
    private final String CIF_NO = "CIF_NO";
    private final String ROLE_NAME = "ROLE_NAME";
    private final String TAX_ID = "TAX_ID";
    private final String TPIN_STATUS = "TPIN_STATUS";

    private final String REGEN_HIS_ID = "REGEN_HIS_ID";
    private final String CORP_ID = "CORP_ID";
    private final String ACTION = "ACTION";
    private final String OFFICER_MAKER = "OFFICER_MAKER";
    private final String OFFICER_MAKER_DTTM = "OFFICER_MAKER_DTTM";
    private final String OFFICER_CHECKER = "OFFICER_CHECKER";
    private final String OFFICER_CHECKER_DTTM = "OFFICER_CHECKER_DTTM";
    private final String EN_PASSWORD = "EN_PASSWORD";
    private final String COUNTER = "COUNTER";
    private final String OFFICER_NEW = "OFFICER_NEW";
    private final String OFFICER_NEW_DTTM = "OFFICER_NEW_DTTM";
    private final String EXPIRE_DTTM = "EXPIRE_DTTM";

    @Autowired
    private SequencerDao sequencerDao;

    public void updateProcUserProfile(final ProcUserProfile userProfile) throws Exception {
        StringBuilder sb = new StringBuilder();
        ArrayList<Object> parameters = new ArrayList<Object>();
        Date createDate = new Date(userProfile.getCreateDate().getTime());
        
        try {
            sb.append("update proc_user_profile ");
            sb.append("set name_th = ?, name_en = ?, full_name_th = ?, full_name_en = ?, surname_th = ?, surname_en = ?, citizen_id = ?, passport_id = ?, ");
            sb.append("sex = ?, email = ?, mobilenumber = ?, status = ?, create_date = ?, create_by = ?, update_dttm = ?, update_by = ? ");
            sb.append("where user_id = ? ");
            
            parameters.add(userProfile.getNameTh());
            parameters.add(userProfile.getNameEn());
            parameters.add(userProfile.getFullNameTh());
            parameters.add(userProfile.getFullNameEn());
            parameters.add(userProfile.getSurnameTh());
            parameters.add(userProfile.getSurnameEn());
            parameters.add(userProfile.getCitizenId());
            parameters.add(userProfile.getPassportId());
            parameters.add(userProfile.getSex());
            
            parameters.add(userProfile.getEmail());
            parameters.add(userProfile.getMobileNumber());
            parameters.add(userProfile.getStatus());
            parameters.add(createDate);
            parameters.add(userProfile.getCreateBy());
            parameters.add(userProfile.getUpDateDttm() != null ? new Timestamp(userProfile.getUpDateDttm().getTime()) : null);
            parameters.add(userProfile.getUpdateBy());
            parameters.add(userProfile.getUserId().longValue());
            
            
            getJdbcTemplate().update(sb.toString(), parameters.toArray());
            
//            getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {
//
//                public void setValues(PreparedStatement prep)
//                        throws SQLException {
//                    prep.setLong(1, userProfile.getTitleId()
//                            .longValue());
//                    prep.setString(2, userProfile.getNameTh());
//                    prep.setString(3, userProfile.getNameEn());
//                    prep.setString(4, userProfile.getFullNameTh());
//                    prep.setString(5, userProfile.getFullNameEn());
//                    prep.setString(6, userProfile.getSurnameTh());
//                    prep.setString(7, userProfile.getSurnameEn());
//                    prep.setString(8, userProfile.getCitizenId());
//                    prep.setString(9, userProfile.getPassportId());
//                    prep.setString(10, userProfile.getSex());
//                    prep.setString(11, userProfile.getEmail());
//                    prep.setString(12, userProfile.getMobileNumber());
//                    prep.setInt(13, userProfile.getVersion());
//                    prep.setString(14, userProfile.getStatus());
//                    prep.setDate(15, new java.sql.Date(userProfile.getCreateDate().getTime()));
//                    prep.setString(16, userProfile.getCreateBy());
//                    prep.setTimestamp(17, userProfile.getUpDateDttm() != null ? new Timestamp(userProfile.getUpDateDttm().getTime()) : null);
//                    prep.setString(18, userProfile.getUpdateBy());
//                    prep.setString(19, userProfile.getCreateIpAddress());
//                    prep.setString(20, userProfile.getUpdateIpAddress());
//                    prep.setString(21, userProfile.getRemark());
//                    prep.setLong(22, userProfile.getUserId().longValue());
//
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }

    final RowMapper<ProcUserProfile> FIND_ProcUserProfile_Responsible_ROW_MAPPER = new RowMapper<ProcUserProfile>() {

        public ProcUserProfile mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            final ProcUserProfile resVO = new ProcUserProfile();

            resVO
                    .setUserId(new BigInteger(String.valueOf(rs
                            .getLong(USER_ID))));
            resVO.setFullNameEn(rs.getString(FULL_NAME_EN));
            resVO.setFullNameTh(rs.getString(FULL_NAME_TH));

            return resVO;
        }
    };

    public long insertProcUserProfile(ProcUserProfile vo) throws Exception {

        long result = 0;
        Date currentDate = new Date();

        try {

            result = sequencerDao.getSeqNum(SEQ_PROC_USER_PROFILE);

            StringBuilder sql = new StringBuilder();

            sql.append("\n INSERT INTO " + TABLE + " (");
            sql.append("\n " + USER_ID + " , ");
            sql.append("\n " + NAME_TH + " , ");
            sql.append("\n " + NAME_EN + " , ");
            sql.append("\n " + SURNAME_TH + " , ");
            sql.append("\n " + SURNAME_EN + " , ");
            sql.append("\n " + FULL_NAME_TH + " , ");
            sql.append("\n " + FULL_NAME_EN + " , ");
            sql.append("\n " + CITIZEN_ID + " , ");
            sql.append("\n " + PASSPORT_ID + " , ");
            sql.append("\n " + SEX + " , ");
            sql.append("\n " + EMAIL + " , ");
            sql.append("\n " + MOBILENUMBER + " , ");
            sql.append("\n " + STATUS + " , ");
            sql.append("\n " + CREATE_DATE + " , ");
            sql.append("\n " + CREATE_BY + " , ");
            sql.append("\n " + UPDATE_DTTM + " , ");
            sql.append("\n " + UPDATE_BY);
            
            sql
                    .append("\nVALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ArrayList<Object> parameters = new ArrayList<Object>();

            parameters.add(result);

            // parameters.add(vo.getTitleId());
            parameters.add(vo.getNameTh());

            parameters.add(vo.getNameEn());

            parameters.add(vo.getSurnameTh());

            parameters.add(vo.getSurnameEn());

            parameters.add(vo.getFullNameTh());

            parameters.add(vo.getFullNameEn());

            parameters.add(vo.getCitizenId());

            parameters.add(vo.getPassportId());

            parameters.add(vo.getSex());

            parameters.add(vo.getEmail());

            parameters.add(vo.getMobileNumber());


            parameters.add(vo.getStatus());

            parameters.add(currentDate);

            parameters.add(vo.getCreateBy());

            parameters.add(currentDate);

            parameters.add(vo.getUpdateBy());

//            systemLogger.info(LogFormatter.info("insertProcUserProfile sql : " + sql.toString()));
//            systemLogger.info(LogFormatter.info("insertProcUserProfile parameters : ") + Arrays.toString(parameters.toArray()));
            
            getJdbcTemplate().update(sql.toString(), parameters.toArray());

        } catch (Exception e) {
            //setError(log, e);
            e.printStackTrace();
        }
        return result;

    }

    final RowMapper<ProcUserProfile> FIND_ProcUserProfile_ROW_MAPPER = new RowMapper<ProcUserProfile>() {

        public ProcUserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
            final ProcUserProfile resVO = new ProcUserProfile();

            resVO.setUserId(BigInteger.valueOf(rs.getLong(USER_ID)));
            resVO.setNameTh(rs.getString(NAME_TH));
            resVO.setNameEn(rs.getString(NAME_EN));
            resVO.setSurnameTh(rs.getString(SURNAME_TH));
            resVO.setSurnameEn(rs.getString(SURNAME_EN));
            resVO.setFullNameTh(rs.getString(FULL_NAME_TH));
            resVO.setFullNameEn(rs.getString(FULL_NAME_EN));
            resVO.setCitizenId(rs.getString(CITIZEN_ID));
            resVO.setPassportId(rs.getString(PASSPORT_ID));
            resVO.setSex(rs.getString(SEX));
            resVO.setEmail(rs.getString(EMAIL));
            resVO.setMobileNumber(rs.getString(MOBILENUMBER));
            resVO.setStatus(rs.getString(STATUS));
            resVO.setCreateDate(rs.getDate(CREATE_DATE));
            resVO.setCreateBy(rs.getString(CREATE_BY));
            resVO.setUpDateDttm(rs.getTimestamp(UPDATE_DTTM));
            resVO.setUpdateBy(rs.getString(UPDATE_BY));

            return resVO;
        }
    };

    public int updateStatusProcCorpUserProfile(ProcUserProfile vo) throws Exception {
        int count = 0;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE PROC_CORP_USER_PROFILE SET ");
            sql.append(STATUS + " = ? ");
            sql.append(" WHERE  CUST_ID  = ? ");

            ArrayList<Object> parameters = new ArrayList<Object>();

            parameters.add(vo.getStatus());
            parameters.add(vo.getUserId().longValue());

            count = getJdbcTemplate().queryForObject(sql.toString(), parameters.toArray(), Integer.class);

            //LogUtil.printLogDebug(CLASS_PROC_USER_PROFILE_DAO_IMPL, "parameters", "update result : " + count);
        } catch (Exception e) {
            //setError(log , e); 
            e.printStackTrace();

        }

        return count;

    }

    public List<ProcUserProfile> getProcUserProfile(ProcUserProfile procUserProfile)
            throws Exception {
        try {
            boolean flagCause = false;
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT ");
            sql.append("\n PRO." + USER_ID + " , ");
            sql.append("\n PRO." + TITLE_ID + " , ");
            sql.append("\n PRO." + NAME_TH + " , ");
            sql.append("\n PRO." + NAME_EN + " , ");
            sql.append("\n PRO." + SURNAME_TH + " , ");
            sql.append("\n PRO." + SURNAME_EN + " , ");
            sql.append("\n PRO." + FULL_NAME_TH + " , ");
            sql.append("\n PRO." + FULL_NAME_EN + " , ");
            sql.append("\n PRO." + CITIZEN_ID + " , ");
            sql.append("\n PRO." + PASSPORT_ID + " , ");
            sql.append("\n PRO." + SEX + " , ");
            sql.append("\n PRO." + EMAIL + " , ");
            sql.append("\n PRO." + MOBILENUMBER + " , ");
            sql.append("\n PRO." + REMARK + " , ");
            sql.append("\n PRO." + REMARK_OTHER + " , ");
            sql.append("\n PRO." + VERSION + " , ");
            sql.append("\n PRO." + STATUS + " , ");
            sql.append("\n PRO." + CREATE_DATE + " , ");
            sql.append("\n PRO." + CREATE_BY + " , ");
            sql.append("\n PRO." + UPDATE_DTTM + " , ");
            sql.append("\n PRO." + UPDATE_BY + " , ");
            sql.append("\n PRO." + CREATE_IPADDRESS + " , ");
            sql.append("\n PRO." + UPDATE_IPADDRESS + " ");
            sql.append("\n FROM " + TABLE + " PRO ");

            ArrayList<Object> parameters = new ArrayList<Object>();

            if (procUserProfile != null) {
                if (procUserProfile.getUserId() != null) {
                    sql.append(" AND " + USER_ID + " = ?");
                    parameters.add(procUserProfile.getUserId().longValue());

                }

                if (procUserProfile.getNameTh() != null) {
                    sql.append(" AND " + NAME_TH + " = ?");
                    parameters.add(procUserProfile.getNameTh());

                }

                if (procUserProfile.getNameEn() != null) {
                    sql.append(" AND " + NAME_EN + " = ?");
                    parameters.add(procUserProfile.getNameEn());

                }

                if (procUserProfile.getSurnameEn() != null) {
                    sql.append(" AND " + SURNAME_EN + " = ?");
                    parameters.add(procUserProfile.getSurnameEn());
                }

                if (procUserProfile.getSurnameTh() != null) {
                    sql.append(" AND " + SURNAME_TH + " = ?");
                    parameters.add(procUserProfile.getSurnameTh());
                }

                if (procUserProfile.getFullNameEn() != null) {
                    sql.append(" AND " + FULL_NAME_EN + " = ?");
                    parameters.add(procUserProfile.getFullNameEn());
                }

                if (procUserProfile.getFullNameTh() != null) {
                    sql.append(" AND " + FULL_NAME_TH + " = ?");
                    parameters.add(procUserProfile.getFullNameTh());
                }

                if (procUserProfile.getCitizenId() != null) {
                    sql.append(" AND " + CITIZEN_ID + " = ?");
                    parameters.add(procUserProfile.getCitizenId());
                }

                if (procUserProfile.getPassportId() != null) {
                    sql.append(" AND " + PASSPORT_ID + " = ?");
                    parameters.add(procUserProfile.getPassportId());
                }

                if (procUserProfile.getSex() != null) {
                    sql.append(" AND " + SEX + " = ?");
                    parameters.add(procUserProfile.getSex());
                }

                if (procUserProfile.getEmail() != null) {
                    sql.append(" AND " + EMAIL + " = ?");
                    parameters.add(procUserProfile.getEmail());

                }

                if (procUserProfile.getMobileNumber() != null) {
                    sql.append(" AND " + MOBILENUMBER + " = ?");
                    parameters.add(procUserProfile.getMobileNumber());
                }

                if (procUserProfile.getStatus() != null) {
                    sql.append(" AND " + STATUS + " = ?");
                    parameters.add(procUserProfile.getStatus());
                }

                if (procUserProfile.getCreateDate() != null) {
                    sql.append(" AND " + CREATE_DATE + " = ?");
                    parameters.add(procUserProfile.getCreateDate());
                }

                if (procUserProfile.getCreateBy() != null) {
                    sql.append(" AND " + CREATE_BY + " = ?");
                    parameters.add(procUserProfile.getCreateBy());
                }

                if (procUserProfile.getUpDateDttm() != null) {
                    sql.append(" AND " + UPDATE_DTTM + " = ?");
                    parameters.add(procUserProfile.getUpDateDttm());
                }

                if (procUserProfile.getUpdateBy() != null) {
                    sql.append(" AND " + UPDATE_BY + " = ?");
                    parameters.add(procUserProfile.getUpdateBy());
                }

            }

            List<ProcUserProfile> listProcUserProfile = getJdbcTemplate().query(sql.toString(), parameters.toArray(), ROW_MAPPER_PROC_USER_PROFILE);
            if (Utility.isListNotNullAndEmpty(listProcUserProfile)) {
                return listProcUserProfile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private final RowMapper<ProcUserProfile> ROW_MAPPER_PROC_USER_PROFILE = new RowMapper<ProcUserProfile>() {

        public ProcUserProfile mapRow(ResultSet rs, int index) throws SQLException {
            ProcUserProfile procUserProfile = new ProcUserProfile();
            procUserProfile.setUserId(new BigInteger(rs.getString(USER_ID)));
            procUserProfile.setNameTh(rs.getString(NAME_TH));
            procUserProfile.setNameEn(rs.getString(NAME_EN));
            procUserProfile.setNameTh(rs.getString(SURNAME_TH));
            procUserProfile.setNameEn(rs.getString(SURNAME_EN));
            procUserProfile.setFullNameTh(rs.getString(FULL_NAME_TH));
            procUserProfile.setFullNameEn(rs.getString(FULL_NAME_EN));
            procUserProfile.setCitizenId(rs.getString(CITIZEN_ID));
            procUserProfile.setPassportId(rs.getString(PASSPORT_ID));
            procUserProfile.setSex(rs.getString(SEX));
            procUserProfile.setEmail(rs.getString(EMAIL));
            procUserProfile.setMobileNumber(rs.getString(MOBILENUMBER));
            procUserProfile.setStatus(rs.getString(STATUS));
            procUserProfile.setCreateDate(rs.getDate(CREATE_DATE));
            procUserProfile.setCreateBy(rs.getString(CREATE_BY));
            procUserProfile.setUpDateDttm(rs.getTimestamp(UPDATE_DTTM));
            procUserProfile.setUpdateBy(rs.getString(UPDATE_BY));
            return procUserProfile;
        }
    };

    public ProcUserProfile findProcUserProfileResponsibleById(Long userId) throws Exception {

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ");
            sql.append("\n PRO.USER_ID , ");
            sql.append("\n PRO.FULL_NAME_TH , ");
            sql.append("\n PRO.FULL_NAME_EN ");
            sql.append("\n FROM " + TABLE + " PRO ");
            sql.append("\n INNER JOIN CIB.PROC_USER_AUTH AUTH ON PRO.USER_ID = AUTH.USER_ID ");
            sql.append("\n INNER JOIN CIB.PCK_ROLE RO ON AUTH.ROLE_CODE = RO.ROLE_CODE ");
            sql.append("\n WHERE PRO.USER_ID  = ? ");

            //LogUtil.printLogDebug(CLASS_PROC_USER_PROFILE_DAO_IMPL, "findProcUserProfileResponsibleById", "sql : " + sql.toString());
            ProcUserProfile result = (ProcUserProfile) getJdbcTemplate().queryForObject(sql.toString(), new Object[]{userId},
                    FIND_ProcUserProfile_Responsible_ROW_MAPPER);

            return result;

        } catch (Exception e) {
            //setError(log, e);
            e.printStackTrace();
        }
        return null;

    }

}
