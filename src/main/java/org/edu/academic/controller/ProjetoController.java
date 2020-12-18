package org.edu.academic.controller;

import org.edu.academic.model.Projeto;
import org.edu.academic.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
    private ProjetoService projetoService;

    // GET endpoints

    @ApiOperation(value = "Busca por todos os projetos cadastrados")
    @GetMapping()
    public Iterable<Projeto> getProjetos() {
        return this.projetoService.getProjetos();
    }

    @ApiOperation(value = "Busca um projeto pelo 'id'")
    @GetMapping("/{id}")
    public Projeto getProjetoById(@PathVariable String id) {
        return this.projetoService.getProjetoById(id);
    }

    // POST endpoints

    @ApiOperation(value = "Insere um projeto Banco de Dados")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public Projeto postProjeto(@RequestBody Projeto projeto) throws Exception {
        return this.projetoService.postProjeto(projeto);
    }

    // PUT endpoints

    @ApiOperation(value = "Atualiza os dados de um projeto no Banco de Dados")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public Projeto putProjeto(@PathVariable String id, @RequestBody Projeto projeto) throws Exception {
        projeto.setId(id);
        return this.projetoService.putProjeto(id, projeto);
    }

    // DELETE endpoints

    @ApiOperation(value = "Deleta um projeto do Banco de Dados")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProjeto(@PathVariable String id) {
        this.projetoService.deleteProjeto(id);
    }
}
