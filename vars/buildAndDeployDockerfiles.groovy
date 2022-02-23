def call() {
    pipeline {
        agent {

        }
        stages {
            stage('build docker file') {
                sh 'docker build -t <image tage> .'
            }
            stage('deploy docker file') {
                sh 'docker login -u <username> -p <password>'
                sh 'docker push <image tag>'
            }
        }
    }
}    