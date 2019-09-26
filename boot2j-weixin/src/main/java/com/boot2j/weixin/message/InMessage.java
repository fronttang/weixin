/**
 * 
 */
package com.boot2j.weixin.message;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class InMessage {

	private String ToUserName;

	private String FromUserName;

	private Long CreateTime;

	private String MsgType;

	private Long MsgId;

	private String Encrypt;

	// 文本消息
	private String Content;

	// 图片消息
	private String PicUrl;

	// 位置消息
	private String Location_X;

	private String Location_Y;

	private Long Scale;

	private String Label;

	// 链接消息
	private String Title;

	private String Description;

	private String Url;

	// 事件
	private String Event;

	private String EventKey;

	private String MediaId;

	private String ThumbMediaId;

	private String Latitude;

	private String Longitude;

	private String Precision;

	private String Ticket;

	private String Format;

	private String Recognition;

	private String Status;

	// 结果回送
	private Long MsgID;

	private Long TotalCount;

	private Long FilterCount;

	private Long SentCount;

	private Long ErrorCount;

	private Long sceneId;

	private String msgsource;

	private String encrypt_type;

	private String msg_signature;

	private String timestamp;

	private String nonce;

	private String token;

	private String appid;

	private String encodingAesKey;

	public String getToUserName() {
		return ToUserName;
	}

	public String getOpenId() {
		return FromUserName;
	}

	public String getWeixinPk() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public Double getLat() {
		return Double.parseDouble(Location_X);
	}

	public Double getLng() {
		return Double.parseDouble(Location_Y);
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public Long getScale() {
		return Scale;
	}

	public void setScale(Long scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Long getMsgID() {
		return MsgID;
	}

	public void setMsgID(Long msgID) {
		MsgID = msgID;
	}

	public Long getTotalCount() {
		return TotalCount;
	}

	public void setTotalCount(Long totalCount) {
		TotalCount = totalCount;
	}

	public Long getFilterCount() {
		return FilterCount;
	}

	public void setFilterCount(Long filterCount) {
		FilterCount = filterCount;
	}

	public Long getSentCount() {
		return SentCount;
	}

	public void setSentCount(Long sentCount) {
		SentCount = sentCount;
	}

	public Long getErrorCount() {
		return ErrorCount;
	}

	public void setErrorCount(Long errorCount) {
		ErrorCount = errorCount;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public Long getSceneId() {
		return sceneId;
	}

	public void setSceneId(Long sceneId) {
		this.sceneId = sceneId;
	}

	public String getMsgsource() {
		return msgsource;
	}

	public void setMsgsource(String msgsource) {
		this.msgsource = msgsource;
	}

	public String getEncrypt() {
		return Encrypt;
	}

	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}

	public String getEncrypt_type() {
		return encrypt_type;
	}

	public void setEncrypt_type(String encryptType) {
		encrypt_type = encryptType;
	}

	public String getMsg_signature() {
		return msg_signature;
	}

	public void setMsg_signature(String msgSignature) {
		msg_signature = msgSignature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
