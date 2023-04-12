package filedown;

import java.util.ArrayList;

public class FileDownService {
	private FileDownDao dao;
	public static final String downDir="C:\\down\\";
	
	public FileDownService() {
		dao = new FileDownDao();
	}
	
	public void addFile(FileDownVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<FileDownVo> getAll(){
		return dao.selectAll();
	}
	
	public FileDownVo getById(int id) {
		return dao.select(id);
	}
	
	public void delFile(int num) {
		dao.delete(num);
	}
	
	public void upCnt(int num) {
		dao.updateCnt(num);
	}
}
