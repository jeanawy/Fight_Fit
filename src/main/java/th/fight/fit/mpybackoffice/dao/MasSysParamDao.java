package th.fight.fit.mpybackoffice.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.MasSystemParam;

public interface MasSysParamDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<MasSystemParam> getMasSysParam(MasSystemParam masSystemParam);
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateMasSysParam(MasSystemParam masSystemParam);
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public MasSystemParam getMasSysParamByParamKey(String paramKey);
	
}
