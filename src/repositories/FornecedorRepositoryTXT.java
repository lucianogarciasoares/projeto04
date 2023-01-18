package repositories;

import java.io.PrintWriter;

import entities.Fornecedor;
import entities.Produto;
import interfaces.IFornecedorRepository;

public class FornecedorRepositoryTXT implements IFornecedorRepository {

	@Override
	public void exportar(Fornecedor fornecedor) throws Exception {

		PrintWriter printWriter = new PrintWriter("c:\\temp\\fornecedor.txt");

		printWriter.write("ID do FORNECEDOR....:" + fornecedor.getIdFornecedor());
		printWriter.write("Nome................:" + fornecedor.getNome());
		printWriter.write("Cnpj................:" + fornecedor.getCnpj());

		for (Produto produto : fornecedor.getProdutos()) {

			printWriter.write("\n\tId do Produto.....:" + produto.getIdProduto());
			printWriter.write("\n\tNome..............:" + produto.getNome());
			printWriter.write("\n\tPreço.............:" + produto.getPreco());
			printWriter.write("\n\tQuantidade........:" + produto.getQuantidade());

		}
		printWriter.flush();
		printWriter.close();

	}

}
