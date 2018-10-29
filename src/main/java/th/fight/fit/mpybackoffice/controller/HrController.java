package th.fight.fit.mpybackoffice.controller;

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
////import th.mfec.mpybackoffice.domain.vo.ButtonVO;
//import th.mfec.mpybackoffice.domain.vo.DropdownVO;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.HrManagement.CreateDocument;
//import th.mfec.mpybackoffice.model.HrManagement.SearchRequestDocHistoryResponeRESTModel;
//import th.mfec.mpybackoffice.model.vo.RequestDocHistory;
//import th.mfec.mpybackoffice.service.GetHistRequestDocService;
//import th.mfec.mpybackoffice.service.LoginService;
//import th.mfec.mpybackoffice.service.PckMenuService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.SystemParamUtil;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Sukrit_p
// */
//@Controller
//public class HrController extends BaseController {
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private SystemParamUtil systemParamUtil;
//    @Autowired
//    private LoginService loginService;
//    @Autowired
//    private PckMenuService pckMenuService;
//    @Autowired
//    private GetHistRequestDocService getHistRequestDocService;
//
//    @RequestMapping(value = "/hrController-initCreateDocument", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initCreateDocument(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("create.document");
//        CreateDocument createDocument = new CreateDocument();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("createDocument", createDocument);
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
//    @RequestMapping(value = "/hrController-initRequestDocHistory", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initRequestDocHistory(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("requestdoc.history");
//        RequestDocHistory requestDocHistory = new RequestDocHistory();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("requestDocHistory", requestDocHistory);
//            List<DropdownVO> documentDropdown = MasterUtils.loadMasDocumentDropdownList(null);
//            model.addObject("documentDropdown", documentDropdown);
//            List<DropdownVO> searchByStatusDropdown = MasterUtils.loadMasStatusDocumentDropdownList(null);
//            model.addObject("searchByStatusDropdown", searchByStatusDropdown);
////            List<ButtonVO> documentButton = MasterUtils.loadMasTranCodeDocumentButtonList(null);
////            model.addObject("documentButton", documentButton);
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
//    @PostMapping("/hrController-searchRequestDocHistory")
//    @ResponseBody
//    public SearchRequestDocHistoryResponeRESTModel searchRequestDocument(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        SearchRequestDocHistoryResponeRESTModel response = new SearchRequestDocHistoryResponeRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
//                    + ", searchRequestDay=" + request.getParameter("requestDay") + ", searchDocumentID=" + request.getParameter("documentID") + ", searchByStatus=" + request.getParameter("searchByStatus")));
//
//            response = getHistRequestDocService.getHistRequestDoc(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length") , request.getParameter("requestDay"),
//                    request.getParameter("documentID"), request.getParameter("searchByStatus"));
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
////    @PostMapping("/hrController-editStatucDoc")
////    @ResponseBody
////    public SearchRequestDocHistoryResponeRESTModel editStatucDoc(HttpServletRequest request) throws Exception {
////        SearchRequestDocHistoryResponeRESTModel response = new SearchRequestDocHistoryResponeRESTModel();
////        Date startDate = new Date();
////        boolean processSuccess = false;
////
////        try {
////            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "-RequestData:" + "language=" + request.getParameter("language")
////                    + ", documnetID=" + request.getParameter("documentID") + "}" + ", tranID=" + request.getParameter("transactionID") + ", tranCode=" + request.getParameter("transactionCode")));
////
////            response = getHistRequestDocService.transactionEditStatucDoc(request.getParameter("documentID"), request.getParameter("transactionID"), request.getParameter("transactionCode"));
////            processSuccess = true;
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
////        } finally {
////
////            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
////
////        }
////        return response;
////    }
//}
