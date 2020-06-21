/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author solucionesit
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface IGenericRepo <T,ID>extends JpaRepository<T, ID>{
    
}
