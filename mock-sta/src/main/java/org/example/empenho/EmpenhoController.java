package org.example.empenho;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ordembancaria")
public class EmpenhoController {

	@RequestMapping("/empenho/{id}")
	public ResponseEntity<EmpenhoDTO> index(@PathVariable String id) {
		EmpenhoDTO empenhoDTO = new EmpenhoDTO();
		empenhoDTO.setId(id);
		return ResponseEntity.ok(empenhoDTO);
	}
}

