package th.fight.fit.mpybackoffice.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.UserDetailDao;
import th.fight.fit.mpybackoffice.domain.PckFunction;
import th.fight.fit.mpybackoffice.domain.PckMenu;
import th.fight.fit.mpybackoffice.domain.PckRole;
import th.fight.fit.mpybackoffice.domain.ProcUserLogin;
import th.fight.fit.mpybackoffice.domain.ProcUserProfile;
import th.fight.fit.mpybackoffice.domain.UserDetail;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;

@Repository
public class UserDetailDaoImpl extends BaseDao implements UserDetailDao {
    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	public UserDetail getUserDetail(final BigInteger userId) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		final UserDetail userDetail = new UserDetail();
		final ProcUserProfile userProfile = new ProcUserProfile();
		final PckRole role = new PckRole();
		List<PckMenu> menuList = null;
		List<PckFunction> functionList = null;
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {

			// Get UserProfile, Role 1-1 relation.
			strBuff.append("SELECT up.USER_ID AS up_user_id, up.TITLE_ID AS up_title_id, up.NAME_TH AS up_name_th, up.NAME_EN AS up_name_en, up.FULL_NAME_TH AS up_full_name_th, up.FULL_NAME_EN AS up_full_name_en, ");
			strBuff.append("up.SURNAME_TH AS up_surname_th, up.SURNAME_EN AS up_surname_en, up.CITIZEN_ID AS up_citizen_id, up.PASSPORT_ID AS up_passport_id, up.SEX AS up_sex, up.EMAIL AS up_email, up.MOBILENUMBER AS up_mobilenumber, ");
			strBuff.append("up.VERSION AS up_version, up.STATUS AS up_status, up.REMARK_OTHER AS up_remark_other, up.REMARK AS up_remark, up.CREATE_DATE AS up_create_date, up.CREATE_BY AS up_create_by, ");
			strBuff.append("up.UPDATE_DTTM AS up_update_dttm, up.UPDATE_BY AS up_update_by, up.CREATE_IPADDRESS AS up_create_ipaddress, up.UPDATE_IPADDRESS AS up_update_ipaddress, ua.USER_AUTH_ID AS ua_user_auth_id, ");
			strBuff.append("ub.BRANCH_CODE AS branch_code, ");
			strBuff.append("r.ROLE_ID AS r_role_id, r.ROLE_CODE AS r_role_code, r.ROLE_NAME AS r_role_name, r.ROLE_TYPE AS r_role_type, r.STATUS AS r_status, r.VERSION AS r_version, r.IS_CLIENT AS r_is_client, ");
			strBuff.append("r.IS_CUSTOMER AS r_is_customer, r.CREATE_DATE AS r_create_date, r.CREATE_BY AS r_create_by, r.UPDATE_DTTM AS r_update_dttm, r.UPDATE_BY AS r_update_by");
			strBuff.append(",br.DIVISIONCODE AS br_divisioncode,br.REGIONCODE AS br_regioncode ");
			strBuff.append("from PROC_USER_PROFILE up ");
			strBuff.append("left outer join proc_user_auth ua on ua.USER_ID = up.USER_ID ");
			strBuff.append("left outer join proc_user_branch ub on ub.USER_ID = up.USER_ID ");
			strBuff.append("left outer join pck_role r on r.ROLE_CODE = ua.ROLE_CODE ");
			strBuff.append("left outer join MAS_BRANCH br on br.BRANCH_CODE = ub.BRANCH_CODE ");
			strBuff.append("where up.user_id = ? and r.STATUS = 'AC' ");

			params.add(userId.longValue());
			
			systemLogger.debug(LogFormatter.common("Get UserProfile sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("Get UserProfile param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().query(strBuff.toString(), new PreparedStatementSetter() {

				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setLong(1, userId.longValue());

				}
			}, new RowMapper() {

				public Object mapRow(ResultSet rs, int index)
						throws SQLException {

					userProfile.setUserId(BigInteger.valueOf(rs.getLong("up_user_id")));
					userProfile.setNameTh(rs.getString("up_name_th"));
					userProfile.setNameEn(rs.getString("up_name_en"));
					userProfile.setFullNameTh(rs.getString("up_full_name_th"));
					userProfile.setFullNameEn(rs.getString("up_full_name_en"));
					userProfile.setSurnameTh(rs.getString("up_surname_th"));
					userProfile.setSurnameEn(rs.getString("up_surname_en"));
					userProfile.setCitizenId(rs.getString("up_citizen_id"));
					userProfile.setPassportId(rs.getString("up_passport_id"));
					userProfile.setSex(rs.getString("up_sex"));
					userProfile.setEmail(rs.getString("up_email"));
					userProfile.setMobileNumber(rs.getString("up_mobilenumber"));
					userProfile.setStatus(rs.getString("up_status"));
					userProfile.setCreateDate(rs.getDate("up_create_date"));
					userProfile.setCreateBy(rs.getString("up_create_by"));
					userProfile.setUpdateDate(rs.getTimestamp("up_update_dttm"));
					userProfile.setUpdateBy(rs.getString("up_update_by"));

					role.setRoleId(BigInteger.valueOf(rs.getLong("r_role_id")));
					role.setRoleCode(rs.getString("r_role_code"));
					role.setRoleName(rs.getString("r_role_name"));
					role.setRoleType(rs.getString("r_role_type"));
					role.setStatus(rs.getString("r_status"));
					role.setVersion(rs.getInt("r_version"));
					role.setIsClient(rs.getString("r_is_client").trim());
					role.setIsCustomer(rs.getString("r_is_customer").trim());
					
					userDetail.setProcUserProfile(userProfile);
					userDetail.setUserAuthenId(BigInteger.valueOf(rs.getLong("ua_user_auth_id")));
					userDetail.setRole(role);

					return null;
				}
			});

			if(role.getRoleId() != null){
				
				//LogUtil.printLogDebug(CLASS_USER_DETAIL_DAO_IMPL, METHOD_GET_USER_BY_USER_ID, "roleCode : " + role.getRoleCode());
				
				// Function
				strBuff = new StringBuffer();

				strBuff.append("select f.func_id, f.func_code, f.func_name_th, f.func_name_en, f.status, f.version, f.create_date, f.create_by, f.update_dttm, f.update_by ");
				strBuff.append("from pck_rel_func_package rfp ");
				strBuff.append("inner join pck_function f on f.func_code = rfp.func_code ");
				strBuff.append("where role_code = ? and f.status = 'AC' ");

				params = new ArrayList<Object>();
				params.add(role.getRoleCode());
				
				systemLogger.debug(LogFormatter.common("Get Function sql : " + strBuff.toString()));
				systemLogger.debug(LogFormatter.common("Get Function : " + Arrays.toString(params.toArray())));
				
				functionList = getJdbcTemplate().query(strBuff.toString(), new PreparedStatementSetter() {

					public void setValues(PreparedStatement prep) throws SQLException {
						prep.setString(1, role.getRoleCode());

					}
				}, new RowMapper() {

					public PckFunction mapRow(ResultSet rs, int index) throws SQLException {
						PckFunction function = new PckFunction();
						function.setFuncId(BigInteger.valueOf(rs.getLong("func_id")));
						function.setFuncCode(rs.getString("func_code"));
						function.setFuncNameTh(rs.getString("func_name_th"));
						function.setFuncNameEn(rs.getString("func_name_en"));
						function.setStatus(rs.getString("status"));
						function.setVersion(rs.getInt("version"));
						function.setCreateDate(rs.getDate("create_date"));
						function.setCreateBy(rs.getString("create_by"));
						function.setUpdateDttm(rs.getTimestamp("update_dttm"));
						function.setUpdateBy(rs.getString("update_by"));

						return function;
					}
				} );

				// Menu
				strBuff = new StringBuffer();

				strBuff.append("select m.menu_id, m.menu_code, m.menu_name_th, m.menu_name_en, m.menu_type, m.menu_parent_code, m.priority, m.status, m.version, m.create_date, m.create_by, m.update_dttm, m.update_by ");
				strBuff.append("from pck_rel_menu_package rmp ");
				strBuff.append("inner join pck_menu m on m.menu_code = rmp.menu_code ");
				strBuff.append("where rmp.role_code = ? and m.status = 'AC' ");

				params = new ArrayList<Object>();
				params.add(role.getRoleCode());
				
				systemLogger.debug(LogFormatter.common("Get Function sql : " + strBuff.toString()));
				systemLogger.debug(LogFormatter.common("Get Function : " + Arrays.toString(params.toArray())));

				menuList = getJdbcTemplate().query(strBuff.toString(), new PreparedStatementSetter() {

					public void setValues(PreparedStatement prep) throws SQLException {
						prep.setString(1, role.getRoleCode());

					}
				}, new RowMapper() {

					public PckMenu mapRow(ResultSet rs, int index) throws SQLException {
						PckMenu menu = new PckMenu();
						menu.setMenuId(BigInteger.valueOf(rs.getLong("menu_id")));
						menu.setMenuCode(rs.getString("menu_code"));
						menu.setMenuNameTh(rs.getString("menu_name_th"));
						menu.setMenuNameEn(rs.getString("menu_name_en"));
						menu.setMenuType(rs.getString("menu_type"));
						menu.setMenuParentCode(rs.getString("menu_parent_code"));
						menu.setPriority(rs.getInt("priority"));
						menu.setStatus(rs.getString("status"));
						menu.setVersion(rs.getInt("version"));
						menu.setCreateDate(rs.getDate("create_date"));
						menu.setCreateBy(rs.getString("create_by"));
						menu.setUpdateDttm(rs.getTimestamp("update_dttm"));
						menu.setUpdateBy(rs.getString("update_by"));

						return menu;
					}
				});

			}

			userDetail.setFunctionList(functionList);
			userDetail.setMenuList(menuList);

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;

		}

		return userDetail.getProcUserProfile() != null ? userDetail:null;
	}

