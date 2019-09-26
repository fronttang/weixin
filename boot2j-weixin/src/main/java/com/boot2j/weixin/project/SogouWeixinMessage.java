/**
 * 
 */
package com.boot2j.weixin.project;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.WeixinMessage;
import com.boot2j.weixin.message.abstracts.AbstractNewsWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class SogouWeixinMessage extends AbstractNewsWeixinMessage implements WeixinMessage {

    private static Logger logger = LoggerFactory.getLogger(SogouWeixinMessage.class);

    @Override
    protected List<Articles> getArticles(MessageContext context) {

        List<Articles> articlesList = new ArrayList<Articles>();
        try {

            String url = "https://weixin.sogou.com/weixin?type=2&query="
                    + URLEncoder.encode(context.getInMessage().getContent(), "UTF-8")
                    + "&ie=utf8&s_from=input&_sug_=y&_sug_type_=";
            Document document = document = Jsoup.connect(url).timeout(50000).get();
            if (document != null) {

                Elements elements = document.select(".news-list");

                if (elements != null && elements.size() > 0) {
                    Element newsList = elements.get(0);
                    Elements li = newsList.select("li");
                    if (li != null && li.size() > 0) {
                        for (Element news : li) {
                            Element imgbox = news.selectFirst("div.img-box");
                            Element txtbox = news.selectFirst("div.txt-box");

                            Element img = imgbox.selectFirst("img");
                            String imgurl = "https:" + img.attr("src");

                            Element titlea = txtbox.selectFirst("h3 a");
                            String title = titlea.text();

                            String newsurl = titlea.attr("href");

                            Element txtinfo = txtbox.selectFirst("p.txt-info");

                            String info = txtinfo.text();

                            Articles articles = new Articles();
                            articles.setTitle(title);
                            articles.setDescription(info);
                            articles.setPicUrl(imgurl);
                            articles.setUrl(url);
                            articlesList.add(articles);

                            logger.debug(articles.toString());
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }

        return articlesList;
    }

}
