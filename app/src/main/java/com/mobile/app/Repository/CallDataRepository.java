package com.mobile.app.Repository;

import com.mobile.app.Model.CallData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallDataRepository extends JpaRepository<CallData, Long> {
    // Add custom query methods if needed
}