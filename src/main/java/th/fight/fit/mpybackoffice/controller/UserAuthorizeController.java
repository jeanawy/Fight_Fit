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
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.domain.vo.CheckBoxVO;
//import th.mfec.mpybackoffice.domain.vo.DropdownVO;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.SearchUserAuthorize;
//import th.mfec.mpybackoffice.model.rest.UserAuthorize.GetEmployeeDetailsResponse;
//import th.mfec.mpybackoffice.model.rest.UserAuthorize.SearchUserAuthorizeResponseRestModel;
//import th.mfec.mpybackoffice.service.EditCustomerUserAuthorizeService;
//import th.mfec.mpybackoffice.service.GetHistMeetingRoomManagementService;
//import th.mfec.mpybackoffice.service.GetUserAuthorizeService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Panaporn
// */
//@Controller
//public class UserAuthorizeController extends BaseController {
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private GetHistMeetingRoomManagementService getHistMeetingRoomManagementService;
//    @Autowired
//    private GetUserAuthorizeService getUserAuthorizeService;
//    @Autowired
//    private EditCustomerUserAuthorizeService editCustomerUserAuthorizeService;
//
//    @RequestMapping(value = "/UserAuthorizeController-init", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView addUser(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("userauth.init");
//        SearchUserAuthorize searchUserAuthorize = new SearchUserAuthorize();
//        try {
//            model.addObject("searchUserAuthorize", searchUserAuthorize);
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
//            List<DropdownVO> departmentsDropDownList = MasterUtils.loadMasDepartmentsDropDownList(null);
//            model.addObject("departmentsDropDownList", departmentsDropDownList);
//
//            List<DropdownVO> divisionDropDownList = MasterUtils.loadMasDivisionDropDownList(null, null);
//            model.addObject("divisionDropDownList", divisionDropDownList);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @RequestMapping(value = "/UserAuthorizeController-initDelete", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView deleteUser(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("userauth.initDelete");
//        SearchUserAuthorize searchUserAuthorize = new SearchUserAuthorize();
//        try {
//            model.addObject("searchUserAuthorize", searchUserAuthorize);
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
//            List<DropdownVO> departmentsDropDownList = MasterUtils.loadMasDepartmentsDropDownList(null);
//            model.addObject("departmentsDropDownList", departmentsDropDownList);
//
//            List<DropdownVO> divisionDropDownList = MasterUtils.loadMasDivisionDropDownList(null, null);
//            model.addObject("divisionDropDownList", divisionDropDownList);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @PostMapping("/UserAuthorizeController-searchUserAuthorize")
//    @ResponseBody
//    public SearchUserAuthorizeResponseRestModel searchUserAuthorize(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        SearchUserAuthorizeResponseRestModel response = new SearchUserAuthorizeResponseRestModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        Boolean flageOption = Boolean.valueOf(request.getParameter("flageoption"));
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", index=" + request.getParameter("start") + ", rowPerPage=" + request.getParameter("length")
//                    + ", searchDateTime=" + request.getParameter("groupID") + "flage" + " department :" + request.getParameter("flageoption") + request.getParameter("departmentID") + " division :" + request.getParameter("divisionID")));
//
//            response = getUserAuthorizeService.getUserAuthorize(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("groupID"), request.getParameter("departmentID"), request.getParameter("divisionID"), request.getParameter("searchName"), flageOption);
//
////            processSuccess = true;
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
//    @RequestMapping(value = "/UserAuthorizeController-initCustomerUserAuthorize", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initUpdate(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("userauth.initCustomerUserAuthorize");
//        SearchUserAuthorize searchUserAuthorize = new SearchUserAuthorize();
//        try {
//            model.addObject("searchUserAuthorize", searchUserAuthorize);
//
//            List<DropdownVO> departmentsDropDownList = MasterUtils.loadMasDepartmentsDropDownList(null);
//            model.addObject("departmentsDropDownList", departmentsDropDownList);
//
//            List<DropdownVO> divisionDropDownList = MasterUtils.loadMasDivisionDropDownList(null, null);
//            model.addObject("divisionDropDownList", divisionDropDownList);
//
//            List<DropdownVO> groupDropdown = MasterUtils.loadMasGroupUserDropdownList(null);
//            model.addObject("groupDropdown", groupDropdown);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @RequestMapping(value = "/UserAuthorizeController-initEditCustomerUserAuthorize", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initEditCustomeUserAuthorize(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("userauth.initEditCustomerUserAuthorize");
//        SearchUserAuthorize searchUserAuthorize = new SearchUserAuthorize();
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s){" + "uid=" + request.getParameter("uid")));
//            model.addObject("searchUserAuthorize", searchUserAuthorize);
//
//            GetEmployeeDetailsResponse employeeDetails = getUserAuthorizeService.getEmployeeDetails(request.getParameter("sid"), request.getParameter("language"), request.getParameter("uid"));
//            Map<String, List<CheckBoxVO>> authority = employeeDetails.getAuthority();
//
//            model.addObject("employeeDetails", employeeDetails);
//
//            List<CheckBoxVO> masBosGroupMenuList = new ArrayList<CheckBoxVO>();
//            masBosGroupMenuList = MasterUtils.loadMasBOSGroupMenuCheckBoxList(null);
//            model.addObject("masBosGroupMenuList", masBosGroupMenuList);
//
//            if (authority != null) {
//                model.addObject("authorityBOS", authority.get("bos"));
//                model.addObject("authorityMobile", authority.get("mobile"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @RequestMapping(value = "/UserAuthorizeController-editCustomerUserAuthorize", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public void editCustomerUserAuthorize(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", uid=" + request.getParameter("uid") + ", bosMenuArray=" + request.getParameter("bosMenuArray")
//                    + ", mobileMenuArray=" + request.getParameter("mobileMenuArray")));
//
//            editCustomerUserAuthorizeService.updateCustomerUserAuthorizeService(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("uid"), request.getParameter("bosMenuArray"),
//                    request.getParameter("mobileMenuArray"));
//
//            processSuccess = true;
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
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, null));
//        }
//    }
//
//    @PostMapping("/reloadDivisionDropDown")
//    @ResponseBody
//    public List<DropdownVO> reloadDivisionDropDown(HttpServletRequest request) throws Exception {
//        List<DropdownVO> response = new ArrayList<DropdownVO>();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s){" + "language=" + request.getParameter("language")
//                    + ", departmentID=" + request.getParameter("departmentID") + "}"));
//
//            response = MasterUtils.loadMasDivisionDropDownList(request.getParameter("language"), request.getParameter("departmentID"));
//            systemLogger.info(LogFormatter.common("test :" + response.toString()));
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
//
//    @PostMapping("/addUserAuthorize")
//    @ResponseBody
//    public SearchUserAuthorizeResponseRestModel addUserAuthorize(HttpServletRequest request) throws Exception {
//        SearchUserAuthorizeResponseRestModel response = new SearchUserAuthorizeResponseRestModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s){" + "language=" + request.getParameter("language")
//                    + ", departmentID=" + request.getParameter("uid") + "}"));
//
//            response = getUserAuthorizeService.transactionAddUserAuthorize(request.getParameter("uid"), request.getParameter("groupID"));
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
//
//    @PostMapping("/deleteUserAuthorize")
//    @ResponseBody
//    public SearchUserAuthorizeResponseRestModel deleteUserAuthorize(HttpServletRequest request) throws Exception {
//        SearchUserAuthorizeResponseRestModel response = new SearchUserAuthorizeResponseRestModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s){" + "language=" + request.getParameter("language")
//                    + ", departmentID=" + request.getParameter("uid") + "}"));
//
//            response = getUserAuthorizeService.transactionDeleteUserAuthorize(request.getParameter("uid"), request.getParameter("groupID"));
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
