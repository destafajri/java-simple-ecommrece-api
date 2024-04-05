package com.destaproject.user.infrastructure.datasource.jpa.repository;

import com.destaproject.user.infrastructure.datasource.jpa.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

    @Query(value = """
            select t from UserToken t inner join User u
            on t.user.id = u.id
            where u.id = :user_id and (t.expired = false or t.revoked = false)
            """)
    List<UserToken> findAllValidTokenByUser(Long user_id);

    Optional<UserToken> findByToken(String token);
}
