package com.computer.campaign.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 *
*封装竞选者信息
 * */
public class Participant implements Serializable {
//pid,竞选职位sid，imgsrc，竞选词路径wordsrc，得票数ppoll
	private String p_id;//个人竞选id
	//p_id组成"p"+su_id
	private String p_name;//竞选者自定义名称
	private String s_id;//竞选类别id
	private String d_id;//所处组织id
	private String imgsrc;//图片路径
	private MultipartFile imgFile;
	private String wordsrc;//竞选词路径
	private	int p_poll;//获得票数
	private Department department;//用于resultMap竞选人与组织一对一
	private Sort sort;//用于resultMap竞选人与竞选组织一对一
	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getD_id() {
		return d_id;
	}

	public void setD_id(String d_id) {
		this.d_id = d_id;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getWordsrc() {
		return wordsrc;
	}

	public void setWordsrc(String wordsrc) {
		this.wordsrc = wordsrc;
	}

	public int getP_poll() {
		return p_poll;
	}

	public void setP_poll(int p_poll) {
		this.p_poll = p_poll;
	}

	@Override
	public String toString() {
		return "Participant{" +
				"p_id='" + p_id + '\'' +
				", p_name='" + p_name + '\'' +
				", s_id='" + s_id + '\'' +
				", d_id='" + d_id + '\'' +
				", imgsrc='" + imgsrc + '\'' +
				", imgFile=" + imgFile +
				", wordsrc='" + wordsrc + '\'' +
				", p_poll=" + p_poll +
				", department=" + department +
				", sort=" + sort +
				'}';
	}
}

