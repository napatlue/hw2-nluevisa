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

/** Evaluator type
 * Updated by JCasGen Mon Sep 23 19:39:23 EDT 2013
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
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Evaluator_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_numCorrectAnswer = jcas.getRequiredFeatureDE(casType, "numCorrectAnswer", "uima.cas.Integer", featOkTst);
    casFeatCode_numCorrectAnswer  = (null == casFeat_numCorrectAnswer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_numCorrectAnswer).getCode();

  }
}



    