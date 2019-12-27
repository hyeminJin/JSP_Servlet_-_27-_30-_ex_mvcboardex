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
		
		request.setAttribute("list", dtos); //request�� ����Ʈ �̸����� ��̸���Ʈ ù��° �ּҸ� ��´�. ��ü�� �����ϴ°� model2 ����̴�.
											//�ٽ��ڵ�
	}

}