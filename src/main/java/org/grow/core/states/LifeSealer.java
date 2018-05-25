package org.grow.core.states;

public interface LifeSealer<H> {

    /**
    **note: one enum for one function
    */

    public enum LifeCircle{
        ANEWBORN,ADVANCED,ABANDONED,AFREEZE;
    }


    H lifeSeal(H h);
    /**
    **note: may be there are other Circle about state machine;
    */
    /**
    **note: ${todo}
     *     if (StringUtils.isEmpty(this.memberCode)) {

     *
     *this.memberCode ="0200"+(random.nextInt(9000)+1000);
     *trainingRole.setRole(TrainingRole.Role.STUDENT);
     *trainingRole.setTrainingStartDate(LocalDate.now());
     *
}
     *else{

             *if(this.memberCode.length()!=8)throw new RuntimeException("memberCode must as 00000000 , length 8");
             *}
             *
             *return this;
    */

}
