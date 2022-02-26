package Game;
import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame
{
    protected String title,username;
    protected int dialogButton, dialogResult;
    public Screen(String title) throws HeadlessException
    {
        super(title);
        this.title = title;
    }
    public void WhatIsNickname()       // For nickname input message box.
    {
        username = JOptionPane.showInputDialog("Your name: ");
    }
    public void showHighscores(String highscore_text)     // Message box for high scores which are in the database.
    {
        JOptionPane.showMessageDialog(null,highscore_text);
    }
    public void Restart()         // Restart yes/no option. If user clicks 'Yes', restart the game.
    {
        dialogButton = JOptionPane.YES_NO_OPTION;
        dialogResult = JOptionPane.showConfirmDialog(null, "Restart the game","Warning",dialogButton);
    }

    public void ShopMessage()        // Shop exit message info box.
    {
        JOptionPane.showMessageDialog(null,"Press enter 7 for exiting shop!");
    }
    public void FightMessage(String text, String text2)       // Our character and enemy health/damage before fight.
    {
        JOptionPane.showMessageDialog(null,text);
        JOptionPane.showMessageDialog(null,text2);
    }
    public String getUsername() {
        return username;
    }
    public int getDialogResult() {
        return dialogResult;
    }
}
