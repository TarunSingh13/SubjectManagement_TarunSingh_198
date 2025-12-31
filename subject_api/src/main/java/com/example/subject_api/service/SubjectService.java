package com.example.subject_api.service;

import com.example.subject_api.model.Subject;
import com.example.subject_api.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public Subject save(Subject subject) {
        return repository.save(subject);
    }

    public List<Subject> getAll() {
        return repository.findAll();
    }

    public Subject getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public Subject update(Long id, Subject subject) {
        Subject existing = getById(id);
        existing.setSubjectCode(subject.getSubjectCode());
        existing.setSubjectName(subject.getSubjectName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
