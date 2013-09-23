
/* First created by JCasGen Mon Sep 23 01:29:20 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** The sentence in the system
 * Updated by JCasGen Mon Sep 23 19:22:43 EDT 2013
 * @generated */
public class Sentence_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, Sentence_Type.this);
  			   Sentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, Sentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Sentence");
 
  /** @generated */
  final Feature casFeat_tokenArray;
  /** @generated */
  final int     casFeatCode_tokenArray;
  /** @generated */ 
  public int getTokenArray(int addr) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray);
  }
  /** @generated */    
  public void setTokenArray(int addr, int v) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    ll_cas.ll_setRefValue(addr, casFeatCode_tokenArray, v);}
    
   /** @generated */
  public int getTokenArray(int addr, int i) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
  }
   
  /** @generated */ 
  public void setTokenArray(int addr, int i, int v) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_NGramArray;
  /** @generated */
  final int     casFeatCode_NGramArray;
  /** @generated */ 
  public int getNGramArray(int addr) {
        if (featOkTst && casFeat_NGramArray == null)
      jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray);
  }
  /** @generated */    
  public void setNGramArray(int addr, int v) {
        if (featOkTst && casFeat_NGramArray == null)
      jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    ll_cas.ll_setRefValue(addr, casFeatCode_NGramArray, v);}
    
   /** @generated */
  public int getNGramArray(int addr, int i) {
        if (featOkTst && casFeat_NGramArray == null)
      jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i);
  }
   
  /** @generated */ 
  public void setNGramArray(int addr, int i, int v) {
        if (featOkTst && casFeat_NGramArray == null)
      jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_NGramArray), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tokenArray = jcas.getRequiredFeatureDE(casType, "tokenArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_tokenArray  = (null == casFeat_tokenArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenArray).getCode();

 
    casFeat_NGramArray = jcas.getRequiredFeatureDE(casType, "NGramArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_NGramArray  = (null == casFeat_NGramArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NGramArray).getCode();

  }
}



    