	public ProcUserLogin getUserLogin(final String userName) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		StringBuffer strBuff = new StringBuffer();
		final ProcUserLogin userLogin = new ProcUserLogin();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {

			strBuff.append("select u.USER_LOGIN_ID as user_login_id, u.USER_ID as user_id, u.USER_NAME as user_name, ");
			strBuff.append(" u.USER_TYPE as user_type, u.corp_code as corp_code, u.counter as counter, u.password as password, ");
			strBuff.append(" u.LAST_LOGIN_DTTM as last_login_dttm, u.LAST_LOGIN_IPADDRESS as last_login_ipaddress ");
			strBuff.append(" from PROC_USER_LOGIN u ");
			strBuff.append(" where u.USER_NAME = ?");

			params.add(userName);
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			
			getJdbcTemplate().query(strBuff.toString(), new PreparedStatementSetter() {

				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setString(1, userName);

				}
			},new RowMapper() {

				public Object mapRow(ResultSet rs, int index)
						throws SQLException {
					userLogin.setUserLoginId(BigInteger.valueOf(rs.getLong("user_login_id")));
					userLogin.setUserId(BigInteger.valueOf(rs.getLong("user_id")));
					userLogin.setUserName(rs.getString("user_name"));
					userLogin.setUserType(rs.getString("user_type"));
					userLogin.setCounter(rs.getInt("counter"));
					userLogin.setPassword(rs.getString("password"));
					userLogin.setLastLoginDttm(rs.getTimestamp("last_login_dttm"));
					userLogin.setLastLoginIpAddress(rs.getString("last_login_ipaddress"));

					return null;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;

		}

		return userLogin.getUserLoginId() != null? userLogin : null;
	}

	public void updateUserLogin(final ProcUserLogin userLogin) throws Exception{
		StringBuffer strBuff = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {

			strBuff.append("update proc_user_login set user_id = ?, user_name = ?, user_type = ?, corp_code = ?, COUNTER = ?, PASSWORD = ?, LAST_LOGIN_DTTM = ?, LAST_LOGIN_IPADDRESS = ? ");
			strBuff.append("where user_login_id = ? ");

			params.add(userLogin);
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {

				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setLong(1, userLogin.getUserId().longValue());
					prep.setString(2, userLogin.getUserName());
					prep.setString(3, userLogin.getUserType());
					prep.setInt(4, userLogin.getCounter());
					prep.setString(5, userLogin.getPassword());
					prep.setTimestamp(6, new Timestamp(userLogin.getLastLoginDttm().getTime()));
					prep.setString(7, userLogin.getLastLoginIpAddress());
					prep.setLong(8, userLogin.getUserLoginId().longValue());

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}

	public void updateUserProfile(final ProcUserProfile userProfile) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		ArrayList<Object> params = new ArrayList<Object>();
		
		try {
			strBuff.append("update proc_user_profile ");
			strBuff.append("set name_th = ?, name_en = ?, full_name_th = ?, full_name_en = ?, surname_th = ?, surname_en = ?, citizen_id = ?, passport_id = ?, ");
			strBuff.append("sex = ?, email = ?, mobilenumber = ?, status = ?, create_date = ?, create_by = ?, update_dttm = ?, update_by = ? ");
			strBuff.append("where user_id = ? ");

			params.add(userProfile.getNameTh());
			params.add(userProfile.getNameEn());
			params.add(userProfile.getFullNameTh());
			params.add(userProfile.getFullNameEn());
			params.add(userProfile.getSurnameTh());
			params.add(userProfile.getSurnameEn());
			params.add(userProfile.getCitizenId());
			params.add(userProfile.getPassportId());
			params.add(userProfile.getSex());
			params.add(userProfile.getEmail());
			params.add(userProfile.getMobileNumber());
			params.add(userProfile.getStatus());
			params.add(userProfile.getCreateDate().getTime());
			params.add(userProfile.getCreateBy());
			params.add(userProfile.getUpdateDate().getTime());
			params.add(userProfile.getUpdateBy());
			params.add(userProfile.getUserId().longValue());
			
			systemLogger.debug(LogFormatter.common("sql : " + strBuff.toString()));
			systemLogger.debug(LogFormatter.common("param : " + Arrays.toString(params.toArray())));
			
			getJdbcTemplate().update(strBuff.toString(), new PreparedStatementSetter() {

				public void setValues(PreparedStatement prep) throws SQLException {
					prep.setString(2, userProfile.getNameTh());
					prep.setString(3, userProfile.getNameEn());
					prep.setString(4, userProfile.getFullNameTh());
					prep.setString(5, userProfile.getFullNameEn());
					prep.setString(6, userProfile.getSurnameTh());
					prep.setString(7, userProfile.getSurnameEn());
					prep.setString(8, userProfile.getCitizenId());
					prep.setString(9, userProfile.getPassportId());
					prep.setString(10, userProfile.getSex());
					prep.setString(11, userProfile.getEmail());
					prep.setString(12, userProfile.getMobileNumber());
					prep.setString(13, userProfile.getStatus());
					prep.setDate(14, new Date(userProfile.getCreateDate().getTime()));
					prep.setString(15, userProfile.getCreateBy());
					prep.setTimestamp(16, new Timestamp(userProfile.getUpdateDate().getTime()));
					prep.setString(17, userProfile.getUpdateBy());
					prep.setLong(18, userProfile.getUserId().longValue());

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			throw e;

		}

	}

}
