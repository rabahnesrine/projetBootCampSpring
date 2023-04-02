package com.sip.gestion_de_stock.repositories;

import com.sip.gestion_de_stock.entities.Produit;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Produit,Long>{}
