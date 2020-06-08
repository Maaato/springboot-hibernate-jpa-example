package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Document;

public interface DocumentService {

	Document createDocument(Document document);

	Document updateDocument(Document document);

	List<Document> getAllDocument();

	Document getDocumentById(long documentId);

	void deleteDocument(long documentId);
}