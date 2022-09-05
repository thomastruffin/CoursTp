package job.bll;

import java.util.List;

public interface CRUDBLLInterfaces<BO,ID> {
	public List<BO> getAll();
	public BO getById(ID id);
	public BO delete(ID id);
	public BO update(BO bo);
	public void insert(BO bo);
}
