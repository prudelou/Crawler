/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.RequestProcessor;

@ActionID(
        category = "File",
        id = "m1.piu.OpenAction"
)
@ActionRegistration(
        displayName = "#CTL_OpenAction"
)
@ActionReference(path = "Menu/File", position = 1200)
@Messages("CTL_OpenAction=Open")
public final class OpenAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        Runnable myRunnable = new Runnable() {
        public void run() {
            ProgressHandle myProgressHandle = ProgressHandleFactory.createHandle("Opening....");
            myProgressHandle.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
            myProgressHandle.finish();
        }
       };
       RequestProcessor.Task myTask = RequestProcessor.getDefault().post(myRunnable);
    }
}
