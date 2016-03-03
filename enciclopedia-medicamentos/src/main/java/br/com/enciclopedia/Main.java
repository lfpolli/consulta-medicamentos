//package br.com.enciclopedia;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.Writer;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.util.PDFText2HTML;
//import org.apache.pdfbox.util.PDFTextStripper;
//
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.io.RandomAccessSourceFactory;
//import com.itextpdf.text.pdf.PRTokeniser;
//import com.itextpdf.text.pdf.PdfDictionary;
//import com.itextpdf.text.pdf.PdfName;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.RandomAccessFileOrArray;
//import com.itextpdf.text.pdf.parser.ContentByteUtils;
//import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
//import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
//import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;
//import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
//import com.itextpdf.text.pdf.parser.PdfTextExtractor;
//import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
//import com.itextpdf.text.pdf.parser.RenderFilter;
//import com.itextpdf.text.pdf.parser.RenderListener;
//import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
//import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
//
//
//
//public class Main {
//	
//    public static final String SOURCE_FILE = "/Users/andremello/Downloads/DCB.pdf";
//    public static final String RESULT_FILE = "/Users/andremello/Downloads/DCB.txt";
//    public static final String RESULT_FILE_HTML = "/Users/andremello/Downloads/Mar2015.html";
//
//	public static void main(String[] args) {
//		
//		try {
//			PDDocument document = PDDocument.load("/Users/andremello/Downloads/DCB.pdf");
//			PDFTextStripper p = new PDFText2HTML("UTF-8");
//			p.setForceParsing( true );
//            p.setSortByPosition( true );
//            p.setShouldSeparateByBeads( true );
//			Writer output = new OutputStreamWriter( new FileOutputStream( RESULT_FILE ), "UTF-8" );
//			p.writeText(document, output);
//			output.close();
//			
//			//String text = p.getText(document);
//			
////			Document pdf = PDF.open("/Users/andremello/Downloads/Mar2015.pdf");
////		    StringBuilder text = new StringBuilder(1024);
////		    pdf.pipe(new OutputTarget(text));
////		    pdf.close();
////		    System.out.println(text);
//			
////			PDDocument pdf = PDDocument.load("/Users/andremello/Downloads/Mar2015.pdf");
////			PDFDomTree parser = new PDFDomTree();
////			parser.processDocument(pdf);
////			Document dom = parser.getDocument();
//		
////			System.out.println(dom);
//			
//			
////			new Main().extractText(SOURCE_FILE, RESULT_FILE);
//			
//			
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		
//		
//		
//
//	}
//	
//	public void parsePdf(String pdf, String txt) throws IOException {
//        PdfReader reader = new PdfReader(pdf);
//        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
//        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
//        TextExtractionStrategy strategy;
//        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
//            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
//            out.println(strategy.getResultantText());
//        }
//        out.flush();
//        out.close();
//        reader.close();
//    }
//	
//	public void parsePdf2(String src, String dest) throws IOException {
//        PdfReader reader = new PdfReader(src);
//        // we can inspect the syntax of the imported page
//        byte[] streamBytes = reader.getPageContent(1);
//        PRTokeniser tokenizer = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));
//        PrintWriter out = new PrintWriter(new FileOutputStream(dest));
//        while (tokenizer.nextToken()) {
//            if (tokenizer.getTokenType() == PRTokeniser.TokenType.STRING) {
//                out.println(tokenizer.getStringValue());
//            }
//        }
//        out.flush();
//        out.close();
//        reader.close();
//    }
//	
//	public void extractText(String src, String dest) throws IOException {
////        PrintWriter out = new PrintWriter(new FileOutputStream(dest));
////        PdfReader reader = new PdfReader(src);
////        RenderListener listener = new MyTextRenderListener(out);
////        PdfContentStreamProcessor processor = new PdfContentStreamProcessor(listener);
////        PdfDictionary pageDic = reader.getPageN(10);
////        PdfDictionary resourcesDic = pageDic.getAsDict(PdfName.RESOURCES);
////        processor.processContent(ContentByteUtils.getContentBytesForPage(reader, 10), resourcesDic);
////        out.flush();
////        out.close();
////        reader.close();
//    }
//	
//	public void parsePdf3(String pdf, String txt) throws IOException {
//        PdfReader reader = new PdfReader(pdf);
//        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
//        Rectangle rect = new Rectangle(70, 80, 200, 200);
//        RenderFilter filter = new RegionTextRenderFilter(rect);
//        TextExtractionStrategy strategy;
//        for (int i = 1; i <= 2; i++) {
//            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
//            out.println(PdfTextExtractor.getTextFromPage(reader, i, strategy));
//        }
//        out.flush();
//        out.close();
//        reader.close();
//    }
//
// }
