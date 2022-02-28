pipeline {
  agent any
  parameters {
    #string(name: 'VERSION', defaultValue: '1.2.0', description: 'version to deploy on PROD')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'], description: 'versions to choose')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  tools {
    npm
    maven 'Maven'
  }
  environment {
    NEW_VERSION = '1.3.0'
    SERVER_CREDENTIALS = credentials('github-credential')
  }
  stages {
    stage("build"){
      steps {
        echo 'building the application......'
        echo "building version ${NEW_VERSION}"
        sh "mvn install"
      }
   }
   
   stage("test"){
     when {
       expression {
         params.executeTests
       }
     }
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
        echo "deploying version ${params.VERSION}"
        echo "deploying with ${SERVER_CREDENTIALS}"
        sh "${SERVER_CREDENTIALS}"
      }
   }
      
  }
}
