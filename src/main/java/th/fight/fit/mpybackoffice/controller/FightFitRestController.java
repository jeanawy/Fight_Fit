package th.fight.fit.mpybackoffice.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.model.rest.SendDateFitbit;
import th.fight.fit.mpybackoffice.service.SendDataFitbitService;
import th.fight.fit.mpybackoffice.util.JSONUtil;
import th.fight.fit.mpybackoffice.util.StringUtils;
//import th.mfec.mpybackend.exception.DatabaseException;
//import th.mfec.mpybackend.exception.ExternalConnectionException;
//import th.mfec.mpybackend.exception.ExternalException;
//import th.mfec.mpybackend.exception.ExternalValidation;
//import th.mfec.mpybackend.exception.InternalConnectionException;
//import th.mfec.mpybackend.exception.InternalException;
//import th.mfec.mpybackend.exception.InternalValidationException;
//import th.mfec.mpybackend.exception.ServiceValidation;
//import th.mfec.mpybackend.formatter.LogFormatter;
//import th.mfec.mpybackend.model.rest.GetGiveStarReason.GetGiveStarReasonResponseRESTModel;
//import th.mfec.mpybackend.model.rest.GetGiveStarReason.GetGiveStarReasonResultRESTModel;
//import th.mfec.mpybackend.model.rest.GetSearchMeetingRoom.GetSearchMeetingRoomRequestRestModel;
//import th.mfec.mpybackend.model.rest.GetSearchMeetingRoom.GetSearchMeetingRoomResponseRestModel;
//import th.mfec.mpybackend.model.rest.GetSearchMeetingRoom.GetSearchMeetingRoomResultModel;
//import th.mfec.mpybackend.model.rest.GetUserReward.GetUserRewardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.GetUserReward.GetUserRewardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.GetUserReward.GetUserRewardResultRESTModel;
//import th.mfec.mpybackend.model.rest.GetUserStar.GetUserStarRequestRESTModel;
//import th.mfec.mpybackend.model.rest.GetUserStar.GetUserStarResponseRESTModel;
//import th.mfec.mpybackend.model.rest.GetUserStar.GetUserStarResultRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionBookingRoom.TransactionBookingRoomRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionBookingRoom.TransactionBookingRoomRequestRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionBookingRoom.TransactionBookingRoomResponseRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionBookingRoom.TransactionBookingRoomResultRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionBookingRoom.VerifyTransactionBookingRoom;
//import th.mfec.mpybackend.model.rest.TransactionCancelBookingRoom.TransactionCancelBookingRoomRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionCancelBookingRoom.TransactionCancelBookingRoomRequestRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionCancelBookingRoom.TransactionCancelBookingRoomResponseRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionCancelBookingRoom.TransactionCancelBookingRoomResultRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionCancelBookingRoom.VerifyTransactionCancelBookingRoom;
//import th.mfec.mpybackend.model.rest.TransactionGiveStar.TransactionGiveStarRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionGiveStar.TransactionGiveStarRequestRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionGiveStar.TransactionGiveStarResponseRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionGiveStar.TransactionGiveStarResultRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionGiveStar.VerifyTransactionGiveStar;
//import th.mfec.mpybackend.model.rest.TransactionRedeem.TransactionRedeemRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionRedeem.TransactionRedeemRequestRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionRedeem.TransactionRedeemResponseRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionRedeem.TransactionRedeemResultRESTModel;
//import th.mfec.mpybackend.model.rest.TransactionRedeem.VerifyTransactionRedeem;
//import th.mfec.mpybackend.model.rest.extendSession.ExtendSessionRequestRESTModel;
//import th.mfec.mpybackend.model.rest.extendSession.ExtendSessionResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getBuildingMeeting.GetBuildingMeetingRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getBuildingMeeting.GetBuildingMeetingResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getBuildingMeeting.GetBuildingMeetingResultRESTModel;
//import th.mfec.mpybackend.model.rest.getCountEmployee.DepartmentNoRestModel;
//import th.mfec.mpybackend.model.rest.getCountEmployee.DivisionNoRestModel;
//import th.mfec.mpybackend.model.rest.getCountEmployee.GetCountEmployeeRequestRestModel;
//import th.mfec.mpybackend.model.rest.getCountEmployee.GetCountEmployeeResponseRestModel;
//import th.mfec.mpybackend.model.rest.getDashBoard.GetDashBoardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getDashBoard.GetDashBoardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getDashBoard.GetDashBoardResultRESTModel;
//import th.mfec.mpybackend.model.rest.getEmployeeList.GetEmployeeListRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getEmployeeList.GetEmployeeListResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getEmployeeList.GetEmployeeListResultRESTModel;
//import th.mfec.mpybackend.model.rest.getEmployeeList.Uid;
//import th.mfec.mpybackend.model.rest.initialConnection.InitialConnectionRequestRESTModel;
//import th.mfec.mpybackend.model.rest.initialConnection.InitialConnectionResultRESTModel;
//import th.mfec.mpybackend.model.rest.updateDashBoard.UpdateDashBoardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.updateDashBoard.UpdateDashBoardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.initialConnection.InitialConnectionResponseRESTModel;
//import th.mfec.mpybackend.model.rest.updateEmployeeFavourite.UpdateEmployeeFavouriteRequestRestModel;
//import th.mfec.mpybackend.model.rest.updateEmployeeFavourite.UpdateEmployeeFavouriteResponseRestModel;
//import th.mfec.mpybackend.model.rest.updateEmployeeFavourite.UpdateEmployeeFavouriteResultRestModel;
//import th.mfec.mpybackend.model.rest.updateProfile.UpdateProfileRequestRESTModel;
//import th.mfec.mpybackend.model.rest.updateProfile.UpdateProfileResponseRESTModel;
//import th.mfec.mpybackend.model.rest.verifyLogin.VerifyLoginRequestRESTModel;
//import th.mfec.mpybackend.model.rest.verifyLogin.VerifyLoginResponseRESTModel;
//import th.mfec.mpybackend.model.rest.verifyLogin.VerifyLoginResultRESTModel;
//import th.mfec.mpybackend.service.ErrorCodeService;
//import th.mfec.mpybackend.util.Utility;
//import th.mfec.mpybackend.model.rest.getCountEmployee.GetCountEmployeeResultRestModel;
//import th.mfec.mpybackend.model.rest.getDashBoard.IndexDashBoard;
//import th.mfec.mpybackend.model.rest.getDashBoard.UrlContent;
//import th.mfec.mpybackend.model.rest.getExchangeStar.GetExchangeStarRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getExchangeStar.GetExchangeStarResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getExchangeStar.GetExchangeStarResultRESTModel;
//import th.mfec.mpybackend.model.rest.getHistMeetingRoom.GetHistMeetingRoomRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getHistMeetingRoom.GetHistMeetingRoomResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getHistMeetingRoom.GetHistMeetingRoomResultRESTModel;
//import th.mfec.mpybackend.model.rest.getProfile.GetProfileRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getProfile.GetProfileResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getProfile.GetProfileResultRESTModel;
//import th.mfec.mpybackend.model.rest.getReward.GetRewardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getReward.GetRewardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getReward.GetRewardResultRESTModel;
//import th.mfec.mpybackend.model.rest.getTransactionGiveStar.GetTransactionGiveStarRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getTransactionGiveStar.GetTransactionGiveStarResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getTransactionGiveStar.GetTransactionGiveStarResultRESTModel;
//
//import th.mfec.mpybackend.model.rest.getUpdateContent.ErrorCode;
//import th.mfec.mpybackend.model.rest.getUpdateContent.GetUpdateContentRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getUpdateContent.GetUpdateContentResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getUpdateContent.GetUpdateContentResultRESTModel;
//import th.mfec.mpybackend.model.rest.getUpdateContent.LabelContent;
//import th.mfec.mpybackend.model.rest.getUsedReward.GetUsedRewardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.getUsedReward.GetUsedRewardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.getUsedReward.GetUsedRewardResultRESTModel;
//import th.mfec.mpybackend.model.rest.initialConnection.InitialConnectionRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.transactionExChangeStar.TransactionExchangeStarRequestDataRESTModel;
//import th.mfec.mpybackend.model.rest.transactionExChangeStar.TransactionExchangeStarRequestRESTModel;
//import th.mfec.mpybackend.model.rest.transactionExChangeStar.TransactionExchangeStarResponseRESTModel;
//import th.mfec.mpybackend.model.rest.transactionExChangeStar.TransactionExchangeStarResultRESTModel;
//import th.mfec.mpybackend.model.rest.transactionExChangeStar.VerifyTransactionExchangeStar;
//import th.mfec.mpybackend.model.rest.transactionUsedReward.TransactionUsedRewardRequestRESTModel;
//import th.mfec.mpybackend.model.rest.transactionUsedReward.TransactionUsedRewardResponseRESTModel;
//import th.mfec.mpybackend.model.rest.transactionUsedReward.TransactionUsedRewardResultRESTModel;
//import th.mfec.mpybackend.model.rest.transactionUsedReward.VerifyTransactionUsedReward;
//import th.mfec.mpybackend.model.rest.updateEmployeeFavourite.UpdateEmployeeFavouriteRequestDataRestModel;
//import th.mfec.mpybackend.model.rest.verifyLogin.VerifyLoginRequestDataRESTModel;
//import th.mfec.mpybackend.service.BookingRoomManagementService;
//import th.mfec.mpybackend.service.ContentManagementService;
//import th.mfec.mpybackend.service.DashBoardManagementService;
//import th.mfec.mpybackend.service.EmployeeManagementService;
//import th.mfec.mpybackend.service.ExchangeStarManagementService;
//import th.mfec.mpybackend.service.GetBuildingMeetingManagementService;
//import th.mfec.mpybackend.service.GetHistMeetingRoomManagementService;
//import th.mfec.mpybackend.service.GetRewardManagementService;
//import th.mfec.mpybackend.service.GetSearchMeetingRoomService;
//import th.mfec.mpybackend.service.GetUsedRewardService;
//import th.mfec.mpybackend.service.GetUserManagementService;
//import th.mfec.mpybackend.service.GetUserRewardService;
//import th.mfec.mpybackend.service.GiveStarManagementService;
//import th.mfec.mpybackend.service.LabelService;
//import th.mfec.mpybackend.service.LoginManagementService;
//import th.mfec.mpybackend.service.ProfileManagementService;
//import th.mfec.mpybackend.service.RedeemManagementService;
//import th.mfec.mpybackend.service.SecurityService;
//import th.mfec.mpybackend.service.SessionLoginService;
//import th.mfec.mpybackend.service.UsedRewardManagementService;
//import th.mfec.mpybackend.service.getTransactionGiveStarService;
//
//import th.mfec.mpybackend.util.DateUtil;
//import th.mfec.mpybackend.util.JSONUtil;
//import th.mfec.mpybackend.util.MasterUtils;
//import th.mfec.mpybackend.util.StringUtils;
//import th.mfec.mpybackend.ws.ldap.caller.LdapCaller;
//import th.mfec.mpybackend.ws.ldap.vo.AuthenticationRequestVO;
//import th.mfec.mpybackend.ws.ldap.vo.AuthenticationResponseVO;
//import th.mfec.mpybackend.service.TransactionCancelBookingRoomService;

