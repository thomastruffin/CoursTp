package job.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.bo.CoursBo;
import data.dao.GenericDaoImpl;
@Service
public class CoursBll implements CRUDBLLInterfaces<CoursBo, Integer> {
	//@Autowired
	GenericDaoImpl<CoursBo, Integer> cours = new GenericDaoImpl<>(CoursBo.class);
	@Override
	public List<CoursBo> getAll(){
		return cours.selectAll();
	}

	@Override
	public CoursBo getById(Integer id) {
		return cours.selectById(id);
	}

	@Override
	public CoursBo delete(Integer id) {
		return cours.delete(id);
	}

	@Override
	public CoursBo update(CoursBo bo) {
		return cours.update(bo);
	}

	@Override
	public void insert(CoursBo bo) {
		cours.insert(bo);
		
	}
	
	public void setCours(GenericDaoImpl<CoursBo, Integer> cours) {
		this.cours = cours;
	}

}
