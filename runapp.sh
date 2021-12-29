#!/bin/bash

if [ $# -lt 1 ]
then
  echo "Usage: $0 classname [args]"
  exit 1
fi

BASEDIR=`dirname $0`

CLASSDIR=${BASEDIR}/build/classes/java/main

if [ ! -d "${CLASSDIR}" ]
then
    echo "Class directory ${CLASSDIR} not found.  Run 'gradle build' then re-run."
    exit 1
fi

MODULEDIR=${BASEDIR}/build/extlibs
MODULELIST='javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web'

if [ ! -d "${MODULEDIR}" ]
then
    echo "External JAR library directory ${JARLIBDIR} not found.  Run 'gradle build' then re-run."
    exit 1
fi

java -cp ${CLASSDIR} --module-path "${MODULEDIR}" --add-modules "${MODULELIST}" "$@"
