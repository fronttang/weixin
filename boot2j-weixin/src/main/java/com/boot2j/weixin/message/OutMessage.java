/**
 * 
 */
package com.boot2j.weixin.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class OutMessage {
	
	private String			ToUserName;
	
	private String			FromUserName;
	
	private Long			CreateTime;
	
	private String			MsgType;
	
	private Long			MsgId;
	
	// 文本消息
	private String			Content;
	
	private String			MusicUrl;
	
	private String			HQMusicUrl;
	
	private Integer			ArticleCount;
	
	private String			Title;
	
	private String			Description;
	
	private String			PicUrl;
	
	private String			Url;
	
	private List<Articles>	Articles;
	
	private Musics			Music;
	
	private Image			Image;
	
	private String			Encrypt;
	
	private String			MsgSignature;
	
	private String			TimeStamp;
	
	private String			Nonce;
	
	//private int				FuncFlag	= 0;
	
	public String getToUserName()
	{
		return ToUserName;
	}
	
	public void setToUserName(String toUserName)
	{
		ToUserName = toUserName;
	}
	
	public String getFromUserName()
	{
		return FromUserName;
	}
	
	public void setFromUserName(String fromUserName)
	{
		FromUserName = fromUserName;
	}
	
	public Long getCreateTime()
	{
		return CreateTime;
	}
	
	public void setCreateTime(Long createTime)
	{
		CreateTime = createTime;
	}
	
	public String getMsgType()
	{
		return MsgType;
	}
	
	public void setMsgType(String msgType)
	{
		MsgType = msgType;
	}
	
	public Long getMsgId()
	{
		return MsgId;
	}
	
	public void setMsgId(Long msgId)
	{
		MsgId = msgId;
	}
	
	public String getContent()
	{
		return Content;
	}
	
	public void setContent(String content)
	{
		Content = content;
	}
	
	//	public int getFuncFlag()
	//	{
	//		return FuncFlag;
	//	}
	//	
	//	public void setFuncFlag(int funcFlag)
	//	{
	//		FuncFlag = funcFlag;
	//	}
	
	public String getMusicUrl()
	{
		return MusicUrl;
	}
	
	public void setMusicUrl(String musicUrl)
	{
		MusicUrl = musicUrl;
	}
	
	public String getHQMusicUrl()
	{
		return HQMusicUrl;
	}
	
	public void setHQMusicUrl(String hQMusicUrl)
	{
		HQMusicUrl = hQMusicUrl;
	}
	
	public int getArticleCount()
	{
		if (this.Articles != null && Articles.size() > 0) {
			return this.Articles.size();
		}
		return ArticleCount;
	}
	
	public void setArticleCount(int articleCount)
	{
		ArticleCount = articleCount;
	}
	
	public String getTitle()
	{
		return Title;
	}
	
	public void setTitle(String title)
	{
		Title = title;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
	public void setDescription(String description)
	{
		Description = description;
	}
	
	public String getPicUrl()
	{
		return PicUrl;
	}
	
	public void setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
	}
	
	public String getUrl()
	{
		return Url;
	}
	
	public void setUrl(String url)
	{
		Url = url;
	}
	
	public List<Articles> getArticles()
	{
		return Articles;
	}
	
	public void setArticles(List<Articles> articles)
	{
		if (articles.size() > 10) {
			articles = new ArrayList<Articles>(articles.subList(0, 10));
		}
		Articles = articles;
	}
	
	public Musics getMusic()
	{
		return Music;
	}
	
	public void setMusic(Musics music)
	{
		Music = music;
	}
	
	public Image getImage()
	{
		return Image;
	}
	
	public void setImage(Image image)
	{
		Image = image;
	}
	
	public String getEncrypt()
	{
		return Encrypt;
	}
	
	public void setEncrypt(String encrypt)
	{
		Encrypt = encrypt;
	}
	
	public String getMsgSignature()
	{
		return MsgSignature;
	}
	
	public void setMsgSignature(String msgSignature)
	{
		MsgSignature = msgSignature;
	}
	
	public String getTimeStamp()
	{
		return TimeStamp;
	}
	
	public void setTimeStamp(String timeStamp)
	{
		TimeStamp = timeStamp;
	}
	
	public String getNonce()
	{
		return Nonce;
	}
	
	public void setNonce(String nonce)
	{
		Nonce = nonce;
	}
	
	public void setArticleCount(Integer articleCount)
	{
		ArticleCount = articleCount;
	}
	
}
