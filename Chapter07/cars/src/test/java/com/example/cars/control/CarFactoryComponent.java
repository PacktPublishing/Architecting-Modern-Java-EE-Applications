package com.example.cars.control;

import com.example.cars.entity.Specification;

import static org.mockito.Mockito.*;

public class CarFactoryComponent extends CarFactory {

    public CarFactoryComponent() {
        automation = mock(Automation.class);
        assemblyLine = mock(AssemblyLine.class);
        when(automation.isAutomated()).thenReturn(true);
    }

    public void verifyCarCreation(Specification spec) {
        verify(assemblyLine).assemble(spec);
        verify(automation).isAutomated();
    }

}
