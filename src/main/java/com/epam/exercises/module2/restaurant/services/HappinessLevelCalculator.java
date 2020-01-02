package com.epam.exercises.module2.restaurant.services;

import com.epam.exercises.module2.restaurant.objects.Order;
import java.math.BigDecimal;

public interface HappinessLevelCalculator {
   BigDecimal calculateHappinessLevel(Order order);

}
