using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FolderWatcher
{
    public partial class FormWatcher : Form
    {
        private FolderBrowserDialog mFolderBrowserDialog;
        private string mFolderPath;

        private FileSystemWatcher mFileSystemWatcher;

        public FormWatcher()
        {
            InitializeComponent();
        }

        private void FormWatcher_Load(object sender, EventArgs e)
        {
            mFolderBrowserDialog = new FolderBrowserDialog();
            mFileSystemWatcher = new FileSystemWatcher();
            startingAble(true);
        }

        #region button clicks

        private void buttonBrowse_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = mFolderBrowserDialog.ShowDialog();
            if (dialogResult == DialogResult.OK)
            {
                setFolderPath(mFolderBrowserDialog.SelectedPath);
                textboxPath.Text = mFolderPath;
            }
        }

        private void buttonStart_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(mFolderPath))
            {
                MessageBox.Show("Please select folder for watcher!",
                    "Enough folder path", MessageBoxButtons.OK);
                return;
            }

            startingAble(false);

            setupFileSystemWatcher();
            startWatching();
            addLog("Started watching");
        }

        private void buttonStop_Click(object sender, EventArgs e)
        {
            startingAble(true);

            stopWatching();
            addLog("Stoped watching");
        }

        #endregion

        #region support methods

        private void setFolderPath(string folderPath)
        {
            mFolderPath = folderPath + "\\";
        }

        private void setupFileSystemWatcher()
        {
            mFileSystemWatcher.Path = mFolderPath;
            mFileSystemWatcher.NotifyFilter = NotifyFilters.LastAccess |
                NotifyFilters.LastWrite | NotifyFilters.DirectoryName | NotifyFilters.FileName;
            mFileSystemWatcher.Filter = "*.*";
            mFileSystemWatcher.IncludeSubdirectories = true;

            mFileSystemWatcher.Changed += new FileSystemEventHandler(OnChange);
            mFileSystemWatcher.Created += new FileSystemEventHandler(OnCreated);
            mFileSystemWatcher.Deleted += new FileSystemEventHandler(OnDeleted);
            mFileSystemWatcher.Renamed += new RenamedEventHandler(OnRenamed);
        }

        private void startWatching()
        {
            mFileSystemWatcher.EnableRaisingEvents = true;
        }

        private void stopWatching()
        {
            mFileSystemWatcher.EnableRaisingEvents = false;
        }

        private void addLog(string log)
        {
            this.Invoke(new MethodInvoker(delegate()
                {
                    listBoxLog.Items.Add(log);
                }));
        }

        private void startingAble(bool isStartingAble)
        {
            if (isStartingAble)
            {
                buttonStart.Enabled = true;
                buttonStop.Enabled = false;
            }
            else
            {
                buttonStart.Enabled = false;
                buttonStop.Enabled = true;
            }
        }

        #endregion

        #region system file watcher events

        private void OnCreated(object sender, FileSystemEventArgs e)
        {
            string log = "File: " + e.FullPath + " " + e.ChangeType;
            addLog(log);
        }

        private void OnRenamed(object sender, RenamedEventArgs e)
        {
            string log = "File: " + e.FullPath + " " + e.ChangeType;
            addLog(log);
        }

        private void OnChange(object sender, FileSystemEventArgs e)
        {
            string log = "File: " + e.FullPath + " " + e.ChangeType;
            addLog(log);
        }

        private void OnDeleted(object sender, FileSystemEventArgs e)
        {
            string log = "File: " + e.FullPath + " " + e.ChangeType;
            addLog(log);
        }

        #endregion

    }
}
