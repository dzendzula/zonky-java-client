package org.zhezhela.zonky.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.zhezhela.zonky.dto.ZonkyInvestmentListDto;
import org.zhezhela.zonky.dto.ZonkyLoanDto;
import org.zhezhela.zonky.dto.filter.ZonkyPagination;
import org.zhezhela.zonky.dto.filter.ZonkyRequestParams;
import org.zhezhela.zonky.dto.filter.ZonkySortItem;
import org.zhezhela.zonky.rest.config.mapping.ZonkyRequest;
import org.zhezhela.zonky.rest.config.mapping.ZonkyRequestHeader;
import org.zhezhela.zonky.rest.connector.impl.ZonkyConnector;
import org.zhezhela.zonky.service.ZonkyApiService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ZonkyApiServiceImpl implements ZonkyApiService {

    @Autowired
    private ZonkyConnector zonkyConnector;


    @Override
    public List<ZonkyLoanDto> getLoans(ZonkyRequestParams params) {
        Map<String, String> headers = prepareHeaders(params);
        ZonkyLoanDto[] zonkyLoanArray = zonkyConnector.sendGetRequest(ZonkyRequest.LOANS_MARKETPLACE, new String[0], null, formMessageParamsList(params), headers, ZonkyLoanDto[].class);
        return Arrays.asList(zonkyLoanArray);
    }

    @Override
    public ZonkyLoanDto getLoan(Integer loanId, ZonkyRequestParams params) {
        Map<String, String> headers = prepareHeaders(params);
        return zonkyConnector.sendGetRequest(ZonkyRequest.LOANS_MARKETPLACE, new String[0], null, formMessageParamsList(params), headers, ZonkyLoanDto.class);
    }

    @Override
    public ZonkyInvestmentListDto getLoanInvestments(Integer loanId, ZonkyRequestParams params) {
        Map<String, String> headers = prepareHeaders(params);
        return zonkyConnector.sendGetRequest(ZonkyRequest.LOANS_MARKETPLACE, new String[0], null, formMessageParamsList(params), headers, ZonkyInvestmentListDto.class);
    }

    private List<NameValuePair> formMessageParamsList(ZonkyRequestParams params) {
        if (params == null) {
            return Collections.emptyList();
        }
        List<NameValuePair> result = new ArrayList<>();
        params.getFilter().stream()
                .filter(i -> (Objects.nonNull(i.formFilterItemQuery()) && !StringUtils.isEmpty(i.getValue())))
                .forEach(i -> {
                    result.add(new BasicNameValuePair(i.formFilterItemQuery(), i.getValue()));
                });

        return result;
    }

    private Map<String, String> prepareHeaders(ZonkyRequestParams params) {
        if (params == null) {
            return Collections.emptyMap();
        }
        Map<String, String> headers = new HashMap<>();
        if (!CollectionUtils.isEmpty(params.getSort())) {
            StringBuilder sb = new StringBuilder();
            List<String> sortParamsValue = params.getSort().stream().map(ZonkySortItem::formSortParam).collect(Collectors.toList());
            headers.put(ZonkyRequestHeader.X_ORDER.getValue(), StringUtils.join(sortParamsValue, ","));
        }
        if (params.getPagination() != null) {
            ZonkyPagination pagination = params.getPagination();
            if (pagination.getTotal() != null) {
                headers.put(ZonkyRequestHeader.X_TOTAL.getValue(), pagination.getTotal().toString());
            }
            if (pagination.getPage() != null) {
                headers.put(ZonkyRequestHeader.X_PAGE.getValue(), pagination.getPage().toString());
            }
            if (pagination.getSize() != null) {
                headers.put(ZonkyRequestHeader.X_SIZE.getValue(), pagination.getSize().toString());
            }
        }

        return headers;
    }
}
