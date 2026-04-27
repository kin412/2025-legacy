package com.kin.oracle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kin.oracle.service.oracleService;
import com.kin.oracle.service.oracleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor - 스프링 레거시는 이거 하려면 @NoArgsConstructor(force = true) 이것도 해줘야함.
//부트는 주입에 대한 완벽한 지원을 하도록 설계해서 하나만으로 되지만 레거시는 안됨
@Controller
@RequestMapping("/oracle")
public class oracleController {
	
	@Autowired
	private oracleService oracleService;
	
	@RequestMapping("/index.do")
	public String WebSquareIndexPage() {
		log.info("--oracle/index.do");
		return "oracle/oracleIndex";
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertTest.do")
	public Map<String, Object> insertTest(@ModelAttribute oracleVo oracleVo) {
		log.info("--oracle/insertTest.do");
		return oracleService.insertTest(oracleVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/procedureTest.do")
	public Map<String, Object> procedureTest(@ModelAttribute oracleVo oracleVo) {
		log.info("--oracle/procedureTest.do");
		return oracleService.procedureTest(oracleVo);
	}
	
}
