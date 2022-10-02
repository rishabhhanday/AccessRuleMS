package com.freelancing.assignment;

import lombok.Data;

import java.util.List;

@Data
public class UserData {
    private List<AddData> addData;
    private List<DeleteData> deleteData;

}
