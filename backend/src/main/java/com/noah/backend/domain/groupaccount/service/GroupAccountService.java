package com.noah.backend.domain.groupaccount.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.noah.backend.domain.groupaccount.dto.requestDto.DepositReqDto;
import com.noah.backend.domain.groupaccount.dto.requestDto.GroupAccountPostDto;
import com.noah.backend.domain.groupaccount.dto.requestDto.GroupAccountUpdateDto;
import com.noah.backend.domain.groupaccount.dto.responseDto.GroupAccountInfoDto;
import com.noah.backend.domain.memberTravel.dto.Response.MemberTravelListGetDto;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.List;

public interface GroupAccountService {

    List<GroupAccountInfoDto> getGroupAccountListByMemberId(Long memberId) throws IOException;

    Long createGroupAccount(GroupAccountPostDto groupAccountPostDto);

    GroupAccountInfoDto groupAccountInfo(String email, Long groupAccountId);

    GroupAccountInfoDto groupAccountInfoByTravelId(String email, Long travelId);

    Long updateGroupAccount(Long memberId, GroupAccountUpdateDto groupAccountUpdateDto);

    int getTotalPay(String email, Long travelId);

    List<MemberTravelListGetDto> getGroupAccountMembers(String email, Long travelId);

    void depositIntoGroupAccount(String email, DepositReqDto depositReqDto) throws IOException;

    void autoTransferGroupAccount() throws IOException;
}
