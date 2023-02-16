package com.gyojincompany.home.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gyojincompany.home.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map =  model.asMap();
		//model 객체 안에 있는 request를 map 매핑
		HttpServletRequest request = (HttpServletRequest) map.get("request");		
		
		String bid = request.getParameter("bid");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDao dao = new BDao();
		dao.modify(bid, btitle, bcontent);

	}

}
