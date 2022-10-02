package com.freelancing.assignment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessRuleEntity {
    private String requestId;
    private String userid;
    private String racfid;
    private String start_val;
    private String end_val;
    private String inclu_excl;
    private String rule_level;
    private String add_delete;
    private String request_status;
    private String error_message;
}
