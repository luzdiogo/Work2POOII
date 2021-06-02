package modelo.dao;

import model.entities.Aluno;
import java.util.List;

public interface AlunoDAO {

	void insert(Aluno obj);
	void update(Aluno obj);
	void deleteByid(int id);
	Aluno findByid(int id);
	List<Aluno> getLista();
}
