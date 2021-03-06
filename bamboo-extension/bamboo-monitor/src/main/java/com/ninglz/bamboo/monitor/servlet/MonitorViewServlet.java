package com.ninglz.bamboo.monitor.servlet;

import com.alibaba.druid.support.http.ResourceServlet;
import com.ninglz.bamboo.monitor.service.MonitorStatService;
import com.ninglz.bamboo.monitor.util.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;

/**
 * @author linchtech
 * @date 2020-09-16 11:10
 **/
@Slf4j
public class MonitorViewServlet extends ResourceServlet {

    private MonitorStatService monitorStatService;

    public MonitorViewServlet() {
        super("support/http/resources");
    }

    @Override
    public void init() throws ServletException {
        log.info("init MonitorViewServlet");
        super.init();
        monitorStatService = SpringContextUtils.getBean(MonitorStatService.class);
    }

    @Override
    protected String process(String url) {
        return monitorStatService.service(url);
    }

}
