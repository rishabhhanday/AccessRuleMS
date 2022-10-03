package com.freelancing.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "accessrule")
@AllArgsConstructor
@NoArgsConstructor
public class AccessRuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
