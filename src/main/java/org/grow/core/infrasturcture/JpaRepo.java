package org.grow.core.infrasturcture;

import org.grow.core.domain.TrainingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<TrainingMember,Long> {

    TrainingMember findByMemberCode(String memberCode);

    void deleteByMemberCode(String memberCode);

}
