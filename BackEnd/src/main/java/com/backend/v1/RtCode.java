package com.backend.v1;

import org.springframework.http.HttpStatus;

public enum RtCode {
    // 2XX SUCCESS Cases - Commons
	RT_SUCCESS("A200000", HttpStatus.OK, "Request Success"),
	RT_EXECUTED("A200001", HttpStatus.CREATED, "Request Executed"),

    // 4XX Error Cases
	RT_PARAMETER_ERROR("A400000", HttpStatus.INTERNAL_SERVER_ERROR, "Parameter Error"),
	RT_PARAMETER_EMPTY("A400001", HttpStatus.INTERNAL_SERVER_ERROR, "Parameter is empty"),
	RT_PARAMETER_LIMIT_NOT_ZERO("A400002", HttpStatus.INTERNAL_SERVER_ERROR, "Page size must not be less than one!"),
	RT_PARAMETER_POWER_CHAR("A100003", HttpStatus.INTERNAL_SERVER_ERROR, "Parameter contains special power char"),
	RT_PARAMETER_USERNAME_CHAR("A100004", HttpStatus.INTERNAL_SERVER_ERROR, "User Name Parameter contains special character"),
	RT_PARAMETER_USERNAME_LENGTH("A100005", HttpStatus.INTERNAL_SERVER_ERROR, "User Name Parameter exceed limited size"),
	RT_PARAMETER_CELL_PHONE_LENGTH("A100006", HttpStatus.INTERNAL_SERVER_ERROR, "User Cell phone number Parameter exceed limited size"),
	RT_NOT_FOUND("A400004", HttpStatus.NOT_FOUND, "Not Found Resource"),
	RT_LOGIN_USER_NOT_FOUND("A400100", HttpStatus.INTERNAL_SERVER_ERROR, "Request User Not Found"),
	RT_LOGIN_PASSWORD_WRONG("A400101", HttpStatus.INTERNAL_SERVER_ERROR, "Wrong Password"),
	RT_USER_NOT_FOUND("A400102", HttpStatus.INTERNAL_SERVER_ERROR, "Request User Not Found"),
	RT_USER_RESETPASSWORD_USER_NOT_FOUND("A400103", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is Not Found"),
	RT_LOGIN_SNS_USER_NOT_FOUND("A400104", HttpStatus.INTERNAL_SERVER_ERROR, "Request SNS User Not Found"),
	RT_LOGIN_BIZ_STATUS_APPLY("A400105", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is under biz membership"),
	RT_LOGIN_BIZ_STATUS_REJECT("A400106", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is review reject"),
	RT_LOGIN_BIZ_STATUS_HOLD("A400107", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is review hold"),
	RT_TOKEN_INVALID("A400200", HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Token"),
	RT_TOKEN_EXPIRED("A400201", HttpStatus.INTERNAL_SERVER_ERROR, "Token Expired"),
	RT_TOKEN_OLD("A400202", HttpStatus.INTERNAL_SERVER_ERROR, "Old Token"),
	RT_USER_LOGO_PERMISSION_ERROR("A400203", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is logo permission error."),
	RT_USER_LOGO_DELETE_ERROR("A400204", HttpStatus.INTERNAL_SERVER_ERROR, "Request logo image delete error."),
	RT_PARAMETER_LOGO_IMAGE_NO_FILE_SELECT("A400205", HttpStatus.BAD_REQUEST, "User Logo Image is no file selected"),
	RT_USER_LOGO_IMAGE_LIMIT_ERROR("A400206", HttpStatus.BAD_REQUEST, "User Logo Image exceed limited size."),
	RT_USER_LOGO_IMAGE_EXTENSION_ERROR("A400207", HttpStatus.BAD_REQUEST, "User Logo Image not allow extension."),
	RT_USER_BOOKMARK_DESIGN_PERMISSION_ERROR("A400208", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is design bookmark permission error."),
	RT_PARAMETER_TEMPLATE_NAME_CHAR("A400209", HttpStatus.INTERNAL_SERVER_ERROR, "Template Name Parameter contains special character"),
	RT_USER_BOOKMARK_DESIGN_NOT_FOUND("A400210", HttpStatus.INTERNAL_SERVER_ERROR, "Request item not found."),
	RT_USER_BOOKMARK_DESIGN_DELETE_ERROR("A400211", HttpStatus.INTERNAL_SERVER_ERROR, "Request item delete error."),
	RT_USER_BOOKMARK_DESIGN_MODIFY_ERROR("A400212", HttpStatus.INTERNAL_SERVER_ERROR, "Request item name modify error."),
	RT_USER_LOGO_NOT_FOUND("A400213", HttpStatus.INTERNAL_SERVER_ERROR, "Request Logo Image not found."),
	RT_USER_EMAIL_RECEIVE_ERROR("A400214", HttpStatus.INTERNAL_SERVER_ERROR, "Request email address receive error."),


	// 5XX Error Cases Common
	RT_INTERNAL_ERROR("A500000", HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error"),

	RT_LOGIN_USER_DELETE("A500100", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is Deleted"),
	RT_USER_WRONG_PASSWORD("A500101", HttpStatus.INTERNAL_SERVER_ERROR, "Wrong Password"),
	RT_USER_JOIN_DUPLICATED_ID("A500102", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Id is duplicated"),
	RT_USER_JOIN_DUPLICATED_SNS("A500103", HttpStatus.INTERNAL_SERVER_ERROR, "Requested SNS Account is duplicated"),
	RT_USER_ALREADY_MEMBER("A500104", HttpStatus.INTERNAL_SERVER_ERROR, "Already a member"),
	RT_USER_JOIN_DUPLICATED_EMAIL("A500105", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Email is duplicated"),
	RT_USER_JOIN_DELETE_MEMBER("A500106", HttpStatus.INTERNAL_SERVER_ERROR, "Requested User is Deleted"),

	RT_USER_MODIFY_USER_NOT_FOUND("A500110", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is not found"),
	RT_USER_MODIFY_PASSWORD_WRONG("A500111", HttpStatus.INTERNAL_SERVER_ERROR, "Wrong Password"),
	RT_USER_MODIFY_EMAIL_ERROR("A500112", HttpStatus.INTERNAL_SERVER_ERROR, "Request Email is duplicated"),
	RT_USER_CELL_PHONE_CERT_ALREADY("A500113", HttpStatus.INTERNAL_SERVER_ERROR, "Request cell phone number is already cert."),
	RT_USER_CELL_PHONE_CERT_KEY_ERROR("A500114", HttpStatus.INTERNAL_SERVER_ERROR, "Request auth key is not valid."),
	RT_USER_CELL_PHONE_CERT_ERROR("A500115", HttpStatus.INTERNAL_SERVER_ERROR, "Request auth key is not found."),

	RT_USER_RESETPASSWORD_EMAIL_NOT_FOUND("A500200", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is email not found"),
	RT_USER_RESETPASSWORD_SNS_USER_ERROR("A500201", HttpStatus.INTERNAL_SERVER_ERROR, "Request User is sns Account"),

	RT_PROJECT_NOT_FOUND("A500300", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Not Found"),
	RT_PROJECT_NOT_COMPLETE_ERROR("A500301", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project has not been completed"),
	RT_PROJECT_XML_NOT_FOUND("A500302", HttpStatus.INTERNAL_SERVER_ERROR, "Requested xml is Not Found"),
	RT_PROJECT_XML_PARSING_ERROR("A500303", HttpStatus.INTERNAL_SERVER_ERROR, "xml parsing error"),
	RT_PROJECT_NOT_ALLOW_QUANTITY_ERROR("A500304", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project do not allow quantity changes"),
	RT_PROJECT_NOT_EDIT("A500305", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project was not edited"),
	RT_PROJECT_CALENDAR_ERROR("A500306", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project Anniversary display error"),
	RT_PROJECT_SAVE_ERROR("A500307", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is not saved normally"),
	RT_PRODUCT_SALE_DISCONTINUED("A500308", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Product is discontinued"),
	RT_PROJECT_ANOTHER_USER_COPIED("A500309", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is copied to another project"),
	RT_PROJECT_NOT_ORDERED("A500310", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is not ordered."),
	RT_PROJECT_STATUS_ERROR("A500311", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PROJECT_TEMPLATE_NOT_FOUND("A500312", HttpStatus.INTERNAL_SERVER_ERROR, "Requested template is Not Found"),
	RT_PROJECT_PHOTO_NOT_FILLED("A500313", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project's picture is not filled."),
	RT_PROJECT_PATH_NOT_FOUND("A500314", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project path not found"),
	RT_PROJECT_THUMBNAIL_CHECK_ERROR("A500315", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project thumbnailImage check error."),
	RT_PROJECT_THUMBNAIL_NOT_FOUND("A500316", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project main thumbnail is Not Found"),
	RT_PROJECT_COPY_ERROR("A500317", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project copy error."),
	RT_PROJECT_ACCESS_DENIED("A500318", HttpStatus.INTERNAL_SERVER_ERROR, "Access to the requested project has been denied"),
	RT_PROJECT_SHARE_NOT_ORDERED("A500319", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is not ordered."),
	RT_PROJECT_CARD_ERROR("A500320", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project card size error"),
	RT_PROJECT_NOT_ALLOW_EDIT("A500321", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project not allow editor."),
	RT_PROJECT_EDIT_FINISH_ERROR("A500322", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project not edit error."),
	RT_PROJECT_NOT_COPY_ERROR("A500323", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project  can not be copied."),
	RT_PROJECT_GENERAL_PHOTO_EDIT_ERROR("A500324", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project not edit error."),

	RT_PRODUCT_NOT_FOUND("A500400", HttpStatus.INTERNAL_SERVER_ERROR, "Requested product is Not Found"),
	RT_PRODUCT_PRICE_NOT_FOUND("A500401", HttpStatus.INTERNAL_SERVER_ERROR, "Requested product price is Not Found"),
	RT_PRODUCT_THUMBNAIL_NOT_FOUND("A500402", HttpStatus.INTERNAL_SERVER_ERROR, "Requested product main thumbnail is Not Found"),
	RT_PRODUCT_LAYFLAT_ERROR("A500403", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PRODUCT_CALENDAR_MEMO_ERROR("A500404", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PRODUCT_LUX_ERROR("A500405", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PROJECT_OLD_ERROR("A500406", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PRODUCT_PAD_COVER_ERROR("A500407", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is Requires re-editing."),
	RT_PRODUCT_FREE_EDIT_ERROR("A500408", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Project is free product."),
	RT_PRODUCT_INDEX_CODE_NOT_FOUND("A500409", HttpStatus.INTERNAL_SERVER_ERROR, "Requested product index code is Not Found"),

	RT_FILE_UPLOAD_FILLED("A500600", HttpStatus.INTERNAL_SERVER_ERROR, "File upload failed."),
	RT_FILE_RESIZE_FILLED("A500601", HttpStatus.INTERNAL_SERVER_ERROR, "File Thumbnail creation failed."),
	RT_FILE_EXTENTION_ERROR("A500602", HttpStatus.INTERNAL_SERVER_ERROR, "Wrong file extention."),
	RT_FILE_UPLOAD_META_ERROR("A500603", HttpStatus.INTERNAL_SERVER_ERROR, "Could not find file meta information."),
	RT_FILE_NOT_FOUND("A500604", HttpStatus.INTERNAL_SERVER_ERROR, "file not found."),
	RT_FILE_COPY_ERROR("A500605", HttpStatus.INTERNAL_SERVER_ERROR, "file copy faild."),
	RT_FILE_ORIGINAL_UPLOAD_FAILED("A500606", HttpStatus.INTERNAL_SERVER_ERROR, "File original upload failed.(original file size 0 or null)"),
	RT_FILE_THUMBNAIL_UPLOAD_FAILED("A500607", HttpStatus.INTERNAL_SERVER_ERROR, "File thumbnail upload failed.(thumbnail file size 0 or null)"),
	RT_FILE_CHECKSUM_ERROR("A500608", HttpStatus.INTERNAL_SERVER_ERROR, "File thumbnail upload failed.(original file checksum error)"),

	RT_QNA_NOT_FOUND("A500700", HttpStatus.INTERNAL_SERVER_ERROR, "Requested QNA is not found"),
	RT_QNA_UPDATE_ERROR("A500701", HttpStatus.INTERNAL_SERVER_ERROR, "Requested QNA can not update because of status"),
	RT_QNA_ADDITIONAL_ERROR("A500702", HttpStatus.INTERNAL_SERVER_ERROR, "Requested QNA can not additional because of status"),
	RT_QNA_DELETE_ERROR("A500703", HttpStatus.INTERNAL_SERVER_ERROR, "Requested QNA can not delete because of status"),
	RT_QNA_WRONG_SEQCODE("A500704", HttpStatus.INTERNAL_SERVER_ERROR, "Requested QNA-seq is wrong"),

	RT_TEMPLATE_NOT_FOUND("A500800", HttpStatus.INTERNAL_SERVER_ERROR, "Requested Template is Not Found"),

	RT_ORDER_NOT_FOUND("A500900", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order is Not Found"),
	RT_ORDER_QUANTITY_MIN_ERROR("A500901", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order quantity error"),
	RT_ORDER_QUANTITY_MAX_ERROR("A500902", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order quantity error"),
	RT_ORDER_DELIVERY_ADDRESS_MODIFY_ERROR("A500903", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order quantity error"),
	RT_ORDER_CANCEL_STATUS_ERROR("A500904", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order cancel status error"),
	RT_ORDER_CANCEL_ERROR("A500905", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order cancel error"),
	RT_RE_ORDER_STATUS_ERROR("A500906", HttpStatus.INTERNAL_SERVER_ERROR, "Requested reorder status error"),
	RT_RE_ORDER_NOT_FOUND("A500907", HttpStatus.INTERNAL_SERVER_ERROR, "Requested reorder is Not Found"),
	RT_ORDER_PRODUCT_NOT_VALID("A500908", HttpStatus.INTERNAL_SERVER_ERROR, "Requested order product not valid."),


	RT_RESOURCE_NOT_FOUND("A500A00", HttpStatus.INTERNAL_SERVER_ERROR, "Requested resource is Not Found"),
	RT_RESOURCE_ACCESS_DENIED("A500A01", HttpStatus.INTERNAL_SERVER_ERROR, "Access to the requested resource has been denied"),

	RT_COUPON_ISSUE_CODE_NOT_FOUND("A500B00", HttpStatus.INTERNAL_SERVER_ERROR, "Requested couponIssueCode is not found"),
	RT_COUPON_CODE_NOT_FOUND("A500B01", HttpStatus.INTERNAL_SERVER_ERROR, "Requested couponCode is not found"),
	RT_COUPON_REGISTER_ISSUE_CLOSE("A500B02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is issue close."),
	RT_COUPON_REGISTER_EXPIRED("A500B03", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is expired."),
	RT_COUPON_REGISTER_LIMIT_COUNT_ERROR("A500B04", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon exceeds the quantity that can be registered."),
	RT_COUPON_REGISTER_ALREADY("A500B05", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is already issue."),
	RT_COUPON_REGISTER_DEVICE_ERROR("A500B06", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon can only be issued by the mobile."),
	RT_COUPON_REGISTER_COUPON_NOT_FOUND("A500B07", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is not found."),
	RT_COUPON_REGISTER_ERROR("A500B08", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is issue error."),
	RT_COUPON_USER_JOIN_REGISTER_ERROR("A500B09", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is issue error."),
	RT_COUPON_REGISTER_VIRTUAL_COUPON_NOT_FOUND("A500B10", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is not found."),
	RT_COUPON_USER_WITHDRAW_REGISTER_ALREADY("A500B11", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is already issue."),
	RT_STAMP_COUNT_ERROR("A500B12", HttpStatus.INTERNAL_SERVER_ERROR, "Requested stamp count error."),
	RT_GIFT_CARD_REGISTER_ALREADY("A500B13", HttpStatus.INTERNAL_SERVER_ERROR, "Requested giftcard is already issue"),
	RT_GIFT_CARD_CODE_NOT_FOUND("A500B14", HttpStatus.INTERNAL_SERVER_ERROR, "Requested giftcard is not found."),
	RT_GIFT_CARD_CODE_PROMOTION_ERROR("A500B15", HttpStatus.INTERNAL_SERVER_ERROR, "Requested giftcard is promotion code."),
	RT_COUPON_REGISTER_SNS_ERROR("A500B16", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is issue error."),
	RT_COUPON_REGISTER_EVENT_NOT_FOUND("A500B17", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon event not found."),
	RT_COUPON_REGISTER_COMPANY_ERROR("A500B18", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon event not found."),
	RT_SNS_COUPON_REGISTER_TYPE_ERROR("A500B19", HttpStatus.INTERNAL_SERVER_ERROR, "Requested sns coupon code not found."),
	RT_SNS_COUPON_STATUS_ERROR("A500B20", HttpStatus.INTERNAL_SERVER_ERROR, "Requested sns coupon status error."),
	RT_SNS_COUPON_REGISTER_ALREADY("A500B21", HttpStatus.INTERNAL_SERVER_ERROR, "Requested sns coupon is already."),
	RT_SNS_COUPON_REGISTER_WMP_ERROR("A500B22", HttpStatus.INTERNAL_SERVER_ERROR, "Requested sns coupon is error."),
	RT_SNS_COUPON_REGISTER_TMON_ERROR("A500B23", HttpStatus.INTERNAL_SERVER_ERROR, "Requested sns coupon is error."),
	RT_CRM_JOIN_COUPON_REGISTER_ALREADY("A500B24", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is already issue."),
	RT_CRM_DORMANT_COUPON_REGISTER_ALREADY("A500B25", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is already issue."),

	RT_PAYMENT_COUPON_ERROR("A500C00", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is invalid."),
	RT_PAYMENT_COUPON_USE_AMOUNT_ERROR("A500C01", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon use amount error."),
	RT_PAYMENT_NO_AVAILABLE_COUPON_ERROR("A500C02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested coupon is invalid."),
	RT_PAYMENT_PROJECT_DUPLICATION_ERROR("A500C10", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project code duplication."),
	RT_PAYMENT_DELIVERY_COUPON_ERROR("A500C20", HttpStatus.INTERNAL_SERVER_ERROR, "Requested No delivery coupon required."),
	RT_PAYMENT_DELIVERY_COUPON_VALID_ERROR("A500C21", HttpStatus.INTERNAL_SERVER_ERROR, "Requested delivery coupon is invalid."),
	RT_PAYMENT_DELIVERY_AMOUNT_ERROR("A500C22", HttpStatus.INTERNAL_SERVER_ERROR, "Requested delivery amount is invalid."),
	RT_PAYMENT_DELIVERY_METHOD_ERROR("A500C23", HttpStatus.INTERNAL_SERVER_ERROR, "Requested delivery method is invalid."),
	RT_PAYMENT_USER_MONEY_ERROR("A500C30", HttpStatus.INTERNAL_SERVER_ERROR, "Requested user money is invalid."),
	RT_PAYMENT_SETTLEMENT_AMOUNT_ERROR("A500C40", HttpStatus.INTERNAL_SERVER_ERROR, "Requested settlementAmount is invalid."),
	RT_PAYMENT_SETTLEMENT_METHOD_ERROR("A500C41", HttpStatus.INTERNAL_SERVER_ERROR, "Requested settlementMethod is invalid."),
	RT_PAYMENT_CHANGE_ORDER_STATUS_ERROR("A500C42", HttpStatus.INTERNAL_SERVER_ERROR, "Requested payment change status is invalid."),
	RT_PAYMENT_CHANGE_ERROR("A500C43", HttpStatus.INTERNAL_SERVER_ERROR, "Requested payment change error."),
	RT_PAYMENT_DATABASE_ERROR("A500C44", HttpStatus.INTERNAL_SERVER_ERROR, "Requested payment error."),

	RT_PAYMENT_INICIS_AUTH_ERROR("A500C50", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication error."),
	RT_PAYMENT_INICIS_AUTH_PARAMETER_ERROR("A500C51", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication parameter error."),
	RT_PAYMENT_INICIS_AUTH_PAYMENT_METHOD_ERROR("A500C52", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication paymentMethod error."),
	RT_PAYMENT_INICIS_AUTH_SUBMIT_ERROR("A500C53", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication submit error."),
	RT_PAYMENT_INICIS_AUTH_CANCEL_ERROR("A500C54", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication cancel."),
	RT_PAYMENT_INICIS_AUTH_TIMEOUT_ERROR("A500C55", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis Authentication time out."),
	RT_PAYMENT_NAVER_AUTH_ERROR("A500C56", HttpStatus.INTERNAL_SERVER_ERROR, "Requested npay Authentication error."),
	RT_PAYMENT_NAVER_RESULT_AUTH_ERROR("A500C57", HttpStatus.INTERNAL_SERVER_ERROR, "Requested npay Authentication error."),
	RT_PAYMENT_KAKAO_AUTH_ERROR("A500C58", HttpStatus.INTERNAL_SERVER_ERROR, "Requested kakao pay Authentication error."),

	RT_PAYMENT_INICIS_PAY_AUTH_ERROR("A500D00", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis pay Authentication error."),
	RT_PAYMENT_INICIS_PAY_AUTH_PARAMETER_ERROR("A500D01", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis pay Authentication parameter error."),
	RT_PAYMENT_INICIS_PAY_AUTH_FAILED_PROCESS_ERROR("A500D02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis pay Authentication Failed to process approval."),
	RT_PAYMENT_INICIS_PAY_AUTH_FAILURE_ERROR("A500D03", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis pay Authentication failure error."),
	RT_PAYMENT_INICIS_VIRTUAL_BANK_ERROR("A500D04", HttpStatus.INTERNAL_SERVER_ERROR, "Requested inicis pay virtual bank process error."),
	RT_PAYMENT_INICIS_VIRTUAL_BANK_STATUS_ERROR("A500D05", HttpStatus.INTERNAL_SERVER_ERROR, "Requested virtual bank deposit order status error."),

	RT_PAYMENT_NAVER_PAY_RESERVE_ERROR("A500E01", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay reserve error"),
	RT_PAYMENT_NAVER_PAY_RECEIPT_AMOUNT_ERROR("A500E02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay ReceiptAmount search error"),
	RT_PAYMENT_NAVER_PAY_CANCEL_CHECK_TIME_ERROR("A500E03", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay ReceiptAmount search error"),
	RT_PAYMENT_NAVER_PAY_INVALID_ERROR("A500E04", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay InvalidMerchant error"),
	RT_PAYMENT_NAVER_PAY_TIME_EXPIRED_ERROR("A500E05", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay TimeExpired error"),
	RT_PAYMENT_NAVER_PAY_ALREADY_ONGOING_ERROR("A500E06", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay AlreadyOnGoing error"),
	RT_PAYMENT_NAVER_PAY_ALREADY_COMPLETE_ERROR("A500E07", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay AlreadyComplete error"),
	RT_PAYMENT_NAVER_PAY_OWNER_AUTH_ERROR("A500E08", HttpStatus.INTERNAL_SERVER_ERROR, "Requested naver pay OwnerAuthFail error"),

	RT_PAYMENT_KAKAO_PAY_SIGNATURE_ERROR("A500E50", HttpStatus.INTERNAL_SERVER_ERROR, "Requested kakao pay TXN_ID error"),
	RT_PAYMENT_KAKAO_PAY_ORDERCODE_ERROR("A500E51", HttpStatus.INTERNAL_SERVER_ERROR, "Requested kakao pay duplication orderCode error"),

	RT_TAX_EXPIRE_ERROR("A500F00", HttpStatus.INTERNAL_SERVER_ERROR, "The tax bill application period has expired."),
	RT_TAX_NOT_ISSUE_ERROR("A500F01", HttpStatus.INTERNAL_SERVER_ERROR, "The tax invoice can not be issued in the previous month based on the order date."),
	RT_TAX_MONTH_ISSUE_ERROR("A500F02", HttpStatus.INTERNAL_SERVER_ERROR, "Tax invoices can only be issued up to 5 days after the order date."),
	RT_TAX_USE_ISSUE_ERROR("A500F03", HttpStatus.INTERNAL_SERVER_ERROR, "This is an issue."),
	RT_TAX_NOT_ORDER_ERROR("A500F04", HttpStatus.INTERNAL_SERVER_ERROR, "There is no order information required to issue a tax invoice."),

	RT_CASH_RECEIPT_NOT_FOUND("A500G00", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt order not found."),
	RT_CASH_RECEIPT_ALREADY("A500G01", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt is already issue"),
	RT_CASH_RECEIPT_SETTLEMENT_AMOUNT_ERROR("A500G02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt settlement amount error."),
	RT_CASH_RECEIPT_ISSUE_ERROR("A500G03", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt issue error."),
	RT_CASH_RECEIPT_STATUS_ERROR("A500G04", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt order status error."),
	RT_CASH_RECEIPT_PAYMETHOD_ERROR("A500G05", HttpStatus.INTERNAL_SERVER_ERROR, "Requested cash receipt order settlementMethod error."),

	RT_REVIEW_SAVE_ERROR("A501000", HttpStatus.INTERNAL_SERVER_ERROR, "Requested User Information is different."),
	RT_REVIEW_CAN_NOT_SAMPLEPACK("A501001", HttpStatus.INTERNAL_SERVER_ERROR, "The sample pack can not be written as a review."),
	RT_REVIEW_MAPPING_NOT_FOUND("A501002", HttpStatus.INTERNAL_SERVER_ERROR, "Requested review mapping Information not found"),
	RT_REVIEW_NOT_WRITE("A501003", HttpStatus.INTERNAL_SERVER_ERROR, "You can not write review."),

	RT_SHARE_CONNECTION_SUCCEED("A500J01", HttpStatus.OK, "Connection Succeeded"),
	RT_SHARE_EDITING_NONE("A500J02", HttpStatus.OK, "Nobody Editing"),
	RT_SHARE_ANOTHER_USER_EDITING("A500J03", HttpStatus.INTERNAL_SERVER_ERROR, "Another User is Editing"),
	RT_SHARE_USER_NOT_FOUND("A500J04", HttpStatus.INTERNAL_SERVER_ERROR, "Request user is not found."),
	RT_SHARE_USER_DUPLICATION_ERROR("A500J05", HttpStatus.INTERNAL_SERVER_ERROR, "Requested user code duplication."),
	RT_SHARE_AUTH_ERROR("A500J06", HttpStatus.INTERNAL_SERVER_ERROR, "Requested share Authentication error."),
	RT_SHARE_USER_ALREADY("A500J07", HttpStatus.INTERNAL_SERVER_ERROR, "Requested user is already."),
	RT_SHARE_USER_LIMIT_COUNT("A500J08", HttpStatus.INTERNAL_SERVER_ERROR, "Requested project share exceed limited."),
	RT_SHARE_PROJECT_COPY_ERROR("A500J09", HttpStatus.INTERNAL_SERVER_ERROR, "Requested share project copy permission error."),

	RT_EVENT_ALREADY_JOIN("A500K01", HttpStatus.INTERNAL_SERVER_ERROR, "You have already joined."),
	RT_EVENT_NOT_FOUND("A500K02", HttpStatus.INTERNAL_SERVER_ERROR, "Requested event code is not found."),
	RT_EVENT_JOIN_ERROR("A500K03", HttpStatus.INTERNAL_SERVER_ERROR, "Requested event join execute error.");

	private final HttpStatus httpStatus;
	private final String errorMessage;
	private final String errorCode;

	private RtCode(String errorCode, HttpStatus httpStatus, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
