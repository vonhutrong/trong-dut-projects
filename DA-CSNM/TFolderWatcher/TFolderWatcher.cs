using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.InteropServices;

namespace TFolderWatcher
{
    class TFolderWatcher
    {
        [StructLayout(LayoutKind.Sequential)]
        public struct OVERLAPPED {
          ULONG_PTR Internal;
          ULONG_PTR InternalHigh;
          union {
            struct {
              DWORD Offset;
              DWORD OffsetHigh;
            };
            PVOID  Pointer;
          };
          HANDLE    hEvent;
        }

        [DllImport("Kernel32.dll")]
        public static extern bool WINAPI ReadDirectoryChangesW(
           IntPtr                          hDirectory,
           IntPtr                          lpBuffer,
           ulong                           nBufferLength,
           bool                            bWatchSubtree,
           ulong                           dwNotifyFilter,
           ref ulong                         lpBytesReturned,
           LPOVERLAPPED                    lpOverlapped,
           LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine
        );
    }
}
