package th.fight.fit.mpybackoffice.dao.impl;


import java.math.BigInteger;
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
import th.fight.fit.mpybackoffice.dao.PckMenuDao;
import th.fight.fit.mpybackoffice.domain.PckMenu;

@Repository
public class PckMenuDaoImpl extends BaseDao implements PckMenuDao {
	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

	private final String PACKAGE_CODE = "PACKAGE_CODE";
	private final String MENU_CODE = "MENU_CODE";
	private final String MENU_NAME_EN = "MENU_NAME_EN";
	private final String TABLE = "PCK_MENU"; 
	private final String MENU_ID = "MENU_ID";
	private final String MENU_NAME_TH = "MENU_NAME_TH";
	private final String MENU_PARENT_CODE = "MENU_PARENT_CODE";
	private final String MENU_TYPE = "MENU_TYPE";
	private final String PRIORITY = "PRIORITY";
	private final String VERSION = "VERSION";
	private final String CREATE_DATE = "CREATE_DATE";
	private final String CREATE_BY = "CREATE_BY";
	private final String UPDATE_DTTM = "UPDATE_DTTM";
	private final String UPDATE_BY = "UPDATE_BY";
	private final String STATUS = "STATUS";
	private final String TABLE_PCK_REL_INIT_PMF = "PCK_REL_INIT_PMF";

	public List<PckMenu> getPckMenu() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM "+TABLE);
		List<PckMenu>list = (List<PckMenu>) getJdbcTemplate().query(sql.toString(), GET_PCK_MENU_ROW_MAPPER);
		return list;
	}

	final RowMapper<PckMenu> GET_PCK_MENU_ROW_MAPPER = new RowMapper<PckMenu>() {

		public PckMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
			final PckMenu resVO = new PckMenu();
			resVO.setMenuId(BigInteger.valueOf(rs.getLong(MENU_ID)));
			resVO.setMenuCode(rs.getString(MENU_CODE));
			resVO.setMenuNameTh(rs.getString(MENU_NAME_TH));
			resVO.setMenuNameEn(rs.getString(MENU_NAME_EN));
			resVO.setPriority(rs.getInt(PRIORITY));
			resVO.setStatus(rs.getString(STATUS));
			resVO.setVersion(rs.getInt(VERSION));
			resVO.setCreateDate(rs.getDate(CREATE_DATE));
			resVO.setCreateBy(rs.getString(CREATE_BY));
			resVO.setUpdateDttm(rs.getTimestamp(UPDATE_DTTM));
			resVO.setUpdateBy(rs.getString(UPDATE_BY));

			return resVO;
		}
	};
}
