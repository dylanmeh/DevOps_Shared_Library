def call() {
  emailext (
  subject: "Failure: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
  body: """Failure: Job '${JOB_NAME} [${BUILD_NUMBER}]':
  Check console output at ${BUILD_URL}""",
  to: 'ted.fenn@concanon.com'
  )
}