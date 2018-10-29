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
//import org.springframework.web.servlet.support.RequestContextUtils;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.dao.MasBosGroupMenuDao;
//import th.mfec.mpybackoffice.dao.MasBosMenuDao;
//import th.mfec.mpybackoffice.dao.MasMobileMenuDao;
//import th.mfec.mpybackoffice.domain.MasBosGroupMenu;
//import th.mfec.mpybackoffice.domain.MasBosMenu;
//import th.mfec.mpybackoffice.domain.MasMobileMenu;
//import th.mfec.mpybackoffice.domain.vo.CheckBoxVO;
//
//import th.mfec.mpybackoffice.domain.vo.DropdownVO;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.Group.CreateGroup;
//import th.mfec.mpybackoffice.model.Getgroup;
//import th.mfec.mpybackoffice.model.Group.CreateGroupResponseRestModel;
//import th.mfec.mpybackoffice.model.Group.GetGroupDetails;
//import th.mfec.mpybackoffice.model.Group.GroupId;
//import th.mfec.mpybackoffice.model.Group.SearchGroupResponseModel;
//import th.mfec.mpybackoffice.model.Group.SearchNameModel;
//import th.mfec.mpybackoffice.service.GroupService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Worakan
// */
//@Controller
//public class GroupController extends BaseController {
//
//    @Autowired
//    private MasMobileMenuDao masMobileMenuDao;
//    @Autowired
//    private MasBosGroupMenuDao masBosGroupMenuDao;
//    @Autowired
//    private MasBosMenuDao masBosMenuDao;
//
//    @Autowired
//    private GroupService groupService;
//
//    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @RequestMapping(value = "/GroupController-initCrateGroup", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initCrateGroup(HttpServletRequest request) throws Exception {
//        Date startDate = new Date();
//
//        List<String> masMobileMenu = new ArrayList<String>();
//
//        ModelAndView model = new ModelAndView("group.createGroup");
//        CreateGroup createGroupModel = new CreateGroup();
//
//        try {
//            model.addObject("createGroupModel", createGroupModel);
//            List<CheckBoxVO> masMobileMenuList = new ArrayList<CheckBoxVO>();
//            masMobileMenuList = MasterUtils.loadMasMobileMenuCheckBoxList(null);
//            model.addObject("masMobileMenuList", masMobileMenuList);
//            systemLogger.info(LogFormatter.common("- masMobileMenuList detail =" + masMobileMenuList.toString()));
//            List<CheckBoxVO> masBosGroupMenuList = new ArrayList<CheckBoxVO>();
//            masBosGroupMenuList = MasterUtils.loadMasBOSGroupMenuCheckBoxList(null);
//            model.addObject("masBosGroupMenuList", masBosGroupMenuList);
//            systemLogger.info(LogFormatter.common("- masBosGroupMenuList detail =" + masBosGroupMenuList.toString()));
//            List<CheckBoxVO> masBOSMenus = new ArrayList<CheckBoxVO>();
//            masBOSMenus = MasterUtils.loadMasBOSMenuCheckboxList(null);
//            model.addObject("masBOSMenus", masBOSMenus);
//            systemLogger.info(LogFormatter.common("- masBOSMenus detail =" + masBOSMenus.toString()));
//            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//        return model;
//    }
//
//    @PostMapping("/GroupController-createGroup")
//    @ResponseBody
//    public CreateGroupResponseRestModel searchData(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        CreateGroupResponseRestModel response = new CreateGroupResponseRestModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", bosGroupId=" + request.getParameter("bosGroupId") + ", bosMenuId=" + request.getParameter("bosMenuId")
//                    + ", mobileMenuId=" + request.getParameter("mobileMenuId") + ", groupNameTh=" + request.getParameter("groupNameTh") + ", groupNameEn=" + request.getParameter("groupNameEn")));
//
//            response = groupService.getCreateGroup(request.getParameter("language"), request.getParameter("sid"), request.getParameter("bosGroupId"), request.getParameter("bosMenuId"), request.getParameter("mobileMenuId"), request.getParameter("groupNameTh"), request.getParameter("groupNameEn"));
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
//    @RequestMapping(value = "/GroupController-initDeleteGroup", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView addUser(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("group.deleteGroup");
//        SearchNameModel searchNameModel = new SearchNameModel();
//        try {
//            model.addObject("searchNameModel", searchNameModel);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @PostMapping("/GroupController-searchDeleteGroup")
//    @ResponseBody
//    public SearchGroupResponseModel searchDeleteGroup(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        SearchGroupResponseModel response = new SearchGroupResponseModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", bosGroupId=" + request.getParameter("bosGroupId") + ", bosMenuId=" + request.getParameter("bosMenuId")
//                    + ", mobileMenuId=" + request.getParameter("mobileMenuId") + ", groupNameTh=" + request.getParameter("groupNameTh") + ", groupNameEn=" + request.getParameter("groupNameEn")));
//
//            response = groupService.searchGroup(request.getParameter("sid"),
//                    request.getParameter("language"), request.getParameter("start"), request.getParameter("length"),
//                    request.getParameter("SearchName"));
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
//    @PostMapping("/deletegroup")
//    @ResponseBody
//    public SearchGroupResponseModel addUserAuthorize(HttpServletRequest request) throws Exception {
//        SearchGroupResponseModel response = new SearchGroupResponseModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        try {
//            response = groupService.deleteGroup(request.getParameter("groupID"));
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
//    @RequestMapping(value = "/GroupController-initUpdateGroup", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initUpdateGroup(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("group.updateGroup");
//        SearchNameModel searchUpdateGroup = new SearchNameModel();
//
//        try {
//            model.addObject("searchUpdateGroup", searchUpdateGroup);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @RequestMapping(value = "/GroupController-initEditUpdateGroup", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView initEditUpdateGroup(HttpServletRequest request) throws Exception {
//        ModelAndView model = new ModelAndView("group.editUpdateGroup");
//        SearchNameModel searchUpdateGroup = new SearchNameModel();
//
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", groupid =" + request.getParameter("groupIDs")));
//////
//            model.addObject("searchUpdateGroup", searchUpdateGroup);
//
//            GetGroupDetails groupDetails = groupService.getGroupDetail(request.getParameter("sid"), request.getParameter("language"), request.getParameter("groupIDs"));
//           
//            model.addObject("GroupNameEn",groupDetails.getGroupNameEn());
//             model.addObject("GroupNameTh",groupDetails.getGroupNameTh());
//           
//            systemLogger.info(LogFormatter.common("GroupNameTh :" + groupDetails.getGroupNameTh().toString() + "GroupNameEn :" + groupDetails.getGroupNameEn().toString() ));
//             
//             
//            Map<String, List<CheckBoxVO>> authority = groupDetails.getAuthority();
//            systemLogger.info(LogFormatter.common("authority :" + authority.toString()));
//            model.addObject("groupDetails", groupDetails);
//            
//            
//            
//            List<CheckBoxVO> masBosGroupMenuList = new ArrayList<CheckBoxVO>();
//            masBosGroupMenuList = MasterUtils.loadMasBOSGroupMenuCheckBoxList(null);
//            model.addObject("masBosGroupMenuList", masBosGroupMenuList);
//            systemLogger.info(LogFormatter.common("masBosGroupMenuList ::" + masBosGroupMenuList.toString()));
//
//            if (authority != null) {
//                model.addObject("authorityBOS", authority.get("bos"));
//                model.addObject("authorityMobile", authority.get("mobile"));
//                systemLogger.info(LogFormatter.common("authority is NOT NULL : BOS =  " + authority.get("bos").toString() + ": mobile =  " + authority.get("mobile")) );
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        }
//
//        return model;
//    }
//
//    @PostMapping("/updateGroup")
//    @ResponseBody
//    public CreateGroupResponseRestModel updateGroup(HttpServletRequest httpRequest, HttpServletRequest request) throws Exception {
//        CreateGroupResponseRestModel response = new CreateGroupResponseRestModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//
//            systemLogger.info(LogFormatter.common(request.getParameter("sid"), "- Request field(s)" + "language=" + request.getParameter("language")
//                    + ", bosGroupId=" + request.getParameter("bosGroupId") + ", bosMenuId=" + request.getParameter("bosMenuId")
//                    + ", mobileMenuId=" + request.getParameter("mobileMenuId") + ", groupNameTh=" + request.getParameter("groupNameTh") + ", groupNameEn=" + request.getParameter("groupNameEn")));
//
//            response = groupService.updateGroup(request.getParameter("language"), request.getParameter("sid"), request.getParameter("bosGroupId"), request.getParameter("bosMenuId"), request.getParameter("mobileMenuId"), request.getParameter("groupNameTh"), request.getParameter("groupNameEn"));
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
//}
