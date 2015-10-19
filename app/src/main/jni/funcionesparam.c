#include "jdebu_github_io_ndkexamples_MainActivity.h"

/*
 * Class:     jdebu_github_io_ndkexamples_MainActivity
 * Method:    funcionesparam
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jdebu_github_io_ndkexamples_MainActivity_suma
  (JNIEnv *env, jobject obj, jint sumando1, jint sumando2) {
  return sumando1+sumando2;
  }

JNIEXPORT jstring JNICALL Java_jdebu_github_io_ndkexamples_MainActivity_resta
        (JNIEnv *env, jobject obj, jint minuendo, jint sustraendo) {
  return minuendo-sustraendo;
}