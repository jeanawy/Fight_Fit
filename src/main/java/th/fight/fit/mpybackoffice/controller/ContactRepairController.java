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
//import th.mfec.mpybackoffice.model.SearchContactRepairHistory;
//import th.mfec.mpybackoffice.model.rest.PictureURLContactRepair;
//import th.mfec.mpybackoffice.model.rest.SearchBookingHistoryResponseRESTModel;
//import th.mfec.mpybackoffice.model.rest.SearchContactRepairHistoryResponseRESTModel;
//import th.mfec.mpybackoffice.model.rest.TransactionUpdateContactRepairResponseRESTModel;
//import th.mfec.mpybackoffice.service.ContactRepairService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.SystemParamUtil;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Jeep_
// */
//@Controller
//public class ContactRepairController extends BaseController {
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    
//    @Autowired
//    private ContactRepairService contactRepairService;
//
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
//
//    @PostMapping("/ContactRepairController-searchContactRepairHistory")
//    @ResponseBody
//    public SearchContactRepairHistoryResponseRESTModel searchContactRepairHistory(HttpServletRequest request) throws Exception {
//        SearchContactRepairHistoryResponseRESTModel response = new SearchContactRepairHistoryResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", buildingID=" + request.getParameter("buildingID") + ", searchDateTime=" + request.getParameter("searchDateTime") + ",statusID = " + request.getParameter("statusID") + ", index=" + request.getParameter("start") + ", rowPerPage=" + request.getParameter("length")
//            ));
//
//            response = contactRepairService.getContactRepair(request.getParameter("sid"), request.getParameter("language"), request.getParameter("buildingID"),
//                    request.getParameter("searchDateTime"), request.getParameter("statusID"), request.getParameter("start"), request.getParameter("length"));
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
//    @PostMapping("/ContactRepairController-UpdateContactRepair")
//    @ResponseBody
//    public TransactionUpdateContactRepairResponseRESTModel get(HttpServletRequest request) throws Exception {
//        TransactionUpdateContactRepairResponseRESTModel response = new TransactionUpdateContactRepairResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", transactionCode=" + request.getParameter("transactionCode") + ", transactionID=" + request.getParameter("transactionID") 
//            ));
//
//            response = contactRepairService.updateContactRepair(request.getParameter("sid"), request.getParameter("language"), request.getParameter("transactionCode"), request.getParameter("transactionID"));
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
//
//    @PostMapping("/getPictureURLContactRepair")
//    @ResponseBody
//    public PictureURLContactRepair getPictureURLContactRepair(HttpServletRequest request) throws Exception {
//        PictureURLContactRepair response = new PictureURLContactRepair();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common("transactionID=" + request.getParameter("transactionID")));
//
//            response = contactRepairService.getPictureURLContactRepair(request.getParameter("transactionID") , request.getParameter("NumberPicture"));
//            processSuccess = true;
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
//}
