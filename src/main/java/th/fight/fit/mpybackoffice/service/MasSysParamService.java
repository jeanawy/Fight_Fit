package th.fight.fit.mpybackoffice.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.MasSystemParam;

public interface MasSysParamService {

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<MasSystemParam> getMasSysParam(MasSystemParam masSystemParam);
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateMasSysParam(MasSystemParam masSystemParam);

	@Transactional(propagation = Propagation.SUPPORTS)
	public MasSystemParam getMasSysParamByParamKey(String paramKey);
	
}
