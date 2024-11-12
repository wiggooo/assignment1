package com.yrgo.services.calls;

import com.yrgo.domain.Action;
import com.yrgo.domain.Call;
import com.yrgo.services.customers.CustomerManagementService;
import com.yrgo.services.customers.CustomerNotFoundException;
import com.yrgo.services.diary.DiaryManagementService;

import java.util.Collection;

public class CallHandlingServiceImpl implements CallHandlingService{
    final private CustomerManagementService customerManagementService;
    final private DiaryManagementService diaryManagementService;

    public CallHandlingServiceImpl(CustomerManagementService customerManagementService, DiaryManagementService diaryManagementService){
        this.customerManagementService = customerManagementService;
        this.diaryManagementService = diaryManagementService;
    }

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        // Update information in CustomerManagementService
        customerManagementService.recordCall(customerId, newCall);

        // Update action-information in DiaryManagementService
        for (Action action : actions){
            diaryManagementService.recordAction(action);
        }
    }
}
