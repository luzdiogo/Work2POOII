package model.entities;

public class Aluno {
	
	private int id;
	private String nome;
	private String sexo;
	/*private Date dt_nasc; */
	
	public Aluno() {
	}
	public Aluno(int id, String nome, String sexo /*Date dt_nasc*/) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		/*this.dt_nasc = dt_nasc;*/
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/*
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/* result = prime * result + ((dt_nasc == null) ? 0 : dt_nasc.hashCode()); */
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		/*if (dt_nasc == null) {
			if (other.dt_nasc != null)
				return false;
		} else if (!dt_nasc.equals(other.dt_nasc))
			return false; */
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + /* dt_nasc + */"]";
	}	
}
