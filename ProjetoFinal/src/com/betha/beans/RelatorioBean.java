package com.betha.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.betha.cadastro.Endereco;
import com.betha.cadastro.Usuario;
import com.betha.util.UsuarioComparar;
import com.betha.repository.EnderecoRepo;
import com.betha.repository.UsuariosRepo;
import com.betha.util.Repositorios;

/**
 * @author Administrador
 *
 */

public class RelatorioBean {
	
	private List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private ArrayList<Usuario> selecionados;
	private List<Usuario> usuarioFiltrado;
	private List<Usuario> todosUsuarios;
	private Usuario usuarioAlterado;
	private boolean sexo;
	private boolean sorted;
	private boolean asc;
	private boolean itemSelecionado;
	private String ordenarPor;
	private String pesquisarPor;
	private Usuario user;
	private String filtro;
	private String teste;
	public int cont=0;
	private String paginaFiltro;
	private boolean excessoNoArray;
	public int numeroDePagina=0;
	private boolean anterior=true,proximo=false;
	private String label="botão desabilitado";
	private Usuario usuarioSelecionado;
	private Repositorios repo = new Repositorios();
	public UsuariosRepo usuarios;
	public EnderecoRepo enderecos;
	public Endereco endereco;
	
	public RelatorioBean(){	
		this.todosUsuarios = new ArrayList<Usuario>();
		this.listaUsuario = new ArrayList<Usuario>();
		this.cont=0;
		this.todosUsuarios =  repo.getUsuarios().listar();
		this.selecionados=new ArrayList<Usuario>();
	}
	
	public void irPagina(){
		boolean verificaNum = false;
		for (int i=0; i<paginaFiltro.length();i++){
			if (Character.isDigit(paginaFiltro.charAt(i))){
				verificaNum=true;
			}else{
				verificaNum=false;
				break;
			}
		}
		if (verificaNum){
			int pag = Integer.parseInt(paginaFiltro);
			if (pag>numeroDePagina){
			//se a página que solicitar for inexistente
				cont=0;
			}else{
				cont=pag;
				listaProxima();
			}
		}
	}
	
	public void listar(){
		this.listaUsuario = new ArrayList<Usuario>();
		numeroDePagina=todosUsuarios.size()/10; //número de página
		if (todosUsuarios.size()<10){
			setAnterior(true);
			setProximo(true);
			for (int i =0;i<todosUsuarios.size();i++){
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}
		}else{
			for (int i=0;i<10;i++){
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}
		}
		cont=0;	
	}
	
	public void marcaTodos(){
		for (int i=0; i<this.listaUsuario.size(); i++){
			//this.listaUsuario.get(i).setSelecionado(this.itemSelecionado);
		}
	}

	public void sort(){
		this.setSorted(true);
		this.setAsc(!this.asc);
		if (this.filtro != null && filtro.length()>0){
			Collections.sort((ArrayList)this.usuarioFiltrado, new UsuarioComparar(this.asc));
		}else{
			Collections.sort((ArrayList)this.listaUsuario, new UsuarioComparar(this.asc));
		}
	}
	
	public void buscarFiltro(){
		this.usuarioFiltrado = new ArrayList<Usuario>();
		for (int i = 0; i < this.todosUsuarios.size(); i++) {
			if(this.todosUsuarios.get(i).getNome().toLowerCase().contains(this.filtro.toLowerCase())
					||this.todosUsuarios.get(i).getEmail().toLowerCase().contains(this.filtro.toLowerCase())
					||Integer.toString(this.todosUsuarios.get(i).getCodigo()).equals(this.filtro)){
				this.usuarioFiltrado.add(this.todosUsuarios.get(i));	
			}
		}
	}
	
	public void back(){
		if (cont>0){	
			setAnterior(false);
			setProximo(false);
			this.cont--;	
			this.listaUsuario = new ArrayList<Usuario>();
			for (int i = 10*cont; i<cont*10+10;i++){
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}	
		}else{	
			setAnterior(true);
			this.cont=0;
			this.listaUsuario = new ArrayList<Usuario>();
			for (int i =0;i<10;i++){ 
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}
		}
	}
	
