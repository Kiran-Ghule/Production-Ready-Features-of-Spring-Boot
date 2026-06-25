package com.week4.production_Ready.controllers;

import com.week4.production_Ready.entities.PostEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.configuration.internal.metadata.reader.AuditedPropertiesReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/Audit")
public class AuditController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/Get/{postid}")
    public List<PostEntity> getPostsRevision(@PathVariable String postid) {
        AuditReader reader =  AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(PostEntity.class, postid);
        return  revisions.stream()
                .map(revisionNumber -> reader.find(PostEntity.class, postid, revisionNumber))
                .collect(Collectors.toList());
    }
}
