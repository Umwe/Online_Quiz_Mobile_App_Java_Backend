package com.mobile.app.Controller;

import com.mobile.app.Model.CallData;
import com.mobile.app.Repository.CallDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calldata")
public class CallDataController {
    @Autowired
    private CallDataRepository callDataRepository;

    @GetMapping("/listall")
    public List<CallData> getAllCallData() {
        return callDataRepository.findAll();
    }
}
