//package th.fight.fit.mpybackoffice.controller;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.controller;
//
//import java.util.Date;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.support.RequestContextUtils;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.domain.vo.DropdownVO;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.StarRewardManagement.CreateReward;
//import th.mfec.mpybackoffice.model.StarRewardManagement.RewardsList;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchRedeemReward;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchRedeemRewardResponseRESTModel;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchRewardsListResponeRESTModel;
//import th.mfec.mpybackoffice.service.GetRewardsListService;
//import th.mfec.mpybackoffice.service.RewardService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author 58050232
// */
//@Controller
//public class RewardController extends BaseController {
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private GetRewardsListService getRewardsListService;
//    @Autowired
//    private RewardService rewardService;
//
//    @RequestMapping(value = "/RewardController-initCreateReward", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initCreateReward(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("star.createReward");
//        CreateReward createReward = new CreateReward();
//
//        try {
//            model.addObject("searchUserAuthorize", createReward);
//
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
//            List<DropdownVO> departmentsDropDownList = MasterUtils.loadMasDepartmentsDropDownList(null);
//            model.addObject("departmentsDropDownList", departmentsDropDownList);
//            List<DropdownVO> divisionDropDownList = MasterUtils.loadMasDivisionDropDownList(null, null);
//            model.addObject("divisionDropDownList", divisionDropDownList);
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("createReward", createReward);
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
//
//    @RequestMapping(value = "/rewardController-initRewardsList", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initRewardsList(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("star.rewardsList");
//        RewardsList rewardsList = new RewardsList();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("RewardsList", rewardsList);
//            List<DropdownVO> searchByStatusDropdown = MasterUtils.loadMasStatusRewardDropdownList(ProjectConstant.STATUS_REDEEM, null);
//            model.addObject("searchByStatusDropdown", searchByStatusDropdown);
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
//
//    @PostMapping("/rewardController-searchRewardsList")
//    @ResponseBody
//    public SearchRewardsListResponeRESTModel searchRewardsList(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        SearchRewardsListResponeRESTModel response = new SearchRewardsListResponeRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
//                    + ", searchRewardName=" + request.getParameter("reward") + ", searchByStatus=" + request.getParameter("searchByStatus")));
//
//            response = getRewardsListService.getRewardsList(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("reward"), request.getParameter("searchByStatus"));
//
//            processSuccess = true;
//
////        } catch (InternalConnectionException e) {
////            errorCode = ProjectConstant.GET_HIS_MEETING_ROOM__ERROR_CODE_INTERNAL_CONNECTION_EXCEPTION;
////            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
////
////        } catch (ServiceValidation e) {
////
////            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
////                errorCode = e.getMessage();
////            } else {
////                errorCode = ProjectConstant.GET_HIS_MEETING_ROOM_ERROR_CODE_SERVICE_VALIDATION_INDEX_PATTERN;
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//
////            if (processSuccess) {
////                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
////                response.setData(data);
////
////            } else {
////                errorMessage = MasterUtils.findErrorDesc(errorCode, rqLanguage);
////
////                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
////                response.setErrorCode(errorCode);
////                response.setErrorMessage(errorMessage);
////            }
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//        return response;
//    }
//
//    @PostMapping("/deleteReward")
//    @ResponseBody
//    public SearchRewardsListResponeRESTModel deleteReward(HttpServletRequest request) throws Exception {
//        SearchRewardsListResponeRESTModel response = new SearchRewardsListResponeRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
//                    + ", searchRewardName=" + request.getParameter("reward") + ", searchByStatus=" + request.getParameter("searchByStatus")));
//
//            response = getRewardsListService.transactionDeleteReward(request.getParameter("sid"), request.getParameter("language"),
//                    request.getParameter("rewardId"), request.getParameter("quantityExchange"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//        return response;
//    }
//
//    @RequestMapping(value = "/rewardController-initRedeemRewards", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initRedeemRewards(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("star.searchRedeemReward");
//        SearchRedeemReward searchRedeemReward = new SearchRedeemReward();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("searchRedeemReward", searchRedeemReward);
//            List<DropdownVO> searchByStatusDropdown = MasterUtils.loadMasStatusRewardDropdownList(ProjectConstant.STATUS_REWARD, null);
//            model.addObject("searchByStatusDropdown", searchByStatusDropdown);
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
//
//    @PostMapping("/rewardController-searchRedeemReward")
//    @ResponseBody
//    public SearchRedeemRewardResponseRESTModel searchRedeemReward(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        SearchRedeemRewardResponseRESTModel response = new SearchRedeemRewardResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
//                    + ", searchRewardName=" + request.getParameter("reward") + ", searchByStatus=" + request.getParameter("searchByStatus")));
//
//            response = rewardService.getRedeemReward(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("searchUser"), request.getParameter("searchRewardName"), request.getParameter("requestDay"), request.getParameter("searchByStatus"));
//
//            processSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//        return response;
//    }
//}
