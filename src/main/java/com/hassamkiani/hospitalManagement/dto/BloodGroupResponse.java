package com.hassamkiani.hospitalManagement.dto;


import com.hassamkiani.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupResponse {

    private BloodGroupType bloodGroupType;
    private Long count;

}
