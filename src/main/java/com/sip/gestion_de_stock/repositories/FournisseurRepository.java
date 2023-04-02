package com.sip.gestion_de_stock.repositories;

import com.sip.gestion_de_stock.entities.Fournisseur;
import com.sip.gestion_de_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long>{

    @Query("SELECT p FROM Produit p Where  p.idFournisseur=:id")
    List<Produit> findProduitByFournisseur(@Param("id") Long id);


}
