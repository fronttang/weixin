package com.boot2j.weixin.message;


public class Articles
{
    private String Title;
    
    private String Description;
    
    private String PicUrl;
    
    private String Url;
    
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

    @Override
    public String toString() {
        return "Articles [Title=" + Title + ", Description=" + Description + ", PicUrl=" + PicUrl
                + ", Url=" + Url + "]";
    }
    
}
