package br.com.rdtecnologia.relatorio;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.rdtecnologia.model.Cliente;

public class ClienteREL 
{
	/**
	 * Caminho base
	 */
	private String path;
	
	
	/**
	 * Caminho para o package onde est�o armazenados os relatorios Jarper
	 */
	private String pathToReportPackage;
	
	
	/**
	 * Recupera os caminhos para que a classe possa encontrar os relat�rios
	 */
	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/rdtecnologia/jasper/";
	}

	
	/**
	 * Imprime/gera uma lista de Clientes
	 * @param clientes
	 */
	public void imprimir(List<Cliente> clientes) throws Exception	
	{
		   
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clientes.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));

		JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio_de_Clientes.pdf");		
	}
	
		
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	
	public String getPath() {
		return this.path;
	}
}
