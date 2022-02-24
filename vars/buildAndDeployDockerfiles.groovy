def call() {
    git 'https://github.com/dylanmeh/DevOps_Dockerfiles.git'
    container('alpine-docker') {
        stage('build and push docker images') {
            sh '''
            pwd 
            ls
            cd Dockerfiles/Maven
            docker build -t dylanmehmedovic/alpine-docker .
            echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin
            docker push dylanmehmedovic/alpine-docker
            cd ../Gradle
            docker build -t dylanmehmedovic/alpine-docker .
            echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin
            docker push dylanmehmedovic/alpine-docker
            '''
        }    
    }       
}    