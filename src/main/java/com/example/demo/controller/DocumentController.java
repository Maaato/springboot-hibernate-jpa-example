package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Document;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/documents")
	public ResponseEntity<List<Document>> getAllDocuments(){
		return ResponseEntity.ok().body(documentService.getAllDocument());
	}
	@GetMapping("/documents/{id}")
	public ResponseEntity<Document> getDocumentById(@PathVariable long id){
		return ResponseEntity.ok().body(documentService.getDocumentById(id));
	}
	@PostMapping("/documents")
	public ResponseEntity<Document> createDocument(@RequestBody Document document){
		return ResponseEntity.ok().body(this.documentService.createDocument(document));
	}
	@PutMapping("/documents/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable long id,@RequestBody Document document){
		document.setId(id);
		return ResponseEntity.ok().body(this.documentService.updateDocument(document));
	}
	@DeleteMapping("/documents/{id}")
	public HttpStatus deleteDocument(@PathVariable long id){
		this.documentService.deleteDocument(id);
		return HttpStatus.OK;
		
	}
}
