/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.PckFavouriteDao;
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.dao.PckUserSessionDao;
import th.fight.fit.mpybackoffice.domain.PckFavourite;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.domain.PckUserSession;
import th.fight.fit.mpybackoffice.exception.DatabaseException;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.model.rest.UserFavourite;
import th.fight.fit.mpybackoffice.service.DB2SequencerService;
import th.fight.fit.mpybackoffice.service.UserManagementService;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    @Autowired
    private DB2SequencerService db2SequencerService;
    
    @Autowired
    private PckProfileDao pckProfileDao;

    @Autowired
    private PckUserSessionDao pckUserSessionDao;

    @Autowired
    private PckFavouriteDao pckFavouriteDao;

    public UserFavourite userFavourite(BigInteger sid, String updateOption, String uidFavourite) throws Exception {

        UserFavourite result = new UserFavourite();
        Date startDate = new Date();

        try {
//            business blows
            String errorMessage = null;
            PckProfile user = new PckProfile();
            user.setUid(uidFavourite);
            user.setIsDelete(ProjectConstant.STATUS_N);
            List<PckProfile> pckProfileListDB = pckProfileDao.getPckProfile(user);
            PckProfile userDB = pckProfileListDB != null && pckProfileListDB.size() > 0 ? pckProfileListDB.get(0) : null;
            PckUserSession pckUserSession = new PckUserSession();
            pckUserSession.setSid(String.valueOf(sid));
            List<PckUserSession> pckUserSessionsListDB = pckUserSessionDao.getPckUserSession(pckUserSession);
            PckUserSession pckUserSessionDB = pckUserSessionsListDB != null && pckUserSessionsListDB.size() > 0 ? pckUserSessionsListDB.get(0) : null;

            if (pckUserSessionDB != null) {
                user.setUid(pckUserSessionDB.getUid());
                user.setIsDelete(ProjectConstant.STATUS_N);
                List<PckProfile> userUpdateListDB = pckProfileDao.getPckProfile(user);
                PckProfile userUpdateDB = userUpdateListDB != null && userUpdateListDB.size() > 0 ? userUpdateListDB.get(0) : null;

                if (StringUtils.isNotEmptyOrNull(updateOption) && ((updateOption.equals(ProjectConstant.UPDATE_OPTION_ADD)) || (updateOption.equals(ProjectConstant.UPDATE_OPTION_DELETE)))) {

                    if (StringUtils.isEmptyOrNull(uidFavourite) || uidFavourite != null) {
                        boolean foundUser = false;
                        boolean foundUserUpdate = false;

                        if (userDB != null) {
                            foundUser = true;
                        }
                        if (userUpdateDB != null) {
                            foundUserUpdate = true;
                        }
                        if (uidFavourite.equals(pckUserSessionDB.getUid())) {
                            systemLogger.info(LogFormatter.info(" - Can't favourite with your UID : ", uidFavourite));
                        }

                        if (!foundUser) {
                            systemLogger.info(LogFormatter.info(" - Can't find this employee in base ! : ", uidFavourite));
                        }
                        if (!foundUserUpdate) {
                            systemLogger.info(LogFormatter.info(" - Can't find this employee in base ! : ", pckUserSessionDB.getUid()));
                        }

                        PckFavourite pckFavourite = new PckFavourite();
                        pckFavourite.setUid(pckUserSessionDB.getUid());
                        List<PckFavourite> pckFavouritesListDB = pckFavouriteDao.getPckFavourite(pckFavourite);
                        if (updateOption.equals("1")) {
                            boolean foundFlag = false;

                            for (PckFavourite pckFavourite1 : pckFavouritesListDB) {

                                if (uidFavourite.equals(pckFavourite1.getFavouriteUid())) {

                                    if ((pckFavourite1.getIsDelete()).equals("Y")) {

                                        pckFavourite1.setIsDelete(ProjectConstant.STATUS_N);
                                        pckFavourite1.setUpdateDate(startDate);
                                        pckFavourite1.setUpdateBy(ProjectConstant.KEY_SYSTEM);
                                        pckFavouriteDao.updatePckFavourite(pckFavourite1);
                                    } else if ((pckFavourite1.getIsDelete()).equals("N")) {
                                        systemLogger.info(LogFormatter.info("You has  addFavourited with UidFavourite !"));
                                    }
                                    foundFlag = true;
                                    break;
                                }
                            }
                            if (!foundFlag) {

                                PckFavourite pckFavouriteUpdate = new PckFavourite();
                                long seq = db2SequencerService.getSeqNum(ProjectConstant.SEQ_PCK_FAVOURITE);
                                pckFavouriteUpdate.setUid(pckUserSessionDB.getUid());
                                pckFavouriteUpdate.setSeq(BigInteger.valueOf(seq));
                                pckFavouriteUpdate.setFavouriteUid(uidFavourite);
                                pckFavouriteUpdate.setCreateDate(startDate);
                                pckFavouriteUpdate.setCreateBy(ProjectConstant.KEY_SYSTEM);
                                pckFavouriteUpdate.setIsDelete("N");
                                pckFavouriteUpdate.setUpdateBy(ProjectConstant.KEY_SYSTEM);
                                pckFavouriteUpdate.setUpdateDate(startDate);
                                pckFavouriteDao.insertPckFavourite(pckFavouriteUpdate);

                            }

                        } else if (updateOption.equals("2")) {
                            boolean foundflag = false;
                            for (PckFavourite pckFavourite1 : pckFavouritesListDB) {

                                if (StringUtils.isNotEmptyOrNull(uidFavourite) && uidFavourite.equals(pckFavourite1.getFavouriteUid())) {
                                    if ((pckFavourite1.getIsDelete()).equals("Y")) {

                                        systemLogger.info(LogFormatter.info("You has deleteFavourited with UidFavourite !"));

                                    }
                                    pckFavourite1.setIsDelete(ProjectConstant.STATUS_Y);
                                    pckFavourite1.setUpdateDate(startDate);
                                    pckFavourite1.setUpdateBy(ProjectConstant.KEY_SYSTEM);
                                    pckFavouriteDao.updatePckFavourite(pckFavourite1);
                                    foundflag = true;
                                    break;
                                }
                            }
                            if (!foundflag) {
                                systemLogger.info(LogFormatter.info("You has deleteFavourited invalid UidFavourite !"));
                            }
                        }
                    } else {
                        // new throws uidFav is null wowss
                        systemLogger.info(LogFormatter.info(" UidFavourite Invalid ! : ", uidFavourite));
                    }
                } else if (updateOption == null || ((!updateOption.equals(ProjectConstant.UPDATE_OPTION_ADD)) || (!updateOption.equals(ProjectConstant.UPDATE_OPTION_DELETE)))) {
                    // no updateoption or updateoption is null
                    systemLogger.info(LogFormatter.info(" Updateoption Invalid Or Updateoption not found. ! : "));
                }
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return result;
    }

}
