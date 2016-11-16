package controllers

import org.apache.commons.codec.digest.DigestUtils

import play.api.Logger
import play.api.mvc._
import play.api.libs.json.Json._

object Application extends Controller {

  def index = Action { implicit request =>
    Ok(currentApi)
  }

  private def currentApi(implicit request: RequestHeader) = {
    toJson(Map(
      "root" -> request.uri
    ))
  }

  def get(signature: String, timestamp: String, nonce: String,echostr: String) = Action { implicit request =>
//確定有沒有接到參數 (print)
//    val logger = Logger(this.getClass)
//    logger.debug(request.rawQueryString)
    println(signature,timestamp,nonce,echostr)

    val token:String= "tokenfortest"

    val tmpStr = (DigestUtils.sha1Hex(Seq(token, timestamp, nonce).sorted.mkString)).toString
    println(tmpStr)

    if( tmpStr == signature ){
//      logger.info("return ok")
      Ok(echostr)
    }else{
//      logger.error("not match signature")
      BadRequest
    }

  }
}
