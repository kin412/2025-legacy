package com.kin.oracle.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class oracleVo {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int cnt;
	
	//프로시저 용
	private int outSeq;
	private String outTitle;
	private String outWriter;
	private String outContent;
	private String outRegdate;
	private int outCnt;
}
