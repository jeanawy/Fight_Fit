package th.fight.fit.mpybackoffice.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.PckMenu;

public interface PckMenuDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<PckMenu> getPckMenu() throws Exception;
	
}
