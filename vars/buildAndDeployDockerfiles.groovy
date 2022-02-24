def call() {
    git credentialsId: 'GitHub_Creds' url: 'https://github.com/dylanmeh/DevOps_Dockerfiles.git'
    sh '''
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