package com.kin.error.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class errorController {

	@RequestMapping(value = "/error/accessError.do")
	public String accessError(HttpServletRequest request, Authentication auth) {
		
		
		log.info("--/error/accessError.do");
		log.info("--auth : " + auth);
		log.info("--_csrf : " + request.getParameter("_csrf"));
		log.info("--id : " + request.getParameter("id"));
		log.info("--pw : " + request.getParameter("pw"));
		
		return "error/accessError";
	}
	
	@RequestMapping(value = "/error/exceptionError.do")
	public String exceptionError(HttpServletRequest request) {
		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	    String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
	    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
	    String exceptionMsg = (throwable != null) ? throwable.getMessage() : "Exception 정보 없음";

	    log.error("====================================================");
	    log.error("에러 발생 컨트롤러 호출: /error/exceptionError.do");
	    log.error("상태 코드 (Status Code): {}", statusCode);
	    log.error("요청 경로 (Request URI): {}", requestUri);
	    if (throwable != null) {
	        // 스택 트레이스 전체를 찍고 싶다면 마지막 인자에 throwable 객체를 넣으세요.
	        log.error("에러 메시지: {}", exceptionMsg, throwable);
	    } else {
	        log.error("에러 메시지: {}", exceptionMsg);
	    }
	    log.error("====================================================");
		
		return "error/exceptionError";
	}
	
}
