package interfaces;

import entities.Fornecedor;

public interface IFornecedorRepository {
	
	void exportar(Fornecedor fornecedor) throws Exception;
}