@RestController
public class FightFitRestController extends BaseController {

    private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

//    @Autowired
//    private ErrorCodeService errorCodeService;
//    @Autowired
//    private LdapCaller ldapCaller;
//    @Autowired
//    private LoginManagementService loginManagementService;
//    @Autowired
//    private ContentManagementService contentManagementService;
//    @Autowired
//    private SecurityService securityService;
//    @Autowired
//    private ProfileManagementService profileManagementService;
//    @Autowired
//    private DashBoardManagementService dashBoardManagementService;
//    @Autowired
//    private SessionLoginService sessionLoginService;
//    @Autowired
//    private EmployeeManagementService employeeManagementService;
//    @Autowired
//    private getTransactionGiveStarService transactionGiveStarService;
//    @Autowired
//    private GetUserRewardService getUserRewardService;
//    @Autowired
//    private GiveStarManagementService giveStarManagementService;
//    @Autowired
//    private GetRewardManagementService getRewardManagementService;
//    @Autowired
//    private GetUsedRewardService getUsedRewardService;
//    @Autowired
//    private RedeemManagementService redeemManagementService;
//    @Autowired
//    private GetUserManagementService getUserManagementService;
//    @Autowired
//    private UsedRewardManagementService usedRewardManagementService;
//    @Autowired
//    private ExchangeStarManagementService exchangeStarManagementService;
//    @Autowired
//    private TransactionCancelBookingRoomService transactionCancelBookingRoomService;
//    @Autowired
//    private GetSearchMeetingRoomService getSearchMeetingRoomService;
//    @Autowired
//    private GetBuildingMeetingManagementService getBuildingMeetingManagementService;
//    @Autowired
//    private GetHistMeetingRoomManagementService getHisMeetingRoomManagementService;
    @Autowired
    private SendDataFitbitService sendDataFitbitService;


