package org.grow.core.head_tobody;

import org.grow.core.domain.HeroBasic;
import org.grow.core.domain.HeroJunior;
import org.grow.core.infrasturcture.Assistant;
import org.grow.core.states.LifeSealer;
import org.grow.core.states.MissionSealer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class DynamicBigHead<H extends HeroJunior<H>> {

    @Resource
    private ApplicationContext applicationContext;

    /*
     ** note:考虑到　sealer 的可变性相对强　采取了一般的策略模式　添加更改容易　只涉及到实现类和ｍａｎａｇｅｒ
     *　而仓库一共就那么几种　采取的ｅｎｕｍ的方式　耦合度很强　调用容易而更改难
     *	对于可变性更强的情况请直接采用ｌａｍｂｄａ表达式
     **/

    protected H quicklySave(Assistant<H> dto, LifeSealer<H> lifeSealer, MissionSealer<H> missionSealer) {

        return applicationContext.getBean(dto.getHeroClass())
                .acceptDataFrom(dto)
                .lifeTransition(lifeSealer)
                .missionTransition(missionSealer)
                .enrichRepo(HeroBasic.RepoType.JPA)
                .noticeOthers(HeroBasic.PublishType.SPRING_LISTENER);
    }
    protected H quicklySave(Assistant<H> dto, LifeSealer<H> lifeSealer, MissionSealer<H> missionSealer,
                            HeroBasic.RepoType repoType) {

        return applicationContext.getBean(dto.getHeroClass())
                .acceptDataFrom(dto)
                .lifeTransition(lifeSealer)
                .missionTransition(missionSealer)
                .enrichRepo(repoType)
                .noticeOthers(HeroBasic.PublishType.SPRING_LISTENER);
    }
    protected H quicklySave(Assistant<H> dto, LifeSealer<H> lifeSealer, MissionSealer<H> missionSealer,
                            HeroBasic.RepoType repoType , HeroBasic.PublishType publishType) {

        return applicationContext.getBean(dto.getHeroClass())
                .acceptDataFrom(dto)
                .lifeTransition(lifeSealer)
                .missionTransition(missionSealer)
                .enrichRepo(repoType)
                .noticeOthers(publishType);
    }

    private DynamicBigHead() {
    }


    /**
    **note: query?
    */


}
