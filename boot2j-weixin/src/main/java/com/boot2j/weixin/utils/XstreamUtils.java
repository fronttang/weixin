package com.boot2j.weixin.utils;

import com.boot2j.weixin.message.InMessage;
import com.thoughtworks.xstream.XStream;

public class XstreamUtils
{
    
    public static XStream XStreamConver(XStream xs)
    {
        xs.aliasField("ToUserName", InMessage.class, "ToUserName");
        xs.aliasField("FromUserName", InMessage.class, "FromUserName");
        xs.aliasField("CreateTime", InMessage.class, "CreateTime");
        xs.aliasField("MsgType", InMessage.class, "MsgType");
        xs.aliasField("Location_X", InMessage.class, "Location_X");
        xs.aliasField("Location_Y", InMessage.class, "Location_Y");
        xs.aliasField("Scale", InMessage.class, "Scale");
        xs.aliasField("Label", InMessage.class, "Label");
        xs.aliasField("MsgId", InMessage.class, "MsgId");
        xs.aliasField("Content", InMessage.class, "Content");
        
        return xs;
    }
    
}
