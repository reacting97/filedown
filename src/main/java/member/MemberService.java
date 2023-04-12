package member;

//서비스: 기능 제공 클래스.
//컨트롤러(서블릿)에 요청오면 그 요청을 처리할 기능을 구현해야 함 => 서비스에 메서드로 구현
public class MemberService {
	private MemberDao dao;

	
	public MemberService() {
		dao = new MemberDao();
	}
	
	//파람에 사용자 입력값 있음
	public void join(MemberVo vo) {
		dao.insert(vo);
	}

	//파람으로 id받아서 동일한 id가 있는지 검색하여 vo객체 반환
	public MemberVo getMember(String id) {
		return dao.select(id);
	}

	//수정할 새 값을 파람으로 받음
	public void editMyInfo(MemberVo vo) {
		dao.update(vo);
	}

	public void delMember(String id) {
		dao.delete(id);
	}
}
