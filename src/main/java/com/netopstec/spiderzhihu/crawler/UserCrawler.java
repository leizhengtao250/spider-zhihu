package com.netopstec.spiderzhihu.crawler;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.spring.common.CrawlerCache;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import com.netopstec.spiderzhihu.common.HttpConstants;
import com.netopstec.spiderzhihu.domain.User;
import com.netopstec.spiderzhihu.domain.UserRepository;
import com.netopstec.spiderzhihu.json.UserInfo;
import com.netopstec.spiderzhihu.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.seimicrawler.xpath.JXDocument;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 爬取知乎用户信息的爬虫类
 * @author zhenye 2019/6/20
 */
@Slf4j
@Crawler(name = "user-crawler", httpTimeOut = 5000)
public class UserCrawler extends BaseSeimiCrawler{

    private static Logger log = Logger.getLogger(UserCrawler.class.getClass());
    @Autowired
    private UserRepository userRepository;

    @Override
    public String[] startUrls() {
        return new String[]{ HttpConstants.ZHIHU_USER_BASEINFO_URL_PREFIX + USER_URL_TOKEN  + HttpConstants.ZHIHU_USER_INFO_SUFFIX };
    }

    @Override
    public void start(Response response) {
        log.info("正在爬取[{}]用户的基本信息..."+" "+USER_URL_TOKEN);
        JXDocument document = response.document();
        String zhihuUserInfoJson = document.selN("body").get(0).asElement().text();
        // 用户的简介信息中可能会有双引号，会影响json解析---手动删除简介信息
        zhihuUserInfoJson = JsonUtil.removeTheStringFieldValue(zhihuUserInfoJson, false, "headline", "gender");
        UserInfo userInfo = JsonUtil.string2Obj(zhihuUserInfoJson, UserInfo.class);
        User user = UserInfo.toEntity(userInfo);
        userRepository.save(user);
    }

    private static String USER_URL_TOKEN;

    /**
     * 从知乎，获取一个用户的信息
     * @param urlToken 该用户的token(每个知乎用户有唯一的url_token)
     */
    public static void getUserInfoFromZhihu(String urlToken) {
        USER_URL_TOKEN = urlToken;
        String url = HttpConstants.ZHIHU_USER_BASEINFO_URL_PREFIX + USER_URL_TOKEN + HttpConstants.ZHIHU_USER_INFO_SUFFIX;
        Request request = Request.build(url, "start");
        request.setCrawlerName("user-crawler");
        CrawlerCache.consumeRequest(request);
    }
}
