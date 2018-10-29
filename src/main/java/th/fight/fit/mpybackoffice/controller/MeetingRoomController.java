package th.fight.fit.mpybackoffice.controller;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.controller;
//
//import com.google.gson.Gson;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.apache.log4j.Logger;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
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
//import th.mfec.mpybackoffice.model.rest.SearchBookingHistoryResponseRESTModel;
//import th.mfec.mpybackoffice.model.vo.BookingHistory;
//import th.mfec.mpybackoffice.service.GetHistMeetingRoomManagementService;
//import th.mfec.mpybackoffice.service.LoginService;
//import th.mfec.mpybackoffice.service.PckMenuService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.SystemParamUtil;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Anuwat_K
// */
//@Controller
//public class MeetingRoomController extends BaseController {
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
//    private GetHistMeetingRoomManagementService getHistMeetingRoomManagementService;
//
//    @RequestMapping(value = "/MeetingRoomController-initBookingHistory", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initBookingHistory(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        ModelAndView model = new ModelAndView("booking.history");
//        BookingHistory bookingHistory = new BookingHistory();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
//            model.addObject("bookingHistory", bookingHistory);
//            List<DropdownVO> buildingDropdown = MasterUtils.loadMasBuildingDropdownList(null);
//            model.addObject("buildingDropdown", buildingDropdown);
//            List<DropdownVO> meetingRoomDropdown = MasterUtils.loadMasMeetingRoomDropdownList(null, null);
//            model.addObject("meetingRoomDropdown", meetingRoomDropdown);
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
//    @PostMapping("/MeetingRoomController-searchBookingHistory")
//    @ResponseBody
//    public SearchBookingHistoryResponseRESTModel searchBookingHistory(HttpServletRequest request) throws Exception {
//        SearchBookingHistoryResponseRESTModel response = new SearchBookingHistoryResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + ", rowPerPage=" + request.getParameter("length")
//                    + ", searchDateTimeFrom=" + request.getParameter("searchDateTimeFrom") + ", searchDateTimeTo=" + request.getParameter("searchDateTimeTo")
//                    + request.getParameter("buildingID") + request.getParameter("meetingRoomID")));
//
//            response = getHistMeetingRoomManagementService.getHistMeetingRoom(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("searchDateTimeFrom"), request.getParameter("searchDateTimeTo"), 
//                    request.getParameter("buildingID"), request.getParameter("meetingRoomID"));
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
//    @PostMapping("/reloadRoomDropDown")
//    @ResponseBody
//    public List<DropdownVO> reloadRoomDropDown(HttpServletRequest request) throws Exception {
//        List<DropdownVO> response = new ArrayList<DropdownVO>();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s){" + "language=" + request.getParameter("language")
//                    + ", buildingID=" + request.getParameter("buildingID") + "}"));
//
//            response = MasterUtils.loadMasMeetingRoomDropdownList(request.getParameter("language"), request.getParameter("buildingID"));
//            
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
