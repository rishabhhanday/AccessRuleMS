package com.freelancing.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class AccessRulesBackendController {

    @GetMapping
    ResponseEntity<List<AccessRuleEntity>> addDeleteData(@RequestBody ManageRestrictionRequest manageRestrictionRequest) throws JsonProcessingException {
        String s = new ObjectMapper()
                .writeValueAsString(manageRestrictionRequest);

        return ResponseEntity.ok(prepareAccessRuleEntity(manageRestrictionRequest));
    }

    private List<AccessRuleEntity> prepareAccessRuleEntity(ManageRestrictionRequest manageRestrictionRequest) {
        String requestId = UUID.randomUUID().toString();

        List<AccessRuleEntity> accessRuleEntityList = new ArrayList<>();

        for (String userID : manageRestrictionRequest.getUserSecurityInfo().getUserList().getRacfIds()) {
            for (AddData addData : manageRestrictionRequest.getUserSecurityInfo().getData().getAddData()) {
                for (String carrier : addData.getCarrier()) {
                    AccessRuleEntity carrierAccessRuleEntity = AccessRuleEntity
                            .builder()
                            .requestId(requestId)
                            .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                            .racfid(userID)
                            .start_val(carrier)
                            .end_val(carrier)
                            .inclu_excl("I")
                            .rule_level("CAR")
                            .add_delete("ADD")
                            .request_status("RECEIVED")
                            .error_message("")
                            .build();

                    accessRuleEntityList.add(carrierAccessRuleEntity);
                }

                AccessRuleEntity contractAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(addData.getContractFrom())
                        .end_val(addData.getContractTo())
                        .inclu_excl(addData.getContractInclusionExclusionIndicator())
                        .rule_level("CON")
                        .add_delete("ADD")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(contractAccessRuleEntity);

                AccessRuleEntity bplAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(addData.getBplFrom())
                        .end_val(addData.getBplTo())
                        .inclu_excl(addData.getBplInclusionExclusionIndicator())
                        .rule_level("CON")
                        .add_delete("ADD")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(bplAccessRuleEntity);

                AccessRuleEntity groupAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(addData.getGroupFrom())
                        .end_val(addData.getGroupTo())
                        .inclu_excl(addData.getGroupInclusionExclusionIndicator())
                        .rule_level("GRP")
                        .add_delete("ADD")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(groupAccessRuleEntity);
            }
            for (DeleteData deleteData : manageRestrictionRequest.getUserSecurityInfo().getData().getDeleteData()) {
                for (String carrier : deleteData.getCarrier()) {
                    AccessRuleEntity carrierAccessRuleEntity = AccessRuleEntity
                            .builder()
                            .requestId(requestId)
                            .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                            .racfid(userID)
                            .requestId(requestId)
                            .start_val(carrier)
                            .end_val(carrier)
                            .inclu_excl("I")
                            .rule_level("CAR")
                            .add_delete("DELETE")
                            .request_status("RECEIVED")
                            .error_message("")
                            .build();

                    accessRuleEntityList.add(carrierAccessRuleEntity);
                }

                AccessRuleEntity contractAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(deleteData.getContractFrom())
                        .end_val(deleteData.getContractTo())
                        .inclu_excl(deleteData.getContractInclusionExclusionIndicator())
                        .rule_level("CON")
                        .add_delete("DELETE")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(contractAccessRuleEntity);

                AccessRuleEntity bplAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(deleteData.getBplFrom())
                        .end_val(deleteData.getBplTo())
                        .inclu_excl(deleteData.getBplInclusionExclusionIndicator())
                        .rule_level("CON")
                        .add_delete("DELETE")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(bplAccessRuleEntity);

                AccessRuleEntity groupAccessRuleEntity = AccessRuleEntity
                        .builder()
                        .requestId(requestId)
                        .userid(manageRestrictionRequest.getUserSecurityInfo().getAdminUserID())
                        .racfid(userID)
                        .requestId(requestId)
                        .start_val(deleteData.getGroupFrom())
                        .end_val(deleteData.getGroupTo())
                        .inclu_excl(deleteData.getGroupInclusionExclusionIndicator())
                        .rule_level("GRP")
                        .add_delete("DELETE")
                        .request_status("RECEIVED")
                        .error_message("")
                        .build();

                accessRuleEntityList.add(groupAccessRuleEntity);
            }
        }

        return accessRuleEntityList;
    }
}
