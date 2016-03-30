#include <windows.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

string convertWCHARToString(PWCHAR pwchar, unsigned int maxlength) {
    char ch[maxlength];
    char DefChar = ' ';
    WideCharToMultiByte(CP_ACP, 0, pwchar, -1, ch, maxlength, &DefChar, NULL);
    ch[maxlength] = '\0';

    return string(ch);
}

HANDLE handleDirectoryForMonitor(string path) {
    HANDLE hDir;
    hDir = CreateFile(
        path.c_str(),
        GENERIC_READ | GENERIC_WRITE | FILE_LIST_DIRECTORY,
        FILE_SHARE_DELETE | FILE_SHARE_READ | FILE_SHARE_WRITE,
        NULL,
        OPEN_EXISTING,
        FILE_FLAG_BACKUP_SEMANTICS |  FILE_FLAG_OVERLAPPED,
        NULL
    );
    return (hDir == INVALID_HANDLE_VALUE) ? NULL : hDir;
}

BOOL monitorDirectory(string path) {
    HANDLE hDir = handleDirectoryForMonitor(path);
    BYTE notify_buff[2048];
    DWORD numBytesReturned;
    OVERLAPPED overlapped;
    overlapped.hEvent = CreateEvent(
        NULL,
        FALSE,
        FALSE,
        NULL
    );
    BOOL result;
    PFILE_NOTIFY_INFORMATION pNotify;
    do {
        result = ReadDirectoryChangesW(
            hDir,
            &notify_buff,
            sizeof(notify_buff),
            TRUE,
            FILE_NOTIFY_CHANGE_FILE_NAME | FILE_NOTIFY_CHANGE_DIR_NAME | FILE_NOTIFY_CHANGE_SIZE,
            &numBytesReturned,
            &overlapped,
            NULL
        );

        BOOL boverlappedResult = GetOverlappedResult(
            hDir,
            &overlapped,
            &numBytesReturned,
            TRUE
        );

        DWORD offset = 0;
        do {
            pNotify = (PFILE_NOTIFY_INFORMATION) (notify_buff + offset);
            string action;
            DWORD filenamelength;
            string filename;
            switch (pNotify->Action) {
            case FILE_ACTION_ADDED:
                action = "file added";
                break;
            case FILE_ACTION_REMOVED:
                action = "removed";
                break;
            case FILE_ACTION_MODIFIED:
                action = "modified";
                break;
            case FILE_ACTION_RENAMED_OLD_NAME:
                action = "renamed old name";
                break;
            case FILE_ACTION_RENAMED_NEW_NAME:
                action = "renamed new name";
                break;
            }
            filenamelength = pNotify->FileNameLength;
            filename = convertWCHARToString(pNotify->FileName, filenamelength);
            cout << action << " : " << filename << endl;

            offset += pNotify->NextEntryOffset;
        } while (pNotify->NextEntryOffset);
    } while (result);
}

int main() {

    string path;
    cout << "path: ";
    cin >> path;

    monitorDirectory(path);

    return 0;
}
