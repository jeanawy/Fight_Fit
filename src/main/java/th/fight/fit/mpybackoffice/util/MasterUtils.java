package th.fight.fit.mpybackoffice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;

import th.fight.fit.mpybackoffice.dao.MasEventDao;
import th.fight.fit.mpybackoffice.dao.MasEventLocationDao;
import th.fight.fit.mpybackoffice.dao.MasMeetingRoomDao;

import th.fight.fit.mpybackoffice.dao.MasSportDao;
import th.fight.fit.mpybackoffice.dao.MasStatusDao;
import th.fight.fit.mpybackoffice.dao.MasTranCodeDao;

import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.domain.MasEventLocation;
import th.fight.fit.mpybackoffice.domain.MasMeetingRoom;

import th.fight.fit.mpybackoffice.domain.MasSport;
import th.fight.fit.mpybackoffice.domain.MasStatus;
import th.fight.fit.mpybackoffice.domain.MasSystemParam;
import th.fight.fit.mpybackoffice.domain.MasTranCode;
import th.fight.fit.mpybackoffice.domain.PckMenu;
import th.fight.fit.mpybackoffice.domain.vo.CheckBoxVO;
import th.fight.fit.mpybackoffice.domain.vo.DropdownVO;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.MasSysParamService;
//import th.mfec.mpybackoffice.service.PckMenuService;

@Component
public class MasterUtils {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

//    @Autowired
//    private SystemParamUtil systemParamUtil;
//    @Autowired
//    private PckMenuService pckMenuService;
//    @Autowired
//    private MasMeetingRoomDao masMeetingRoomDao;
//    @Autowired
//    private MasBuildingDao masBuildingDao;
//    @Autowired
//    private MasMobileMenuDao masMobileMenuDao;
//    @Autowired
//    private MasBosGroupMenuDao masBosGroupMenuDao;
//    @Autowired
//    private MasBosMenuDao masBosMenuDao;
//    @Autowired
//    private MasGroupUserDao masGroupUserDao;
//    @Autowired
//    private MasDocumentDao masDocumentDao;
//    @Autowired
//    private MasPurposeDao masPurposeDao;
//    @Autowired
//    private MasStatusDao masStatusDao;
//    @Autowired
//    private MasDepartmentDao masDepartmentDao;
//    @Autowired
//    private MasDivisionDao masDivisionDao;
//    @Autowired
//    private MasRelationDepDivDao masRelationDepDivDao;
//    @Autowired
//    private MasTranCodeDao masTranCodeDao;
    @Autowired
    private MasEventDao masEventDao;
    @Autowired
    private MasEventLocationDao masEventLocationDao;
    @Autowired
    private MasSportDao masSportDao;
    @Autowired

    private static List<MasEvent> masEventList;
    private static List<MasEventLocation> masEventLocationList;
    private static List<MasSport> masSportList;
//
//    private static List<PckMenu> lstPckMenu;
//    private static List<MasMeetingRoom> masMeetingRoomList;
//    private static List<MasBuilding> masBuildingList;
//    private static List<MasMobileMenu> masMobileMenuList;
//    private static List<MasBosGroupMenu> masBosGroupMenuList;
//
//    private static List<MasBosMenu> masBosMenuList;
//    private static List<MasGroupUser> masGroupUserList;
//    private static List<MasDocument> masDocumentList;
//    private static List<MasPurpose> masPurposesList;
//    private static List<MasStatus> masStatusesList;
//
//    private static List<MasDepartment> masDepartmentList;
//    private static List<MasDivision> masDivisionList;
//    private static List<MasRelationDepDiv> masRelationDepDivList;
//    private static List<MasTranCode> masTranCodeList;

