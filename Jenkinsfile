pipeline {
  agent any
  environment {
    NEW_VERSION = '1.3.0'
    SERVER_CREDENTIALS = credentials('github-credential')
  }
  stages {
    stage("build"){
      steps {
        echo 'building the application......'
        echo "building version ${NEW_VERSION}"
      }
   }
   
   stage("test"){
      steps {
        echo 'testing the application......'
        withCredentials([
          usernamePassword(credentials: 'github-credential', usernameVariable:USER, passwordVariable: PWD)          
        ]) {
          sh "some script ${USER} ${PWD}"
          echo 'testing the application with credentials: username= ${USER} password= ${PWD}'
        }
      }
   }
   
   stage("deploy"){
      steps {
        echo 'deploying the application......'
        echo "deploying with ${SERVER_CREDENTIALS}"
        sh "${SERVER_CREDENTIALS}"
      }
   }
      
  }
}
