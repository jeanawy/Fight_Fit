package th.fight.fit.mpybackoffice.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import th.fight.fit.mpybackoffice.dao.BaseDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.util.PropertiesUtil;

@Repository
public class SequencerDaoImpl extends BaseDao implements SequencerDao {
	public static final String DATE_PATTERN = "yyyyMMddHH";
    public static final String DATE_PATTERN_EBANKREF = "yyMMdd";
    public static final Locale ENGLISH_LOCALE = new Locale("en", "EN");
    static final int ID_LENGTH = 8;

    @Autowired
    private PropertiesUtil propertiesUtil;

    public long getSeqNum(String sequenceName) throws Exception {
        long num = 0;
        try {
            StringBuffer sql = new StringBuffer();

            sql.append("SELECT NEXT VALUE FOR " + sequenceName);
            Long numSeq = getJdbcTemplate().queryForObject(sql.toString(), Long.class);
            num = Long.parseLong(dateFormatter(DATE_PATTERN) + formatSeq(String.valueOf(numSeq), ID_LENGTH));

//            num = new java.util.Date().getTime();
        } catch (Exception s) {
            s.printStackTrace();
            throw s;
        }

        return num;
    }

    public String getSeqNumForEbankRefNonFIN(String sequenceName) throws Exception {
        long num = 0;
        String ebanfRef = null;
//		int EBANK_ID_LENGTH = 7;

        try {
            StringBuffer sql = new StringBuffer();

            sql.append("SELECT NEXTVAL FOR " + sequenceName + " FROM SYSIBM.SYSDUMMY1");

            Long numSeq = getJdbcTemplate().queryForObject(sql.toString(), Long.class);

            num = Long.parseLong(dateFormatter(DATE_PATTERN_EBANKREF) + formatSeq(String.valueOf(numSeq), ID_LENGTH));

            ebanfRef = propertiesUtil.getValue("gsb.web.service.app.rquid.prefix") + String.valueOf(num);

        } catch (Exception s) {
            s.printStackTrace();
            throw s;
        }

        return ebanfRef;

    }

    public long getSeqNumWithPrefix(String sequenceName, String prefix, int lenValue) throws Exception {
        long num = 0;
        try {
            StringBuffer sql = new StringBuffer();

            sql.append("SELECT NEXTVAL FOR " + sequenceName + " FROM SYSIBM.SYSDUMMY1");

            Long numSeq = getJdbcTemplate().queryForObject(sql.toString(), Long.class);

            num = Long.parseLong(prefix + formatSeq(String.valueOf(numSeq), lenValue));

        } catch (Exception s) {
            s.printStackTrace();
            throw s;
        }

        return num;
    }

    public String getSeqNumForEbankRefForSMS(String sequenceName) throws Exception {
        long num = 0;
        String ebanfRef = null;
        int EBANK_ID_LENGTH = 7;
        try {
            StringBuffer sql = new StringBuffer();

            sql.append("SELECT NEXTVAL FOR " + sequenceName + " FROM SYSIBM.SYSDUMMY1");

            Long numSeq = getJdbcTemplate().queryForObject(sql.toString(), Long.class);

            num = Long.parseLong(dateFormatter(DATE_PATTERN_EBANKREF) + formatSeq(String.valueOf(numSeq), EBANK_ID_LENGTH));

            ebanfRef = propertiesUtil.getValue("gsb.web.service.app.rquid.prefix") + String.valueOf(num);

        } catch (Exception s) {
            s.printStackTrace();
            throw s;
        }

        return ebanfRef;

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
