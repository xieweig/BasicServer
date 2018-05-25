package org.grow.core.states;

/**
**note: record about the varies changed by Mission , operations by workers; like submit audit carryout
*/

public interface MissionSealer<H> {

    public enum SubmitCircle {
        SUBMIT_NOTYET, SUBMITTED
    }

    public enum  AuditCircle{
        AUDIT_NOTYET, AUDITING, AUDITED_SUCCESS, AUDITTED_FAILURE
    }

    H missionSeal(H h);


}
