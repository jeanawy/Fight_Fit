/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.dao.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.springframework.stereotype.Repository;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.DB2SequencerDao;
import th.fight.fit.mpybackoffice.util.StringUtils;

/**
 *
 * @author Anuwat_K
 */
@Repository
public class DB2SequencerDaoImpl extends BaseDao implements DB2SequencerDao {

    public static final String DATE_PATTERN = "yyyyMMddHH";
    public static final String DATE_PATTERN_EBANKREF = "yyMMdd";
    public static final Locale ENGLISH_LOCALE = new Locale("en", "EN");
    static final int ID_LENGTH = 8;

    public int getSeqNum(String sequenceName) throws Exception {
        int num = 0;
        StringBuilder sql = new StringBuilder();

        try {

            if (StringUtils.isNotEmptyOrNull(sequenceName)) {
                sql.append("SELECT NEXT VALUE FOR ").append(sequenceName);
                num = getJdbcTemplate().queryForObject(sql.toString(), Integer.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return num;
    }

    public long getSeqNumTransaction(String sequenceName) throws Exception {
        long num = 0;
        StringBuilder sql = new StringBuilder();

        try {

            if (StringUtils.isNotEmptyOrNull(sequenceName)) {

                sql.append("SELECT NEXT VALUE FOR ").append(sequenceName);
                Long numSeq = getJdbcTemplate().queryForObject(sql.toString(), Long.class);
                num = Long.parseLong(dateFormatter(DATE_PATTERN) + formatSeq(String.valueOf(numSeq), ID_LENGTH));

            } else {
                num = new java.util.Date().getTime();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return num;
    }

    public String formatSeq(String seq, int lenValue) throws Exception {

        StringBuffer pad = new StringBuffer();
        for (int i = (lenValue - seq.length()); i > 0; i--) {
            pad.append("0");
        }
        return pad.toString() + seq;
    }

    private String dateFormatter(String format) {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat(format, ENGLISH_LOCALE);
        String datenewformat = formatter.format(today);
        return datenewformat;
    }

}
