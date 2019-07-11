package com.diginepal.schoolmgmt.dto;

import com.diginepal.schoolmgmt.entities.Branch;
import com.diginepal.schoolmgmt.entities.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BranchAndCompanyDto {
    private Company company;
    private ArrayList<Branch> branches;
}
