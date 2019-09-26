/**
 * 
 */
package com.boot2j.weixin.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot2j.weixin.message.ImageWeixinMessage;
import com.boot2j.weixin.message.LinkWeixinMessage;
import com.boot2j.weixin.message.LocationWeixinMessage;
import com.boot2j.weixin.message.MusicWeixinMessage;
import com.boot2j.weixin.message.NewsWeixinMessage;
import com.boot2j.weixin.message.ShortvideoWeixinMessage;
import com.boot2j.weixin.message.TextWeixinMessage;
import com.boot2j.weixin.message.VideoWeixinMessage;
import com.boot2j.weixin.message.VoiceWeixinMessage;
import com.boot2j.weixin.message.handler.EventWeixinMessageHandler;
import com.boot2j.weixin.message.handler.ImageWeixinMessageHandler;
import com.boot2j.weixin.message.handler.LinkWeixinMessageHandler;
import com.boot2j.weixin.message.handler.LocationWeixinMessageHandler;
import com.boot2j.weixin.message.handler.MessageHandler;
import com.boot2j.weixin.message.handler.MusicWeixinMesageHandler;
import com.boot2j.weixin.message.handler.NewsWeixinMessageHandler;
import com.boot2j.weixin.message.handler.ShortvideoWeixinMessageHandler;
import com.boot2j.weixin.message.handler.TextWeixinMessageHandler;
import com.boot2j.weixin.message.handler.VideoWeixinMessageHandler;
import com.boot2j.weixin.message.handler.VoiceWeixinMessageHandler;
import com.boot2j.weixin.message.impl.DefaultImageWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultLinkWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultLocationWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultMusicWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultNewsWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultShortvideoWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultTextWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultVideoWeixinMessage;
import com.boot2j.weixin.message.impl.DefaultVoiceWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Configuration
@ConditionalOnWebApplication
public class WeixinMessageConfiguration {
	
	@Bean
	@ConditionalOnMissingBean(TextWeixinMessage.class)
	public TextWeixinMessage textWeixinMessage() {
		return new DefaultTextWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(TextWeixinMessageHandler.class)
	public MessageHandler textWeixinMessageHandler(TextWeixinMessage message) {
		return new TextWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(LocationWeixinMessage.class)
	public LocationWeixinMessage locationWeixinMessage() {
		return new DefaultLocationWeixinMessage();
	}

	@Bean
	@ConditionalOnMissingBean(LocationWeixinMessageHandler.class)
	public MessageHandler locationWeixinMessageHandler(LocationWeixinMessage message) {
		return new LocationWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(ImageWeixinMessage.class)
	public ImageWeixinMessage imageWeixinMessage() {
		return new DefaultImageWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(ImageWeixinMessageHandler.class)
	public MessageHandler imageWeixinMessageHandler(ImageWeixinMessage message) {
		return new ImageWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(LinkWeixinMessage.class)
	public LinkWeixinMessage linkWeixinMessage() {
		return new DefaultLinkWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(LinkWeixinMessageHandler.class)
	public MessageHandler linkWeixinMessageHandler(LinkWeixinMessage message) {
		return new LinkWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(EventWeixinMessageHandler.class)
	public MessageHandler eventWeixinMessageHandler() {
		return new EventWeixinMessageHandler();
	}
	
	@Bean
	@ConditionalOnMissingBean(NewsWeixinMessage.class)
	public NewsWeixinMessage newsWeixinMessage() {
		return new DefaultNewsWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(NewsWeixinMessageHandler.class)
	public MessageHandler newsWeixinMessageHandler(NewsWeixinMessage message) {
		return new NewsWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(MusicWeixinMessage.class)
	public MusicWeixinMessage musicWeixinMessage() {
		return new DefaultMusicWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(MusicWeixinMesageHandler.class)
	public MessageHandler musicWeixinMesageHandler(MusicWeixinMessage message) {
		return new MusicWeixinMesageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(VoiceWeixinMessage.class)
	public VoiceWeixinMessage voiceWeixinMessage() {
		return new DefaultVoiceWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(VoiceWeixinMessageHandler.class)
	public MessageHandler voiceWeixinMessageHandler(VoiceWeixinMessage message) {
		return new VoiceWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(VideoWeixinMessage.class)
	public VideoWeixinMessage videoWeixinMessage() {
		return new DefaultVideoWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(VoiceWeixinMessageHandler.class)
	public MessageHandler videoWeixinMessageHandler(VideoWeixinMessage message) {
		return new VideoWeixinMessageHandler(message);
	}
	
	@Bean
	@ConditionalOnMissingBean(ShortvideoWeixinMessage.class)
	public ShortvideoWeixinMessage shortvideoWeixinMessage() {
		return new DefaultShortvideoWeixinMessage();
	}
	
	@Bean
	@ConditionalOnMissingBean(ShortvideoWeixinMessageHandler.class)
	public MessageHandler shortVideoWeixinMessageHandler(ShortvideoWeixinMessage message) {
		return new ShortvideoWeixinMessageHandler(message);
	}
}
