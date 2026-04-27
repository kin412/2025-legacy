package com.kin.oracle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kin.oracle.service.oracleService;
import com.kin.oracle.service.oracleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@RequiredArgsConstructor - 스프링 레거시는 이거 하려면 @NoArgsConstructor(force = true) 이것도 해줘야함.
//부트는 주입에 대한 완벽한 지원을 하도록 설계해서 하나만으로 되지만 레거시는 안됨
public class oracleServiceImpl implements oracleService {
	
	@Autowired
	private oracleMapper mapper;

	@Override
	public Map<String, Object> insertTest(oracleVo oracleVo) {
		
		Map map = new HashMap<String, Object>();
		
		try {
			int seq = mapper.insertTest(oracleVo);
			map.put("seq", seq);
			map.put("message", "등록완료");
		}catch (Exception e) {
			log.info("--------------------" + e.getMessage());
            map.put("message", e.getMessage());
			map.put("result", "FAIL");
		}
		return map;
	}

	@Override
	public Map<String, Object> procedureTest(oracleVo oracleVo) {
		
		Map map = new HashMap<String, Object>();
		Map resultMap = new HashMap<String, Object>();
		try {
			//프로시저는 parameterType으로 들어간 oracleVo 가 return정보를 가지고 있는다. 따라서 oracleVo를 넣어주면된다.
			//resultMap = mapper.procedureTest(oracleVo);
			
			mapper.procedureTest(oracleVo);
			
			map.put("message", "프로시저 등록완료");
			map.put("resultMap", oracleVo);
		}catch (Exception e) {
			log.info("--------------------" + e.getMessage());
            map.put("message", e.getMessage());
			map.put("result", "FAIL");
		}
		
		
		return map;
	}

}
