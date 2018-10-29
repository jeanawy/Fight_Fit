package th.fight.fit.mpybackoffice.service.impl;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.mfec.mpybackoffice.service.impl;
//
//import java.util.List;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.dao.PckEmployeeDao;
//import th.mfec.mpybackoffice.dao.PckUserSessionDao;
//import th.mfec.mpybackoffice.domain.MasBosMenu;
//import th.mfec.mpybackoffice.domain.MasMobileMenu;
//import th.mfec.mpybackoffice.domain.PckEmployee;
//import th.mfec.mpybackoffice.domain.PckUserSession;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.service.EditCustomerUserAuthorizeService;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.StringUtils;
//import th.mfec.mpybackoffice.util.Utility;
//
///**
// *
// * @author Anuwat_K
// */
//@Service
//public class EditCustomerUserAuthorizeServiceImpl implements EditCustomerUserAuthorizeService {
//
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//
//    @Autowired
//    private PckUserSessionDao pckUserSessionDao;
//    @Autowired
//    private PckEmployeeDao pckEmployeeDao;
//
//    public void updateCustomerUserAuthorizeService(String sid, String language, String uid, String bosMenuRequest, String mobileMenuRequest) throws Exception {
//
//        try {
//
//            if (StringUtils.isNotEmptyOrNull(uid)) {
//                PckUserSession userSessionQuery = new PckUserSession();
//                userSessionQuery.setSid(sid);
//                userSessionQuery.setSidStatus(ProjectConstant.SESSION_ACTIVE);
//                List<PckUserSession> pckUserSessionListDB = pckUserSessionDao.getPckUserSession(userSessionQuery);
//                PckUserSession pckUserSessionDB = pckUserSessionListDB != null && pckUserSessionListDB.size() > 0 ? pckUserSessionListDB.get(0) : null;
//
//                if (pckUserSessionDB != null) {
//                    PckEmployee pckEmployeeQuery = new PckEmployee();
//                    pckEmployeeQuery.setIsDelete(ProjectConstant.STATUS_N);
//                    pckEmployeeQuery.setUid(uid);
//                    List<PckEmployee> employeeListDB = pckEmployeeDao.getPckEmployee(pckEmployeeQuery, null, null);
//                    PckEmployee employeeDB = employeeListDB != null && employeeListDB.size() > 0 ? employeeListDB.get(0) : null;
//
//                    if (employeeDB != null) {
//                        systemLogger.info(LogFormatter.info(sid, "- Found updateUser , Details=" + employeeDB.toString()));
//
//                        systemLogger.info(LogFormatter.info(sid, "1) Update BOS authority begin..."));
//                        if (StringUtils.isNotEmptyOrNull(bosMenuRequest)) {
//                            String bosMenuData = bosMenuRequest.replaceAll("\\[", "").replaceAll("\\]", "").trim();
//                            systemLogger.info(LogFormatter.info(sid, "- BOS-Menu Request=" + bosMenuData));
//
//                            //Validate data from database
//                            String[] bosMenuDataArray = bosMenuData.split(",");
//                            if (bosMenuDataArray != null && bosMenuDataArray.length > 0) {
//                                for (String bosMenu : bosMenuDataArray) {
//                                    List<MasBosMenu> masBosMenuListDB = MasterUtils.loadMasBosMenu(bosMenu);
//                                    if (masBosMenuListDB == null || masBosMenuListDB.isEmpty()) {
//                                        systemLogger.info(LogFormatter.info(sid, "- Service validation : Bos menu not found. bosMenuID=" + bosMenu));
//                                        throw new Exception();
//                                    } else {
//                                        systemLogger.info(LogFormatter.info(sid, "- Found BOS menu. bosMenuID=" + bosMenu));
//                                    }
//                                }
//                            }
//                            //
//                            //   update this menu to database
//                            //
//                        } else {
//                            systemLogger.info(LogFormatter.info(sid, "- Service validation : BOS menu not found, No update for employeeID=" + employeeDB.getEmployeeId()));
//                            throw new Exception();
//                        }
//
//                        systemLogger.info(LogFormatter.info(sid, "2) Update Mobile authority begin..."));
//                        if (StringUtils.isNotEmptyOrNull(mobileMenuRequest)) {
//                            String mobileMenuData = mobileMenuRequest.replaceAll("\\[", "").replaceAll("\\]", "").trim();
//                            systemLogger.info(LogFormatter.info(sid, "- Mobile-Menu Request=" + mobileMenuData));
//
//                            //Validate data from database
//                            String[] mobileMenuDataArray = mobileMenuData.split(",");
//                            if (mobileMenuDataArray != null && mobileMenuDataArray.length > 0) {
//                                for (String mobileMenu : mobileMenuDataArray) {
//                                    List<MasMobileMenu> masMobileMenuListDB = MasterUtils.loadMasMobileMenu(mobileMenu);
//                                    if (masMobileMenuListDB == null || masMobileMenuListDB.isEmpty()) {
//                                        systemLogger.info(LogFormatter.info(sid, "- Service validation : Mobile menu not found. mobileMenuID=" + mobileMenu));
//                                        throw new Exception();
//                                    } else {
//                                        systemLogger.info(LogFormatter.info(sid, "- Found Mobile menu. mobileMenuID=" + mobileMenu));
//                                    }
//                                }
//                            }
//                            //
//                            //   update this menu to database
//                            //
//                        } else {
//                            systemLogger.info(LogFormatter.info(sid, "- Service validation : Mobile menu not found, Noupdate for employeeID=" + employeeDB.getEmployeeId()));
//                            throw new Exception();
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//    }
//}
