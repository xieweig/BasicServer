package org.grow.core.domain;

import org.grow.core.states.LifeSealer;
import org.grow.core.states.MissionSealer;

public interface HeroJunior<H> extends HeroBasic<H>{

    /**
     ** note: for dynamic entity ,there must be some Enumerate properties to transition states
     *
     * please write  if (sealer == null) return this;
     *
     * that means does not care about this state
     * */
    H lifeTransition(LifeSealer<H> sealer);


    /**
    **note: two is enough
    */

    H missionTransition(MissionSealer<H> sealer);

  //  S trainSuccessor();

}
