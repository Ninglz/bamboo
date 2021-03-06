///*
// *
// *      Copyright (c) 2018-2025, lengleng All rights reserved.
// *
// *  Redistribution and use in source and binary forms, with or without
// *  modification, are permitted provided that the following conditions are met:
// *
// * Redistributions of source code must retain the above copyright notice,
// *  this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
// *  notice, this list of conditions and the following disclaimer in the
// *  documentation and/or other materials provided with the distribution.
// *  Neither the name of the pig4cloud.com developer nor the names of its
// *  contributors may be used to endorse or promote products derived from
// *  this software without specific prior written permission.
// *  Author: lengleng (wangiegie@gmail.com)
// *
// */
//
//package com.ninglz.bamboo.upms.api;
//
//import com.ninglz.bamboo.common.core.constant.SecurityConstants;
//import com.ninglz.bamboo.common.core.constant.ServiceNameConstants;
//import com.ninglz.bamboo.common.core.util.StatusResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//
///**
// * @author lengleng
// * @date 2020/12/05
// */
//@FeignClient(contextId = "remoteClientDetailsService", value = ServiceNameConstants.UPMS_SERVICE)
//public interface RemoteClientDetailsService {
//
//	/**
//	 * 通过clientId 查询客户端信息
//	 * @param clientId 用户名
//	 * @param from 调用标志
//	 * @return StatusResponse
//	 */
//	@GetMapping("/client/getClientDetailsById/{clientId}")
//	StatusResponse getClientDetailsById(@PathVariable("clientId") String clientId,
//										@RequestHeader(SecurityConstants.FROM) String from);
//
//}