    @PostMapping("/SendDataFitbit")
    public SendDateFitbit sendDateFitbit(HttpServletRequest httpRequest) throws Exception {
        SendDateFitbit response = new SendDateFitbit();
        SendDateFitbit data = new SendDateFitbit();
//        List<Uid> uidList = new ArrayList<Uid>();
//        Uid uid = new Uid();
        Date startDate = new Date();
        boolean processSuccess = false;
        String errorCode = null;
        String errorMessage = null;

      //  String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetEmployeeListRequestRESTModel request = null;

        try {

        //    request = (SendDateFitbit) JSONUtil.transformStringToVO(jsonInput, GetEmployeeListRequestRESTModel.class);

//            if (request.getData() == null) {
//                systemLogger.info(LogFormatter.info("- REQUEST DATA IS EMPTY."));
//                throw new ServiceValidation(ProjectConstant.EMPLOYEE_MANAGEMENT_GET_EMPLOYEE_LIST_ERROR_CODE_SERVICE_EXCEPTION);
//            }

//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;

//            data = sendDataFitbitService.sendDatefitbit(sid);

//            response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            response.setMytime(data);
//            response.setMytime(data);
//            response.set 
//                    
            processSuccess = true;

        

        } catch (Exception e) {


        } 
        return response;
    }
    
    
    
//    @PostMapping("/initialConnection")
//    public InitialConnectionResponseRESTModel initialConnection(@RequestBody InitialConnectionRequestRESTModel requestObj) throws Exception {
//        InitialConnectionResponseRESTModel response = new InitialConnectionResponseRESTModel();
//        InitialConnectionResultRESTModel data = new InitialConnectionResultRESTModel();
//        Map<String, String> inputMap = null;
//        Date startDate = new Date();
//        InitialConnectionRequestDataRESTModel request = null;
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//            systemLogger.info(LogFormatter.info("- InitialConnection begin."));
//            request = requestObj.getData();
//
//            inputMap = securityService.getExChangeKey(request.getPublicKey(), request.getPlatform(), request.getDeviceName(), request.getAppVersion(), requestObj.getLanguage());
//
//            if (StringUtils.isNotEmptyOrNull(inputMap.get(ProjectConstant.KEY_SID))) {
//                processSuccess = true;
//            }
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.INITIAL_CONNECTION_ERROR_CODE_SERVICE_VALIDATION_EXCEPTION;
//            }
//
//        } catch (Exception e) {
//
//            errorCode = ProjectConstant.INITIAL_CONNECTION_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                data.setSid(inputMap.get(ProjectConstant.KEY_SID));
//
//                if (ProjectConstant.STATUS_Y.equals(messageSource.getMessage(ProjectConstant.KEY_SECURITY_ENCRYPT_TRANSFER_DATA_ACTIVE, null, null))) {
//                    data.setPublicKey(inputMap.get(ProjectConstant.KEY_PUBLIC_KEY));
//                    systemLogger.info(LogFormatter.info(data.getSid(), "- SECURITY-ENCRYPT = TRUE "));
//                } else {
//                    data.setPublicKey(null);
//                    systemLogger.info(LogFormatter.info(data.getSid(), "- SECURITY-ENCRYPT = FALSE "));
//                }
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//
//                if (StringUtils.isNotEmptyOrNull(errorCode)) {
//                    errorMessage = MasterUtils.findErrorDesc(errorCode, requestObj.getLanguage());
//                } else {
//                    errorCode = ProjectConstant.INITIAL_CONNECTION_ERROR_CODE_SERVICE_EXCEPTION;
//                }
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), requestObj.getSid(), null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//        return response;
//    }
//
//    @PostMapping("/verifyLogin")
//    public VerifyLoginResponseRESTModel verifyLogin(HttpServletRequest httpRequest) throws Exception {
//        VerifyLoginResponseRESTModel response = new VerifyLoginResponseRESTModel();
//        VerifyLoginResultRESTModel data = new VerifyLoginResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        String rqSid = (String) httpRequest.getAttribute(ProjectConstant.KEY_SID);
//        String rqLanguage = (String) httpRequest.getAttribute(ProjectConstant.KEY_LANGUAGE);
//        VerifyLoginRequestRESTModel request = null;
//
//        systemLogger.info(LogFormatter.common(rqSid, "- sid=" + rqSid + ", language=" + rqLanguage));
//
//        try {
//
//            request = (VerifyLoginRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, VerifyLoginRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(rqSid) ? new BigInteger(rqSid) : null;
//            VerifyLoginRequestDataRESTModel requestData = request.getData();
//
//            data = loginManagementService.verifyLogin(sid, rqLanguage, requestData.getVerifyOption(), requestData.getEmail(), requestData.getJack(), requestData.getToken());
//
//            processSuccess = true;
//
//        } catch (DatabaseException e) {
//
//            errorCode = ProjectConstant.LOGIN_MANAGEMENT_VERIFY_LOGIN_ERROR_CODE_DATABASE_EXCRPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ExternalConnectionException e) {
//
//            errorCode = ProjectConstant.LOGIN_MANAGEMENT_VERIFY_LOGIN_ERROR_CODE_EXTERNAL_CONNECTION_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.LOGIN_MANAGEMENT_VERIFY_LOGIN_ERROR_CODE_SERVICE_VALIDATION_EXCEPTION;
//            }
//
//        } catch (Exception e) {
//
//            errorCode = ProjectConstant.LOGIN_MANAGEMENT_VERIFY_LOGIN_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
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
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid(), null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getEmployeeList")
//    public GetEmployeeListResponseRESTModel getEmployeeList(HttpServletRequest httpRequest) throws Exception {
//        GetEmployeeListResponseRESTModel response = new GetEmployeeListResponseRESTModel();
//        GetEmployeeListResultRESTModel data = new GetEmployeeListResultRESTModel();
//        List<Uid> uidList = new ArrayList<Uid>();
//        Uid uid = new Uid();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetEmployeeListRequestRESTModel request = null;
//
//        try {
//
//            request = (GetEmployeeListRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetEmployeeListRequestRESTModel.class);
//
//            if (request.getData() == null) {
//                systemLogger.info(LogFormatter.info("- REQUEST DATA IS EMPTY."));
//                throw new ServiceValidation(ProjectConstant.EMPLOYEE_MANAGEMENT_GET_EMPLOYEE_LIST_ERROR_CODE_SERVICE_EXCEPTION);
//            }
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = employeeManagementService.getEmployeeList(sid, request.getLanguage(), request.getData().getSortBy(), request.getData().getSearchValue(), request.getData().getDepartment(), request.getData().getDivision(), request.getData().getFavouriteFlag(), request.getData().getIndex());
//
//            response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            response.setData(data);
//
//            processSuccess = true;
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_EMPLOYEE_LIST_ERROR_CODE_SERVICE_VALIDATION_EXCEPTION;
//            }
//
//        } catch (Exception e) {
//
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_EMPLOYEE_LIST_ERROR_CODE_SERVICE_EXCEPTION;
//
//        } finally {
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//        return response;
//    }
//
//    @PostMapping("/updateEmployeeFavourite")
//    public UpdateEmployeeFavouriteResponseRestModel updateEmployeeFavourite(HttpServletRequest httpRequest) throws Exception {
//        UpdateEmployeeFavouriteResponseRestModel response = null;
//        UpdateEmployeeFavouriteResultRestModel data = null;
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        UpdateEmployeeFavouriteRequestRestModel request = null;
//
//        try {
//
//            request = (UpdateEmployeeFavouriteRequestRestModel) JSONUtil.transformStringToVO(jsonInput, UpdateEmployeeFavouriteRequestRestModel.class);
//
//            //insert business below
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            response = employeeManagementService.updateEmployeeFavourite(sid, request.getData().getUpdateOption(), request.getData().getUidFavourite());
//
//            response.setData(data);
//            processSuccess = true;
//
//        } catch (DatabaseException e) {
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_UPDATE_EMPLOYEE_FAVOURITE_ERROR_CODE_DATA_BASE_EXCEPTION;
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } catch (ServiceValidation e) {
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_UPDATE_EMPLOYEE_FAVOURITE_ERROR_CODE_SERVICE_VALIDATION;
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (InternalValidationException e) {
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_UPDATE_EMPLOYEE_FAVOURITE_UPDATE_OPTION_ERROR_CODE_SERVICE_VALIDATION;
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_UPDATE_EMPLOYEE_FAVOURITE_ERROR_CODE_SERVICE_EXCEPTION;
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//            } else {
//                response = new UpdateEmployeeFavouriteResponseRestModel();
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//                response.setData(data);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getUpdateContent")
//    public GetUpdateContentResponseRESTModel getUpdateContent(HttpServletRequest httpRequest) throws Exception {
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        GetUpdateContentResponseRESTModel response = new GetUpdateContentResponseRESTModel();
//        String errorCode = null;
//        String errorMessage = null;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetUpdateContentRequestRESTModel request = null;
//
//        try {
//
//            request = (GetUpdateContentRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetUpdateContentRequestRESTModel.class);
//
//            response = contentManagementService.getContentLabel(request.getData().getLabelDate(), request.getData().getErrorDate());
//
//            processSuccess = true;
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.CONTENT_MANAGEMENT_GET_UPDATE_CONTENT_ERROR_CODE_VALIDATION_EXCEPTION;
//            }
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.CONTENT_MANAGEMENT_GET_UPDATE_CONTENT_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
////              insertTransactionIn 
////              transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//
//        return response;
//    }
//
//    @PostMapping("/getCountEmployee")
//    public GetCountEmployeeResponseRestModel getCountEmployee(HttpServletRequest httpRequest) throws Exception {
//        GetCountEmployeeResponseRestModel response = new GetCountEmployeeResponseRestModel();
//        GetCountEmployeeResultRestModel data = new GetCountEmployeeResultRestModel();
//        String errorCode = null;
//        String errorMessage = null;
//
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        int rowPerPage = 10;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetCountEmployeeRequestRestModel request = null;
//
//        try {
//
//            request = (GetCountEmployeeRequestRestModel) JSONUtil.transformStringToVO(jsonInput, GetCountEmployeeRequestRestModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = employeeManagementService.getCountEmployee(sid, request.getData().getIndex(), request.getData().getSortBy(), request.getData().getDepartment(), request.getData().getDivision(), rowPerPage, request.getLanguage());
//
//            response.setData(data);
//            response.getErrorCode();
//            response.getErrorMessage();
//            response.getResponseStatus();
//
//            if (data != null) {
//                processSuccess = true;
//            }
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_COUNT_EMPLOYEE_ERROR_CODE_SERVICE_VALIDATION_SORTBY;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_COUNT_EMPLOYEE_ERROR_CODE_SERVICE_EXCEPTION;
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getDashBoard")
//    public GetDashBoardResponseRESTModel getDashBoard(HttpServletRequest httpRequest) throws Exception {
//        GetDashBoardResponseRESTModel response = new GetDashBoardResponseRESTModel();
//        GetDashBoardResultRESTModel data = null;
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetDashBoardRequestRESTModel request = null;
//
//        try {
//
//            request = (GetDashBoardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetDashBoardRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = dashBoardManagementService.getDashBoard(sid, request.getLanguage(), request.getData().getUrlDate());
//
//            response.setData(data);
//
//            processSuccess = true;
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_GET_DASHBOARD_ERROR_CODE_EXTERNAL_VALIDATION_EXCEPTION;
//            }
//        } catch (Exception e) {
//            errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_GET_DASHBOARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//
//                if (StringUtils.isNotEmptyOrNull(errorCode)) {
//                    errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                }
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/updateProfile")
//    public UpdateProfileResponseRESTModel updateProfile(HttpServletRequest httpRequest) throws Exception {
//
//        UpdateProfileResponseRESTModel response = new UpdateProfileResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        UpdateProfileRequestRESTModel request = null;
//
//        try {
//
//            request = (UpdateProfileRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, UpdateProfileRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
////            response = dashBoardManagementService.UpdateDashBoard(sid, request.getData().getMenuIndex());
//            response = profileManagementService.updateProfile(sid, request.getData().getUpdateOption(), request.getData().getStatusEmotion(), request.getData().getIndexEmotion(), request.getData().getMobilePhoneNo(), request.getData().getLineId(), request.getData().getPictureURL());
//
//            processSuccess = true;
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.PROFILE_MANAGEMENT_UPDATE_PROFILE_ERROR_CODE_SERVICE_EXCEPTION;
//            }
//
//        } catch (DatabaseException e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.PROFILE_MANAGEMENT_UPDATE_PROFILE_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid(), null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/updateDashBoard")
//    public UpdateDashBoardResponseRESTModel updateDashBoard(HttpServletRequest httpRequest) throws Exception {
//
//        UpdateDashBoardResponseRESTModel response = new UpdateDashBoardResponseRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        UpdateDashBoardRequestRESTModel request = null;
//        String errorCode = null;
//        String errorMessage = null;
//
//        try {
//
//            request = (UpdateDashBoardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, UpdateDashBoardRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            systemLogger.info(LogFormatter.info("MenuIndex request=" + request.getData().getIndexDashboard()));
//            response = dashBoardManagementService.UpdateDashBoard(sid, request.getData().getIndexDashboard());
//
//            processSuccess = true;
//        } catch (InternalConnectionException e) {
//            errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_UPDATE_DASHBOARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (InternalValidationException e) {
//            errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_UPDATE_DASHBOARD_ERROR_CODE_INTERNAL_VALIDATION_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ServiceValidation e) {
//            errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_UPDATE_DASHBOARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.DASHBOARD_MANAGEMENT_UPDATE_DASHBOARD_ERROR_CODE_SERVICE_EXCEPTION;
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//
//                if (StringUtils.isNotEmptyOrNull(errorCode)) {
//                    errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                }
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/extendSession")
//    public ExtendSessionResponseRESTModel extendSession(HttpServletRequest httpRequest) throws Exception {
//        ExtendSessionResponseRESTModel response = new ExtendSessionResponseRESTModel();
//
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        ExtendSessionRequestRESTModel request = null;
//
//        try {
//
//            request = (ExtendSessionRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, ExtendSessionRequestRESTModel.class);
//
//            //insert business below
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            sessionLoginService.extendSessionTimeout(sid);
//            //dummy data
//            processSuccess = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getProfile")
//    public GetProfileResponseRESTModel getProfile(HttpServletRequest httpRequest) throws Exception {
//        GetProfileResponseRESTModel response = new GetProfileResponseRESTModel();
//        GetProfileResultRESTModel data = new GetProfileResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetProfileRequestRESTModel request = null;
//
//        try {
//
//            request = (GetProfileRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetProfileRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = profileManagementService.getProfile(sid, request.getData().getDateRequest(), request.getData().getUid(), request.getLanguage());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.PROFILE_MANAGEMENT_GET_PROFILE_ERROR_CODE_SERVICE_VALIDATION;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.PROFILE_MANAGEMENT_GET_PROFILE_ERROR_CODE_SERVICE_EXCEPTIONL;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getUserReward")
//    public GetUserRewardResponseRESTModel getUserReward(HttpServletRequest httpRequest) throws Exception {
//        GetUserRewardResponseRESTModel response = new GetUserRewardResponseRESTModel();
//        GetUserRewardResultRESTModel data = new GetUserRewardResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetUserRewardRequestRESTModel request = null;
//
//        try {
//
//            request = (GetUserRewardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetUserRewardRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getUserRewardService.getUserReward(sid, request.getLanguage());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (ServiceValidation e) {
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_USER_REWARD_ERROR_CODE_SERVICE_VALIDATION;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_USER_REWARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
/////               response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/getTransactionGiveStar")
//    public GetTransactionGiveStarResponseRESTModel getTransactionGiveStar(HttpServletRequest httpRequest) throws Exception {
//        GetTransactionGiveStarResponseRESTModel response = new GetTransactionGiveStarResponseRESTModel();
//        GetTransactionGiveStarResultRESTModel data = new GetTransactionGiveStarResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetTransactionGiveStarRequestRESTModel request = null;
//        int rowPerPage = 10;
//
//        try {
//
//            request = (GetTransactionGiveStarRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetTransactionGiveStarRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            int index = StringUtils.isNotEmptyOrNull(request.getData().getIndex()) ? new Integer(request.getData().getIndex()) : 0;
//            data = transactionGiveStarService.GetTransactionGiveStar(sid, request.getData().getGetTranOption(), request.getData().getUid(), request.getData().getDepartment(), request.getData().getDivision(), index, rowPerPage, request.getLanguage());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_TRANSACTION_GIVE_STAR_ERROR_CODE_SERVICE_VALIDATION_NOOPTION;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_TRANSACTION_GIVE_STAR_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getGiveStarReason")
//    public GetGiveStarReasonResponseRESTModel getGiveStarReason(HttpServletRequest httpRequest) throws Exception {
//        GetGiveStarReasonResponseRESTModel response = new GetGiveStarReasonResponseRESTModel();
//        GetGiveStarReasonResultRESTModel data = null;
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetDashBoardRequestRESTModel request = null;
//
//        try {
//            request = (GetDashBoardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetDashBoardRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = giveStarManagementService.getGiveStarReason(sid, request.getLanguage());
//
//            response.setData(data);
//
//            processSuccess = true;
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.GET_GIVE_STAR_REASON_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//
//                if (StringUtils.isNotEmptyOrNull(errorCode)) {
//                    errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                }
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//
//            }
//        }
//        return response;
//    }
//
//    @PostMapping("/getExchangeStar")
//    public GetExchangeStarResponseRESTModel getExchangeStar(HttpServletRequest httpRequest) throws Exception {
//        GetExchangeStarResponseRESTModel response = new GetExchangeStarResponseRESTModel();
//        GetExchangeStarResultRESTModel data = new GetExchangeStarResultRESTModel();
//        String errorCode = null;
//        String errorMessage = null;
//
//        Date startDate = new Date();
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetExchangeStarRequestRESTModel request = null;
//
//        try {
//
//            request = (GetExchangeStarRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetExchangeStarRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = exchangeStarManagementService.getExchangeStar(sid, request.getLanguage());
//
//            response.setData(data);
//            response.getErrorCode();
//            response.getErrorMessage();
//            response.getResponseStatus();
//
//            if (data != null) {
//                processSuccess = true;
//            }
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_COUNT_EMPLOYEE_ERROR_CODE_SERVICE_VALIDATION_SORTBY;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            errorCode = ProjectConstant.EMPLOYEE_MANAGEMENT_GET_COUNT_EMPLOYEE_ERROR_CODE_SERVICE_EXCEPTION;
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//
//    }
//
//    @PostMapping("/getReward")
//
//    public GetRewardResponseRESTModel getReward(HttpServletRequest httpRequest) throws Exception {
//        GetRewardResponseRESTModel response = new GetRewardResponseRESTModel();
//        GetRewardResultRESTModel data = new GetRewardResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetRewardRequestRESTModel request = null;
//
//        try {
//
//            request = (GetRewardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetRewardRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getRewardManagementService.getReward(sid, request.getLanguage(), request.getData().getShowDateFlag());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (InternalConnectionException e) {
//            errorCode = ProjectConstant.GET_REWARD_ERROR_CODE_INTERNAL_CONNECTION_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (InternalValidationException e) {
//            errorCode = ProjectConstant.GET_REWARD_ERROR_CODE_INTERNAL_VALIDATION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_REWARD_ERROR_CODE_INTERNAL_VALIDATION;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_REWARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//            return response;
//
//        }
//
//    }
//
//    @PostMapping("/getUsedReward")
//    public GetUsedRewardResponseRESTModel getUsedReward(HttpServletRequest httpRequest) throws Exception {
//        GetUsedRewardResponseRESTModel response = new GetUsedRewardResponseRESTModel();
//        GetUsedRewardResultRESTModel data = new GetUsedRewardResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetUsedRewardRequestRESTModel request = null;
//
//        try {
//
//            request = (GetUsedRewardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetUsedRewardRequestRESTModel.class);
//
//            if (request.getData() == null) {
//                systemLogger.info(LogFormatter.info("- REQUEST DATA IS EMPTY."));
//                throw new ServiceValidation();
//            }
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getUsedRewardService.getUsedReward(sid, request.getLanguage(), request.getData().getRewardQRCode());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (ServiceValidation e) {
//            errorCode = ProjectConstant.GET_USED_REWARD_ERROR_CODE_SERVICE_VALIDATION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (DatabaseException e) {
//            errorCode = ProjectConstant.GET_USED_REWARD_ERROR_CODE_DATABASE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.GET_USED_REWARD_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/transactionRedeem")
//    public TransactionRedeemResponseRESTModel transactionRedeem(HttpServletRequest httpRequest) throws Exception {
//        TransactionRedeemResponseRESTModel response = new TransactionRedeemResponseRESTModel();
//        TransactionRedeemResultRESTModel data = null;
//        Date startDate = new Date();
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        TransactionRedeemRequestRESTModel request = null;
//
//        try {
//
//            request = (TransactionRedeemRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionRedeemRequestRESTModel.class);
//            TransactionRedeemRequestDataRESTModel requestData = request != null ? request.getData() : null;
//
//            if (requestData != null && StringUtils.isNotEmptyOrNull(requestData.getRewardID())) {
//
//                BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//                VerifyTransactionRedeem verifyTransactionRedeem = redeemManagementService.verifyTransactionRedeem(sid, request.getLanguage(), request.getData().getRewardID());
//                if (verifyTransactionRedeem != null) {
//                    data = redeemManagementService.transactionRedeem(sid, request.getLanguage(), verifyTransactionRedeem);
//                }
//
//                response.setData(data);
//                processSuccess = true;
//
//            } else {
//                systemLogger.info(LogFormatter.common("- Invalid request."));
//                throw new ServiceValidation();
//            }
//        } catch (DatabaseException e) {
//            errorCode = ProjectConstant.REDEEM_MANAGEMENT_ERROR_CODE_DATABASE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//
//        } catch (ServiceValidation e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_REDEEM_ERROR_CODE_SERVICE_VALIDATION;
//            }
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.REDEEM_MANAGEMENT_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/getUserStar")
//    public GetUserStarResponseRESTModel getUserStar(HttpServletRequest httpRequest) throws Exception {
//        GetUserStarResponseRESTModel response = new GetUserStarResponseRESTModel();
//        GetUserStarResultRESTModel data = new GetUserStarResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetUserStarRequestRESTModel request = null;
//
//        try {
//
//            request = (GetUserStarRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetUserStarRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getUserManagementService.getUserStar(sid, request.getData().getUid());
//
//            response.setData(data);
//
//            processSuccess = true;
//        } catch (DatabaseException e) {
//            errorCode = ProjectConstant.GET_USER_STAR_ERROR_CODE_DATA_BASE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_USER_STAR_ERROR_CODE_SERVICE_VALIDATION;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_USER_STAR_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/transactionGiveStar")
//    public TransactionGiveStarResponseRESTModel transactionGiveStar(HttpServletRequest httpRequest) throws Exception {
//        TransactionGiveStarResponseRESTModel response = new TransactionGiveStarResponseRESTModel();
//        TransactionGiveStarResultRESTModel data = null;
//        Date startDate = new Date();
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        TransactionGiveStarRequestRESTModel request = null;
//
//        try {
//
//            request = (TransactionGiveStarRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionGiveStarRequestRESTModel.class);
//            TransactionGiveStarRequestDataRESTModel requestData = request != null ? request.getData() : null;
//
//            if (requestData != null && StringUtils.isNotEmptyOrNull(requestData.getUidReceive()) && StringUtils.isNotEmptyOrNull(requestData.getGiveStarType()) && StringUtils.isNotEmptyOrNull(requestData.getGiveStarAmount()) && StringUtils.isNotEmptyOrNull(requestData.getGiveTypeID()) && StringUtils.isNotEmptyOrNull(requestData.getGiveReasonID())) {
//
//                BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//                VerifyTransactionGiveStar verifyTransactionGiveStar = giveStarManagementService.verifyTransactionGiveStar(sid, request.getLanguage(), request.getData().getUidReceive(), request.getData().getGiveStarType(), request.getData().getGiveStarAmount(), request.getData().getGiveTypeID(), request.getData().getGiveReasonID(), request.getData().getGiveReasonOther());
//                if (verifyTransactionGiveStar != null) {
//                    data = giveStarManagementService.transactionGiveStar(sid, request.getLanguage(), verifyTransactionGiveStar);
//                }
//                response.setData(data);
//                processSuccess = true;
//            } else {
//                systemLogger.info(LogFormatter.common("- Invalid request."));
//                throw new ServiceValidation(ProjectConstant.TRANSACTION_GIVE_STAR_ERROR_CODE_SERVICE_VALIDATION);
//            }
//        } catch (DatabaseException e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//
//        } catch (ServiceValidation e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_GIVE_STAR_ERROR_CODE_SERVICE_VALIDATION;
//            }
//        } catch (Exception e) {
//            errorCode = ProjectConstant.TRANSACTION_GIVE_STAR_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/transactionUsedReward")
//    public TransactionUsedRewardResponseRESTModel transactionUsedReward(HttpServletRequest httpRequest) throws Exception {
//        TransactionUsedRewardResponseRESTModel response = new TransactionUsedRewardResponseRESTModel();
//        TransactionUsedRewardResultRESTModel data = new TransactionUsedRewardResultRESTModel();
//        TransactionUsedRewardRequestRESTModel request = null;
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        try {
//            request = (TransactionUsedRewardRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionUsedRewardRequestRESTModel.class);
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            VerifyTransactionUsedReward verifyTransactionUsedReward = usedRewardManagementService.verifyTransactionUsedReward(sid, request.getData().getRewardQRCode(), request.getLanguage());
//            if (verifyTransactionUsedReward.getRewardId() != null && verifyTransactionUsedReward.getRewardamount() != null) {
//                data = usedRewardManagementService.transactionUsedReward(sid, request.getLanguage(), verifyTransactionUsedReward);
//            }
//            response.setData(data);
//            processSuccess = true;
//        } catch (DatabaseException e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        } catch (ServiceValidation e) {
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_USED_REWARD_ERROR_CODE_SERVICE_VALIDATION_NOT_REWARD;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.PROFILE_MANAGEMENT_GET_PROFILE_ERROR_CODE_SERVICE_EXCEPTIONL;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
////            insertTransactionIn
////            transactionInService.insertTransactionIn(transactionIn);
//        }
//        return response;
//
//    }
//
//    @PostMapping("/transactionExchangeStar")
//    public TransactionExchangeStarResponseRESTModel transactionExchangeStar(HttpServletRequest httpRequest) throws Exception {
//        TransactionExchangeStarResponseRESTModel response = new TransactionExchangeStarResponseRESTModel();
//        TransactionExchangeStarResultRESTModel data = null;
//        TransactionExchangeStarRequestRESTModel request = null;
//
//        Date startDate = new Date();
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//
//        try {
//
//            request = (TransactionExchangeStarRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionExchangeStarRequestRESTModel.class);
//            TransactionExchangeStarRequestDataRESTModel requestData = request != null ? request.getData() : null;
//
//            if (requestData != null && StringUtils.isNotEmptyOrNull(requestData.getGoldStar()) | StringUtils.isNotEmptyOrNull(requestData.getSilverStar())) {
//
//                BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//                VerifyTransactionExchangeStar verifyTransactionExchangeStar = exchangeStarManagementService.verifyTransactionExchangeStar(sid, request.getLanguage(), request.getData().getGoldStar(), request.getData().getSilverStar());
//                if (verifyTransactionExchangeStar != null) {
//                    data = exchangeStarManagementService.transactionExchangeStar(sid, request.getLanguage(), verifyTransactionExchangeStar);
//                }
//
//                response.setData(data);
//                processSuccess = true;
//
//            } else {
//                systemLogger.info(LogFormatter.common("- Invalid request."));
//                throw new ServiceValidation();
//            }
//        } catch (DatabaseException e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        } catch (ServiceValidation e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_EXCHANGE_ERROR_CODE_SERVICE_VALIDATION_VERIFY_PATTERN;
//            }
//        } catch (Exception e) {
//            errorCode = ProjectConstant.TRANSACTION_EXCHANGE_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/transactionCancelBookingRoom")
//    public TransactionCancelBookingRoomResponseRESTModel transactionCancelBookingRoom(HttpServletRequest httpRequest) throws Exception {
//        TransactionCancelBookingRoomResponseRESTModel response = new TransactionCancelBookingRoomResponseRESTModel();
//        TransactionCancelBookingRoomResultRESTModel data = null;
//        Date startDate = new Date();
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        TransactionCancelBookingRoomRequestRESTModel request = null;
//
//        try {
//
//            request = (TransactionCancelBookingRoomRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionCancelBookingRoomRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            VerifyTransactionCancelBookingRoom verifyTransactionCancelBookingRoom = transactionCancelBookingRoomService.verifyTransactionCancelBookingRoom(sid, request.getLanguage(), request.getData().getTransactionID());
//
//            if (verifyTransactionCancelBookingRoom.getUid() != null && verifyTransactionCancelBookingRoom.getRoomId() != null && verifyTransactionCancelBookingRoom.getTranIdgen() != null && verifyTransactionCancelBookingRoom.getBookingStatus() != null) {
//
//                data = transactionCancelBookingRoomService.transactionCancelBookingRoom(sid, request.getLanguage(), verifyTransactionCancelBookingRoom);
//
//            } else {
//                systemLogger.info(LogFormatter.common("- Verify request fail : Detail = ." + verifyTransactionCancelBookingRoom));
//                throw new ServiceValidation();
//
//            }
//
//            response.setData(data);
//            processSuccess = true;
//        } catch (DatabaseException e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        } catch (ServiceValidation e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_CANCEL_BOOKING_ROOM_ERROR_CODE_SERVICE_VALIDATION_TRAN_ID;
//            }
//        } catch (Exception e) {
//            errorCode = ProjectConstant.TRANSACTION_CANCEL_BOOKING_ROOM_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
//
//    @PostMapping("/getSearchMeetingRoom")
//    public GetSearchMeetingRoomResponseRestModel getSearchMeetingRoomResponseRestModel(HttpServletRequest httpRequest) throws Exception {
//        GetSearchMeetingRoomResponseRestModel response = new GetSearchMeetingRoomResponseRestModel();
//        GetSearchMeetingRoomResultModel data = new GetSearchMeetingRoomResultModel();
//        String errorCode = null;
//        String errorMessage = null;
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        int rowPerPage = 10;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetSearchMeetingRoomRequestRestModel request = null;
//        try {
//            request = (GetSearchMeetingRoomRequestRestModel) JSONUtil.transformStringToVO(jsonInput, GetSearchMeetingRoomRequestRestModel.class);
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//            data = getSearchMeetingRoomService.getSearchMeetingRoom(sid, request.getLanguage(), request.getData().getBuildingID(), request.getData().getNumberOfAttendees(), request.getData().getTimeBookingFrom(), request.getData().getTimeBookingTo(), request.getData().getProjecter(), request.getData().getMonitor(), request.getData().getVDOConference(), request.getData().getWhiteboard(), request.getData().getIndex());
//            response.setData(data);
//            response.getErrorCode();
//            response.getErrorMessage();
//            response.getResponseStatus();
//            if (data != null) {
//                processSuccess = true;
//            }
//        } catch (ServiceValidation e) {
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.GET_SEARCH_MEETING_ROOM_ERROR_CODE_SERVICE_VALIDATION_BUIDING_ID_INCORRECT;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            errorCode = ProjectConstant.GET_SEARCH_MEETING_ROOM_ERROR_CODE_SERVICE_EXCEPTION;
//        } finally {
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid().toString() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//        return response;
//    }
//
//    @PostMapping("/getBuildingMeeting")
//
//    public GetBuildingMeetingResponseRESTModel getBuildingMeeting(HttpServletRequest httpRequest) throws Exception {
//        GetBuildingMeetingResponseRESTModel response = new GetBuildingMeetingResponseRESTModel();
//        GetBuildingMeetingResultRESTModel data = new GetBuildingMeetingResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetBuildingMeetingRequestRESTModel request = null;
//
//        try {
//
//            request = (GetBuildingMeetingRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetBuildingMeetingRequestRESTModel.class);
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getBuildingMeetingManagementService.getBuildingMeeting(sid, request.getLanguage());
//
//            response.setData(data);
//
//            processSuccess = true;
//
//        } catch (InternalConnectionException e) {
//            errorCode = ProjectConstant.GET_BUILDING_MEETING_ERROR_CODE_INTERNAL_CONNECTION_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_BUILDING_MEETING_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//        return response;
//
//    }
//
//    @PostMapping("/getHisMeetingRoom")
//    public GetHistMeetingRoomResponseRESTModel getHisMeetingRoom(HttpServletRequest httpRequest) throws Exception {
//        GetHistMeetingRoomResponseRESTModel response = new GetHistMeetingRoomResponseRESTModel();
//        GetHistMeetingRoomResultRESTModel data = new GetHistMeetingRoomResultRESTModel();
//        Date startDate = new Date();
//        boolean processSuccess = false;
//        String errorCode = null;
//        String errorMessage = null;
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        GetHistMeetingRoomRequestRESTModel request = null;
//
//        int rowPerpage = 10;
//
//        try {
//
//            request = (GetHistMeetingRoomRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, GetHistMeetingRoomRequestRESTModel.class
//            );
//
//            BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//            data = getHisMeetingRoomManagementService.getHistMeetingRoom(sid, request.getLanguage(), request.getData().getIndex(), rowPerpage);
//
//            response.setData(data);
//
//            processSuccess = true;
//
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
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorCode = ProjectConstant.GET_HIS_MEETING_ROOM_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//
//        }
//        return response;
//    }
//
//    @PostMapping("/transactionBookingRoom")
//    public TransactionBookingRoomResponseRESTModel transactionBookingRoom(HttpServletRequest httpRequest) throws Exception {
//        TransactionBookingRoomResponseRESTModel response = new TransactionBookingRoomResponseRESTModel();
//        TransactionBookingRoomResultRESTModel data = null;
//        Date startDate = new Date();
//        String errorCode = null;
//        String errorMessage = null;
//        boolean processSuccess = false;
//
//        String jsonInput = (String) httpRequest.getAttribute(ProjectConstant.KEY_JSON_INPUT_DATA);
//        TransactionBookingRoomRequestRESTModel request = null;
//
//        try {
//
//            request = (TransactionBookingRoomRequestRESTModel) JSONUtil.transformStringToVO(jsonInput, TransactionBookingRoomRequestRESTModel.class
//            );
//            TransactionBookingRoomRequestDataRESTModel requestData = request != null ? request.getData() : null;
//
//            if (requestData != null) {
//
//                BigInteger sid = StringUtils.isNotEmptyOrNull(request.getSid()) ? new BigInteger(request.getSid()) : null;
//
//                VerifyTransactionBookingRoom verifyTransactionBookingRoom = bookingRoomManagementService.verifyTransactionBookingRoom(sid, request.getLanguage(), request.getData().getRoomId(), request.getData().getTimeBookingFrom(), request.getData().getTimeBookingTo(), request.getData().getUidOfAttendees(), request.getData().getTopicMeeting());
//                if (verifyTransactionBookingRoom != null) {
//                    data = bookingRoomManagementService.transactionBookingRoom(sid, request.getLanguage(), verifyTransactionBookingRoom);
//                }
//
//                response.setData(data);
//                processSuccess = true;
//
//            } else {
//                systemLogger.info(LogFormatter.common("- Invalid request."));
//                throw new ServiceValidation();
//            }
//        } catch (DatabaseException e) {
//            errorCode = ProjectConstant.TRANSACTION_BOOKING_ROOM_ERROR_CODE_DATABASE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//
//        } catch (ServiceValidation e) {
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//            if (StringUtils.isNotEmptyOrNull(e.getMessage())) {
//                errorCode = e.getMessage();
//            } else {
//                errorCode = ProjectConstant.TRANSACTION_REDEEM_ERROR_CODE_SERVICE_VALIDATION;
//            }
//
//        } catch (Exception e) {
//            errorCode = ProjectConstant.TRANSACTION_BOOKING_ROOM_ERROR_CODE_SERVICE_EXCEPTION;
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//
//        } finally {
//
//            if (processSuccess) {
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS);
//                response.setData(data);
//
//            } else {
//                errorMessage = MasterUtils.findErrorDesc(errorCode, request.getLanguage());
//
//                response.setResponseStatus(ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE);
//                response.setErrorCode(errorCode);
//                response.setErrorMessage(errorMessage);
//            }
//
//            accessLogger.info(LogFormatter.accessLog(startDate, new Date(), request.getSid() != null ? request.getSid() : null, null, processSuccess ? ProjectConstant.REST_SERVICE_RESPONSE_STATUS_SUCCESS : ProjectConstant.REST_SERVICE_RESPONSE_STATUS_FAILURE, request, response));
//        }
//
//        return response;
//    }
}
