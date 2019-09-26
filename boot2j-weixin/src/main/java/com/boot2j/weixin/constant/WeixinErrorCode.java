/**
 * 
 */
package com.boot2j.weixin.constant;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信API 全局返回码  
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class WeixinErrorCode {
	
	private static Logger logger = LoggerFactory.getLogger(WeixinErrorCode.class);
	
	/**
	 * 图片（image）: 1M，支持JPG格式
	 */
	public final static long	IMAGE_UPLOAD_MAXSIZE						= 1048576;
	
	/**
	 * 系统繁忙
	 */
	public final static int		SYSTEM_ERROR								= -1;
	
	/**
	 * 请求成功
	 */
	public final static int		SUCCESS_CODE								= 0;
	
	/**
	 * 获取access_token时AppSecret错误，或者access_token无效
	 */
	public final static int		INVALID_CREDENTIAL							= 40001;
	
	/**
	 * 不合法的凭证类型
	 */
	public final static int		INVALID_GRANT_TYPE							= 40002;
	
	/**
	 * 不合法的OpenID
	 */
	public final static int		INVALID_OPENID								= 40003;
	
	/**
	 * 不合法的媒体文件类型
	 */
	public final static int		INVALID_MEDIA_TYPE							= 40004;
	
	/**
	 * 不合法的文件类型
	 */
	public final static int		INVALID_FILE_TYPE							= 40005;
	
	/**
	 * 不合法的文件大小
	 */
	public final static int		INVALID_MEIDA_SIZE							= 40006;
	
	/**
	 * 不合法的媒体文件id
	 */
	public final static int		INVALID_MEDIA_ID							= 40007;
	
	/**
	 * 不合法的消息类型
	 */
	public final static int		INVALID_MESSAGE_TYPE						= 40008;
	
	/**
	 * 不合法的图片大小
	 */
	public final static int		INVALID_IMAGE_SIZE							= 40009;
	
	/**
	 * 不合法的语音大小
	 */
	public final static int		INVALID_VOICE_SIZE							= 40010;
	
	/**
	 * 不合法的视频大小
	 */
	public final static int		INVALID_VIDEO_SIZE							= 40011;
	
	/**
	 * 不合法的缩略图大小
	 */
	public final static int		INVALID_THUMB_SIZE							= 40012;
	
	/**
	 * 不合法的APPID
	 */
	public final static int		INVALID_APPID								= 40013;
	
	/**
	 * 不合法的access_token
	 */
	public final static int		INVALID_ACCESS_TOKEN						= 40014;
	
	/**
	 * 不合法的菜单类型
	 */
	public final static int		INVALID_MENU_TYPE							= 40015;
	
	/**
	 * 不合法的按钮个数
	 */
	public final static int		INVALID_BUTTON_SIZE							= 40016;
	
	/**
	 * 不合法的按钮类型
	 */
	public final static int		INVALID_BUTTON_TYPE							= 40017;
	
	/**
	 * 不合法的按钮名字长度
	 */
	public final static int		INVALID_BUTTON_NAME_SIZE					= 40018;
	
	/**
	 * 不合法的按钮KEY长度
	 */
	public final static int		INVALID_BUTTON_KEY_SIZE						= 40019;
	
	/**
	 * 不合法的url长度
	 */
	public final static int		INVALID_BUTTON_URL							= 40020;
	
	/**
	 * 不合法的子菜单按钮个数
	 */
	public final static int		INVALID_SUB_BUTTON_SIZE						= 40023;
	
	/**
	 * 不合法的子菜单类型
	 */
	public final static int		INVALID_SUB_BUTTON_TYPE						= 40024;
	
	/**
	 * 不合法的子菜单按钮名称长度
	 */
	public final static int		INVALID_SUB_BUTTON_NAME_SIZE				= 40025;
	
	/**
	 * 不合法的子菜单按钮KEY长度
	 */
	public final static int		INVALID_SUB_BUTTON_KEY_SIZE					= 40026;
	
	/**
	 * 不合法的子菜单按钮url长度
	 */
	public final static int		INVALID_SUB_BUTTON_URL_SIZE					= 40027;
	
	/**
	 * 不合法或已过期的code
	 */
	public final static int		INVALID_CODE								= 40029;
	
	/**
	 * 不合法的refresh_token
	 */
	public final static int		INVALID_REFRESH_TOKEN						= 40030;
	
	/**
	 * 不合法的template_id长度
	 */
	public final static int		INVALID_TEMPLATE_ID_SIZE					= 40036;
	
	/**
	 * 不合法的模板消息ID
	 */
	public final static int		INVALID_TEMPLATE_ID							= 40037;
	
	/**
	 * 40039	invalid url size	不合法的url长度
	 */
	public final static int		INVALID_URL_SIZE							= 40039;
	
	/**
	 * 40048	invalid url domain	不合法的url域名
	 */
	public final static int		INVALID_URL_DOMAIN							= 40048;
	
	/**
	 * 40054	invalid sub button url domain	不合法的子菜单按钮url域名
	 */
	public final static int		INVALID_SUB_BUTTON_URL_DOMAIN				= 40045;
	
	/**
	 * 40055	invalid button url domain	不合法的菜单按钮url域名
	 */
	public final static int		INVALID_BUTTON_URL_DOMAIN					= 40055;
	
	/**
	 * 40066	invalid url	不合法的url
	 */
	public final static int		INVALID_URL									= 40066;
	
	/**
	 * 缺少access_token参数
	 */
	public final static int		ACCESS_TOKEN_MISSING						= 41001;
	
	/**
	 * 41002	appid missing	缺失appid参数
	 */
	public final static int		APPID_MISSING								= 41002;
	
	/**
	 * 41003	refresh_token missing	缺失refresh_token参数
	 */
	public final static int		REFRESH_TOKEN_MISSING						= 41003;
	
	/**
	 * 41004	appsecret missing	缺失secret参数
	 */
	public final static int		APPSECRET_MISSING							= 41004;
	
	/**
	 * 缺少多媒体文件数据
	 */
	public final static int		MEDIA_DATA_MISSING							= 41005;
	
	/**
	 * 41006	media_id missing	缺失media_id参数
	 */
	public final static int		MEDIA_ID_MISSING							= 41006;
	
	/**
	 * 41007	sub_menu data missing	缺失子菜单数据
	 */
	public final static int		SUB_MENU_DATA_MISSING						= 41007;
	
	/**
	 * 41008	missing code	缺失code参数
	 */
	public final static int		MISSING_CODE								= 41008;
	
	/**
	 * 41009	missing openid	缺失openid参数
	 */
	public final static int		MISSING_OPENID								= 41009;
	
	/**
	 * 41010	missing url	缺失url参数
	 */
	public final static int		MISSING_URL									= 41010;
	
	/**
	 * 42001	access_token expired	access_token超时
	 */
	public final static int		ACCESS_TOKEN_EXPIRED						= 42001;
	
	/**
	 * 42002	refresh_token expired	refresh_token超时
	 */
	public final static int		REFRESH_TOKEN_EXPIRED						= 42002;
	
	/**
	 * 42003	code expired	code超时
	 */
	public final static int		CODE_EXPIRED								= 42003;
	
	/**
	 * api使用过期
	 */
	public final static int		API_USAGE_EXPIRED							= 42005;
	
	/**
	 * 43001	require GET method	需要使用GET方法请求
	 */
	public final static int		REQUIRE_GET_METHOD							= 43001;
	
	/**
	 * 需要使用POST方法请求
	 */
	public final static int		REQUIRE_POST_METHOD							= 43002;
	
	/**
	 * 43003	require https	需要使用HTTPS
	 */
	public final static int		REQUIRE_HTTPS								= 43003;
	
	/**
	 * 需要接收者关注
	 */
	public final static int		REQUIRE_SUBSCRIBE							= 43004;
	
	/**
	 * 44001	empty media data	空白的二进制数据
	 */
	public final static int		EMPTY_MEDIA_DATA							= 44001;
	
	/**
	 * 44002	empty post data	空白的POST数据
	 */
	public final static int		EMPTY_POST_DATA								= 44002;
	
	/**
	 * 图文消息内容为空
	 */
	public final static int		EMPTY_NEWS_DATA								= 44003;
	
	/**
	 * 44004	empty content	空白的内容
	 */
	public final static int		EMPTY_CONTENT								= 44004;
	
	/**
	 * 44005	empty list size	空白的列表
	 */
	public final static int		EMPTY_LIST_SIZE								= 44005;
	
	/**
	 * 45001	media size out of limit	二进制文件超过限制
	 */
	public final static int		MEDIA_SIZE_OUT_OF_LIMIT						= 45001;
	
	/**
	 * 45002	content size out of limit	content参数超过限制
	 */
	public final static int		CONTENT_SIZE_OUT_OF_LIMIT					= 45002;
	
	/**
	 * 45003	title size out of limit	title参数超过限制
	 */
	public final static int		TITLE_SIZE_OUT_OF_LIMIT						= 45003;
	
	/**
	 * 45004	description size out of limit	description参数超过限制
	 */
	public final static int		DESCRIPTION_SIZE_OUT_OF_LIMIT				= 45004;
	
	/**
	 * 45005	url size out of limit	url参数长度超过限制
	 */
	public final static int		URL_SIZE_OUT_OF_LIMIT						= 45005;
	
	/**
	 * 45006	picurl size out of limit	picurl参数超过限制
	 */
	public final static int		PICURL_SIZE_OUT_OF_LIMIT					= 45006;
	
	/**
	 * 45007	playtime out of limit	播放时间超过限制（语音为60s最大）
	 */
	public final static int		PLAYTIME_OUT_OF_LIMIT						= 45007;
	
	/**
	 * 45008	article size out of limit	article参数超过限制
	 */
	public final static int		ARTICLE_SIZE_OUT_OF_LIMIT					= 45008;
	
	/**
	 * 接口调用超过限制
	 */
	public final static int		API_FREQ_OUT_OF_LIMIT						= 45009;
	
	/**
	 * 45010	create menu limit	建立菜单被限制
	 */
	public final static int		CREATE_MENU_LIMIT							= 45010;
	
	/**
	 * 45011	api limit	频率限制
	 */
	public final static int		API_LIMIT									= 45011;
	
	/**
	 * 45012	template size out of limit	模板大小超过限制
	 */
	public final static int		TEMPLATE_SIZE_OUT_OF_LIMIT					= 45012;
	
	/**
	 * 回复时间超过限制
	 */
	public final static int		RESPONSE_OUT_OF_TIME_LIMIT					= 45015;
	
	/**
	 * 45016	can't modify sys group	不能修改默认组
	 */
	public final static int		CANNOT_MODIFY_SYS_GROUP						= 45016;
	
	/**
	 * 45017	can't set group name too long sys group	修改组名过长
	 */
	public final static int		CANNOT_SET_GROUP_NAME_TOO_LONG_SYS_GROUP	= 45017;
	
	/**
	 * 45018	too many group now, no need to add new	组数量过多
	 */
	public final static int		TOO_MANY_GROUP_NOW_NO_NEED_TO_ADD_NEW		= 45018;
	
	/**
	 * api功能未授权
	 */
	public final static int		API_UNAUTHORIZED							= 48001;
	
	/**
	 * 50001	api unauthorized	接口未授权
	 */
	public final static int		API_UNAUTHORIZED1							= 50001;
	
	/**
	 * 内部map，保存所有的常量信息
	 */
	private static Map			map;
	
	public WeixinErrorCode()
	{
		// initialize only once...
		if (map != null)
		{
			return;
		}
		map = new HashMap();
		Class c = this.getClass();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			int modifier = field.getModifiers();
			// 排除private类型
			if (Modifier.isFinal(modifier) && !Modifier.isPrivate(modifier))
			{
				try
				{
					this.put(field.getName(), field.get(this));
				}
				catch (IllegalAccessException ex)
				{
					logger.error("", ex);
				}
			}
		}
	}
	
	/**
	 * 继承map的get方法 
	 * @param key 键
	 * @return
	 */
	public Object get(Object key)
	{
		return map.get(key);
	}
	
	/**
	 * 继承map的put方法 
	 * @param key  键
	 * @param value 值
	 * @return
	 */
	public Object put(Object key, Object value)
	{
		return map.put(key, value);
	}
}
