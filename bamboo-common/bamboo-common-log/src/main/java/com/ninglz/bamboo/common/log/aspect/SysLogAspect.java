/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.ninglz.bamboo.common.log.aspect;

import com.ninglz.bamboo.common.core.util.KeyStrResolver;
import com.ninglz.bamboo.common.log.annotation.SysLog;
import com.ninglz.bamboo.common.log.event.SysLogEvent;
import com.ninglz.bamboo.common.log.util.LogTypeEnum;
import com.ninglz.bamboo.common.log.util.SysLogUtils;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 操作日志使用spring event异步入库
 *
 * @author L.cm
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class SysLogAspect {

	private final ApplicationEventPublisher publisher;

	private final KeyStrResolver tenantKeyStrResolver;

	@SneakyThrows
	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		log.debug("调用: [类名]:{},[方法]:{}", strClassName, strMethodName);

		SysLogAddCmd sysLogAddCmd = SysLogUtils.getSysLog();
		sysLogAddCmd.setTitle(sysLog.value());
		// 发送异步日志事件
		Long startTime = System.currentTimeMillis();
		Object obj;
		try {
			obj = point.proceed();
		}
		catch (Exception e) {
			sysLogAddCmd.setType(LogTypeEnum.ERROR.getType());
			sysLogAddCmd.setException(e.getMessage());
			throw e;
		}
		finally {
			Long endTime = System.currentTimeMillis();
			sysLogAddCmd.setTime(endTime - startTime);
			log.error("tenantId:{}",tenantKeyStrResolver.key());
			sysLogAddCmd.setTenantId(Integer.parseInt(tenantKeyStrResolver.key()));
			publisher.publishEvent(new SysLogEvent(sysLogAddCmd));
		}
		return obj;
	}

}
