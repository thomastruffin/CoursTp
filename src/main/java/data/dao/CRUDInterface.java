package data.dao;

import java.util.List;

public interface CRUDInterface<BO , ID> {
	public List<BO> selectAll();
	public BO selectById(ID id);
	public BO update(BO bo);
	public BO delete(ID id);
	public void insert(BO bo);
}
