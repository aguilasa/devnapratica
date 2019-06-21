package br.com.senior.furb.basico.pedido;

public interface ItemRepositoryCustom {
	/**
	 * Quantidade de itens
	 * @param id
	 * @return
	 */
	Long findQuantityById(String id);

}
