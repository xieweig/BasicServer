package org.grow.core.domain;

import org.grow.core.infrasturcture.Assistant;
import org.grow.core.states.LifeSealer;

import java.io.Serializable;

/**
 ** note:H represents hero , means domain
 *			A represents assistant, means Dto*/
public interface HeroBasic<H> extends Serializable {

    /**
     ** note: store self into JpaRepository, like Data Access Object save T ,means enrich the repository;
     **/
    enum RepoType{
        JPA, REDIS, MONGODB;
    }
    enum PublishType{
        SPRING_LISTENER, RABBIT_MQ;
    }

    /**
    **note: save info H into Repository
    */
    H enrichRepo(RepoType repoType);
    /**
     ** note: publish_consume mode , observer mode*/

    H noticeOthers(PublishType publishType);
    /**
    **note: assistant means Dto, is a helper for H
    */

    H acceptDataFrom(Assistant<H> a);

    H lifeTransition(LifeSealer<H> sealer);
}
