package br.com.senior.furb.basico.pedido;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.senior.furb.basico.QItemEntity;
import br.com.senior.furb.basico.core.RepositoryBaseJpa;


@Repository
public class ItemRepositoryCustomImpl extends RepositoryBaseJpa implements ItemRepositoryCustom {

	@Override
	public Long findQuantityById(String id) {
		UUID uuidToFind = UUID.fromString(id);
		
		QItemEntity itens = QItemEntity.itemEntity;
		JPAQuery<Double> query= select(itens.quantidade).from(itens).where(itens.id.eq(uuidToFind));
		
		return query.fetch().get(0).longValue();
		}

}
