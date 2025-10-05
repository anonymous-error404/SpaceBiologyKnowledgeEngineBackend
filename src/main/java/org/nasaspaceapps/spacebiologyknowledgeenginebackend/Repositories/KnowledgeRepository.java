package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT k.researchArea, COUNT(k.researchArea) " +
            "FROM KnowledgeTable k " +
            "GROUP BY k.researchArea " +
            "ORDER BY COUNT(k.researchArea) DESC")
    List<Object[]> countOccurrencesByResearchArea();

    List<KnowledgeTable> findFirst10ByPaperIdGreaterThanOrderByPaperIdAsc(int id);

    @Query("SELECT k.title, k.url FROM KnowledgeTable k ORDER BY k.viewCount DESC limit 10")
    List<String[]> findTopTenMostViewed();

    @Query(
            value = "SELECT k.title, k.url " +
                    "FROM knowledge_table k " +
                    "JOIN knowledge_table_authors a ON k.paper_id = a.knowledge_table_paper_id " +
                    "WHERE a.authors = :authorName",
            nativeQuery = true
    )
    List<String[]> findPapersByAuthorName(String authorName);

    @Query(
            value = "SELECT * FROM knowledge_table k WHERE k.publication = :publication",
            nativeQuery = true
    )
    List<KnowledgeTable> findPapersByPublication(String publication);

    @Query(
            value = "SELECT a.authors, k.title, k.url " +
                    "FROM knowledge_table k " +
                    "JOIN knowledge_table_authors a ON k.paper_id = a.knowledge_table_paper_id",
            nativeQuery = true
    )
    List<Object[]> findAllAuthorsWithTheirPapersRaw();

    @Query(
            value = "SELECT k.publication, k.title, k.url " +
                    "FROM knowledge_table k",
            nativeQuery = true
    )
    List<Object[]> findAllPublicationsWithTheirPapersRaw();

    @Query(
            value = "SELECT k.paper_id, k.title, k.url, k.publication, k.research_area, kw.keywords " +
                    "FROM knowledge_table k " +
                    "LEFT JOIN knowledge_table_keywords kw ON k.paper_id = kw.knowledge_table_paper_id " +
                    "WHERE k.paper_id = :paperId",
            nativeQuery = true
    )
    List<Object[]> findPaperWithKeywords(@Param("paperId") int paperId);

    @Query(value = """
            SELECT DISTINCT k.paper_id, k.title
            FROM knowledge_table k
            LEFT JOIN knowledge_table_keywords kw ON k.paper_id = kw.knowledge_table_paper_id
            WHERE LOWER(k.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
               OR LOWER(kw.keywords) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
               OR LOWER(k.research_area) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            """, nativeQuery = true)
    List<Object[]> searchByTerm(@Param("searchTerm") String searchTerm);

}
