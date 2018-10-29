package th.fight.fit.mpybackoffice.service.impl;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.service.impl;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.dao.MasDepartmentDao;
//import th.mfec.mpybackoffice.dao.MasDivisionDao;
//import th.mfec.mpybackoffice.dao.MasGroupUserDao;
//import th.mfec.mpybackoffice.dao.PckEmployeeDao;
//import th.mfec.mpybackoffice.domain.MasBosGroupMenu;
//import th.mfec.mpybackoffice.domain.MasBosMenu;
//import th.mfec.mpybackoffice.domain.MasDepartment;
//import th.mfec.mpybackoffice.domain.MasDivision;
//import th.mfec.mpybackoffice.domain.MasGroupUser;
//import th.mfec.mpybackoffice.domain.MasMobileMenu;
//import th.mfec.mpybackoffice.domain.PckEmployee;
//import th.mfec.mpybackoffice.domain.vo.CheckBoxVO;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.rest.UserAuthorize.GetEmployeeDetailsResponse;
//import th.mfec.mpybackoffice.model.rest.UserAuthorize.SearchUserAuthorizeResponseRestModel;
//import th.mfec.mpybackoffice.model.rest.UserAuthorize.UserAuthorize;
//import th.mfec.mpybackoffice.service.GetUserAuthorizeService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.StringUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Panaporn
// */
//@Service
//public class GetUserAuthorizeServiceImpl implements GetUserAuthorizeService {
//
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private PckEmployeeDao pckEmployeeDao;
//    @Autowired
//    private MasDepartmentDao masDepartmentDao;
//    @Autowired
//    private MasDivisionDao masDivisionDao;
//    @Autowired
//    private MasGroupUserDao masGroupUserDao;
//
//    public SearchUserAuthorizeResponseRestModel getUserAuthorize(String sid, String language, String requestIndex, String requestRowPerPage, String group, String department, String division, String SearchName, boolean flageOption) throws Exception {
//        SearchUserAuthorizeResponseRestModel model = new SearchUserAuthorizeResponseRestModel();
//        PckEmployee pckEmployee = new PckEmployee();
//        List<UserAuthorize> authorizes = new ArrayList<UserAuthorize>();
//        int index = 0;
//        int rowPerPage = 0;
//
//        index = Integer.parseInt(requestIndex);
//        rowPerPage = Integer.parseInt(requestRowPerPage);
//        pckEmployee.setIsDelete("N");
//        if (StringUtils.isNotEmptyOrNull(department)) {
//            pckEmployee.setDepartmentNo(department);
//        }
//        if (StringUtils.isNotEmptyOrNull(division)) {
//            pckEmployee.setDivisionNo(division);
//        }
//        if (StringUtils.isNotEmptyOrNull(SearchName)) {
//            pckEmployee.setFirstNameEn(SearchName);
//            pckEmployee.setFirstNameTh(SearchName);
//        }
//        if (StringUtils.isNotEmptyOrNull(group)) {
//            pckEmployee.setGroupUserID(Integer.valueOf(group));
//        }
//
//        List<PckEmployee> pckEmployeeListDB = pckEmployeeDao.getPckEmployeeforSearchName(pckEmployee, Integer.valueOf(requestIndex), Integer.valueOf(requestRowPerPage), flageOption);
//        for (PckEmployee pckEmployeeDB : pckEmployeeListDB) {
//            UserAuthorize userAuthorize = new UserAuthorize();
//            userAuthorize.setName(pckEmployeeDB.getFirstNameTh() + " " + pckEmployeeDB.getLastNameTh() + " " + "(" + pckEmployeeDB.getNickNameTh() + ")" + "<br>" + pckEmployeeDB.getFirstNameEn() + " " + pckEmployeeDB.getLastNameEn());
//            userAuthorize.setUid(pckEmployeeDB.getUid());
//            userAuthorize.setEmployeeID(pckEmployeeDB.getEmployeeId());
//
//            MasDepartment masDepartment = new MasDepartment();
//            masDepartment.setDepartmentNo(pckEmployeeDB.getDepartmentNo());
//            List<MasDepartment> masDepartmentListDB = masDepartmentDao.getMasDepartment(masDepartment);
//            MasDepartment masDepartmentDB = masDepartmentListDB != null && masDepartmentListDB.size() > 0 ? masDepartmentListDB.get(0) : null;
//
//            MasDivision masDivision = new MasDivision();
//            masDivision.setDivisionNo(pckEmployeeDB.getDivisionNo());
//            List<MasDivision> masDivisionListDB = masDivisionDao.getMasDivision(masDivision);
//            MasDivision masDivisionDB = masDivisionListDB != null && masDivisionListDB.size() > 0 ? masDivisionListDB.get(0) : null;
//
//            userAuthorize.setDivision(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masDivisionDB.getDivisionEn() : masDivisionDB.getDivisionTh());
//            userAuthorize.setDepartment(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masDepartmentDB.getDepartmentEn() : masDepartmentDB.getDepartmentTh());
//
//            userAuthorize.setImage(pckEmployeeDB.getPictureUrl());
//            if (pckEmployeeDB.getGroupUserID() != null) {
//                MasGroupUser masGroupUser = new MasGroupUser();
//                masGroupUser.setIsDelete(ProjectConstant.STATUS_N);
//                masGroupUser.setGroupUserId(pckEmployeeDB.getGroupUserID());
//                List<MasGroupUser> masGroupUserListDB = masGroupUserDao.getMasGroupUser(masGroupUser);
//                MasGroupUser masGroupUserDB = masGroupUserListDB != null && masGroupUserListDB.size() > 0 ? masGroupUserListDB.get(0) : null;
//                userAuthorize.setGroup(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masGroupUserDB.getGroupUserEn() : masGroupUserDB.getGroupUserTh());
//            } else {
//                userAuthorize.setGroup("Not Group");
//            }
//
//            authorizes.add(userAuthorize);
//        }
//
//        int count = pckEmployeeDao.getcountPckEmployeeforSearchName(pckEmployee, flageOption);
//        if ((index + rowPerPage) < count) {
//            model.setRemaindRecordFlag(true);
//        } else {
//            model.setRemaindRecordFlag(false);
//        }
//        model.setRecordsFiltered(String.valueOf(count));
//        model.setRecordsTotal(String.valueOf(count));
//        model.setUserAuthorize(authorizes);
//        return model;
//    }
//
//    public GetEmployeeDetailsResponse getEmployeeDetails(String sid, String language, String uid) throws Exception {
//        GetEmployeeDetailsResponse response = new GetEmployeeDetailsResponse();
//        Map<String, List<CheckBoxVO>> authiorityMap = new HashMap<String, List<CheckBoxVO>>();
//
//        try {
//            if (StringUtils.isNotEmptyOrNull(uid)) {
//
//                PckEmployee pckEmployee = new PckEmployee();
//                pckEmployee.setUid(uid);
//                pckEmployee.setIsDelete(ProjectConstant.STATUS_N);
//                List<PckEmployee> employeeListDB = pckEmployeeDao.getPckEmployeeforSearchName(pckEmployee, null, null, false);
//                PckEmployee employeeDB = employeeListDB != null && employeeListDB.size() > 0 ? employeeListDB.get(0) : null;
//
//                if (employeeDB != null) {
//
//                    response.setImage(employeeDB.getPictureUrl());
//                    response.setName(employeeDB.getFirstNameTh() + " " + employeeDB.getLastNameTh() + " " + "(" + employeeDB.getNickNameTh() + ")" + "<br>" + employeeDB.getFirstNameEn() + " " + employeeDB.getLastNameEn());
//                    response.setEmployeeID(employeeDB.getEmployeeId());
//                    response.setPosition(employeeDB.getPositionNo()); //should be position name
//                    response.setLevel(employeeDB.getLevel());
//                    response.setUid(employeeDB.getUid());
//
//                    List<MasDepartment> departmentListDB = MasterUtils.loadMasDepartment(employeeDB.getDepartmentNo());
//                    MasDepartment departmentDB = departmentListDB != null && departmentListDB.size() > 0 ? departmentListDB.get(0) : null;
//                    if (departmentDB != null) {
//                        response.setDepartment(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? departmentDB.getDepartmentEn() : departmentDB.getDepartmentTh());
//                        systemLogger.info(LogFormatter.common(sid, "- Get department from database complete, Department=" + response.getDepartment()));
//                    }
//
//                    List<MasDivision> divisionListDB = MasterUtils.loadMasDivision(employeeDB.getDivisionNo());
//                    MasDivision divisionDB = divisionListDB != null && divisionListDB.size() > 0 ? divisionListDB.get(0) : null;
//                    if (divisionDB != null) {
//                        response.setDivision(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? divisionDB.getDivisionEn() : divisionDB.getDivisionTh());
//                        systemLogger.info(LogFormatter.common(sid, "- Get division from database complete, Division=" + response.getDivision()));
//                    }
//                    systemLogger.info(LogFormatter.common(sid, " 1) Prepare employeeDetails complete, Details=" + employeeDB.toString()));
//
//                    MasGroupUser groupUserDB = null;
//                    String[] bosMenuArrayDB = null;
//                    String[] mobileMenuArrayDB = null;
//                    if (employeeDB.getGroupUserID() != null) {
//                        List<MasGroupUser> groupUserListDB = MasterUtils.loadMasGroupUser(employeeDB.getGroupUserID().toString());
//                        groupUserDB = groupUserListDB != null && groupUserListDB.size() > 0 ? groupUserListDB.get(0) : null;
//                    }
//                    if (groupUserDB != null) {
//                        response.setGroup(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? groupUserDB.getGroupUserEn() : groupUserDB.getGroupUserTh());
//
//                        String bosMenuDB = groupUserDB.getBosMenuId();
//                        String mobileMenuDB = groupUserDB.getMobileMenuId();
//
//                        if (StringUtils.isNotEmptyOrNull(bosMenuDB)) {
//                            bosMenuArrayDB = bosMenuDB.contains(",") ? bosMenuDB.split(",") : new String[]{bosMenuDB};
//                        }
//
//                        if (StringUtils.isNotEmptyOrNull(mobileMenuDB)) {
//                            mobileMenuArrayDB = mobileMenuDB.contains(",") ? mobileMenuDB.split(",") : new String[]{mobileMenuDB};
//                        }
//
//                        systemLogger.info(LogFormatter.common(sid, " 2) Get employee group and prepare authority complete."));
//
//                    } else {
//                        systemLogger.info(LogFormatter.common(sid, "- Not found Group, EmployeeID=" + employeeDB.getEmployeeId()));
//                    }
//
//                    List<CheckBoxVO> bosMenuAuthorizeList = new ArrayList<CheckBoxVO>();
//                    CheckBoxVO bosMenuAuthorize = null;
//                    List<MasBosGroupMenu> loadMasBosGroupMenuListDB = MasterUtils.loadMasBosGroupMenu(null);
//                    List<MasBosMenu> loadMasBosMenuListDB = MasterUtils.loadMasBosMenu(null);
//                    if (loadMasBosGroupMenuListDB != null && loadMasBosGroupMenuListDB.size() > 0 && loadMasBosMenuListDB != null && loadMasBosMenuListDB.size() > 0) {
////                        //wrong version
////                        for (MasBosGroupMenu masBosGroupMenuDB : loadMasBosGroupMenuListDB) {
////                            bosMenuAuthorize = new CheckBoxVO();
////                            bosMenuAuthorize.setCheckBoxKey(String.valueOf(masBosGroupMenuDB.getBosGroupId()));
////                            for (MasBosMenu masBosMenuDB : loadMasBosMenuListDB) {
////                                bosMenuAuthorize.setCheckBoxKey2(String.valueOf(masBosMenuDB.getBosMenuId()));
////                                bosMenuAuthorize.setCheckBoxValue(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masBosMenuDB.getBosMenuEn() : masBosMenuDB.getBosMenuTh());
////                                boolean foundBosMenuID = false;
////                                for (String bosMenuID : bosMenuArrayDB) {
////                                    if (StringUtils.isNotEmptyOrNull(bosMenuID) && bosMenuID.equalsIgnoreCase(String.valueOf(masBosMenuDB.getBosMenuId()))) {
////                                        foundBosMenuID = true;
////                                        break;
////                                    }
////                                }
////                                bosMenuAuthorize.setCheckBoxKey3(foundBosMenuID ? ProjectConstant.STATUS_Y : ProjectConstant.STATUS_N);
////
////                                bosMenuAuthorizeList.add(bosMenuAuthorize);
////                            }
////                        }
//
//                        //right version
//                        for (MasBosMenu masBosMenuDB : loadMasBosMenuListDB) {
//                            boolean foundBosMenuID = false;
//                            if (bosMenuArrayDB != null && bosMenuArrayDB.length > 0) {
//                                for (String bosMenuID : bosMenuArrayDB) {
//                                    if (StringUtils.isNotEmptyOrNull(bosMenuID) && bosMenuID.equalsIgnoreCase(String.valueOf(masBosMenuDB.getBosMenuId()))) {
//                                        foundBosMenuID = true;
//                                        break;
//                                    }
//                                }
//                            }
//
//                            bosMenuAuthorize = new CheckBoxVO();
//                            bosMenuAuthorize.setCheckBoxKey2(String.valueOf(masBosMenuDB.getBosMenuId()));
//                            bosMenuAuthorize.setCheckBoxValue2(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masBosMenuDB.getBosMenuEn() : masBosMenuDB.getBosMenuTh());
//                            for (MasBosGroupMenu masBosGroupMenuDB : loadMasBosGroupMenuListDB) {
//                                if (masBosMenuDB.getBosGroupId().equals(masBosGroupMenuDB.getBosGroupId())) {
//                                    bosMenuAuthorize.setCheckBoxKey(String.valueOf(masBosGroupMenuDB.getBosGroupId()));
//                                    bosMenuAuthorize.setCheckBoxValue(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? masBosGroupMenuDB.getBosGroupEn() : masBosGroupMenuDB.getBosGroupTh());
//                                    break;
//                                }
//                            }
//                            bosMenuAuthorize.setCheckBoxKey3(foundBosMenuID ? ProjectConstant.STATUS_Y : ProjectConstant.STATUS_N);
//                            bosMenuAuthorizeList.add(bosMenuAuthorize);
//                        }
//
//                    }
//                    authiorityMap.put("bos", bosMenuAuthorizeList);
//                    systemLogger.info(LogFormatter.common(sid, "- Add bos authority complete. EmployeeID=" + employeeDB.getEmployeeId() + ", bosMenuAuthorize=" + authiorityMap.get("bos")));
//
//                    List<CheckBoxVO> mobileMenuAuthorizeList = new ArrayList<CheckBoxVO>();
//                    List<MasMobileMenu> masMobileMenuListDB = MasterUtils.loadMasMobileMenu(null);
//                    for (MasMobileMenu mobileMenu : masMobileMenuListDB) {
//                        CheckBoxVO mobileMenuAuthorize = new CheckBoxVO();
//                        mobileMenuAuthorize.setCheckBoxKey(String.valueOf(mobileMenu.getMobileMenuID()));
//                        mobileMenuAuthorize.setCheckBoxValue(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? mobileMenu.getMobileMenuEn() : mobileMenu.getMobileMenuTh());
//                        boolean foundMobileMenuID = false;
//                        if (mobileMenuArrayDB != null && mobileMenuArrayDB.length > 0) {
//                            for (String mobileMenuID : mobileMenuArrayDB) {
//                                if (StringUtils.isNotEmptyOrNull(mobileMenuID) && mobileMenuID.equalsIgnoreCase(String.valueOf(mobileMenu.getMobileMenuID()))) {
//                                    foundMobileMenuID = true;
//                                    break;
//                                }
//                            }
//                        }
//
//                        mobileMenuAuthorize.setCheckBoxKey2(foundMobileMenuID ? ProjectConstant.STATUS_Y : ProjectConstant.STATUS_N);
//
//                        mobileMenuAuthorizeList.add(mobileMenuAuthorize);
//                    }
//                    authiorityMap.put("mobile", mobileMenuAuthorizeList);
//                    response.setAuthority(authiorityMap);
//                    systemLogger.info(LogFormatter.common(sid, "- Add mobile authority complete. EmployeeID=" + employeeDB.getEmployeeId() + ", mobileMenuAuthorize=" + mobileMenuAuthorizeList.toString()));
//
//                } else {
//                    systemLogger.info(LogFormatter.common(sid, "- Not found employee, EmployeeID=" + employeeDB.getEmployeeId()));
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//        return response;
//    }
//
//    public SearchUserAuthorizeResponseRestModel transactionAddUserAuthorize(String uid, String groupId) throws Exception {
//        SearchUserAuthorizeResponseRestModel authorizeResponseRestModel = new SearchUserAuthorizeResponseRestModel();
//        String[] data = uid.split(",");
//        if (groupId != null) {
//            if (data.length > 0) {
//                for (String uidData : data) {
//                    systemLogger.info(LogFormatter.info("uid" + uidData));
//                    PckEmployee pckemployee = new PckEmployee();
//                    pckemployee.setEmployeeId(uidData);
//                    pckemployee.setIsDelete(ProjectConstant.STATUS_N);
//                    List<PckEmployee> pckEmployeesListDb = pckEmployeeDao.getPckEmployee(pckemployee, null, null);
//                    PckEmployee pckEmployeeDB = pckEmployeesListDb != null && pckEmployeesListDb.size() > 0 ? pckEmployeesListDb.get(0) : null;
//                    pckEmployeeDB.setGroupUserID(Integer.valueOf(groupId));
//                    pckEmployeeDao.updatePckEmployee(pckEmployeeDB);
//
//                }
//            }
//        }
//
//        return authorizeResponseRestModel;
//    }
//
//    public SearchUserAuthorizeResponseRestModel transactionDeleteUserAuthorize(String uid, String groupId) throws Exception {
//        SearchUserAuthorizeResponseRestModel authorizeResponseRestModel = new SearchUserAuthorizeResponseRestModel();
//        String[] data = uid.split(",");
//        if (groupId != null) {
//            if (data.length > 0) {
//                for (String uidData : data) {
//                    systemLogger.info(LogFormatter.info("uid" + uidData));
//                    PckEmployee pckemployee = new PckEmployee();
//                    pckemployee.setEmployeeId(uidData);
//                    pckemployee.setIsDelete(ProjectConstant.STATUS_N);
//                    List<PckEmployee> pckEmployeesListDb = pckEmployeeDao.getPckEmployee(pckemployee, null, null);
//                    PckEmployee pckEmployeeDB = pckEmployeesListDb != null && pckEmployeesListDb.size() > 0 ? pckEmployeesListDb.get(0) : null;
//                    pckEmployeeDB.setGroupUserID(null);
//                    pckEmployeeDao.updatePckEmployee(pckEmployeeDB);
//
//                }
//            }
//        }
//
//        return authorizeResponseRestModel;
//    }
//
//}
