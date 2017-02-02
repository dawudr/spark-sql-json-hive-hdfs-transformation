package AwsConfigProvider

import com.amazonaws.AmazonClientException
import com.amazonaws.auth.{AWSCredentials, AWSCredentialsProviderChain, InstanceProfileCredentialsProvider}
import com.amazonaws.auth.profile.ProfileCredentialsProvider

/**
  * Created by dawud.rahman on 01/02/2017.
  */
object AwsConfigProvider {


  def main(args: Array[String]): Unit = {
    /*
 * The ProfileCredentialsProvider will return your [default]
 * credential profile by reading from the credentials file located at
 * (~/.aws/credentials).
 */


    var accessKey = ""
    var secretAccessKey = ""

    lazy val credentialsChain = new AWSCredentialsProviderChain(
      // attempt on-instance credentials first
      new InstanceProfileCredentialsProvider(),
      // fallback to aws credentials file
      new ProfileCredentialsProvider()
    )

    val credentials: Option[AWSCredentials] = Some(credentialsChain.getCredentials)

    try {
      val credentials = credentialsChain.getCredentials
      accessKey = credentials.getAWSAccessKeyId
      secretAccessKey = credentials.getAWSSecretKey
    } catch {
      case e: Exception => throw new AmazonClientException(
        "Cannot load the credentials from the credential profiles file. " +
          "Please make sure that your credentials file is at the correct " +
          "location (~/.aws/credentials), and is in valid format.",
        e)
    }

    println(accessKey)
    println(secretAccessKey)

  }



}
