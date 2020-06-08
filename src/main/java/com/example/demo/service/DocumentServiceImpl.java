package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Document;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DocumentRepository;

@Service
@Transactional

public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Document createDocument(Document document) {
		return documentRepository.save(document);
	}

	@Override
	public Document updateDocument(Document document) {
		Optional<Document> documentDb = this.documentRepository.findById(document.getId());

		if (documentDb.isPresent()) {
			Document documentUpdate = documentDb.get();
			documentUpdate.setId(document.getId());
			documentUpdate.setName(document.getName());
			documentUpdate.setVersion(document.getVersion());
			documentUpdate.setFileUrl(document.getFileUrl());
			documentRepository.save(documentUpdate);
			return documentUpdate;
		} else {
			throw new ResourceNotFoundException("Documento ID : " + document.getId() + " no encontrado.");
		}
	}

	@Override
	public List<Document> getAllDocument() {
		return this.documentRepository.findAll();
	}

	@Override
	public Document getDocumentById(long documentId) {
		Optional<Document> documentDb = this.documentRepository.findById(documentId);
		if (documentDb.isPresent()) {
			return documentDb.get();
		} else {
			throw new ResourceNotFoundException("Documento ID no encontrado.");
		}
	}

	@Override
	public void deleteDocument(long documentId) {
		Optional<Document> documentDb = this.documentRepository.findById(documentId);
		if (documentDb.isPresent()) {
			this.documentRepository.delete(documentDb.get());
		} else {
			throw new ResourceNotFoundException("Documento ID : " + documentId + " no encontrado.");
		}

	}

}