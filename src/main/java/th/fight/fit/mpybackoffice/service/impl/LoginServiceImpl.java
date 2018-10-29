package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.ProcLoginFailDao;
import th.fight.fit.mpybackoffice.dao.ProcSessionLoginDao;
import th.fight.fit.mpybackoffice.dao.ProcUserAuthDao;
import th.fight.fit.mpybackoffice.dao.ProcUserLoginDao;
import th.fight.fit.mpybackoffice.dao.ProcUserProfileDao;
import th.fight.fit.mpybackoffice.dao.SequencerDao;
import th.fight.fit.mpybackoffice.dao.UserDetailDao;
import th.fight.fit.mpybackoffice.domain.PckFunction;
import th.fight.fit.mpybackoffice.domain.PckMenu;
import th.fight.fit.mpybackoffice.domain.ProcUserLogin;
import th.fight.fit.mpybackoffice.domain.UserDetail;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.LoginService;
import th.fight.fit.mpybackoffice.service.SecurityService;
import th.fight.fit.mpybackoffice.util.SystemParamUtil;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    public UserDetail login() throws AuthenticationException {
        UserDetail userDetail = new UserDetail();

        List<PckFunction> functionList = new ArrayList<PckFunction>();

        PckFunction function = new PckFunction();
        function.setFuncCode("FUNC_001");
        functionList.add(function);

        function = new PckFunction();
        function.setFuncCode("FUNC_002");
        functionList.add(function);

        List<PckMenu> menuList = new ArrayList<PckMenu>();

        PckMenu menu = new PckMenu();
        menu.setMenuCode("MENU_001");
        menuList.add(menu);

        menu = new PckMenu();
        menu.setMenuCode("MENU_002");
        menuList.add(menu);

        userDetail.setFunctionList(functionList);
        userDetail.setMenuList(menuList);

        return userDetail;
    }

    @Override
    public void logout() throws Exception {
        // TODO Auto-generated method stub

    }

}
