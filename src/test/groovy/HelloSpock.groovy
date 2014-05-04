import spock.lang.*

import iamedu.crypt.CryptoUtil

class CryptoSpec extends spock.lang.Specification {
  def "encrypt and decrypt using unicode strings"() {
    def password = "rándomPassword0"
    when:
      def str = CryptoUtil.encrypt(password, "Some rándom string")
      println str
    then:
      CryptoUtil.decrypt(password, str) == "Some rándom string"
  }

  def "encrypt and decrypt using ascii strings"() {
    def password = "randomPassword00"
    when:
      def str = CryptoUtil.encrypt(password, "Some random string")
      println str
    then:
      CryptoUtil.decrypt(password, str) == "Some random string"
  }
}  


