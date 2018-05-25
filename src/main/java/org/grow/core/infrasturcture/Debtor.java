package org.grow.core.infrasturcture;

import org.springframework.data.jpa.domain.Specification;

/**
**note: debt
*/

public interface Debtor<H> {

    Specification<H> concentrating();

    Class<H> getHeroClass();

}
