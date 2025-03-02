package dev.zalaya.acquisition.infrastructure.system.mocks;

import oshi.software.os.OSProcess;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OSProcessMockFactory {

    public static OSProcess create(Integer pid, String name, String path, Double usage, Integer threads) {
        OSProcess osProcessMock = mock(OSProcess.class);

        when(osProcessMock.getProcessID()).thenReturn(pid);
        when(osProcessMock.getName()).thenReturn(name);
        when(osProcessMock.getPath()).thenReturn(path);
        when(osProcessMock.getProcessCpuLoadCumulative()).thenReturn(usage);
        when(osProcessMock.getThreadCount()).thenReturn(threads);

        return osProcessMock;
    }

}
