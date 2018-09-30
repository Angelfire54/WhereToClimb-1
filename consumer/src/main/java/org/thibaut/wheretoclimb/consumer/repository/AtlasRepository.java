package org.thibaut.wheretoclimb.consumer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.thibaut.wheretoclimb.model.entity.Atlas;

@Repository
public interface AtlasRepository  extends JpaRepository< Atlas, Integer > {

	public Atlas findByName(String name);

	@Query("SELECT atlas FROM Atlas atlas WHERE lower(atlas.name) like :keyword")
	public Page<Atlas> searchAtlas( @Param( "keyword" ) String keyword, Pageable pageable );
	//j'ai l'impression que le mini traitement lower relève de la couche business, mais pas sur...
}
