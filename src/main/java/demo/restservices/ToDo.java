package demo.restservices;

public class ToDo {
    private int id;
	private String descricao;
	private boolean feita;

    public ToDo(String descricao, boolean feita) {
        this.descricao = descricao;
        this.feita = feita;
    }

    public void Update(ToDo toDo) {
		if (toDo != null) {
			this.descricao  = toDo.descricao;
			this.feita = toDo.feita;
		}
	}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isFeita() {
        return feita;
    }
    public void setFeita(boolean feita) {
        this.feita = feita;
    }
}
