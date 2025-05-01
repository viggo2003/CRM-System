package se.yrgo.services.calls;

import java.util.Collection;

import se.yrgo.domain.Action;
import se.yrgo.domain.Call;
import se.yrgo.services.customers.CustomerManagementService;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.diary.DiaryManagementService;

public class CallHandlingServiceImpl implements CallHandlingService {
    private CustomerManagementService chs;
    private DiaryManagementService dms;

    public CallHandlingServiceImpl(CustomerManagementService chs, DiaryManagementService dms) {
        this.chs = chs;
        this.dms = dms;
    }

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions)
            throws CustomerNotFoundException {
        chs.recordCall(customerId, newCall);
        for(Action i : actions){
            dms.recordAction(i);
        }
    }

}
