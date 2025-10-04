package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeRepository extends JpaRepository<KnowledgeTable, Integer> {
    KnowledgeTable findByPaperId(int paperId);

    @Query("SELECT k.year, COUNT(k.year) " +
            "FROM KnowledgeTable k " +
            "GROUP BY k.year " +
            "ORDER BY COUNT(k.year) DESC")
    List<Integer[]> countOccurrencesByYear();
}
