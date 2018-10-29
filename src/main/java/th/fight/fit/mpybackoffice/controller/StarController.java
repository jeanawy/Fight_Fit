package th.fight.fit.mpybackoffice.controller;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.controller;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchByUserGiveStarResponseRESTModel;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchGroupUserStarGiveResponseRESTModel;
//import th.mfec.mpybackoffice.model.vo.SetGiveStar;
//import th.mfec.mpybackoffice.service.StarService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author ��ҡ�
// */
//@Controller
//public class StarController extends BaseController {
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
////
////    @Autowired
////    private SystemParamUtil systemParamUtil;
////    @Autowired
////    private LoginService loginService;
////    @Autowired
////    private PckMenuService pckMenuService;
//    @Autowired
//    private StarService starService;
//
//    @RequestMapping(value = "/StarController-initGiveStarByGroup", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initGiveStarByGroup(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("star.setByGroup");
//        SetGiveStar setGiveStar = new SetGiveStar();
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("setGiveStar", setGiveStar);
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
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
//    @RequestMapping(value = "/StarController-initGiveStarByUser", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initGiveStarByUser(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("star.setByUser");
//        SetGiveStar setGiveStar = new SetGiveStar();
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("setGiveStar", setGiveStar);
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
//            List<DropdownVO> departmentDropdown = MasterUtils.loadMasDepartmentsDropDownList(null);
//            model.addObject("departmentDropdown", departmentDropdown);
//            List<DropdownVO> divisionDropdown = MasterUtils.loadMasDivisionDropDownList(null, null);
//            model.addObject("divisionDropdown", divisionDropdown);
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
//    @PostMapping("/StarController-GiveStarByGroup")
//    @ResponseBody
//    public SearchGroupUserStarGiveResponseRESTModel searchGroupStarGive(HttpServletRequest request) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel response = new SearchGroupUserStarGiveResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + "groupUserID=" + request.getParameter("groupUserID")));
//
//            response = starService.getGroupUserStarGive(request.getParameter("sid"), request.getParameter("language"), request.getParameter("groupUserID"));
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
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, ProjectConstant.STATUS_SUCCESS, null, null));
//
//        }
//        return response;
//    }
//
//    @PostMapping("/StarController-searchGiveStarByUser")
//    @ResponseBody
//    public SearchByUserGiveStarResponseRESTModel searchUser(HttpServletRequest request) throws Exception {
//        SearchByUserGiveStarResponseRESTModel response = new SearchByUserGiveStarResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + ", rowPerPage=" + request.getParameter("length")
//                    + ", groupUserID=" + request.getParameter("groupUserID") + ", department=" + request.getParameter("department")
//                    + ", division=" + request.getParameter("division") + ", searchName=" + request.getParameter("searchName")));
//
//            response = starService.getByUserGiveStar(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("groupUserID"), request.getParameter("department"), request.getParameter("division"),
//                    request.getParameter("searchName"));
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
//    @PostMapping("/StarController-updateGiveStarByGroup")
//    @ResponseBody
//    public SearchGroupUserStarGiveResponseRESTModel updateGiveStarByGroup(HttpServletRequest request) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel response = new SearchGroupUserStarGiveResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", groupUserID=" + request.getParameter("groupUserID") + ", giveGoldStar=" + request.getParameter("giveGoldStar")
//                    + ", giveSilverStar=" + request.getParameter("giveSilverStar") + ", giveBronzeStar=" + request.getParameter("giveBronzeStar")));
//
//            response = starService.updateGroupUserStarGive(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("groupUserID"), request.getParameter("giveGoldStar"),
//                    request.getParameter("giveSilverStar"), request.getParameter("giveBronzeStar"));
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
//    @PostMapping("/StarController-updateGiveStarByUser")
//    @ResponseBody
//    public SearchGroupUserStarGiveResponseRESTModel updateGiveStarByUser(HttpServletRequest request) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel response = new SearchGroupUserStarGiveResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", uid=" + request.getParameter("uid") + ", giveGoldStar=" + request.getParameter("giveGoldStar")
//                    + ", giveSilverStar=" + request.getParameter("giveSilverStar") + ", giveBronzeStar=" + request.getParameter("giveBronzeStar")));
//
//            response = starService.updateByUserStarGive(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("uid"), request.getParameter("giveGoldStar"),
//                    request.getParameter("giveSilverStar"), request.getParameter("giveBronzeStar"));
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
//}
