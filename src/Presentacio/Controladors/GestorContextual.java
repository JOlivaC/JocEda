package Presentacio.Controladors;

import java.awt.Component;
import java.util.Stack;

import Presentacio.Comuns.PanellContenidor;

public class GestorContextual {
	private Stack<PanellContenidor> Pila;
	
	public GestorContextual(){
		Pila = new Stack<>();
	}
	
	public void NouContext(PanellContenidor c){
		Pila.push(c);
	}
	
	public PanellContenidor Retrocedir(){
		return Pila.pop();
	}
}
