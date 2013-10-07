package edu.cmu.deiis.types;

/* First created by JCasGen Mon Sep 23 15:30:12 EDT 2013 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Hold information of the method used for scoring and result. This type is intended to be used by casConsumer
 * Updated by JCasGen Mon Oct 07 02:34:05 EDT 2013
 * @generated */
public class Evaluator_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Evaluator_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Evaluator_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Evaluator(addr, Evaluator_Type.this);
  			   Evaluator_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Evaluator(addr, Evaluator_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Evaluator.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Evaluator");
 
  /** @generated */
  final Feature casFeat_numCorrectAnswer;
  /** @generated */
  final int     casFeatCode_numCorrectAnswer;
  /** @generated */ 
  public int getNumCorrectAnswer(int addr) {
        if (featOkTst && casFeat_numCorrectAnswer == null)
      jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    return ll_cas.ll_getIntValue(addr, casFeatCode_numCorrectAnswer);
  }
  /** @generated */    
  public void setNumCorrectAnswer(int addr, int v) {
        if (featOkTst && casFeat_numCorrectAnswer == null)
      jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    ll_cas.ll_setIntValue(addr, casFeatCode_numCorrectAnswer, v);}
    
  
 
  /** @generated */
  final Feature casFeat_resultText;
  /** @generated */
  final int     casFeatCode_resultText;
  /** @generated */ 
  public String getResultText(int addr) {
        if (featOkTst && casFeat_resultText == null)
      jcas.throwFeatMissing("resultText", "edu.cmu.deiis.types.Evaluator");
    return ll_cas.ll_getStringValue(addr, casFeatCode_resultText);
  }
  /** @generated */    
  public void setResultText(int addr, String v) {
        if (featOkTst && casFeat_resultText == null)
      jcas.throwFeatMissing("resultText", "edu.cmu.deiis.types.Evaluator");
    ll_cas.ll_setStringValue(addr, casFeatCode_resultText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_scoringClassId;
  /** @generated */
  final int     casFeatCode_scoringClassId;
  /** @generated */ 
  public String getScoringClassId(int addr) {
        if (featOkTst && casFeat_scoringClassId == null)
      jcas.throwFeatMissing("scoringClassId", "edu.cmu.deiis.types.Evaluator");
    return ll_cas.ll_getStringValue(addr, casFeatCode_scoringClassId);
  }
  /** @generated */    
  public void setScoringClassId(int addr, String v) {
        if (featOkTst && casFeat_scoringClassId == null)
      jcas.throwFeatMissing("scoringClassId", "edu.cmu.deiis.types.Evaluator");
    ll_cas.ll_setStringValue(addr, casFeatCode_scoringClassId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_questionText;
  /** @generated */
  final int     casFeatCode_questionText;
  /** @generated */ 
  public String getQuestionText(int addr) {
        if (featOkTst && casFeat_questionText == null)
      jcas.throwFeatMissing("questionText", "edu.cmu.deiis.types.Evaluator");
    return ll_cas.ll_getStringValue(addr, casFeatCode_questionText);
  }
  /** @generated */    
  public void setQuestionText(int addr, String v) {
        if (featOkTst && casFeat_questionText == null)
      jcas.throwFeatMissing("questionText", "edu.cmu.deiis.types.Evaluator");
    ll_cas.ll_setStringValue(addr, casFeatCode_questionText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_precision;
  /** @generated */
  final int     casFeatCode_precision;
  /** @generated */ 
  public double getPrecision(int addr) {
        if (featOkTst && casFeat_precision == null)
      jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Evaluator");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precision);
  }
  /** @generated */    
  public void setPrecision(int addr, double v) {
        if (featOkTst && casFeat_precision == null)
      jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Evaluator");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precision, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Evaluator_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_numCorrectAnswer = jcas.getRequiredFeatureDE(casType, "numCorrectAnswer", "uima.cas.Integer", featOkTst);
    casFeatCode_numCorrectAnswer  = (null == casFeat_numCorrectAnswer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_numCorrectAnswer).getCode();

 
    casFeat_resultText = jcas.getRequiredFeatureDE(casType, "resultText", "uima.cas.String", featOkTst);
    casFeatCode_resultText  = (null == casFeat_resultText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_resultText).getCode();

 
    casFeat_scoringClassId = jcas.getRequiredFeatureDE(casType, "scoringClassId", "uima.cas.String", featOkTst);
    casFeatCode_scoringClassId  = (null == casFeat_scoringClassId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_scoringClassId).getCode();

 
    casFeat_questionText = jcas.getRequiredFeatureDE(casType, "questionText", "uima.cas.String", featOkTst);
    casFeatCode_questionText  = (null == casFeat_questionText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionText).getCode();

 
    casFeat_precision = jcas.getRequiredFeatureDE(casType, "precision", "uima.cas.Double", featOkTst);
    casFeatCode_precision  = (null == casFeat_precision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precision).getCode();

  }
}



    