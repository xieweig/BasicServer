package org.grow.core.infrasturcture;

import org.grow.core.domain.HeroBasic;


public interface Assistant<H> {

    void validate();
    /*
     ** note: if you follow one domain has its dto
     *			then you can use this method to attach to its relative domain
     **/

    Class<H> getHeroClass();




}
