package demo.restservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurriculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String email;
    private String telefone;
    private String[] competencias;

    public CurriculoModel(String nome, String email, String telefone, String[] competencias) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.competencias = competencias;
    }

    public void Update(CurriculoModel curriculo) {
		if (curriculo != null) {
			this.nome = curriculo.nome;
            this.email = curriculo.email;
            this.telefone = curriculo.telefone;
            this.competencias = curriculo.competencias;
		}
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String[] getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String[] competencias) {
        this.competencias = competencias;
    }

    
}

