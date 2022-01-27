/**
 * 
 */
function calc(){
	//입력한 값 가져오기 - 결과값은 String 타입이다
	
	var price = parseInt(document.fr.price.value);
	var qty = parseInt(document.fr.qty.value);
	
	var res = price * qty;
	
	//res를 출력
	document.getElementById('result').textContent = res;

}
