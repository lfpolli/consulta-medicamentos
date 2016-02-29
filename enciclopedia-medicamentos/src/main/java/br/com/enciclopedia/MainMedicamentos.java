package br.com.enciclopedia;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.enciclopedia.entity.Generico;
import br.com.enciclopedia.entity.MedicamentoReferencia;
import br.com.enciclopedia.entity.Similar;

public class MainMedicamentos {

	private static final String BASE_DIR = "C:\\Users\\Luiz\\Downloads\\consulta-medicamentos\\";
	private static final String ARQUIVO_REFERENCIA_LISTA_A = "tabula-Lista A 29-01-2016-referencia.tsv";
	private static final String ARQUIVO_REFERENCIA_LISTA_B = "tabula-Lista B 29-01-2016-referencia-novo.tsv";
	private static final String ARQUIVO_GENERICOS = "tabula-lista-genericos-tab.csv";
	private static final String ARQUIVO_SIMILARES = "tabula-lista-similares-tab.csv";

	public static void main(String[] args) throws Exception {
		List<MedicamentoReferencia> medicamentosReferencia = carregarMedicamentosReferencia();
		List<Generico> genericos = carregarGenericos();
		List<Similar> similares = carregarSimilares();
		int count = 0;
		int countErro = 0;

		// for (Generico generico : genericos) {
		// boolean achou = false;
		// for (MedicamentoReferencia medicamentoReferencia :
		// medicamentosReferencia) {
		// if
		// (generico.getMedicamentoReferencia().equalsIgnoreCase(medicamentoReferencia.getNomeMedicamento()))
		// {
		// achou = true;
		// count++;
		// medicamentoReferencia.getGenericos().add(generico);
		// break;
		// }
		// }
		//
		// if (!achou) {
		// countErro++;
		// // System.out.println("Generico " + generico.getPrincipioAtivo()
		// // + " órfão: " + generico.getMedicamentoReferencia());
		// }
		// }

		for (MedicamentoReferencia medicamentoReferencia : medicamentosReferencia) {
			for (Generico generico : genericos) {
				if (generico.getMedicamentoReferencia().equalsIgnoreCase(medicamentoReferencia.getNomeMedicamento())) {
					medicamentoReferencia.getGenericos().add(generico);
				}
			}
			for (Similar similar : similares) {
				if (similar.getMedicamentoReferencia().equalsIgnoreCase(medicamentoReferencia.getNomeMedicamento())) {
					medicamentoReferencia.getSimilares().add(similar);
				}
			}
		}

		// System.out.println("Sucesso " + count);
		// System.out.println("Erro " + countErro);
		Set<String> formasFarmaceuticas = new HashSet<String>();
		Set<String> meds = new HashSet<String>();
		for (MedicamentoReferencia medicamentoReferencia : medicamentosReferencia) {

			// if
			// (!formasFarmaceuticas.contains(medicamentoReferencia.getFormaFarmaceutica()))
			// {
			// formasFarmaceuticas.add(medicamentoReferencia.getFormaFarmaceutica());
			// meds.add(medicamentoReferencia.getFormaFarmaceutica() + " - "
			// + medicamentoReferencia.getNomeMedicamento());
			// }

			System.out.println("Referência: " + medicamentoReferencia.getNomeMedicamento() + " - "
					+ medicamentoReferencia.getFormaFarmaceutica());
			System.out.println("Laboratório: " + medicamentoReferencia.getDetentorRegistro());
			System.out.println("Genéricos: ");
			for (Generico generico : medicamentoReferencia.getGenericos()) {
				System.out.println("\t" + generico.getPrincipioAtivo() + " - " + generico.getFormaFarmaceutica() + " - " + generico.getConcentracao() + " - "
						+ " - Laboratório: " + generico.getDetentorRegistro());
			}
			System.out.println("Similares: ");
			for (Similar similar : medicamentoReferencia.getSimilares()) {
				System.out.println("\t" + similar.getNomeComercial() + " - " + similar.getFormaFarmaceutica() + " - " + similar.getConcentracao() + " - "
						+ " - Laboratório: " + similar.getDetentorRegistro());
			}
			System.out.println("#######################################");
		}

		for (String string : meds) {
			System.out.println(string);
		}
	}

	private static List<Generico> carregarGenericos() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get(BASE_DIR + ARQUIVO_GENERICOS), Charset.forName("UTF-8"));

		Generico generico = null;
		List<Generico> genericos = new ArrayList<Generico>();

		List<String> fixedLines = fixLines(allLines, "\t", 6);

		for (String string : fixedLines) {
			string = string.replace("\n", "");
			generico = new Generico();
			String[] splited = string.split("\t");
			generico.setPrincipioAtivo(splited[0].trim());
			generico.setMedicamentoReferencia(splited[1].trim());
			generico.setFormaFarmaceutica(splited[2].trim());
			generico.setConcentracao(splited[3].trim());
			generico.setDetentorRegistro(splited[4].trim());
			generico.setDataPublicacaoRegistro(splited[5].trim());

			genericos.add(generico);
		}
		return genericos;
	}

	private static List<MedicamentoReferencia> carregarMedicamentosReferencia() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get(BASE_DIR + ARQUIVO_REFERENCIA_LISTA_A),
				Charset.forName("UTF-8"));
		allLines.addAll(Files.readAllLines(Paths.get(BASE_DIR + ARQUIVO_REFERENCIA_LISTA_B), Charset.forName("UTF-8")));

		List<String> fixedLines = fixLines(allLines, "\t", 7);

		MedicamentoReferencia referencia = null;
		List<MedicamentoReferencia> medicamentosReferencia = new ArrayList<MedicamentoReferencia>();

		for (String string : fixedLines) {
			string = string.replace("\n", "");
			referencia = new MedicamentoReferencia();
			String[] splited = string.split("\t");
			referencia.setPrincipioAtivo(splited[0].trim());
			referencia.setDetentorRegistro(splited[1].trim());
			referencia.setNomeMedicamento(splited[2].trim());
			referencia.setNumeroRegistro(splited[3].trim());
			referencia.setConcentracao(splited[4].trim());
			referencia.setFormaFarmaceutica(splited[5].trim());
			referencia.setDataInclusaoRegistro(splited[6].trim());

			medicamentosReferencia.add(referencia);
		}
		return medicamentosReferencia;
	}

	private static List<Similar> carregarSimilares() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get(BASE_DIR + ARQUIVO_SIMILARES), Charset.forName("UTF-8"));

		Similar similare = null;
		List<Similar> similares = new ArrayList<Similar>();

		List<String> fixedLines = fixLines(allLines, "\t", 7);

		for (String string : fixedLines) {
			string = string.replace("\n", "");
			similare = new Similar();
			String[] splited = string.split("\t");
			similare.setMedicamentoReferencia(splited[0].trim());
			similare.setPrincipioAtivo(splited[1].trim());
			similare.setNomeComercial(splited[2].trim());
			similare.setDetentorRegistro(splited[3].trim());
			similare.setFormaFarmaceutica(splited[4].trim());
			similare.setConcentracao(splited[5].trim());
			similare.setDataInclusao(splited[6].trim());

			similares.add(similare);
		}
		return similares;
	}

	private static List<String> fixLines(List<String> allLines, String separador, int numberOfParts) {
		List<String> fixedLines = new ArrayList<String>();
		String part = "";

		for (String string : allLines) {
			part += string.replace("\n", "");

			if (part.split(separador).length == numberOfParts) {
				fixedLines.add(part);
				part = "";
			}
		}
		return fixedLines;
	}
}
