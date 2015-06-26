/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

/**
 *
 * @author JOAN
 */
public abstract class PanellAmbMsg extends PanellContenidor {
    protected MessageArea msg = new MessageArea();
    public void MostraMsg(String msg){
        this.msg.SetText(msg);
        this.repaint();
    }
    
}
