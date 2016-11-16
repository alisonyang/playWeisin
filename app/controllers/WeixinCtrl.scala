package controllers

/**
  * Created by alison on 2016/9/22.
  */



import org.apache.commons.lang3.StringUtils
import play.api.mvc.{Action, AnyContent,Controller}
import org.apache.commons.codec.digest.DigestUtils
import play.api._
import play.api.libs.json._
import scala.concurrent.Future
import scala.xml.Elem


//class WeixinCtrl extends Controller {
//
//  val logger = Logger(this.getClass)
//
//
//  def get(signature: String, echostr: String, timestamp: String, nonce: String) = Action { request =>
//    val token = "tokenfortest"
//    val tmpStr = DigestUtils.sha1Hex(Seq(token, timestamp, nonce).sorted.mkString)
//    tmpStr.map {
//        case signature => Ok(echostr)
//        case s =>
//          logger.error(s"$s not match $signature")
//          BadRequest
//      }
//
//    Ok("Hello world")
//  }
//}