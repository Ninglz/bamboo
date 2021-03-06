package com.ninglz.bamboo.upms.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.ninglz.bamboo.upms.api.CustomerServiceI;
import com.ninglz.bamboo.upms.dto.CustomerAddCmd;
import com.ninglz.bamboo.upms.dto.CustomerListByNameQry;
import com.ninglz.bamboo.upms.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import com.ninglz.bamboo.upms.customer.executor.CustomerAddCmdExe;
import com.ninglz.bamboo.upms.customer.executor.query.CustomerListByNameQryExe;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}