	public void listaProxima(){
		this.listaUsuario = new ArrayList<Usuario>();
		 //caso seja número ñ divisível por 10 e se estivermos indo para a última página, então
		//devemos mostrar apenas o que resta na lista
		//se por exemplo, for uma lista de 44 usuarios, estamos na última página: logo precisamos mostrar apenas 4.
		if (((double)this.todosUsuarios.size()%10 != 0) && (this.cont == this.todosUsuarios.size()/10)){	
			setProximo(true); //desabilito o botão
			setAnterior(false); //habilito pra voltar
			for (int i = 10*cont; i<this.todosUsuarios.size();i++){ //+10 pq preciso pegar do 10 ao 20 (exemplo)
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}
		}else{
			setProximo(false);
			setAnterior(false);
			for (int i = 10*cont; i<cont*10+10;i++){ //+10 pq preciso pegar do 10 ao 20 (exemplo)
				this.listaUsuario.add(this.todosUsuarios.get(i));
			}
		}
		
	}
	public void next(){
		/*Exemplo de um array de tamanho 44:
		 	tamanho do array/10: 4.4
		  	cont 0 = 1 ao 10
			cont 1 = 11 ao 20
			cont 2 = 21 a 30
			cont 3 = 31 ao 40
			cont 4 = Aqui preciso passar apenas 4 usuários.
			cont 5 = excesso no array! Paro por aqui! :-)
		*/
		this.cont++;
		//se não tiver mais o que mostrar, significa que o cont é >= ao resultado do tamanho do array/10 
		if (cont >= ((double)this.todosUsuarios.size()/10)){ //maior ou igual pq ele passa 1x menos aqui.
			//logo, tiro -1 do cont sempre q o usuário insistir em ir p/ o próximo
			this.cont--; 
			setProximo(true);
		}else{	
			listaProxima();
		}
	}
	
	public void alterarCadastro(Usuario user) {
		sexo=false;
		if (user.getSexo().equalsIgnoreCase("m")){
			sexo = true;
		}
		this.usuarioAlterado = user;
	}
	
	public void alterar(){
		if (sexo == true){
			usuarioAlterado.setSexo("M");
		}else{
			usuarioAlterado.setSexo("F");
		}
		this.usuarios = repo.getUsuarios();
		this.enderecos = repo.getEndereco();
		this.enderecos.alterar(this.usuarioAlterado.getEndereco());
		usuarios.alterar(usuarioAlterado);
		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados alterados com sucesso!", ""));
		//this.usuarioAlterado=null;
	}
	
	public void excluir(Usuario user){ 
		this.repo = new Repositorios();
		this.usuarios = repo.getUsuarios();
		this.enderecos = repo.getEndereco();		
		this.usuarios.excluir(user);
		this.enderecos.excluir(user.getEndereco());
		this.todosUsuarios = new ArrayList<>();
		this.todosUsuarios = this.usuarios.listar();
		listar();
	}
	
	public boolean isAnterior() {
		return anterior;
	}
	
	public void setAnterior(boolean anterior) {
		this.anterior = anterior;
	}

	public boolean isProximo() {
		return proximo;
	}

	public void setProximo(boolean proximo) {
		this.proximo = proximo;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean isItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(boolean itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	public ArrayList<Usuario> getSelecionados() {
		return selecionados;
	}
	
	public void setSelecionados(ArrayList<Usuario> selecionados) {
		this.selecionados = selecionados;
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public String getOrdenarPor() {
		return ordenarPor;
	}

	public void setOrdenarPor(String ordenarPor) {
		this.ordenarPor = ordenarPor;
	}

	public List<Usuario> getUsuarioFiltrado() {
		return usuarioFiltrado;
	}

	public void setUsuarioFiltrado(ArrayList<Usuario> usuarioFiltrado) {
		this.usuarioFiltrado = usuarioFiltrado;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getPesquisarPor() {
		return pesquisarPor;
	}

	public void setPesquisarPor(String pesquisarPor) {
		this.pesquisarPor = pesquisarPor;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public boolean isExcessoNoArray() {
		return excessoNoArray;
	}

	public void setExcessoNoArray(boolean excessoNoArray) {
		this.excessoNoArray = excessoNoArray;
	}
	
	public String getpaginaFiltro() {
		return paginaFiltro;
	}

	public void setpaginaFiltro(String paginaFiltro) {
		this.paginaFiltro = paginaFiltro;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	public Usuario getUsuarioAlterado() {
		return usuarioAlterado;
	}

	public void setUsuarioAlterado(Usuario usuarioAlterado) {
		this.usuarioAlterado = usuarioAlterado;
	}
	
	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
}
