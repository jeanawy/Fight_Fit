/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.controller;

import th.fight.fit.mpybackoffice.service.ProfileManagementService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 *
 * @author Sent
 */

@Controller
public class ProfileController extends BaseController{
    @Autowired
    private ProfileManagementService profileManagementService ;
    
    @RequestMapping(value="/userprofile", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView profile(HttpServletRequest request){
		Date startDate = new Date();
		ModelAndView model = new ModelAndView("login.welcome");
               
                                    
		request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());
		
		
		return model;
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//    @RequestMapping(value = "/ContactRepairController-initContactRepairHistory", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initContactRepairHistory(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("contactrepair.history");
//        SearchContactRepairHistory searchContactRepairHistory = new SearchContactRepairHistory();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("searchContactRepairHistory", searchContactRepairHistory);
//            List<DropdownVO> buildingDropdown = MasterUtils.loadMasBuildingDropdownListForContactRepair(null);
//            model.addObject("buildingDropdown", buildingDropdown);
//            List<DropdownVO> contactRepairDropdown = MasterUtils.loadMasStatusRepairDropDownList(null);
//            model.addObject("contactRepairDropdown", contactRepairDropdown);
//
//            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, ProjectConstant.STATUS_SUCCESS, null, null));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//        return model;
//    }
  
}
