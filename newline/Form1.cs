﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows;
using System.IO;

namespace newline
{
    public partial class Form1 : Form
    {
        

        public Form1()
        {
            InitializeComponent();
            
        }

       public void TextBox1_Click(object sender, EventArgs e)
        {     OpenFileDialog openFileDialog1 = new OpenFileDialog();
 
    openFileDialog1.InitialDirectory = @"C:\";
    openFileDialog1.Title = "Browse Text Files";
 
    openFileDialog1.CheckFileExists = true;
    openFileDialog1.CheckPathExists = true;
 
    openFileDialog1.DefaultExt = "txt";
    openFileDialog1.Filter = "Text files (*.txt)|*.txt|All files (*.*)|*.*";
    openFileDialog1.FilterIndex = 2;
    openFileDialog1.RestoreDirectory = true;
 
    openFileDialog1.ReadOnlyChecked = true;
    openFileDialog1.ShowReadOnly = true;
 
    if (openFileDialog1.ShowDialog() == DialogResult.OK)
        {
            textBox1.Text = openFileDialog1.FileName;
        }
      }

       private void button1_Click(object sender, EventArgs e)
       {   string filepath1 = textBox1.Text;
           string lookup = textBox2.Text;
           int counting = 0;

           try
           {
               var lines = File.ReadAllLines(filepath1);
               foreach (var line in lines)
               { if (line.Contains(lookup)) counting++; }
               MessageBox.Show("Number of messages is: " + counting);
           }
           catch (Exception ee)
           {
               MessageBox.Show("An error occurred: "+ ee);
           }

       }
           
    }
}
