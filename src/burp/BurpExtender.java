package burp;

import java.io.PrintWriter;
import javax.swing.*;
import CVSS_Calculator.tab;

public class BurpExtender extends JPanel implements IBurpExtender
{
    
    public static IBurpExtenderCallbacks callbacks;
    static JScrollPane frame;
    public static PrintWriter output;
    public static String project_Name="CVSS Calculator";
    private static final String project_Version="0.3.1";
    
    public BurpExtender() {
//        this.historyModel = (DefaultTableModel)mainPanel.historyTable.getModel();
    }
    
    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks)
    {
        // keep a reference to our callbacks object
        this.callbacks = callbacks;
        
        output = new PrintWriter(callbacks.getStdout(), true);
        // create our UI
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                initComponents();
                // customize our UI components
                callbacks.customizeUiComponent(tab.panel);
                
                // add the custom tab to Burp's UI
                callbacks.addSuiteTab(tab.tb);
            }
        });
    }
    
    private void initComponents() {
    }// </editor-fold>
    
    public byte[] processProxyMessage(int messageReference, boolean messageIsRequest, String remoteHost, int remotePort, boolean serviceIsHttps, String httpMethod, String url,
        String resourceType, String statusCode, String responseContentType, byte message[], int action[])
    {
        return message;
    }
    
    public static String getProjectName(){
        return project_Name;
    }
    public static String getVersion(){
        return project_Version;
    }
    
}