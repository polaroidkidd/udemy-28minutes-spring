package dev.dle.learnspringframework.enterprise.business;

import dev.dle.learnspringframework.enterprise.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessService {
    private final DataService dataService;

    @Autowired
    public BusinessService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public long calculateSum() {
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}
