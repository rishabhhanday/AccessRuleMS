package com.freelancing.assignment;

import lombok.Data;

import java.util.List;

@Data
public class AddData {
    private List<String> carrier;
    private String contractFrom;
    private String contractTo;
    private String contractInclusionExclusionIndicator;
    private String bplFrom;
    private String bplTo;
    private String bplInclusionExclusionIndicator;
    private String groupFrom;
    private String groupTo;
    private String groupInclusionExclusionIndicator;

}
