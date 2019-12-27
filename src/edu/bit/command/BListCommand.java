package edu.bit.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.BDao;
import edu.bit.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		request.setAttribute("list", dtos); //request에 리스트 이름으로 어레이리스트 첫번째 주소를 담는다. 객체만 전달하는게 model2 방식이다.
											//핵심코드
	}

}
