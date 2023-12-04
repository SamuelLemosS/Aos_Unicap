package demo.restservices;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

	public Optional<CurriculoModel> getCurriculo(Long id) {
		return curriculoRepository.findById(id);
	}

	public Collection<CurriculoModel> getCurriculos() {
        return (Collection<CurriculoModel>) curriculoRepository.findAll();
	}

	public CurriculoModel insert(CurriculoModel curriculo) {
		return curriculoRepository.save(curriculo);
	}

	public CurriculoModel update(CurriculoModel curriculo) {
		return curriculoRepository.save(curriculo);
	}

	public void delete(Long id) {
		curriculoRepository.deleteById(id);
	}
    
}
