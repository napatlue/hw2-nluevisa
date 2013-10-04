package edu.cmu.deiis.cpe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.CasToInlineXml;

import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Evaluator;

public class OutputScreenCasConsumer  extends CasConsumer_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";

  private File mOutputDir;


  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
  
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS is converted to XML and written into the output file .
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
 
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    FSIterator it = jcas.getAnnotationIndex(Evaluator.type).iterator();
    
    while(it.hasNext())
    {
      Evaluator eval = (Evaluator) it.next();
      System.out.println(eval.getQuestionText());
      System.out.println("Class producing score: "+ eval.getScoringClassId());
      System.out.println("Result: \n"+eval.getResultText());
      
    }
    // retrieve the filename of the input file from the CAS
//    FSIterator it = jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator();
//    File outFile = null;
//    if (it.hasNext()) {
//      SourceDocumentInformation fileLoc = (SourceDocumentInformation) it.next();
//      File inFile;
//      try {
//        inFile = new File(new URL(fileLoc.getUri()).getPath());
//        outFile = new File(mOutputDir, inFile.getName());
//      } catch (MalformedURLException e1) {
//        // invalid URL, use default processing below
//      }
//    }
//    if (outFile == null) {
//      outFile = new File(mOutputDir, "doc" + mDocNum++);
//    }
//    // convert CAS to xml format and write to output file in UTF-8
//    try {
//      String xmlAnnotations = cas2xml.generateXML(aCAS);
//      FileOutputStream outStream = new FileOutputStream(outFile);
//      outStream.write(xmlAnnotations.getBytes("UTF-8"));
//      outStream.close();
//    } catch (CASException e) {
//      throw new ResourceProcessException(e);
//    } catch (IOException e) {
//      throw new ResourceProcessException(e);
//    }
  }

}
