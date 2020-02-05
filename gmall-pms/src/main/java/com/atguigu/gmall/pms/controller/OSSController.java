package com.atguigu.gmall.pms.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.atguigu.core.bean.Resp;
import com.atguigu.core.exception.RRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenGJ
 * @since 2020/1/11 9:26
 */
@RestController
@RequestMapping("/pms/oss")
public class OSSController {

	@GetMapping("/policy")
	public Resp policy() {
		String accessId = "LTAI4FxKp1J64htwTEf5hT9s"; // 请填写您的AccessKeyId。
		String accessKey = "PFbeRfJjV5mBhz8HJdkNsz2mfIjrje"; // 请填写您的AccessKeySecret。
		String endpoint = "oss-cn-beijing.aliyuncs.com"; // 请填写您的 endpoint。
		String bucket = "my-gmall"; // 请填写您的 bucketname 。
		String host = "https://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dir = simpleDateFormat.format(new Date()); // 用户上传文件时指定的前缀。

		OSSClient client = new OSSClient(endpoint, accessId, accessKey);
		try {
			long expireTime = 30;
			long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
			Date expiration = new Date(expireEndTime);
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

			String postPolicy = client.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String encodedPolicy = BinaryUtil.toBase64String(binaryData);
			String postSignature = client.calculatePostSignature(postPolicy);

			Map<String, String> respMap = new LinkedHashMap<String, String>();
			respMap.put("accessid", accessId);
			respMap.put("policy", encodedPolicy);
			respMap.put("signature", postSignature);
			respMap.put("dir", dir);
			respMap.put("host", host);
			respMap.put("expire", String.valueOf(expireEndTime / 1000));

			return Resp.ok(respMap);
		} catch (Exception e) {
			throw new RRException("获取OSS上传签名失败");
		}

	}
}
