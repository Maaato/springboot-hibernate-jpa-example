package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
