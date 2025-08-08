package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
        @RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
                var medico = new Medico(dados);
        repository.save(medico);

        //gera a URI do novo recurso criado
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> Listar(@PageableDefault(size =10, sort ={"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page); 
    }

    @PutMapping
    @Transactional
    public  ResponseEntity  Atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {

       var medico = repository.getReferenceById(dados.id());
medico.AtualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    //deixando o parâmetro id de forma dinâmica
    //A notação @PatchVariable antes do Long id é para dizer ao spring que é o parâmmetro variável definida no @DeleteMapping
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Excluir(@PathVariable Long id) {
//re    pository.deleteById(id);;
        var medico = repository.getReferenceById(id);
            medico.Excluir();
        return ResponseEntity.noContent().build();  
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    //
}
