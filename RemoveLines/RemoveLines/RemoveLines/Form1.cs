using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RemoveLines
{
    public partial class Form1 : Form
    {
        string path = "";

        BackgroundWorker ReaderWorker = new BackgroundWorker();
        BackgroundWorker AlgorithmWorker = new BackgroundWorker();

        List<String> file1Content = new List<String>();
        List<String> file2Content = new List<String>();
        int sizeOfList1;
        int sizeOfList1a;
        int sizeOfList2;
        int sizeOfList2a;
       /* public delegate void MethodInvoker();
            this.Invoke((MethodInvoker)delegate()
    {
        // Log message on UI thread
        LogMessage(line, 1);
    });*/

        public Form1()
        {
            InitializeComponent();
            LogMessage("Application started", 2);
            btnStart.Enabled = false;

            // initialize background worker for file reading
            ReaderWorker.DoWork += ReaderWorker_DoWork;
            ReaderWorker.RunWorkerCompleted += ReaderWorker_RunWorkerCompleted;

            // initialize background worker for lines removing
            AlgorithmWorker.DoWork += AlgorithmWorker_DoWork;
            AlgorithmWorker.RunWorkerCompleted += AlgorithmWorker_RunWorkerCompleted;
        }

        void AlgorithmWorker_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            throw new NotImplementedException();
        }

        void AlgorithmWorker_DoWork(object sender, DoWorkEventArgs e)
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// Triggers after worker has finished task
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void ReaderWorker_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            btnFile1.Enabled = btnFile2.Enabled = true;
            LogMessage("Loading completed", 2);

            //if (file1Content.Count > 0 && file2Content.Count > 0)
                btnStart.Enabled = true;
        }

        /// <summary>
        /// Worker does work on seperate thread
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void ReaderWorker_DoWork(object sender, DoWorkEventArgs e)
        {
            System.IO.StreamReader filestream = new System.IO.StreamReader(path);
    

            string line = "";

            while ((line = filestream.ReadLine()) != null)
            {
                if ((string)e.Argument == "1"){
                    file1Content.Add(line);
                    /*file1Content[a] = line;
                    a++;*/
                }
                    
                else if ((string)e.Argument == "2")
                {
                    file2Content.Add(line);
                   /* file2Content[b] = line;
                    b++;*/
                }
                   
            }
        }

        /// <summary>
        /// Manages first file loading
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnFile1_Click(object sender, EventArgs e)
        {
            ofdFileLoading = new OpenFileDialog();
            ofdFileLoading.Title = "Open First Text File!";
            ofdFileLoading.Filter = "CSV files|*.csv|TXT files|*.txt|All files|*.*";
            ofdFileLoading.InitialDirectory = @"C:\";

            if (ofdFileLoading.ShowDialog() == DialogResult.OK)
            {
                LogMessage("Loading first file: " + ofdFileLoading.FileName.ToString(), 2);
                lblFile1.Text = path = ofdFileLoading.FileName.ToString();
                btnFile1.Enabled = btnFile2.Enabled = false;
                ReaderWorker.RunWorkerAsync("1");

            }
        }

        /// <summary>
        /// Manages second file loading
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnFile2_Click(object sender, EventArgs e)
        {
            ofdFileLoading = new OpenFileDialog();
            ofdFileLoading.Title = "Open Second Text File!";
            ofdFileLoading.Filter = "TXT files|*.txt|All files|*.*";
            ofdFileLoading.InitialDirectory = @"C:\";

            if (ofdFileLoading.ShowDialog() == DialogResult.OK)
            {
                LogMessage("Loading second file: " + ofdFileLoading.FileName.ToString(), 2);
                lblFile2.Text = path = ofdFileLoading.FileName.ToString();
                btnFile1.Enabled = btnFile2.Enabled = false;
                ReaderWorker.RunWorkerAsync("2");

            }
        }

        /// <summary>
        /// Handles logging
        /// </summary>
        /// <param name="message"></param>
        /// <param name="type"></param>
        private void LogMessage(string message, int type)
        {
            if(type == 1)
            {
                tbOutput.AppendText("[" + DateTime.Now.ToLongTimeString() + "]  " + message + Environment.NewLine);
            }
            else
            {
                tbOutput.AppendText("[" + DateTime.Now.ToLongTimeString() + "]  " + message + Environment.NewLine);
                tsslLabel1.Text = message;
            }
        }

        /// <summary>
        /// Starts removing lines
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnStart_Click(object sender, EventArgs e)
        {
            LogMessage("STARTED Removing lines..", 2);

            sizeOfList1 = file1Content.Count;
            sizeOfList1a = sizeOfList1 - 1;
            sizeOfList2 = file2Content.Count;
            sizeOfList2a = sizeOfList2 - 1;
            MessageBox.Show(sizeOfList1.ToString());
            MessageBox.Show(sizeOfList2.ToString());
           List<String> _tempCollection = new List<string>();
            List<String> _tempCollection2 = new List<string>();

          // string[] result = file1Content.Except<string>(file2Content).ToArray<string>();

       //linq
           foreach (var item2 in file2Content)
            {

                int index = file1Content.FindIndex(f => file1Content.Contains(item2));

                if(index > 0)
                {
                    LogMessage("Found existing: " + file2Content.IndexOf(item2), 2);
                    index = 0;
                }
	        }
            //pomocu polja
           /* for (int i = 0; i < sizeOfList1; i++)
            {
                
                for (int j = 0; j < sizeOfList2; j++)
                {
                    
                    if(file1Content[i].Contains(file2Content[j]) && file2Content[j].Length > 4)
                    {
                        
                        LogMessage("Removing item: " + file1Content[i].ToString() + " because of " + file2Content[j].ToString(), 1);
                        file1Content[i] = "";
                    }
                }
            }
            file1Content.RemoveAll(String.IsNullOrEmpty);*/

            //pomoću listi
              foreach (var item1 in file1Content)
                {
                   
               
                         _tempCollection.Add(item1);
                     }

                foreach (var item2 in file2Content)
                {
                    LogMessage("Checking item [" + file2Content.IndexOf(item2).ToString() + "/" + sizeOfList2a.ToString() + "] " + item2, 1);

                    _tempCollection.RemoveAll(x => _tempCollection.Contains(item2));
                    foreach (var item1 in file1Content)
                    {
                        foreach (var item3 in file2Content)
                        {
                            if (item1.Contains(item3) && item2.Length > 5)
                            {
                                LogMessage("Removing item1 [" + file1Content.IndexOf(item1).ToString() + "/" + file1Content.Count.ToString() + "] " + item1, 1);
                                _tempCollection[file1Content.IndexOf(item1)] = "";
                               // _tempCollection.RemoveAt(file1Content.IndexOf(item1));
                            }

                        }
                    }
                }
                _tempCollection.RemoveAll(item => item.Equals(""));
                LogMessage("FINISH Removing lines..", 2);

               // MessageBox.Show(file1Content.Count().ToString());
               MessageBox.Show(_tempCollection.Count().ToString());
        }
    }
}