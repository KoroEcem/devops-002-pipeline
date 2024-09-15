pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KoroEcem/devops-002-pipeline']])
                sh 'mvn clean install'
            }
        }
        stage('Docker Image') {
            steps {
                sh 'docker build -t ecemkoro1/my-application:latest .'
                //sh 'docker build -t ecemkoro1/$JOB_NAME:$BUILD_ID .'
            }
        }
        stage('Docker Image to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {
                        sh 'docker login -u ecemkoro1 -p ${dockerhub}'
                        sh 'docker image push ecemkoro1/my-application:latest'
                        //sh 'docker build -t ecemkoro1/$JOB_NAME:$BUILD_ID .'
                    }
                }
            }
        }
      stage('Deploy Kubernetes') {
            steps {
              script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'kubernetes')
              }
            }
        }
    }
}

