package th.fight.fit.mpybackoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.fight.fit.mpybackoffice.dao.MasSysParamDao;
import th.fight.fit.mpybackoffice.domain.MasSystemParam;
import th.fight.fit.mpybackoffice.service.MasSysParamService;

@Service
public class MasSysParamServiceImpl implements MasSysParamService {

	@Autowired MasSysParamDao masSysParamDao;
	
	public List<MasSystemParam> getMasSysParam(MasSystemParam masSystemParam) {
		return masSysParamDao.getMasSysParam(masSystemParam);
		
	}

	public void updateMasSysParam(MasSystemParam masSystemParam) {
		masSysParamDao.updateMasSysParam(masSystemParam);
		
	}

	public MasSystemParam getMasSysParamByParamKey(String paramKey) {
		return masSysParamDao.getMasSysParamByParamKey(paramKey);
		
	}

}
