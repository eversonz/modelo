package com.everson.action;

import java.math.BigInteger;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.everson.common.enums.MascotEnum;
import com.everson.common.util.ArithmeticUtil;
import com.everson.common.vo.UrnVO;
import com.everson.ejb.UrnBeanRemote;

@Namespace("/")
public class VoteAction extends DefaultAction {
		
	private String masc;
	private String jcaptcha;
	private String [] votes = new String [3];
	
	private UrnBeanRemote urnBean;
	private static final long serialVersionUID = 2668158413650658380L;
	
	public VoteAction() {
		try {
			urnBean = (UrnBeanRemote) getBeanEJB(UrnBeanRemote.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Action(value="vote",results={ 
			@Result(name="success",location="/pages/vote.jsp")})	
	public String vote() throws Exception {
		
		if (masc != null) {
			if (!isCaptcha(jcaptcha)) {
				addActionError(getText("error.captcha"));
				return SUCCESS;
			}
			
			MascotEnum mascotEnum = urnBean.voteMascote(Integer.valueOf(masc));
			
			addActionMessage(getText("vote.success") + " " + mascotEnum.getName());
		}

		return SUCCESS;
	}

	@Action(value="result",results={ 
			@Result(name="success",location="/pages/result.jsp")})
	public String result() throws Exception {
		
		 UrnVO urnVO = urnBean.urnVotes();
		 
		BigInteger total = urnVO.getAmijubi().add(urnVO.getFuleco()).add(urnVO.getZuzeco());
			
		votes[0] = ArithmeticUtil.percent(urnVO.getAmijubi(), total).toString();
		votes[1] = ArithmeticUtil.percent(urnVO.getFuleco(), total).toString();
		votes[2] = ArithmeticUtil.percent(urnVO.getZuzeco(), total).toString();
		
		return SUCCESS;
	}

	public String getMasc() {
		return masc;
	}

	public void setMasc(String masc) {
		this.masc = masc;
	}

	public String[] getVotes() {
		return votes;
	}

	public void setVotes(String[] votes) {
		this.votes = votes;
	}

	public String getJcaptcha() {
		return jcaptcha;
	}

	public void setJcaptcha(String jcaptcha) {
		this.jcaptcha = jcaptcha;
	}
	
	
}
