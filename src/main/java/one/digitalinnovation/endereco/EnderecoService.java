package one.digitalinnovation.endereco;

import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService {

    @Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ViaCepService viaCepService;

    public Endereco findById(String cep) {
         return enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);

			return novoEndereco;
		});
    }

 
    
}
