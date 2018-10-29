package th.fight.fit.mpybackoffice.service.impl;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.service.impl;
//
//import com.mysql.jdbc.log.Log;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.dao.MasGroupUserDao;
//import th.mfec.mpybackoffice.dao.PckEmployeeDao;
//import th.mfec.mpybackoffice.dao.PckUserSessionDao;
//import th.mfec.mpybackoffice.dao.PckUserStarDao;
//import th.mfec.mpybackoffice.domain.MasDepartment;
//import th.mfec.mpybackoffice.domain.MasDivision;
//import th.mfec.mpybackoffice.domain.MasGroupUser;
//import th.mfec.mpybackoffice.domain.PckEmployee;
//import th.mfec.mpybackoffice.domain.PckUserStar;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.model.StarRewardManagement.Employee;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchByUserGiveStarResponseRESTModel;
//import th.mfec.mpybackoffice.model.StarRewardManagement.SearchGroupUserStarGiveResponseRESTModel;
//import th.mfec.mpybackoffice.service.StarService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.StringUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author ธนากร
// */
//@Service
//public class StarServiceImpl implements StarService {
//
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private PckEmployeeDao pckEmployeeDao;
//    @Autowired
//    private PckUserSessionDao pckUserSessionDao;
//    @Autowired
//    private PckUserStarDao pckUserStarDao;
//    @Autowired
//    private MasGroupUserDao masGroupUserDao;
//
//    public SearchGroupUserStarGiveResponseRESTModel getGroupUserStarGive(String sid, String language, String groupUserID) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel result = new SearchGroupUserStarGiveResponseRESTModel();
//        try {
//            MasGroupUser masGroupUser = new MasGroupUser();
//            masGroupUser.setGroupUserId(Integer.valueOf(groupUserID));
//            List<MasGroupUser> masGroupUsersListDB = masGroupUserDao.getMasGroupUser(masGroupUser);
//            MasGroupUser masGroupUserDB = masGroupUsersListDB != null && masGroupUsersListDB.size() > 0 ? masGroupUsersListDB.get(0) : null;
//            if (masGroupUserDB != null) {
//                result.setGiveGoldStar(masGroupUserDB.getGiveGoldStar().toString());
//                result.setGiveSilverStar(masGroupUserDB.getGiveSiverStar().toString());
//                result.setGiveBronzeStar(masGroupUserDB.getGiveBronzeStar().toString());
//            }
//            systemLogger.info(LogFormatter.info("masGroupUserList    " + masGroupUserDB.toString()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//        return result;
//    }
//
//    public SearchByUserGiveStarResponseRESTModel getByUserGiveStar(String sid, String language, String requestIndex, String requestRowPerPage, String groupUserID, String department, String division, String searchName) throws Exception {
//        SearchByUserGiveStarResponseRESTModel result = new SearchByUserGiveStarResponseRESTModel();
//        List<Employee> employeeList = new ArrayList<Employee>();
//
//        boolean remaindRecordFlag = false;
//        int index = 0;
//        int rowPerPage = 0;
//
//        try {
//
//            if (NumberUtils.isDigits(requestIndex) && NumberUtils.isDigits(requestRowPerPage)) {
//                index = Integer.parseInt(requestIndex);
//                rowPerPage = Integer.parseInt(requestRowPerPage);
//
//                PckUserStar pckUserStar = new PckUserStar();
//                PckEmployee pckEmployee = new PckEmployee();
//                pckEmployee.setIsDelete(ProjectConstant.STATUS_N);
//
//                if (NumberUtils.isDigits(groupUserID)) {
//                    pckEmployee.setGroupUserID(Integer.valueOf(groupUserID));
//                }
//                if (StringUtils.isNotEmptyOrNull(department)) {
//                    pckEmployee.setDepartmentNo(department);
//                }
//                if (StringUtils.isNotEmptyOrNull(division)) {
//                    pckEmployee.setDivisionNo(division);
//                }
//                if (StringUtils.isNotEmptyOrNull(searchName)) {
//                    pckEmployee.setFirstNameEn(searchName);
//                    pckEmployee.setFirstNameTh(searchName);
//                }
//
//                List<PckEmployee> pckEmployeeListDB = pckEmployeeDao.getPckEmployeeforSearchName(pckEmployee, index, rowPerPage, false);
//                for (PckEmployee pckEmployeeDB : pckEmployeeListDB) {
//                    Employee employee = new Employee();
//
//                    pckUserStar.setIsDelete(ProjectConstant.STATUS_N);
//                    pckUserStar.setUid(pckEmployeeDB.getUid());
//                    List<PckUserStar> pckUsrtStarListDB = pckUserStarDao.getPckUserStar(pckUserStar);
//
//                    for (PckUserStar pckUserStarDB : pckUsrtStarListDB) {
//                        if (pckUserStarDB != null) {
//                            if (ProjectConstant.STAR_TYPE_GOLD.equals(pckUserStarDB.getStarType())) {
//                                employee.setGoldStarGenGiveAmount(pckUserStarDB.getGenGiveAmount().toString());
//
//                            } else if (ProjectConstant.STAR_TYPE_SILVER.equals(pckUserStarDB.getStarType())) {
//                                employee.setSilverStarGenGiveAmount(pckUserStarDB.getGenGiveAmount().toString());
//
//                            } else if (ProjectConstant.STAR_TYPE_BRONZE.equals(pckUserStarDB.getStarType())) {
//                                employee.setBronzeStarGenGiveAmount(pckUserStarDB.getGenGiveAmount().toString());
//                            }
//                        }
//                    }
//
//                    employee.setNo(pckEmployeeDB.getUid());
//                    employee.setName(pckEmployeeDB.getFirstNameTh() + " " + pckEmployeeDB.getLastNameTh() + " (" + pckEmployeeDB.getNickNameTh() + ") " + pckEmployeeDB.getFirstNameEn() + " " + pckEmployeeDB.getLastNameEn());
//
//                    List<MasDepartment> empDepartmentList = MasterUtils.loadMasDepartment(pckEmployeeDB.getDepartmentNo());
//                    MasDepartment empDepartment = empDepartmentList != null && empDepartmentList.size() > 0 ? empDepartmentList.get(0) : null;
//                    List<MasDivision> empDivisionList = MasterUtils.loadMasDivision(pckEmployeeDB.getDivisionNo());
//                    MasDivision empDivision = empDivisionList != null && empDivisionList.size() > 0 ? empDivisionList.get(0) : null;
//
//                    if (empDepartment != null) {
//                        employee.setDepartmentName(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? empDepartment.getDepartmentEn() : empDepartment.getDepartmentTh());
//                    }
//                    if (empDivision != null) {
//                        employee.setDivisionName(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language) ? empDivision.getDivisionEn() : empDivision.getDivisionTh());
//                    }
//                    employee.setPositionName(pckEmployeeDB.getPositionNo());
//                    employee.setPictureURL(pckEmployeeDB.getPictureUrl());
//                    employeeList.add(employee);
//                }
//                int count = pckEmployeeDao.getcountPckEmployeeforSearchName(pckEmployee, false);
//                if ((index + rowPerPage) < count) {
//                    result.setRemaindRecordFlag(true);
//                } else {
//                    result.setRemaindRecordFlag(false);
//                }
//                result.setRecordsFiltered(String.valueOf(count));
//                result.setRecordsTotal(String.valueOf(count));
//                result.setRemaindRecordFlag(remaindRecordFlag);
//                result.setEmployee(employeeList);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//        return result;
//    }
//
//    public SearchGroupUserStarGiveResponseRESTModel updateGroupUserStarGive(String sid, String language, String groupUserID, String giveGoldStar, String giveSilverStar, String giveBronzeStar) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel result = new SearchGroupUserStarGiveResponseRESTModel();
//        Date currentDate = new Date();
//
//        try {
//
////            boolean groupUserFlag = false;
////            boolean giveGoldStarFlag = false;
////            boolean giveSilverStarFlag = false;
////            boolean giveBronzeStarFlag = false;
//            if (NumberUtils.isDigits(groupUserID)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Group User ID Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveGoldStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Gold Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveSilverStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Silver Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveBronzeStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Bronze Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//
//            PckEmployee employee = new PckEmployee();
//
//            List<MasGroupUser> masGroupUsersListDB = MasterUtils.loadMasGroupUser(groupUserID);
//            MasGroupUser masGroupUserDB = masGroupUsersListDB != null && masGroupUsersListDB.size() > 0 ? masGroupUsersListDB.get(0) : null;
//            if (masGroupUserDB != null) {
//                //business
//                //รับค่าจาก html เพื่ออัพเดต
//                masGroupUserDB.setGiveGoldStar(Integer.valueOf(giveGoldStar));
//                masGroupUserDB.setGiveSiverStar(Integer.valueOf(giveSilverStar));
//                masGroupUserDB.setGiveBronzeStar(Integer.valueOf(giveBronzeStar));
//                masGroupUserDB.setUpdateBy("TEST");
//                masGroupUserDB.setUpdateDate(currentDate);
//
//                systemLogger.info(LogFormatter.info("Update GiveStar to MasGroupUser = Gold star=" + masGroupUserDB.getGiveGoldStar() + ", Silver Star=" + masGroupUserDB.getGiveSiverStar() + ", Bronze Star=" + masGroupUserDB.getGiveBronzeStar()));
////                MasGroupUser masGroupUser2 = new MasGroupUser();
////                masGroupUser2.setGroupUserId(Integer.valueOf(groupUserID));
//
//                masGroupUserDao.updateMasGroupUser(masGroupUserDB);
//
////                List<MasGroupUser> groupUsers = masGroupUserDao.getMasGroupUser(masGroupUser2);
//                systemLogger.info(LogFormatter.info("Update MasGroupUser Success !!!  Gold star=" + masGroupUserDB.toString()));
//
//                //set pckEmployee in Group to search in PckUserStar 
//                employee.setIsDelete(ProjectConstant.STATUS_N);
//                employee.setGroupUserID(Integer.valueOf(groupUserID));
//                List<PckEmployee> pckEmployeeListDB = pckEmployeeDao.getPckEmployee(employee, null, null);
//
//                for (PckEmployee pckEmployeeDB : pckEmployeeListDB) {
//                    PckUserStar pckUserStar = new PckUserStar();
//                    pckUserStar.setIsDelete(ProjectConstant.STATUS_N);
//                    pckUserStar.setUid(pckEmployeeDB.getUid());
//                    List<PckUserStar> pckUsrtStarListDB = pckUserStarDao.getPckUserStar(pckUserStar);
//
//                    systemLogger.info(LogFormatter.info("Update GiveStar to PckUserStar = Gold star=" + masGroupUserDB.getGiveGoldStar() + ", Silver Star=" + masGroupUserDB.getGiveSiverStar() + ", Bronze Star=" + masGroupUserDB.getGiveBronzeStar()));
//
//                    for (PckUserStar pckUserStarDB : pckUsrtStarListDB) {
//                        if (pckUserStarDB != null) {
//                            if (ProjectConstant.STAR_TYPE_GOLD.equals(pckUserStarDB.getStarType())) {
//                                pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveGoldStar));
//                                pckUserStarDB.setUpdateBy("TEST");
//                                pckUserStarDB.setUpdateDate(currentDate);
//                                pckUserStarDao.updatePckUserStar(pckUserStarDB);
//
//                                result.setGiveGoldStar(giveGoldStar);
//
//                                systemLogger.info(LogFormatter.info("Update Gen Give Gold Star Successs = " + pckUserStarDB.toString()));
//
//                            } else if (ProjectConstant.STAR_TYPE_SILVER.equals(pckUserStarDB.getStarType())) {
//                                pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveSilverStar));
//                                pckUserStarDB.setUpdateBy("TEST");
//                                pckUserStarDB.setUpdateDate(currentDate);
//                                pckUserStarDao.updatePckUserStar(pckUserStarDB);
//
//                                result.setGiveSilverStar(giveSilverStar);
//
//                                systemLogger.info(LogFormatter.info("Update Gen Give Silver Star Successs = " + pckUserStarDB.toString()));
//
//                            } else if (ProjectConstant.STAR_TYPE_BRONZE.equals(pckUserStarDB.getStarType())) {
//                                pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveBronzeStar));
//                                pckUserStarDB.setUpdateBy("TEST");
//                                pckUserStarDB.setUpdateDate(currentDate);
//                                pckUserStarDao.updatePckUserStar(pckUserStarDB);
//
//                                result.setGiveBronzeStar(giveBronzeStar);
//
//                                systemLogger.info(LogFormatter.info("Update Gen Give Bronze Star Successs = " + pckUserStarDB.toString()));
//                            } else {
//                                systemLogger.info(LogFormatter.info(sid, " ------ Star Type Not Found !!!! ------"));
//                                throw new Exception();
//                            }
//                        } else {
//                            systemLogger.info(LogFormatter.info(sid, " ------ Pck User Star Not Found !!!! ------"));
//                            throw new Exception();
//                        }
//                    }
//                }
//
//            } else {
//                systemLogger.info(LogFormatter.info(sid, " ------ Group User Not Found !!!! ------"));
//                throw new Exception();
//            }
//            systemLogger.info(LogFormatter.info("masGroupUserList    " + masGroupUserDB.toString()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//        return result;
//    }
//
//    public SearchGroupUserStarGiveResponseRESTModel updateByUserStarGive(String sid, String language, String uid, String giveGoldStar, String giveSilverStar, String giveBronzeStar) throws Exception {
//        SearchGroupUserStarGiveResponseRESTModel result = new SearchGroupUserStarGiveResponseRESTModel();
//        Date currentDate = new Date();
//
//        try {
////            boolean groupUserFlag = false;
////            boolean giveGoldStarFlag = false;
////            boolean giveSilverStarFlag = false;
////            boolean giveBronzeStarFlag = false;
//
//            if (NumberUtils.isDigits(uid)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Group User ID Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveGoldStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Gold Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveSilverStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Silver Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//            if (NumberUtils.isDigits(giveBronzeStar)) {
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Give Bronze Star Wrong Pattern !!!! ------"));
//                throw new Exception();
//            }
//
//            PckEmployee employee = new PckEmployee();
//
//            //set pckEmployee in Group to search in PckUserStar 
//            employee.setIsDelete(ProjectConstant.STATUS_N);
//            employee.setUid(uid);
//            List<PckEmployee> pckEmployeeListDB = pckEmployeeDao.getPckEmployee(employee, null, null);
//            PckEmployee pckEmployeeDB = pckEmployeeListDB != null && pckEmployeeListDB.size() > 0 ? pckEmployeeListDB.get(0) : null;
//
//            if (pckEmployeeDB != null) {
//
//                PckUserStar pckUserStar = new PckUserStar();
//                pckUserStar.setIsDelete(ProjectConstant.STATUS_N);
//                pckUserStar.setUid(pckEmployeeDB.getUid());
//                List<PckUserStar> pckUsrtStarListDB = pckUserStarDao.getPckUserStar(pckUserStar);
//
//                systemLogger.info(LogFormatter.info("Update GiveStar to PckUserStar = Gold star=" + giveGoldStar + ", Silver Star=" + giveSilverStar + ", Bronze Star=" + giveBronzeStar));
//
//                for (PckUserStar pckUserStarDB : pckUsrtStarListDB) {
//                    if (pckUserStarDB != null) {
//                        if (ProjectConstant.STAR_TYPE_GOLD.equals(pckUserStarDB.getStarType())) {
//                            pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveGoldStar));
//                            pckUserStarDB.setUpdateBy("TEST");
//                            pckUserStarDB.setUpdateDate(currentDate);
//                            pckUserStarDao.updatePckUserStar(pckUserStarDB);
//                            
//                            result.setGiveGoldStar(giveGoldStar);
//
//                            systemLogger.info(LogFormatter.info("Update Gen Give Gold Star Successs = " + pckUserStarDB.toString()));
//
//                        } else if (ProjectConstant.STAR_TYPE_SILVER.equals(pckUserStarDB.getStarType())) {
//                            pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveSilverStar));
//                            pckUserStarDB.setUpdateBy("TEST");
//                            pckUserStarDB.setUpdateDate(currentDate);
//                            pckUserStarDao.updatePckUserStar(pckUserStarDB);
//                            
//                            result.setGiveSilverStar(giveSilverStar);
//
//                            systemLogger.info(LogFormatter.info("Update Gen Give Silver Star Successs = " + pckUserStarDB.toString()));
//
//                        } else if (ProjectConstant.STAR_TYPE_BRONZE.equals(pckUserStarDB.getStarType())) {
//                            pckUserStarDB.setGenGiveAmount(Integer.valueOf(giveBronzeStar));
//                            pckUserStarDB.setUpdateBy("TEST");
//                            pckUserStarDB.setUpdateDate(currentDate);
//                            pckUserStarDao.updatePckUserStar(pckUserStarDB);
//                            
//                            result.setGiveBronzeStar(giveBronzeStar);
//
//                            systemLogger.info(LogFormatter.info("Update Gen Give Bronze Star Successs = " + pckUserStarDB.toString()));
//                        } else {
//                            systemLogger.info(LogFormatter.info(sid, " ------ Star Type Not Found !!!! ------"));
//                            throw new Exception();
//                        }
//                    } else {
//                        systemLogger.info(LogFormatter.info(sid, " ------ Pck User Star Not Found !!!! ------"));
//                        throw new Exception();
//                    }
//                }
//            } else {
//                systemLogger.info(LogFormatter.info(" ------ Can't not find this employee !!!! ------"));
//                throw new Exception();
//            }
//
//            systemLogger.info(LogFormatter.info("masGroupUserList    "));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//        return result;
//    }
//
//}