    @PostConstruct
    public void loadMaster() throws Exception {
//        systemParamUtil.loadParam();
//        systemLogger.info(LogFormatter.info("Load SystemParam list success."));
//
//        lstPckMenu = pckMenuService.getPckMenu();
//        systemLogger.info(LogFormatter.info("Load Pck menu list success."));

        masEventList = masEventDao.getMasEvent(null);
        systemLogger.info(LogFormatter.info("- Load mas_event list success."));

        masEventLocationList = masEventLocationDao.getMasEventLocation(null);
        systemLogger.info(LogFormatter.info("- Load mas_event_location list success."));

        masSportList = masSportDao.getMasSport(null);
        systemLogger.info(LogFormatter.info("- Load mas_sport list success."));

//
//        masMeetingRoomList = masMeetingRoomDao.getMasMeetingRoom(null);
//        systemLogger.info(LogFormatter.info("- Load mas_meeting_room list success."));
//
//        masBuildingList = masBuildingDao.getMasBuilding(null);
//        systemLogger.info(LogFormatter.info("- Load mas_building list success."));
//
//        masMobileMenuList = masMobileMenuDao.GetMasMobileMenu(null);
//        systemLogger.info(LogFormatter.info("- Load mas_mobileMenu list success."));
//
//        masBosGroupMenuList = masBosGroupMenuDao.getMasBosGroupMenu(null);
//        systemLogger.info(LogFormatter.info("- Load mas_bosGroupMenu list success."));
//
//        masBosMenuList = masBosMenuDao.getMasBosmenu(null);
//        systemLogger.info(LogFormatter.info("- Load masbosmenu list success."));
//
//        masGroupUserList = masGroupUserDao.getMasGroupUser(null);
//        systemLogger.info(LogFormatter.info("- Load masgroupUser list success."));
//
//        masDocumentList = masDocumentDao.getMasDocument(null);
//        systemLogger.info(LogFormatter.info("- Load mas_document list success."));
//
//        masPurposesList = masPurposeDao.getMasPurpose(null);
//        systemLogger.info(LogFormatter.info("- Load mas_Purpose list success."));
//
//        masStatusesList = masStatusDao.getMasStatus(null);
//        systemLogger.info(LogFormatter.info("- Load mas_Status list success."));
//
//        masDepartmentList = masDepartmentDao.getMasDepartment(null);
//        systemLogger.info(LogFormatter.info("- Load mas_department list success."));
//
//        masDivisionList = masDivisionDao.getMasDivision(null);
//        systemLogger.info(LogFormatter.info("- Load mas_division list success."));
//
//        masRelationDepDivList = masRelationDepDivDao.getMasRelationDepDiv(null);
//        systemLogger.info(LogFormatter.info("- Load mas_relation_dev_div list success."));
//
//        masTranCodeList = masTranCodeDao.getMasTranCode(null);
//        systemLogger.info(LogFormatter.info("- Load mas_trancode_dev_div list success."));
    }

