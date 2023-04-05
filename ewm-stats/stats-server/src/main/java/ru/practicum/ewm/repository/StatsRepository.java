package ru.practicum.ewm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.EndpointHit;
import ru.practicum.ewm.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<EndpointHit, Long> {
    @Query("SELECT NEW ru.practicum.ewm.model.ViewStats(hit.app, hit.uri, COUNT(DISTINCT hit.ip)) " +
            "FROM EndpointHit hit " +
            "WHERE hit.timestamp >= :start " +
            "AND hit.timestamp <= :end " +
            "AND hit.uri IN (:uris) " +
            "GROUP BY hit.app, hit.uri " +
            "ORDER BY COUNT(DISTINCT hit.ip) DESC")
    List<ViewStats> getStatisticsByUris(@Param("start") LocalDateTime start,
                                        @Param("end") LocalDateTime end,
                                        @Param("uris") List<String> uris
    );

    @Query("SELECT NEW ru.practicum.ewm.model.ViewStats(hit.app, hit.uri, COUNT(hit.ip)) " +
            "FROM EndpointHit hit " +
            "WHERE hit.timestamp >= :start " +
            "AND hit.timestamp <= :end " +
            "AND hit.uri IN (:uris) " +
            "GROUP BY hit.app, hit.uri " +
            "ORDER BY COUNT(hit.ip) DESC")
    List<ViewStats> getUniqueStatisticsByUris(@Param("start") LocalDateTime start,
                                              @Param("end") LocalDateTime end,
                                              @Param("uris") List<String> uris
    );
}
