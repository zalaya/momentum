package dev.zalaya.momentum.common.mock;

import oshi.software.os.OSProcess;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OSProcessMockFactory {

    public static OSProcess createOSProcessMock(int pid, String name, String path, double cpu, long memory, int threads) {
        OSProcess osProcess = mock(OSProcess.class);

        when(osProcess.getProcessID()).thenReturn(pid);
        when(osProcess.getName()).thenReturn(name);
        when(osProcess.getPath()).thenReturn(path);
        when(osProcess.getProcessCpuLoadCumulative()).thenReturn(cpu);
        when(osProcess.getResidentSetSize()).thenReturn(memory);
        when(osProcess.getThreadCount()).thenReturn(threads);

        return osProcess;
    }

}