    public void reloadMaster(String reloadOption) throws Exception {
        if (StringUtils.isNotEmptyOrNull(reloadOption)) {

            if (reloadOption.equalsIgnoreCase(ProjectConstant.MASTER_UTILS_RELOAD_MAS_MEETING_ROOM)) {
                masEventList = masEventDao.getMasEvent(null);
                systemLogger.info(LogFormatter.info("- reload mas_meeting_room list success."));
            } else if (reloadOption.equalsIgnoreCase(ProjectConstant.MASTER_UTILS_RELOAD_MAS_BUILDING)) {
                masEventLocationList = masEventLocationDao.getMasEventLocation(null);
                systemLogger.info(LogFormatter.info("- reload mas_building list success."));
            }
//            if (reloadOption.equalsIgnoreCase(ProjectConstant.MASTER_UTILS_RELOAD_MAS_MEETING_ROOM)) {
//                masMeetingRoomList = masMeetingRoomDao.getMasMeetingRoom(null);
//                systemLogger.info(LogFormatter.info("- reload mas_meeting_room list success."));
//            } else if (reloadOption.equalsIgnoreCase(ProjectConstant.MASTER_UTILS_RELOAD_MAS_BUILDING)) {
//                masBuildingList = masBuildingDao.getMasBuilding(null);
//                systemLogger.info(LogFormatter.info("- reload mas_building list success."));
//            }

        }
    }

//    public static synchronized Map<String, String> getMenuMap(String language) throws Exception {
//        Map<String, String> menuMap = new HashMap<String, String>();
//
//        for (PckMenu rec : lstPckMenu) {
//            if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                menuMap.put(rec.getMenuCode(), rec.getMenuNameTh());
//            } else {
//                menuMap.put(rec.getMenuCode(), rec.getMenuNameEn());
//            }
//        }
//
//        return menuMap;
//
//    }
    
    
//    public static List<DropdownVO> loadMasMeetingRoomDropdownList(String language, String buildingID) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasMeetingRoom masMeetingRoom : masMeetingRoomList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masMeetingRoom.getIsDelete())) {
//                    boolean foundBuildingFlag = false;
//                    if (StringUtils.isNotEmptyOrNull(buildingID)) {
//                        if (Integer.parseInt(buildingID) == masMeetingRoom.getBuildingId()) {
//                            foundBuildingFlag = true;
//                        } else {
//                            foundBuildingFlag = false;
//                        }
//                    } else {
//                        foundBuildingFlag = true;
//                    }
//                    if (foundBuildingFlag) {
//                        mapper = new DropdownVO();
//                        mapper.setDropDownKey(masMeetingRoom.getRoomId().toString());
//                        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                            mapper.setDropDownValue(masMeetingRoom.getRoomTh());
//                        } else {
//                            mapper.setDropDownValue(masMeetingRoom.getRoomEn());
//                        }
//                        dropdownList.add(mapper);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasBuildingDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasBuilding masBuilding : masBuildingList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBuilding.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masBuilding.getBuildingId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masBuilding.getBuildingTh());
//                    } else {
//                        mapper.setDropDownValue(masBuilding.getBuildingEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> getDropdownMap(Map<String, String> contentMap) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
//            mapper = new DropdownVO();
//            mapper.setDropDownKey(entry.getKey());
//            mapper.setDropDownValue(entry.getValue());
//            dropdownList.add(mapper);
//        }
//
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasMobileMenuDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasMobileMenu masMobileMenu : masMobileMenuList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masMobileMenu.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masMobileMenu.getMobileMenuID().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masMobileMenu.getMobileMenuTh());
//                    } else {
//                        mapper.setDropDownValue(masMobileMenu.getMobileMenuEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasBOSGroupMenuDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasBosGroupMenu masBosGroupMenu : masBosGroupMenuList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBosGroupMenu.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masBosGroupMenu.getBosGroupId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masBosGroupMenu.getBosGroupTh());
//                    } else {
//                        mapper.setDropDownValue(masBosGroupMenu.getBosGroupEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<CheckBoxVO> loadMasBOSMenuCheckboxList(String language) throws Exception {
//        List<CheckBoxVO> checkboxList = new ArrayList<CheckBoxVO>();
//        CheckBoxVO mapper;
//        try {
//            for (MasBosMenu masBosMenu : masBosMenuList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBosMenu.getIsDelete())) {
//                    mapper = new CheckBoxVO();
//                    mapper.setCheckBoxKey(masBosMenu.getBosGroupId().toString());
//                    mapper.setCheckBoxKey2(masBosMenu.getBosMenuId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setCheckBoxValue(masBosMenu.getBosMenuTh());
//                    } else {
//                        mapper.setCheckBoxValue(masBosMenu.getBosMenuEn());
//                    }
//                    checkboxList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return checkboxList;
//    }
//
//    public static List<DropdownVO> loadMasGroupUserDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasGroupUser masGroupUser : masGroupUserList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masGroupUser.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masGroupUser.getGroupUserId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masGroupUser.getGroupUserTh());
//                    } else {
//                        mapper.setDropDownValue(masGroupUser.getGroupUserEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<MasMeetingRoom> loadMasMeetingRoom(String paramKey) throws Exception {
//        List<MasMeetingRoom> result = new ArrayList<MasMeetingRoom>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasMeetingRoom masMeetingRoom : masMeetingRoomList) {
//                    if (paramKey.equals(masMeetingRoom.getRoomId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masMeetingRoom.getIsDelete())) {
//                            result.add(masMeetingRoom);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masMeetingRoomList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<DropdownVO> loadMasDocumentDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasDocument masDocument : masDocumentList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDocument.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masDocument.getDocumentId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masDocument.getDocumentTh());
//                    } else {
//                        mapper.setDropDownValue(masDocument.getDocumentEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasStatusDocumentDropdownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasStatus masStatus : masStatusesList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masStatus.getIsDelete()) && ("DOCUMENT").equalsIgnoreCase(masStatus.getStatusUseIn())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masStatus.getStatusId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masStatus.getStatusTh());
//                    } else {
//                        mapper.setDropDownValue(masStatus.getStatusEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasStatusRewardDropdownList(String status, String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasStatus masStatus : masStatusesList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masStatus.getIsDelete())) {
//                    if (status.equalsIgnoreCase(masStatus.getStatusUseIn())) {
//                        mapper = new DropdownVO();
//                        mapper.setDropDownKey(masStatus.getStatusId().toString());
//                        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                            mapper.setDropDownValue(masStatus.getStatusTh());
//                        } else {
//                            mapper.setDropDownValue(masStatus.getStatusEn());
//                        }
//                        dropdownList.add(mapper);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<MasBuilding> loadMasBuilding(String paramKey) throws Exception {
//        List<MasBuilding> result = new ArrayList<MasBuilding>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasBuilding masBuilding : masBuildingList) {
//                    if (paramKey.equals(masBuilding.getBuildingId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBuilding.getIsDelete())) {
//                            result.add(masBuilding);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masBuildingList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasDocument> loadMasDocument(String paramKey) throws Exception {
//        List<MasDocument> result = new ArrayList<MasDocument>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasDocument masDocument : masDocumentList) {
//                    if (paramKey.equals(masDocument.getDocumentId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDocument.getIsDelete())) {
//                            result.add(masDocument);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masDocumentList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasPurpose> loadMasPurpose(String paramKey) throws Exception {
//        List<MasPurpose> result = new ArrayList<MasPurpose>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasPurpose masPurpose : masPurposesList) {
//                    if (paramKey.equals(masPurpose.getPurposeId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masPurpose.getIsDelete())) {
//                            result.add(masPurpose);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masPurposesList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasStatus> loadMasStatus(String paramKey) throws Exception {
//        List<MasStatus> result = new ArrayList<MasStatus>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasStatus masStatus : masStatusesList) {
//                    if (paramKey.equals(masStatus.getStatusId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masStatus.getIsDelete())) {
//                            result.add(masStatus);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masStatusesList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<DropdownVO> loadMasDepartmentsDropDownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasDepartment masDepartment : masDepartmentList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDepartment.getIsDelete())) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masDepartment.getDepartmentNo());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masDepartment.getDepartmentTh());
//                    } else {
//                        mapper.setDropDownValue(masDepartment.getDepartmentEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasDivisionDropDownList(String language, String department) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasDivision masDivision : masDivisionList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDivision.getIsDelete())) {
//                    boolean foundRelativeFlag = false;
//                    if (StringUtils.isNotEmptyOrNull(department)) {
//                        for (MasRelationDepDiv masRelationDepDiv : masRelationDepDivList) {
//                            if (department.equalsIgnoreCase(masRelationDepDiv.getDepartmentNo()) && masDivision.getDivisionNo().equalsIgnoreCase(masRelationDepDiv.getDivisionNo())) {
//                                foundRelativeFlag = true;
//                            }
//                        }
//                    } else {
//                        foundRelativeFlag = true;
//                    }
//                    if (foundRelativeFlag) {
//                        mapper = new DropdownVO();
//                        mapper.setDropDownKey(masDivision.getDivisionNo());
//                        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                            mapper.setDropDownValue(masDivision.getDivisionTh());
//                        } else {
//                            mapper.setDropDownValue(masDivision.getDivisionEn());
//                        }
//                        dropdownList.add(mapper);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<MasGroupUser> loadMasGroupUser(String paramKey) throws Exception {
//        List<MasGroupUser> result = new ArrayList<MasGroupUser>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasGroupUser masGroupUser : masGroupUserList) {
//                    if (paramKey.equals(masGroupUser.getGroupUserId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masGroupUser.getIsDelete())) {
//                            result.add(masGroupUser);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masGroupUserList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasDepartment> loadMasDepartment(String paramKey) throws Exception {
//        List<MasDepartment> result = new ArrayList<MasDepartment>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasDepartment masDepartment : masDepartmentList) {
//                    if (paramKey.equals(masDepartment.getDepartmentNo())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDepartment.getIsDelete())) {
//                            result.add(masDepartment);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masDepartmentList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasDivision> loadMasDivision(String paramKey) throws Exception {
//        List<MasDivision> result = new ArrayList<MasDivision>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasDivision masDivision : masDivisionList) {
//                    if (paramKey.equals(masDivision.getDivisionNo())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masDivision.getIsDelete())) {
//                            result.add(masDivision);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masDivisionList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<DropdownVO> loadMasStatusRepairDropDownList(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasStatus masStatus : masStatusesList) {
//                if ((ProjectConstant.STATUS_N.equalsIgnoreCase(masStatus.getIsDelete())) && (masStatus.getStatusUseIn().equalsIgnoreCase("REPAIR"))) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masStatus.getStatusId());
//                    mapper.setDropDownValue(masStatus.getStatusId());
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<DropdownVO> loadMasBuildingDropdownListForContactRepair(String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasBuilding masBuilding : masBuildingList) {
//                if ((ProjectConstant.STATUS_N.equalsIgnoreCase(masBuilding.getIsDelete())) && (ProjectConstant.STATUS_Y.equalsIgnoreCase(masBuilding.getContactRepair()))) {
//                    mapper = new DropdownVO();
//                    mapper.setDropDownKey(masBuilding.getBuildingId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setDropDownValue(masBuilding.getBuildingTh());
//                    } else {
//                        mapper.setDropDownValue(masBuilding.getBuildingEn());
//                    }
//                    dropdownList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
//
//    public static List<MasTranCode> loadMasTranCode(String paramKey) throws Exception {
//        List<MasTranCode> result = new ArrayList<MasTranCode>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasTranCode masTranCode : masTranCodeList) {
//                    if (paramKey.equals(masTranCode.getTranCode())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masTranCode.getIsDelete())) {
//                            result.add(masTranCode);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masTranCodeList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<CheckBoxVO> loadMasBOSGroupMenuCheckBoxList(String language) throws Exception {
//        List<CheckBoxVO> checkboxList = new ArrayList<CheckBoxVO>();
//        CheckBoxVO mapper;
//        try {
//            for (MasBosGroupMenu masBosGroupMenu : masBosGroupMenuList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBosGroupMenu.getIsDelete())) {
//                    mapper = new CheckBoxVO();
//                    mapper.setCheckBoxKey(masBosGroupMenu.getBosGroupId().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setCheckBoxValue(masBosGroupMenu.getBosGroupTh());
//                    } else {
//                        mapper.setCheckBoxValue(masBosGroupMenu.getBosGroupEn());
//                    }
//                    checkboxList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return checkboxList;
//    }
//
//    public static List<CheckBoxVO> loadMasMobileMenuCheckBoxList(String language) throws Exception {
//        List<CheckBoxVO> checkboxList = new ArrayList<CheckBoxVO>();
//        CheckBoxVO mapper;
//        try {
//            for (MasMobileMenu masMobileMenu : masMobileMenuList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masMobileMenu.getIsDelete())) {
//                    mapper = new CheckBoxVO();
//                    mapper.setCheckBoxKey(masMobileMenu.getMobileMenuID().toString());
//                    if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                        mapper.setCheckBoxValue(masMobileMenu.getMobileMenuTh());
//                    } else {
//                        mapper.setCheckBoxValue(masMobileMenu.getMobileMenuEn());
//                    }
//                    checkboxList.add(mapper);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return checkboxList;
//    }
//
//    public static List<MasBosGroupMenu> loadMasBosGroupMenu(String paramKey) throws Exception {
//        List<MasBosGroupMenu> result = new ArrayList<MasBosGroupMenu>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasBosGroupMenu masBosGroupMenu : masBosGroupMenuList) {
//                    if (paramKey.equals(masBosGroupMenu.getBosGroupId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBosGroupMenu.getIsDelete())) {
//                            result.add(masBosGroupMenu);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masBosGroupMenuList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasBosMenu> loadMasBosMenu(String paramKey) throws Exception {
//        List<MasBosMenu> result = new ArrayList<MasBosMenu>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasBosMenu masBosMenu : masBosMenuList) {
//                    if (paramKey.equals(masBosMenu.getBosMenuId().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masBosMenu.getIsDelete())) {
//                            result.add(masBosMenu);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masBosMenuList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
//
//    public static List<MasMobileMenu> loadMasMobileMenu(String paramKey) throws Exception {
//        List<MasMobileMenu> result = new ArrayList<MasMobileMenu>();
//        try {
//            if (StringUtils.isNotEmptyOrNull(paramKey)) {
//                for (MasMobileMenu masMobileMenu : masMobileMenuList) {
//                    if (paramKey.equals(masMobileMenu.getMobileMenuID().toString())) {
//                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masMobileMenu.getIsDelete())) {
//                            result.add(masMobileMenu);
//                        }
//                    }
//                }
//            } else if (paramKey == null) {
//                result = masMobileMenuList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return result;
//    }
    public static List<DropdownVO> loadMasEventDropdownList(String eventName, String language) throws Exception {
        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
        DropdownVO mapper;
        try {
            for (MasEvent masEvent : masEventList) {
                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masEvent.getIsDelete())) {
                    if (eventName.equalsIgnoreCase(masEvent.getEventName())) {
                        mapper = new DropdownVO();
                        mapper.setDropDownKey(masEvent.getEventId().toString());

                        dropdownList.add(mapper);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return dropdownList;
    }

    public static List<DropdownVO> loadMasEventLocationDropdownList(String language) throws Exception {
        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
        DropdownVO mapper;
        try {
            for (MasEventLocation masEventLocation : masEventLocationList) {
                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masEventLocation.getIsDelete())) {
                    mapper = new DropdownVO();
                    mapper.setDropDownKey(masEventLocation.getEventLocationId());
                    
                    dropdownList.add(mapper);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return dropdownList;
    }
    public static List<DropdownVO> loadMasSportDropdownList(String language) throws Exception {
        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
        DropdownVO mapper;
        try {
            for (MasSport masSport : masSportList) {
                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masSport.getIsDelete())) {
                    mapper = new DropdownVO();
                    mapper.setDropDownKey(masSport.getSportId());
                    
                    dropdownList.add(mapper);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return dropdownList;
    }

//        public static List<DropdownVO> loadMasEventLocationDropdownList( String language) throws Exception {
//        List<DropdownVO> dropdownList = new ArrayList<DropdownVO>();
//        DropdownVO mapper;
//        try {
//            for (MasEventLocation masEventLocation : masEventLocationList) {
//                if (ProjectConstant.STATUS_N.equalsIgnoreCase(masEventLocation.getIsDelete())) {
//                        mapper = new DropdownVO();
//                        mapper.setDropDownKey(masStatus.getStatusId().toString());
//                        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language)) {
//                            mapper.setDropDownValue(masStatus.getStatusTh());
//                        } else {
//                            mapper.setDropDownValue(masStatus.getStatusEn());
//                        }
//                        dropdownList.add(mapper);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(e));
//            throw e;
//        }
//        return dropdownList;
//    }
  

    public static List<MasEvent> loadMasEvent(String paramKey) throws Exception {
        List<MasEvent> result = new ArrayList<MasEvent>();
        try {
            if (StringUtils.isNotEmptyOrNull(paramKey)) {
                for (MasEvent masEvent : masEventList) {
                    if (paramKey.equals(masEvent.getEventId().toString())) {
                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masEvent.getIsDelete())) {
                            result.add(masEvent);
                        }
                    }
                }
            } else if (paramKey == null) {
                result = masEventList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return result;
    }

    public static List<MasEventLocation> loadMasEventLocation(String paramKey) throws Exception {
        List<MasEventLocation> result = new ArrayList<MasEventLocation>();
        try {
            if (StringUtils.isNotEmptyOrNull(paramKey)) {
                for (MasEventLocation masEventLocation : masEventLocationList) {
                    if (paramKey.equals(masEventLocation.getEventLocationId().toString())) {
                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masEventLocation.getIsDelete())) {
                            result.add(masEventLocation);
                        }
                    }
                }
            } else if (paramKey == null) {
                result = masEventLocationList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return result;
    }

    public static List<MasSport> loadMasSport(String paramKey) throws Exception {
        List<MasSport> result = new ArrayList<MasSport>();
        try {
            if (StringUtils.isNotEmptyOrNull(paramKey)) {
                for (MasSport masSport : masSportList) {
                    if (paramKey.equals(masSport.getSportId().toString())) {
                        if (ProjectConstant.STATUS_N.equalsIgnoreCase(masSport.getIsDelete())) {
                            result.add(masSport);
                        }
                    }
                }
            } else if (paramKey == null) {
                result = masSportList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));
            throw e;
        }
        return result;
    }

}
