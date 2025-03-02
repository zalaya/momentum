package dev.zalaya.acquisition.infrastructure.system.mocks;

import oshi.software.os.OSProcess;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OSProcessMockFactory {

    public static OSProcess create(Integer pid, String name, String path, Double usage, Integer threads) {
        OSProcess mock = mock(OSProcess.class);

        when(mock.getProcessID()).thenReturn(pid);
        when(mock.getName()).thenReturn(name);
        when(mock.getPath()).thenReturn(path);
        when(mock.getProcessCpuLoadCumulative()).thenReturn(usage);
        when(mock.getThreadCount()).thenReturn(threads);

        return mock;
    }

}
