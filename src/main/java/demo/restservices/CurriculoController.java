package demo.restservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;


@Controller
@RequestMapping(value="/api")
@CrossOrigin
public class CurriculoController {


	@Autowired
	private CurriculoService service;

	// Get all curriculos.
	@GetMapping(value="/curriculos")
	public ResponseEntity<Collection<CurriculoModel>> getCurriculos() {
		Collection<CurriculoModel> result = service.getCurriculos();
		return ResponseEntity.ok().body(result);
	}

	// Get a specific curriculo.
	@GetMapping(value="/curriculo/{id}")
	public ResponseEntity<Optional<CurriculoModel>> getCurriculo(@PathVariable Long id) {
		Optional<CurriculoModel> result = service.getCurriculo(id);
		if (service.getCurriculo(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(result);
	}

	// Insert a new curriculo.
	@PostMapping(value="/curriculo")
	public ResponseEntity<CurriculoModel> addCurriculo(@RequestBody CurriculoModel curriculo) {
		service.insert(curriculo);
		URI uri = URI.create("/item/" + curriculo.getId());
		return ResponseEntity.created(uri).body(curriculo);
	}

	// Update an existing curriculo.
	@PutMapping(value="/curriculo/{id}")
	public ResponseEntity<Object> modifyCurriculo(@PathVariable Long id, @RequestBody CurriculoModel curriculo) {
		if (service.getCurriculo(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.update(curriculo);
			return ResponseEntity.ok().build();
		}
	}

	// Delete an existing curriculo.
	@DeleteMapping("/curriculo/{id}")
	public  ResponseEntity<Object> deleteCurriculo(@PathVariable Long id) {
		if (service.getCurriculo(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
