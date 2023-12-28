pipeline {
  agent any
  options {
    // Timeout counter starts AFTER agent is allocated
    timeout(time: 1, unit: 'HOURS')
  }
  stages {
    stage('Running the tests') {
      steps {
      bat """
        cd growpital-qa-automation
        mvn clean install
      """
      }
    }
  }
  post {
    failure {
        //slackSend(channel: "growpital-automation", message: "Hey Neil, Automation tests failed - Job Number: ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>) Allure Report Link - ${env.BUILD_URL}allure/")
        emailext(body: "Automation tests executed - Job Number:} ${env.BUILD_NUMBER} Allure Report Link - ${env.BUILD_URL}allure/", subject: 'Automation tests Failed', to: 'neil@growpital.com')
    }
    //success {
    //    slackSend(channel: "growpital-automation", message: "Automation tests success - Job Number: ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>) Allure Report Link - ${env.BUILD_URL}allure/ ")
    //}
    always {
      emailext(body: "Automation tests executed - Job Number:} ${env.BUILD_NUMBER} Allure Report Link - ${env.BUILD_URL}allure/", subject: 'Automation tests Executed', to: 'neil@growpital.com')
      //bat """
        //  aws s3 cp Growpital/allure-results s3://growpital-automation/${env.BUILD_NUMBER}/ --recursive
        //"""
      publishHTML target: [
        allowMissing: false,
        alwaysLinkToLastBuild: false,
        keepAll: true,
        reportDir: 'growpital-automation/extentReport',
        reportFiles: 'TestExecutionReport.html',
        reportName: 'Extent Report'
      ]
      allure([
        includeProperties: false,
        jdk: '',
        properties: [],
        reportBuildPolicy: 'ALWAYS',
        results: [[path: 'growpital-qa-automation/allure-results']]
      ])
      cleanWs()
    }
  }
}