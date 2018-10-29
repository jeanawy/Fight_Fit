package th.fight.fit.mpybackoffice.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface SequencerDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public long getSeqNum(String sequenceName) throws Exception;
 
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public long getSeqNumWithPrefix(String sequenceName, String prefix, int lenValue) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public String getSeqNumForEbankRefNonFIN(String sequenceName) throws Exception;

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public String getSeqNumForEbankRefForSMS(String sequenceName) throws Exception;
	
}
