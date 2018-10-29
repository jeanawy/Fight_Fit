/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.vo.DropdownVO;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.model.CreateEvent.CreateEvent;
import th.fight.fit.mpybackoffice.model.GetEvent.EventLists;
import th.fight.fit.mpybackoffice.model.GetEvent.SearchEventListResponeRESTModel;
import th.fight.fit.mpybackoffice.service.EventService;
import th.fight.fit.mpybackoffice.util.MasterUtils;
import th.fight.fit.mpybackoffice.util.Utility;
import th.fight.fit.mpybackoffice.service.GetSearchEventListService;

/**
 *
 * @author Sent
 */
@Controller
public class EventController {
    
    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
    
   
    
    @Autowired
    private GetSearchEventListService getEventListService;
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/EventController-initCreateEvent", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initCreateEvent(HttpServletRequest request) throws Exception {
        Date startDate = new Date();
        ModelAndView model = new ModelAndView("event.createEvent");
        CreateEvent createEvent = new CreateEvent();

        try {
            model.addObject("searchUserAuthorize", createEvent);

            List<DropdownVO> eventDropdown = MasterUtils.loadMasEventDropdownList(null,null);
            model.addObject("eventDropdown", eventDropdown);
            List<DropdownVO> eventLocationDropDownList = MasterUtils.loadMasEventLocationDropdownList(null);
            model.addObject("eventLocationDropDownList", eventLocationDropDownList);
            List<DropdownVO> sportDropDownList = MasterUtils.loadMasSportDropdownList(null);
            model.addObject("sportDropDownList", sportDropDownList);

//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//
            model.addObject("createReward", createEvent);

            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());

            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, ProjectConstant.STATUS_SUCCESS, null, null));

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
        }
        return model;
    }

    
    
    
    
      @RequestMapping(value = "/EventController-initMyEventHistory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initMyEventHistory(HttpServletRequest request) throws Exception {
        Date startDate = new Date();
        ModelAndView model = new ModelAndView("event.eventHistory");
        EventLists eventList = new EventLists();

        try {

//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));

            model.addObject("eventList", eventList);
            List<DropdownVO> searchByEventNameDropdown = MasterUtils.loadMasEventDropdownList(null, null);
            model.addObject("searchByEventNameDropdown", searchByEventNameDropdown);

            
            List<DropdownVO> eventDropdown = MasterUtils.loadMasEventDropdownList(null,null);
            model.addObject("eventDropdown", eventDropdown);
            List<DropdownVO> eventLocationDropDownList = MasterUtils.loadMasEventLocationDropdownList(null);
            model.addObject("eventLocationDropDownList", eventLocationDropDownList);
            List<DropdownVO> sportDropDownList = MasterUtils.loadMasSportDropdownList(null);
            model.addObject("sportDropDownList", sportDropDownList);
            
            systemLogger.info(LogFormatter.common("- eventDropdown LoadMaster." + eventDropdown.toString()));
            systemLogger.info(LogFormatter.common("- eventLocationDropDownList LoadMaster." + eventLocationDropDownList.toString()));
            systemLogger.info(LogFormatter.common("- sportDropDownList LoadMaster." + sportDropDownList.toString()));

            
            
            
            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());

            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, null, null, null));

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
        }
        return model;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/EventController-initEventList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initEventList(HttpServletRequest request) throws Exception {
        Date startDate = new Date();
        ModelAndView model = new ModelAndView("event.eventList");
        EventLists eventList = new EventLists();

        try {

//            systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//            systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));

            model.addObject("eventList", eventList);
            List<DropdownVO> searchByEventNameDropdown = MasterUtils.loadMasEventDropdownList(null, null);
            model.addObject("searchByEventNameDropdown", searchByEventNameDropdown);

            
            List<DropdownVO> eventDropdown = MasterUtils.loadMasEventDropdownList(null,null);
            model.addObject("eventDropdown", eventDropdown);
            List<DropdownVO> eventLocationDropDownList = MasterUtils.loadMasEventLocationDropdownList(null);
            model.addObject("eventLocationDropDownList", eventLocationDropDownList);
            List<DropdownVO> sportDropDownList = MasterUtils.loadMasSportDropdownList(null);
            model.addObject("sportDropDownList", sportDropDownList);
            
            systemLogger.info(LogFormatter.common("- eventDropdown LoadMaster." + eventDropdown.toString()));
            systemLogger.info(LogFormatter.common("- eventLocationDropDownList LoadMaster." + eventLocationDropDownList.toString()));
            systemLogger.info(LogFormatter.common("- sportDropDownList LoadMaster." + sportDropDownList.toString()));

            
            
            
            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());

            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, null, null, null));

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
        }
        return model;
    }

    @PostMapping("/eventController-searchEventList")
    @ResponseBody
    public SearchEventListResponeRESTModel searchEventList(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
        SearchEventListResponeRESTModel response = new SearchEventListResponeRESTModel();
        Date startDate = new Date();
        boolean processSuccess = false;
        String errorCode = null;
        String errorMessage = null;

        try {
            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
                    + ", eventName=" + request.getParameter("searchDateTimeFrom") + ", searchDateTimeTo=" ));

            response = getEventListService.getEventList(request.getParameter("sid"),
                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
                    request.getParameter("eventName"),request.getParameter("eventID"),request.getParameter("eventLocationID"), request.getParameter("searchDateTimeFrom"), request.getParameter("searchDateTimeTo") );

            processSuccess = true;

//        } catch (InternalConnectionException e) {
//            errorCode = ProjectConstant.GET_HIS_MEETING_ROOM__ERROR_CODE_INTERNAL_CONNECTION_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_HIS_MEETING_ROOM_ERROR_CODE_SERVICE_VALIDATION_INDEX_PATTERN;
//            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
        } finally {

//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, rqLanguage);
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));

        }
        return response;
    }

//    @PostMapping("/deleteEvent")
//    @ResponseBody
//    public SearchEventListResponeRESTModel deleteEvent(HttpServletRequest request) throws Exception {
//        SearchEventListResponeRESTModel response = new SearchEventListResponeRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + "rowPerPage=" + request.getParameter("length")
//                    + ", searchRewardName=" + request.getParameter("reward") + ", searchByStatus=" + request.getParameter("searchByStatus")));
//
//            response = getEventListService.transactionDeleteEvent(request.getParameter("sid"), request.getParameter("language"),
//                    request.getParameter("EventId"));
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
    
    
    
    
}
