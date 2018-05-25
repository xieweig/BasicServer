package org.grow.core.head_tobody;

import org.grow.core.domain.TrainingMember;
import org.grow.core.infrasturcture.Assistant;
import org.springframework.stereotype.Service;

@Service
public class TrainingMemberManager extends StaticBigHead<TrainingMember> {

    public TrainingMember saveNew(Assistant<TrainingMember> a){
        return  this.save(a);

    }
}
